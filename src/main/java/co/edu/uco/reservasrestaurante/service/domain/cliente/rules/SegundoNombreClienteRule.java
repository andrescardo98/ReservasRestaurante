package co.edu.uco.reservasrestaurante.service.domain.cliente.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;

public final class SegundoNombreClienteRule implements Rule<String>{

	private static final Rule<String> instancia = new SegundoNombreClienteRule();
	
	private SegundoNombreClienteRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(String dato) {
		validarLongitud(dato);
		validarFormato(dato);
	}

	
	private final void validarLongitud(final String dato) {
		if (!UtilTexto.longitudMaximaValida(dato, 50)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000149);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final String dato) {
		if ((!UtilTexto.contieneSoloLetrasDigitosEspacios(dato)) && (!dato.isEmpty())) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000150);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
}
