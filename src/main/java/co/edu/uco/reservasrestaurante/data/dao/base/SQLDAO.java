package co.edu.uco.reservasrestaurante.data.dao.base;

import java.sql.Connection;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.CrossCuttingReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilSQL;

public class SQLDAO {
	
	private Connection conexion;

	protected SQLDAO(final Connection conexion) {
		setConexion(conexion);
	}
	
	protected final Connection getConexion() {
		return conexion;
	}
	
	private final void setConexion(final Connection conexion) {
		if (!UtilSQL.conexionAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000035);
			throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.conexion = conexion;
	}

}
