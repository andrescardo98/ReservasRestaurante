package co.edu.uco.reservasrestaurante.crosscutting.util;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.CrossCuttingReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;

public final class UtilSQL {
	
	private UtilSQL() {
		super();
	}
	
	public static final boolean conexionAbierta(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000009);
			throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		try {
			return !UtilObjeto.esNulo(conexion) && !conexion.isClosed();
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000005);
			throw CrossCuttingReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000006);
			throw CrossCuttingReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void cerrarConexion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000007);
			throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		try {
			if (!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000008);
				throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
			}
			conexion.close();
			
		} catch (final CrossCuttingReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000010);
			throw CrossCuttingReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);		
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000011);
			throw CrossCuttingReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void iniciarTransaccion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000012);
			throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		try {
			if (!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000013);
				throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
			}
			if (!conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000014);
				throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			conexion.setAutoCommit(false);
		} catch (final CrossCuttingReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000015);
			throw CrossCuttingReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);		
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000016);
			throw CrossCuttingReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void confirmarTransaccion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000017);
			throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		try {
			if (!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000018);
				throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
			}
			if (conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000019);
				throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			conexion.commit();
		} catch (final CrossCuttingReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000020);
			throw CrossCuttingReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);		
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000021);
			throw CrossCuttingReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	public static final void cancelarTransaccion(final Connection conexion) {
		if (UtilObjeto.esNulo(conexion)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000022);
			throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		try {
			if (!conexionAbierta(conexion)) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000023);
				throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
			}
			if (conexion.getAutoCommit()) {
				var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000024);
				throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
			}
			
			conexion.rollback();
		} catch (final CrossCuttingReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000025);
			throw CrossCuttingReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);		
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000026);
			throw CrossCuttingReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
}

