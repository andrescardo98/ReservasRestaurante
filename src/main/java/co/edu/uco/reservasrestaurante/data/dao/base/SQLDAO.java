package co.edu.uco.reservasrestaurante.data.dao.base;

import java.sql.Connection;

public class SQLDAO {
	
	private Connection conexion;

	protected SQLDAO(final Connection conexion) {
		setConexion(conexion);
	}
	
	protected final Connection getConexion() {
		return conexion;
	}
	
	private final void setConexion(final Connection conexion) {
		// TODO: Controlar que la conexion no sea nula, que no esté cerrada o que ya se 
		// haya confirmado una transaccion
		this.conexion = conexion;
	}

}
