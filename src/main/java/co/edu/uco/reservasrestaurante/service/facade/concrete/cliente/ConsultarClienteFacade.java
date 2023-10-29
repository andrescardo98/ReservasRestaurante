package co.edu.uco.reservasrestaurante.service.facade.concrete.cliente;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.concrete.cliente.ConsultarClienteUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.cliente.ConsultarClienteValidator;
import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.dto.ClienteDTO;
import co.edu.uco.reservasrestaurante.service.facade.FacadeFind;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.ClienteDTOMapper;

public class ConsultarClienteFacade implements FacadeFind<ClienteDTO>{

	@Override
	public List<ClienteDTO> execute(ClienteDTO dto) {
		final ClienteDomain domain =  ClienteDTOMapper.convertToDomain(dto);
		ConsultarClienteValidator.ejecutar(domain);
		List<ClienteDTO> resultados = new ArrayList<>();
		
		DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new ConsultarClienteUseCase(daoFactory);
			resultados = ClienteDTOMapper.convertToListDTO(useCase.execute(domain));
			
			daoFactory.confirmarTransaccion();
		}catch (final ReservasRestauranteException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000207);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000208);
			throw ServiceReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} finally {
			daoFactory.cerrarConexion();
		}
		return resultados;
	}

	
}
