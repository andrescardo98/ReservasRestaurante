package co.edu.uco.reservasrestaurante.service.facade.concrete.reserva;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.concrete.reserva.ConsultarReservaUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.reserva.ConsultarReservaValidator;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;
import co.edu.uco.reservasrestaurante.service.dto.ReservaDTO;
import co.edu.uco.reservasrestaurante.service.facade.FacadeFind;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.ReservaDTOMapper;

public final class ConsultarReservaFacade implements FacadeFind<ReservaDTO>{

	@Override
	public List<ReservaDTO> execute(ReservaDTO dto) {
		final ReservaDomain domain = ReservaDTOMapper.convertToDomain(dto);
		ConsultarReservaValidator.ejecutar(domain);
		List<ReservaDTO> resultados = new ArrayList<>();
		
		DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new ConsultarReservaUseCase(daoFactory);
			resultados = ReservaDTOMapper.convertToListDTO(useCase.execute(domain));
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final ReservasRestauranteException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000262);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000263);
			throw ServiceReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} finally {
			daoFactory.cerrarConexion();
		}
		return resultados;
	}

}
