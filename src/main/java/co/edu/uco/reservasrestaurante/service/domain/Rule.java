package co.edu.uco.reservasrestaurante.service.domain;

public interface Rule<T> {
	
	void validar(T dato);
}
