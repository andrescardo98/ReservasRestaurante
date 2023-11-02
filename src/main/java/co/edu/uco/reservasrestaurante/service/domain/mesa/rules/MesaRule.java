package co.edu.uco.reservasrestaurante.service.domain.mesa.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;

public final class MesaRule implements Rule<MesaDomain>{
	
private static final Rule<MesaDomain> instancia = new MesaRule();
	
	private MesaRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final MesaDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(MesaDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000293);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
}
