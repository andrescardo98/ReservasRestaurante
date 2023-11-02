package co.edu.uco.reservasrestaurante.service.facade.concrete.cliente;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.concrete.cliente.RegistrarClienteUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.cliente.RegistrarClienteValidator;
import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.dto.ClienteDTO;
import co.edu.uco.reservasrestaurante.service.facade.Facade;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.ClienteDTOMapper;

public class RegistrarClienteFacade implements Facade<ClienteDTO>{

	@Override
	public void execute(ClienteDTO dto) {
		final ClienteDomain domain =  ClienteDTOMapper.convertToDomain(dto);
		RegistrarClienteValidator.ejecutar(domain);
		
		DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new RegistrarClienteUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		}catch (final ReservasRestauranteException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000197);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000198);
			throw ServiceReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

	
}
