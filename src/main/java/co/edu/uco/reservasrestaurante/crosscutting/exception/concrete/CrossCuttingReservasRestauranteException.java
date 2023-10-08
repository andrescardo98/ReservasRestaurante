package co.edu.uco.reservasrestaurante.crosscutting.exception.concrete;

import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.exception.enumerator.LugarException;

public class CrossCuttingReservasRestauranteException extends ReservasRestauranteException{
	

	private static final long serialVersionUID = 2765757041071477495L;
	
	protected CrossCuttingReservasRestauranteException(Throwable excepcionRaiz, String mensajeUsuario, 
			String mensajeTecnico) {
		super(LugarException.CROSSCUTTING ,excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
	
	public static final ReservasRestauranteException crear(final String mensajeUsuario) {
		return new CrossCuttingReservasRestauranteException(null, mensajeUsuario, mensajeUsuario);
	}
	
	public static final ReservasRestauranteException crear(final String mensajeUsuario, final String mensajeTecnico) {
		return new CrossCuttingReservasRestauranteException(null, mensajeUsuario, mensajeTecnico);
	}
	
	public static final ReservasRestauranteException crear(final Throwable excepcionRaiz , final String mensajeUsuario, final String mensajeTecnico) {
		return new CrossCuttingReservasRestauranteException(excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}

}
