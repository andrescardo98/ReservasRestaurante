package co.edu.uco.reservasrestaurante.crosscutting.exception.concrete;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.enumerator.LugarException;

public class ServiceReservasRestauranteException extends ReservasRestauranteException{

	private static final long serialVersionUID = 2765757041071477495L;
	
	protected ServiceReservasRestauranteException(Throwable excepcionRaiz, String mensajeUsuario,
			String mensajeTecnico) {
		super(LugarException.SERVICE ,excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
	
	public static final ReservasRestauranteException crear(final String mensajeUsuario) {
		return new ServiceReservasRestauranteException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final ReservasRestauranteException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new ServiceReservasRestauranteException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final ReservasRestauranteException crear(final Throwable excepcionRaiz , final String mensajeUsuario, final String mensajeTecnico) {
		return new ServiceReservasRestauranteException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

}
