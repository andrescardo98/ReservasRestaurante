package co.edu.uco.reservasrestaurante.service.facade.concrete.reserva;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.concrete.reserva.EliminarReservaUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.reserva.EliminarReservaValidator;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;
import co.edu.uco.reservasrestaurante.service.dto.ReservaDTO;
import co.edu.uco.reservasrestaurante.service.facade.Facade;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.ReservaDTOMapper;

public final class EliminarReservaFacade implements Facade<ReservaDTO>{

	@Override
	public void execute(ReservaDTO dto) {
		final ReservaDomain domain = ReservaDTOMapper.convertToDomain(dto);
		EliminarReservaValidator.ejecutar(domain);
		
		DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new EliminarReservaUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final ReservasRestauranteException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000258);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000259);
			throw ServiceReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} finally {
			daoFactory.cerrarConexion();
		}
		
	}

}
