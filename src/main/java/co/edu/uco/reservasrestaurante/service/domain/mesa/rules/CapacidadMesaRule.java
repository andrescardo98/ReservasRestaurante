package co.edu.uco.reservasrestaurante.service.domain.mesa.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.service.domain.Rule;

public final class CapacidadMesaRule implements Rule<Integer>{
	
private static final Rule<Integer> instancia = new CapacidadMesaRule();
	
	private CapacidadMesaRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final int dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(Integer dato) {
		validarFormato(dato);
		
	}
	
	private final void validarFormato(final int dato) {
		if (dato < 0) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000292);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
}
