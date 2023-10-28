package co.edu.uco.reservasrestaurante.crosscutting.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class UtilNumeroCelular {
	
	private static final String PATRON_NUMERO_CELULAR = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
	
	private UtilNumeroCelular() {
		super();
	}
	
	public static boolean validarNumeroCelular(String numeroCelular) {
		Pattern patron = Pattern.compile(PATRON_NUMERO_CELULAR);
		Matcher matcher = patron.matcher(numeroCelular);
		return matcher.matches();
	}
	
}
