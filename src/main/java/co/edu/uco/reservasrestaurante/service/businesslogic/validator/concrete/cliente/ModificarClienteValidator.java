package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.cliente;

import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.CorreoElectronicoClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.IdClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.IdentificacionClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.NumeroCelularClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.rules.TipoIdentificacionRule;

public final class ModificarClienteValidator implements Validator<ClienteDomain>{

	private static final Validator<ClienteDomain> instancia = new ModificarClienteValidator();
	
	private ModificarClienteValidator() {
		super();
	}
	
	public static final void ejecutar(final ClienteDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public final void execute(final ClienteDomain data) {
		IdClienteRule.ejecutarValidacion(data.getId());
		IdentificacionClienteRule.ejecutarValidacion(data.getIdentificacion());
		TipoIdentificacionRule.ejecutarValidacion(data.getIdentificacion().getTipoIdentificacion());
		CorreoElectronicoClienteRule.ejecutarValidacion(data.getCorreoElectronico().getCorreoElectronico());
		NumeroCelularClienteRule.ejecutarValidacion(data.getNumeroCelular().getNumeroCelular());
	}

}
