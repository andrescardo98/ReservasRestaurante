package co.edu.uco.reservasrestaurante.crosscutting.util;

import java.sql.Date;
import java.util.Objects;

public class UtilFecha {
	
	public static final Date FECHA_DEFECTO = new Date(0);
	
	private UtilFecha() {
		super();
	}
	
	public static final Date obtenerFechaDefecto(final Date valor, final Date valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}
	
	public static final Date obtenerValorDefecto(final Date valor) {
		return obtenerFechaDefecto(valor, FECHA_DEFECTO);
	}
	
	public static final boolean esNulo(final Date fecha) {
		return Objects.isNull(fecha) || fecha == FECHA_DEFECTO;
	}
}
