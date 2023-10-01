package co.edu.uco.reservasrestaurante.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.data.dao.PaisDAO;
import co.edu.uco.reservasrestaurante.data.dao.base.SQLDAO;
import co.edu.uco.reservasrestaurante.data.entity.PaisEntity;

public class PaisSQLServerDAO extends SQLDAO implements PaisDAO {

	public PaisSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final PaisEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void modificar(final PaisEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final void eliminar(final UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public final Optional<PaisEntity> consultarPorId(final UUID id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public final List<PaisEntity> consultar(final PaisEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

}
