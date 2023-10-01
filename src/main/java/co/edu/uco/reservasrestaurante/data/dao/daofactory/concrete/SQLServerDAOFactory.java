package co.edu.uco.reservasrestaurante.data.dao.daofactory.concrete;

import java.sql.Connection;

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
		// TODO Your homework will be to obtain connection with SQL Server database
		conexion = null;
		
	}

	@Override
	public final void cerrarConexion() {
		// TODO Your homework will be to close connection
		
	}

	@Override
	public final void iniciarTransaccion() {
		// TODO Your homework will be to init transaction
		
	}

	@Override
	public final void confirmarTransaccion() {
		// TODO Your homework will be to commit transaction
		
	}

	@Override
	public final void cancelarTransaccion() {
		// TODO Your homework will be to rollback transaction
		
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
