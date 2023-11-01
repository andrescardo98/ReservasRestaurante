package co.edu.uco.reservasrestaurante.service.domain.reserva.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;

public final class ReservaRule implements Rule<ReservaDomain>{
	
	private static final Rule<ReservaDomain> instancia = new ReservaRule();
	
	private ReservaRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final ReservaDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(ReservaDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000241);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
}
