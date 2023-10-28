package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.cliente;

import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.IdClienteRule;

public final class EliminarClienteValidator implements Validator<ClienteDomain>{

	private static final Validator<ClienteDomain> instancia = new EliminarClienteValidator();
	
	private EliminarClienteValidator() {
		super();
	}
	
	public static final void ejecutar(final ClienteDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public final void execute(final ClienteDomain data) {
		IdClienteRule.ejecutarValidacion(data.getId());
	}

}
