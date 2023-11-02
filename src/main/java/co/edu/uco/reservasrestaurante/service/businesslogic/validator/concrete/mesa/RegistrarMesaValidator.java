package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.mesa;

import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;
import co.edu.uco.reservasrestaurante.service.domain.mesa.rules.IdMesaRule;
import co.edu.uco.reservasrestaurante.service.domain.mesa.rules.MesaRule;
import co.edu.uco.reservasrestaurante.service.domain.mesa.rules.NumeroMesaRule;

public final class RegistrarMesaValidator implements Validator<MesaDomain>{

	private static final Validator<MesaDomain> instancia = new RegistrarMesaValidator();
	
	private RegistrarMesaValidator() {
		super();
	}
	
	public static final void ejecutar(final MesaDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(final MesaDomain data) {
		MesaRule.ejecutarValidacion(data);
		IdMesaRule.ejecutarValidacion(data.getId());
		NumeroMesaRule.ejecutarValidacion(data.getNumero());
	}

}
