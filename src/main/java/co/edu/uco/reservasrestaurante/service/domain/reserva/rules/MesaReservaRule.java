package co.edu.uco.reservasrestaurante.service.domain.reserva.rules;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;

public final class MesaReservaRule implements Rule<MesaDomain>{
	
	private static final int LIMITE_MESAS = 15;
	
	private static final Rule<MesaDomain> instancia = new MesaReservaRule();
	
	private MesaReservaRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final MesaDomain dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(MesaDomain dato) {
		validarFormato(dato);
		validarObligatoriedad(dato);
	}
	
	private final void validarObligatoriedad(final MesaDomain dato) {
		if (UtilObjeto.esNulo(dato)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000247);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarFormato(final MesaDomain dato) {
		if (dato.getNumero() < 0) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000245);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		} else if (dato.getNumero() > LIMITE_MESAS){
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000246);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}

}
