package co.edu.uco.reservasrestaurante.service.domain.reserva.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;

public final class MesaReservaRule implements Rule<Integer>{
	
	private static final int LIMITE_MESAS = 15;
	
	private static final Rule<Integer> instancia = new MesaReservaRule();
	
	private MesaReservaRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final int dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(Integer dato) {
		validarFormato(dato);
		validarObligatoriedad(dato);
	}
	
	private final void validarObligatoriedad(final int dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000247);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final int dato) {
		if (dato < 0) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000245);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		} else if (dato > LIMITE_MESAS){
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000246);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}

}
