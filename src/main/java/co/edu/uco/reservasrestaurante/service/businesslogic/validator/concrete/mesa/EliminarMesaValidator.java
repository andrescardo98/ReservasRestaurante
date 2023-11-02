package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.mesa;

import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;
import co.edu.uco.reservasrestaurante.service.domain.mesa.rules.IdMesaRule;
import co.edu.uco.reservasrestaurante.service.domain.mesa.rules.MesaRule;

public final class EliminarMesaValidator implements Validator<MesaDomain>{

	private static final Validator<MesaDomain> instancia = new EliminarMesaValidator();
	
	private EliminarMesaValidator() {
		super();
	}
	
	public static final void ejecutar(final MesaDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(final MesaDomain data) {
		MesaRule.ejecutarValidacion(data);
		IdMesaRule.ejecutarValidacion(data.getId());
	}

}
