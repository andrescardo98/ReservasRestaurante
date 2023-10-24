package co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public final class TipoIdentificacionRule implements Rule<TipoIdentificacionDomain> {

	private static final Rule<TipoIdentificacionDomain> instancia = new TipoIdentificacionRule();
	
	private TipoIdentificacionRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final TipoIdentificacionDomain dato) {
		instancia.validar(dato);
	}
	
	@Override
	public void validar(final TipoIdentificacionDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000080);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
}
