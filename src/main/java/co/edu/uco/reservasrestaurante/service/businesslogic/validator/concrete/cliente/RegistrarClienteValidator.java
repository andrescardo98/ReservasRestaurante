package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.cliente;

import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.ClaveClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.CorreoElectronicoClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.FechaNacimientoClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.IdClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.IdentificacionClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.PrimerApellidoClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.PrimerNombreClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.SegundoApellidoClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.SegundoNombreClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.rules.TipoIdentificacionRule;

public final class RegistrarClienteValidator implements Validator<ClienteDomain>{

	private static final Validator<ClienteDomain> instancia = new RegistrarClienteValidator();
	
	private RegistrarClienteValidator() {
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
		PrimerNombreClienteRule.ejecutarValidacion(data.getNombreCompleto().getPrimerNombre());
		SegundoNombreClienteRule.ejecutarValidacion(data.getNombreCompleto().getSegundoNombre());
		PrimerApellidoClienteRule.ejecutarValidacion(data.getNombreCompleto().getPrimerApellido());
		SegundoApellidoClienteRule.ejecutarValidacion(data.getNombreCompleto().getSegundoApellido());
		CorreoElectronicoClienteRule.ejecutarValidacion(data.getCorreoElectronico().getCorreoElectronico());
		ClaveClienteRule.ejecutarValidacion(data.getCorreoElectronico().getClave());
		FechaNacimientoClienteRule.ejecutarValidacion(data.getFechaNacimiento());
	}

}
