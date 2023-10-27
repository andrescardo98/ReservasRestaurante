package co.edu.uco.reservasrestaurante.service.domain.cliente.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;
import co.edu.uco.reservasrestaurante.service.domain.support.IdentificacionClienteDomain;

public final class IdentificacionClienteRule implements Rule<IdentificacionClienteDomain>{

	private static final Rule<IdentificacionClienteDomain> instancia = new IdentificacionClienteRule();
	
	private IdentificacionClienteRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final IdentificacionClienteDomain dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(IdentificacionClienteDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000145);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
		
	}

	
}
