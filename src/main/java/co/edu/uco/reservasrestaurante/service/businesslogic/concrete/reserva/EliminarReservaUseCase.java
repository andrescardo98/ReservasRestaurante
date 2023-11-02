package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.reserva;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.ReservaDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.reserva.EliminarReservaValidator;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;

public class EliminarReservaUseCase implements UseCase<ReservaDomain> {
	
	private DAOFactory factoria;	

	public EliminarReservaUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(ReservaDomain domain) {
		EliminarReservaValidator.ejecutar(domain);
		validarRegistroExistente(domain.getId());
		eliminar(domain.getId());
	}
	
	private final void eliminar(final UUID uuid) {
		getReservaDAO().eliminar(uuid);
	}
	
	private final void validarRegistroExistente(final UUID uuid) {
		final var resultados = getReservaDAO().consultarPorId(uuid);
		
		if (resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000251);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final ReservaDAO getReservaDAO() {
		return getFactoria().obtenerReservaDAO();
	}


	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000249);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000250);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
