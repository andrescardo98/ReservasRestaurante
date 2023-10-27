package co.edu.uco.reservasrestaurante.crosscutting.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilFecha {
	
	public static final Date FECHA_NACIMIENTO_DEFECTO = new Date(0);
	private static final String FORMATO_FECHA = "dd/MM/yyyy";
	
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
	
	public static final boolean formatoFechaCorrecto(final String fecha) {
		return fecha.matches(FORMATO_FECHA);
	}
	
	public static String formatearFecha(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
		return sdf.format(fecha);
	}
}
