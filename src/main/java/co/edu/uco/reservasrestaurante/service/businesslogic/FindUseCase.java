package co.edu.uco.reservasrestaurante.service.businesslogic;

import java.util.List;

public interface FindUseCase<D> {
	
	List<D> execute(D domain);
	
	
}
