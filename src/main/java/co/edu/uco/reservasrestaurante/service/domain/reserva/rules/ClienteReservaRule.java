package co.edu.uco.reservasrestaurante.service.domain.reserva.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;

public final class ClienteReservaRule implements Rule<ClienteDomain>{
	
	private static final Rule<ClienteDomain> instancia = new ClienteReservaRule();
	
	private ClienteReservaRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final ClienteDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(ClienteDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000241);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}

}
