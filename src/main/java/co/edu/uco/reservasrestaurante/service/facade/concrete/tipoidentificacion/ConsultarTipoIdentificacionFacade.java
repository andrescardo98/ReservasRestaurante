package co.edu.uco.reservasrestaurante.service.facade.concrete.tipoidentificacion;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.concrete.tipoidentificacion.ConsultarTipoIdentificacionUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.tipoidentificacion.ConsultarTipoIdentificacionValidator;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.reservasrestaurante.service.dto.TipoIdentificacionDTO;
import co.edu.uco.reservasrestaurante.service.facade.FacadeFind;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

public final class ConsultarTipoIdentificacionFacade implements FacadeFind<TipoIdentificacionDTO> {

	@Override
	public final List<TipoIdentificacionDTO> execute(final TipoIdentificacionDTO dto) {
		
		final TipoIdentificacionDomain domain = TipoIdentificacionDTOMapper.convertToDomain(dto); 
		ConsultarTipoIdentificacionValidator.ejecutar(domain);
		List<TipoIdentificacionDTO> resultados = new ArrayList<>();
		
		DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
		
		try {
			daoFactory.iniciarTransaccion();
			var useCase = new ConsultarTipoIdentificacionUseCase(daoFactory);
			resultados = TipoIdentificacionDTOMapper.convertToListDTO(useCase.execute(domain));
			
			daoFactory.confirmarTransaccion();
		} catch (final ReservasRestauranteException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000187);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000188);
			throw ServiceReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} finally {
			daoFactory.cerrarConexion();
		}
		return resultados;
	}

}
