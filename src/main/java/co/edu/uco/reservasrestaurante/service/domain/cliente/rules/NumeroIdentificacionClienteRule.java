package co.edu.uco.reservasrestaurante.service.domain.cliente.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;

public final class NumeroIdentificacionClienteRule implements Rule<String>{

	private static final Rule<String> instancia = new NumeroIdentificacionClienteRule();
	
	private NumeroIdentificacionClienteRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(String dato) {
		validarObligatoriedad(dato);
		validarFormato(dato);
	}
	
	private final void validarObligatoriedad(final String dato) {
		if (UtilTexto.estaVacio(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000177);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final String dato) {
		if (!UtilTexto.contieneLetrasDigitos(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000178);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
}
