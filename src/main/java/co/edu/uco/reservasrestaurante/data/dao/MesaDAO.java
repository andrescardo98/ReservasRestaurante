package co.edu.uco.reservasrestaurante.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.data.entity.MesaEntity;

public interface MesaDAO {
	
	void crear(MesaEntity entity);
	
	void modificar(MesaEntity entity);
	
	void eliminar(UUID id);
	
	Optional<MesaEntity> consultarPorId(UUID id);
	
	List<MesaEntity> consultar(MesaEntity entity);

}
