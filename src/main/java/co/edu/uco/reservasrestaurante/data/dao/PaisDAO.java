package co.edu.uco.reservasrestaurante.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.data.entity.PaisEntity;

public interface PaisDAO {
	
	void crear(PaisEntity entity);
	
	void modificar(PaisEntity entity);
	
	void eliminar(UUID id);
	
	Optional<PaisEntity> consultarPorId(UUID id);
	
	List<PaisEntity> consultar(PaisEntity entity);

}
