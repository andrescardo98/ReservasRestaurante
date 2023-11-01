package co.edu.uco.reservasrestaurante.service.domain.reserva.rules;

import java.sql.Date;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilFecha;
import co.edu.uco.reservasrestaurante.service.domain.Rule;

public final class FechaReservaRule implements Rule<Date>{

	private static final Rule<Date> instancia = new FechaReservaRule();
	
	private FechaReservaRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final Date dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(Date dato) {
		validarObligatoriedad(dato);
		validarFechaAnterior(dato);
	}
	
	private final void validarObligatoriedad(final Date dato) {
		if (UtilFecha.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000235);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFechaAnterior(final Date dato) {
		long tiempoActual = System.currentTimeMillis();
		
		if (dato.getTime() < tiempoActual) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000240);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
}
