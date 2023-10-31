package co.edu.uco.reservasrestaurante.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.data.entity.ReservaEntity;

public interface ReservaDAO {

	void crear(ReservaEntity entity);
	
	void modificar(ReservaEntity entity);
	
	void eliminar(UUID id);
	
	Optional<ReservaEntity> consultarPorId(UUID id);
	
	List<ReservaEntity> consultar(ReservaEntity entity);
}
