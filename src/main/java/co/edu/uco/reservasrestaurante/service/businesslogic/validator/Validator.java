package co.edu.uco.reservasrestaurante.service.businesslogic.validator;

public interface Validator<T> {

	void execute(T data);
}
