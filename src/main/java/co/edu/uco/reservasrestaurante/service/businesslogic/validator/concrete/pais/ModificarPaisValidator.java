package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.pais;

import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.PaisClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;
import co.edu.uco.reservasrestaurante.service.domain.pais.rules.CodigoISO3PaisRule;
import co.edu.uco.reservasrestaurante.service.domain.pais.rules.CodigoIndicativoPaisRule;
import co.edu.uco.reservasrestaurante.service.domain.pais.rules.IdPaisRule;
import co.edu.uco.reservasrestaurante.service.domain.pais.rules.NombrePaisRule;

public class ModificarPaisValidator implements Validator<PaisDomain>{

	private static final Validator<PaisDomain> instancia = new ModificarPaisValidator();
	
	private ModificarPaisValidator() {
		super();
	}
	
	public static final void ejecutar(final PaisDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public void execute(PaisDomain data) {
		PaisClienteRule.ejecutarValidacion(data);
		IdPaisRule.ejecutarValidacion(data.getId());
		NombrePaisRule.ejecutarValidacion(data.getNombre());
		CodigoIndicativoPaisRule.ejecutarValidacion(data.getCodigoIndicativo());
		CodigoISO3PaisRule.ejecutarValidacion(data.getCodigoiso3());
	}

}
