package co.edu.uco.reservasrestaurante.data.dao.daofactory.concrete;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.DataReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilSQL;
import co.edu.uco.reservasrestaurante.data.dao.ClienteDAO;
import co.edu.uco.reservasrestaurante.data.dao.MesaDAO;
import co.edu.uco.reservasrestaurante.data.dao.PaisDAO;
import co.edu.uco.reservasrestaurante.data.dao.ReservaDAO;
import co.edu.uco.reservasrestaurante.data.dao.TipoIdentificacionDAO;
import co.edu.uco.reservasrestaurante.data.dao.concrete.postgresql.ClientePostgreSQLDAO;
import co.edu.uco.reservasrestaurante.data.dao.concrete.postgresql.MesaPostgreSQLDAO;
import co.edu.uco.reservasrestaurante.data.dao.concrete.postgresql.PaisPostgreSQLDAO;
import co.edu.uco.reservasrestaurante.data.dao.concrete.postgresql.ReservaPostgreSQLDAO;
import co.edu.uco.reservasrestaurante.data.dao.concrete.postgresql.TipoIdentificacionPostgreSQLDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;

public final class PostgreSQLDAOFactory extends DAOFactory{
	
	private Connection conexion;
	
	public PostgreSQLDAOFactory() {
		abrirConexion();
	}

	@Override
	protected final void abrirConexion() {
		
		try {
			Properties prop = new Properties();
			InputStream input = getClass().getResourceAsStream("/application.properties");
			prop.load(input);
			String url = prop.getProperty("db.url");
			String usuario = prop.getProperty("db.user");
			String contresenia = prop.getProperty("db.password");
	        
	        if (url == null || url.isEmpty() || usuario == null || usuario.isEmpty() || contresenia == null || contresenia.isEmpty()) {
	        	var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
				var mensajeTecnico = "No se pudieron obtener credenciales de la base de datos";
				throw DataReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
	        }
			
			conexion = DriverManager.getConnection(url, usuario, contresenia);
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
		return new ClientePostgreSQLDAO(conexion);
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		return new TipoIdentificacionPostgreSQLDAO(conexion);
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		return new PaisPostgreSQLDAO(conexion);
	}

	@Override
	public ReservaDAO obtenerReservaDAO() {
		return new ReservaPostgreSQLDAO(conexion);
	}

	@Override
	public MesaDAO obtenerMesaDAO() {
		return new MesaPostgreSQLDAO(conexion);
	}


}
