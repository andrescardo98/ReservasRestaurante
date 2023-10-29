package co.edu.uco.reservasrestaurante.service.facade.concrete.pais;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.concrete.pais.ConsultarPaisUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.pais.ConsultarPaisValidator;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;
import co.edu.uco.reservasrestaurante.service.dto.PaisDTO;
import co.edu.uco.reservasrestaurante.service.facade.FacadeFind;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.PaisDTOMapper;

public final class ConsultarPaisFacade implements FacadeFind<PaisDTO>{

	@Override
	public final List<PaisDTO> execute(final PaisDTO dto) {
		final PaisDomain domain = PaisDTOMapper.convertToDomain(dto);
		ConsultarPaisValidator.ejecutar(domain);
		List<PaisDTO> resultados = new ArrayList<>();
		
		DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new ConsultarPaisUseCase(daoFactory);
			resultados = PaisDTOMapper.convertToListDTO(useCase.execute(domain));
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final ReservasRestauranteException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000205);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000206);
			throw ServiceReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} finally {
			daoFactory.cerrarConexion();
		}
		return resultados;
	}

}
