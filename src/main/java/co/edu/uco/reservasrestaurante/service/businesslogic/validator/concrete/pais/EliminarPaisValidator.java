package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.pais;

import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.PaisClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;
import co.edu.uco.reservasrestaurante.service.domain.pais.rules.IdPaisRule;

public class EliminarPaisValidator implements Validator<PaisDomain>{

	private static final Validator<PaisDomain> instancia = new EliminarPaisValidator();
	
	private EliminarPaisValidator() {
		super();
	}
	
	public static final void ejecutar(final PaisDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public void execute(PaisDomain data) {
		PaisClienteRule.ejecutarValidacion(data);
		IdPaisRule.ejecutarValidacion(data.getId());
	}

}
