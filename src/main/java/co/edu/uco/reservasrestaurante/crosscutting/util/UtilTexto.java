package co.edu.uco.reservasrestaurante.crosscutting.util;

public final class UtilTexto {
	
	public static final String VACIO = "";
	public static final String PATTERN_SOLO_LETRAS = "^[A-Za-záéíóúÁÉÍÓÚ]+$";
	public static final String PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS = "^[0-9A-Za-záéíóúÁÉÍÓÚ ]+$";
	
	private UtilTexto() {
		super();
	}
	
	public static final String obtenerValorDefecto(final String valor, final String valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}
	
	public static final String obtenerValorDefecto(final String valor) {
		return obtenerValorDefecto(valor, VACIO);
	}
	
	public static final String aplicarTrim(final String valor) {
		return obtenerValorDefecto(valor).trim();
	}
	
	public static final boolean igualdadValoresSinTrim(final String valorUno, final String valorDos) {
		return obtenerValorDefecto(valorUno).equals(obtenerValorDefecto(valorDos));
	}
	
	public static final boolean igualdadValoresConTrim(final String valorUno, final String valorDos) {
		return aplicarTrim(valorUno).equals(aplicarTrim(valorDos));
	}
	
	public static final boolean igualdadValoresSinTrimIgnoreCase(final String valorUno, final String valorDos) {
		return obtenerValorDefecto(valorUno).equalsIgnoreCase(obtenerValorDefecto(valorDos));
	}
	
	public static final boolean igualdadValoresConTrimIgnoreCase(final String valorUno, final String valorDos) {
		return aplicarTrim(valorUno).equalsIgnoreCase(aplicarTrim(valorDos));
	}
	
	public static final boolean estaNulo(final String valor) {
		return UtilObjeto.esNulo(valor);
	}
	
	public static final boolean estaVacio(final String valor) {
		return igualdadValoresConTrim(valor, VACIO);
	}
	
	public static final boolean longitudMinimaValida(final String valor, final int longitud) {
		return aplicarTrim(valor).length() >= longitud;
	}
	
	public static final boolean longitudMaximaValida(final String valor, final int longitud) {
		return aplicarTrim(valor).length() <= longitud;
	}
	
	public static final boolean longitudValida(final String valor, final int longitudMinima, final int longitudMaxima) {
		return longitudMinimaValida(valor, longitudMinima) && longitudMaximaValida(valor, longitudMaxima);
	}
	
	public static final boolean contieneSoloLetras(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_SOLO_LETRAS);
	}
	
	public static final boolean contieneSoloLetrasDigitosEspacios(final String valor) {
		return obtenerValorDefecto(valor).matches(PATTERN_SOLO_LETRAS_DIGITOS_ESPACIOS);
	}
	
}
