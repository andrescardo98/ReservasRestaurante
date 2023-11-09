package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.pais;

import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.PaisClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;
import co.edu.uco.reservasrestaurante.service.domain.pais.rules.CodigoISO3PaisRule;
import co.edu.uco.reservasrestaurante.service.domain.pais.rules.CodigoIndicativoPaisRule;
import co.edu.uco.reservasrestaurante.service.domain.pais.rules.NombrePaisRule;

public class RegistrarPaisValidator implements Validator<PaisDomain>{

	private static final Validator<PaisDomain> instancia = new RegistrarPaisValidator();
	
	private RegistrarPaisValidator() {
		super();
	}
	
	public static final void ejecutar(final PaisDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public void execute(PaisDomain data) {
		PaisClienteRule.ejecutarValidacion(data);
		CodigoIndicativoPaisRule.ejecutarValidacion(data.getCodigoIndicativo());
		CodigoISO3PaisRule.ejecutarValidacion(data.getCodigoIso3());
		NombrePaisRule.ejecutarValidacion(data.getNombre());
	}

}
