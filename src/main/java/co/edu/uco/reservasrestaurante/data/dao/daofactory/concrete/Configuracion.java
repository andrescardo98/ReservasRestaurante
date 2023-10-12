package co.edu.uco.reservasrestaurante.data.dao.daofactory.concrete;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.DataReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;

public final class Configuracion {
	
	private static final Properties PROPIEDADES = new Properties();
	
	static {
		try(InputStream input = ClassLoader.getSystemResourceAsStream("config.properties")) {
			PROPIEDADES.load(input);
		} catch (final IOException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000030);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000031);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
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
