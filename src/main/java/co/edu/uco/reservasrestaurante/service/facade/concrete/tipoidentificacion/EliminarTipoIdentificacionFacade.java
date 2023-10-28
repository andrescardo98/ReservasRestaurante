package co.edu.uco.reservasrestaurante.service.facade.concrete.tipoidentificacion;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.concrete.tipoidentificacion.EliminarTipoIdentificacionUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.tipoidentificacion.EliminarTipoIdentificacionValidator;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.reservasrestaurante.service.dto.TipoIdentificacionDTO;
import co.edu.uco.reservasrestaurante.service.facade.Facade;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.TipoIdentificacionDTOMapper;

public final class EliminarTipoIdentificacionFacade implements Facade<TipoIdentificacionDTO> {

	@Override
	public final void execute(final TipoIdentificacionDTO dto) {
		
		final TipoIdentificacionDomain domain = TipoIdentificacionDTOMapper.convertToDomain(dto); 
		EliminarTipoIdentificacionValidator.ejecutar(domain);
		
		DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.SQLSERVER);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new EliminarTipoIdentificacionUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final ReservasRestauranteException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000191);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000192);
			throw ServiceReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

}
