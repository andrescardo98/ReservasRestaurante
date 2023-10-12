package co.edu.uco.reservasrestaurante.data.dao.daofactory.concrete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.DataReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilSQL;
import co.edu.uco.reservasrestaurante.data.dao.ClienteDAO;
import co.edu.uco.reservasrestaurante.data.dao.PaisDAO;
import co.edu.uco.reservasrestaurante.data.dao.TipoIdentificacionDAO;
import co.edu.uco.reservasrestaurante.data.dao.concrete.sqlserver.ClienteSQLServerDAO;
import co.edu.uco.reservasrestaurante.data.dao.concrete.sqlserver.PaisSQLServerDAO;
import co.edu.uco.reservasrestaurante.data.dao.concrete.sqlserver.TipoIdentificacionSQLServerDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;

public final class SQLServerDAOFactory extends DAOFactory{
	
	private Connection conexion;
	
	public SQLServerDAOFactory() {
		abrirConexion();
	}

	@Override
	protected final void abrirConexion() {
		final String url = Configuracion.obtenerURL();
		final String usuario = Configuracion.obtenerUsuario();
		final String contrasenia = Configuracion.obtenerContrasenia();
		
		try {
			conexion = DriverManager.getConnection(url, usuario, contrasenia);
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000027);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch(final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000029);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public final void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}

	@Override
	public final void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	@Override
	public final void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	@Override
	public final void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
	}

	@Override
	public ClienteDAO obtenerClienteDAO() {
		return new ClienteSQLServerDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		return new TipoIdentificacionSQLServerDAO(conexion);
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		return new PaisSQLServerDAO(conexion);
	}


}
