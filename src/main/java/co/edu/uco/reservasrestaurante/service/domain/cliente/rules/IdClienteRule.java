package co.edu.uco.reservasrestaurante.service.domain.cliente.rules;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;

public final class IdClienteRule implements Rule<UUID>{

	private static final Rule<UUID> instancia = new IdClienteRule();
	
	private IdClienteRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(final UUID dato) {
		validarObligatoriedad(dato);
		
	}
	
	private final void validarObligatoriedad(final UUID dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000143);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}

}
