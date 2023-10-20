package co.edu.uco.reservasrestaurante.service.businesslogic;

public interface UseCase<D> {
	
	void execute(D domain);
	
	
}
