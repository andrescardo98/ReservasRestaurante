package co.edu.uco.reservasrestaurante.crosscutting.util;

import java.util.Date;

public class UtilFecha {
	
	public static final Date FECHA_NACIMIENTO_DEFECTO = new Date(0);
	
	private UtilFecha() {
		super();
	}
	
	public static final Date obtenerFechaDefecto(final Date valor, final Date valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}
	
	public static final Date obtenerValorDefecto(final Date valor) {
		return obtenerFechaDefecto(valor, FECHA_NACIMIENTO_DEFECTO);
	}
	
	public static final boolean esFechaInvalida(final Date fecha) {
		return fecha.equals(FECHA_NACIMIENTO_DEFECTO);
	}
}
