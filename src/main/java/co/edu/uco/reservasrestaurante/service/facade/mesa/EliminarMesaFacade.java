package co.edu.uco.reservasrestaurante.service.facade.mesa;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.TipoDAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.concrete.mesa.EliminarMesaUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.mesa.EliminarMesaValidator;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;
import co.edu.uco.reservasrestaurante.service.dto.MesaDTO;
import co.edu.uco.reservasrestaurante.service.facade.Facade;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.MesaDTOMapper;

public final class EliminarMesaFacade implements Facade<MesaDTO>{

	@Override
	public void execute(MesaDTO dto) {
		final MesaDomain domain = MesaDTOMapper.convertToDomain(dto);
		EliminarMesaValidator.ejecutar(domain);
		
		DAOFactory daoFactory = DAOFactory.obtenerDAOFactory(TipoDAOFactory.POSTGRESQL);
		
		try {
			daoFactory.iniciarTransaccion();
			
			var useCase = new EliminarMesaUseCase(daoFactory);
			useCase.execute(domain);
			
			daoFactory.confirmarTransaccion();
		} catch (final ReservasRestauranteException excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (final Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000304);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000305);
			throw ServiceReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

}
