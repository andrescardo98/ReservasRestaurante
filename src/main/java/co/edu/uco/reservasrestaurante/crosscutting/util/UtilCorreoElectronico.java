package co.edu.uco.reservasrestaurante.crosscutting.util;

public final class UtilCorreoElectronico {
	
	public static final String CORREO_DEFECTO = "";
	private static final String PATTERN_CORREO_ELECTRONICO = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
	//expresión regular que asegura un conjunto de caracteres antes y después del @, seguido de un dominio
	
	private UtilCorreoElectronico() {
		super();
	}
	
	public static final String obtenerValorDefecto(final String valor, final String valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}
	
	public static final String obtenerValorDefecto(final String valor) {
		return obtenerValorDefecto(valor, CORREO_DEFECTO);
	}
	
	public static final boolean contieneLetrasDigitosEspaciosArroba(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_CORREO_ELECTRONICO);
	}

}
