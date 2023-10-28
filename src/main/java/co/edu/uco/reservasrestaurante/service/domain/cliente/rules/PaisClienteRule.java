package co.edu.uco.reservasrestaurante.service.domain.cliente.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;

public final class PaisClienteRule implements Rule<PaisDomain>{

	private static final Rule<PaisDomain> instancia = new PaisClienteRule();
	
	private PaisClienteRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final PaisDomain dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(PaisDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000165);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
		
	}

	
}
