package co.edu.uco.reservasrestaurante.service.domain.pais.rules;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilUUID;
import co.edu.uco.reservasrestaurante.service.domain.Rule;

public class IdPaisRule implements Rule<UUID>{

private static final Rule<UUID> instancia = new IdPaisRule();
	
	private IdPaisRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final UUID dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(final UUID dato) {
		validarObligatoriedad(dato);
		validarIdPorDefecto(dato);
		
	}
	
	private final void validarObligatoriedad(final UUID dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000169);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarIdPorDefecto(final UUID dato) {
		if (UtilUUID.esUUIDPorDefecto(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000170);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
}
