package co.edu.uco.reservasrestaurante.data.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.data.entity.ClienteEntity;

public interface ClienteDAO {
	
	void crear(ClienteEntity entity);
	
	void modificar(ClienteEntity entity);
	
	void eliminar(UUID id);
	
	Optional<ClienteEntity> consultarPorId(UUID id);
	
	List<ClienteEntity> consultar(ClienteEntity entity);

}
