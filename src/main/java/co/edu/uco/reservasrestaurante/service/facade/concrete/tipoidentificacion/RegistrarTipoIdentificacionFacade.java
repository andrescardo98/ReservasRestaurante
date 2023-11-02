package co.edu.uco.reservasrestaurante.service.facade.concrete.tipoidentificacion;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.concrete.tipoidentificacion.RegistrarTipoIdentificacionUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.tipoidentificacion.RegistrarTipoIdentificacionValidator;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.reservasrestaurante.service.dto.TipoIdentificacionDTO;
import co.edu.uco.reservasrestaurante.service.facade.Facade;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

public final class RegistrarTipoIdentificacionFacade implements Facade<TipoIdentificacionDTO> {

	@Override
	public final void execute(final TipoIdentificacionDTO dto) {
		
		final TipoIdentificacionDomain domain = TipoIdentificacionDTOMapper.convertToDomain(dto); 
		RegistrarTipoIdentificacionValidator.ejecutar(domain);
		
		DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new RegistrarTipoIdentificacionUseCase(daoFactory);
			
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final ReservasRestauranteException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000081);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000082);
			throw ServiceReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

}
