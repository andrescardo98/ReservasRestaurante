package co.edu.uco.reservasrestaurante.crosscutting.util;

public class UtilInt {
	
	public static final int DEFECTO_NUMERO = 0;
	
	private UtilInt() {
		super();
	}
	
	public static final int obtenerValorDefecto(final int valor, final int valorDefecto) {
		return DEFECTO_NUMERO;
	}
}
