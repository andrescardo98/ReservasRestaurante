package co.edu.uco.reservasrestaurante.data.dao.daofactory;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.DataReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.data.dao.ClienteDAO;
import co.edu.uco.reservasrestaurante.data.dao.MesaDAO;
import co.edu.uco.reservasrestaurante.data.dao.PaisDAO;
import co.edu.uco.reservasrestaurante.data.dao.ReservaDAO;
import co.edu.uco.reservasrestaurante.data.dao.TipoIdentificacionDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.concrete.PostgreSQLDAOFactory;

public abstract class DAOFactory {
	
	public static final DAOFactory obtenerDAOFactory(final TipoDAOFactory factoria) {
		
		switch (factoria) {
		case SQLSERVER: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000091);
			throw DataReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		case POSTGRESQL: {
			return new PostgreSQLDAOFactory();
		}
		case MYSQL: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000091);
			throw DataReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		case ORACLE: {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000091);
			throw DataReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		default:
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000091);
			throw DataReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
	}
	
	protected abstract void abrirConexion();
	
	public abstract void cerrarConexion();
	
	public abstract void iniciarTransaccion();
	
	public abstract void confirmarTransaccion();
	
	public abstract void cancelarTransaccion();

	public abstract ClienteDAO obtenerClienteDAO();
	
	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDAO();
	
	public abstract PaisDAO obtenerPaisDAO();
	
	public abstract ReservaDAO obtenerReservaDAO();
	
	public abstract MesaDAO obtenerMesaDAO();
	
}
