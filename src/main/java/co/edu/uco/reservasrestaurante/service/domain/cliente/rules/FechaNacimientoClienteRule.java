package co.edu.uco.reservasrestaurante.service.domain.cliente.rules;

import java.util.Date;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilFecha;
import co.edu.uco.reservasrestaurante.service.domain.Rule;

public final class FechaNacimientoClienteRule implements Rule<Date>{

	private static final Rule<Date> instancia = new FechaNacimientoClienteRule();
	
	private FechaNacimientoClienteRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final Date dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(Date dato) {
		validarObligatoriedad(dato);
		validarFormato(dato);
	}
	
	private final void validarObligatoriedad(final Date dato) {
		if (dato == null || UtilFecha.esFechaInvalida(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000163);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final Date dato) {
		String fechaFormateada = UtilFecha.formatearFecha(dato);
		if (!UtilFecha.formatoFechaCorrecto(fechaFormateada)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000164);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
}
