package co.edu.uco.reservasrestaurante.service.domain.mesa.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;

public final class UbicacionMesaRule implements Rule<String>{
	
private static final Rule<String> instancia = new UbicacionMesaRule();
	
	private UbicacionMesaRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(String dato) {
		validarLongitud(dato);
		validarObligatoriedad(dato);
	}
	
	private final void validarLongitud(final String dato) {
		if (!UtilTexto.longitudMaximaValida(dato, 100)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000289);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000290);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
}
