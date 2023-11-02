package co.edu.uco.reservasrestaurante.service.domain.reserva.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.service.domain.Rule;

public final class CantidadPersonasReservaRule implements Rule<Integer>{
	
	private static final int CAPACIDAD_MESA = 4;
	
	private static final Rule<Integer> instancia = new CantidadPersonasReservaRule();
	
	private CantidadPersonasReservaRule() {
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
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000242);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		} else if (dato > CAPACIDAD_MESA){
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000243);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}

}
