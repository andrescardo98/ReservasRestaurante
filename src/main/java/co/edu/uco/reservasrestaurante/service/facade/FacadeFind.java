package co.edu.uco.reservasrestaurante.service.facade;

import java.util.List;

public interface FacadeFind<T> {

	List<T> execute(T dto);
}
