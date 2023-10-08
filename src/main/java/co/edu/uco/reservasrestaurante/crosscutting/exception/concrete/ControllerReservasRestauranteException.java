package co.edu.uco.reservasrestaurante.crosscutting.exception.concrete;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.enumerator.LugarException;

public final class ControllerReservasRestauranteException extends ReservasRestauranteException{

	private static final long serialVersionUID = 2765757041071477495L;
	
	protected ControllerReservasRestauranteException(Throwable excepcionRaiz, String mensajeUsuario, 
			String mensajeTecnico) {
		super(LugarException.CONTROLLER ,excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
	
	public static final ReservasRestauranteException crear(final String mensajeUsuario) {
		return new ControllerReservasRestauranteException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final ReservasRestauranteException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new ControllerReservasRestauranteException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final ReservasRestauranteException crear(final Throwable excepcionRaiz , final String mensajeUsuario, final String mensajeTecnico) {
		return new ControllerReservasRestauranteException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

}
