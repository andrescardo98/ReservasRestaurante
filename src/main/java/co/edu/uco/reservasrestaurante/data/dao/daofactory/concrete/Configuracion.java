package co.edu.uco.reservasrestaurante.data.dao.daofactory.concrete;

import java.io.InputStream;
import java.util.Properties;

public final class Configuracion {
	
	private static final Properties PROPIEDADES = new Properties();
	
	static {
		try(InputStream input = ClassLoader.getSystemResourceAsStream("config.properties")) {
			PROPIEDADES.load(input);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String obtenerURL() {
		return PROPIEDADES.getProperty("db.url");
	}
	
	public static String obtenerUsuario() {
		return PROPIEDADES.getProperty("db.usuario");
	}
	
	public static String obtenerContrasenia() {
		return PROPIEDADES.getProperty("db.contrasenia");
	}

}
