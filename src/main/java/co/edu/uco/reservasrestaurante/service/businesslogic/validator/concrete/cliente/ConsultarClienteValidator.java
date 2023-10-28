package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.cliente;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.CorreoElectronicoClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.FechaNacimientoClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.IdClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.NumeroCelularClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.NumeroIdentificacionClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.PaisClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.PrimerApellidoClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.PrimerNombreClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.SegundoApellidoClienteRule;
import co.edu.uco.reservasrestaurante.service.domain.cliente.rules.SegundoNombreClienteRule;

public final class ConsultarClienteValidator implements Validator<ClienteDomain>{

	private static final Validator<ClienteDomain> instancia = new ConsultarClienteValidator();
	
	private ConsultarClienteValidator() {
		super();
	}
	
	public static final void ejecutar(final ClienteDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public final void execute(final ClienteDomain data) {
		if (!UtilObjeto.esNulo(data)) {
			validarIdentificacion(data);
			validarNombreCompleto(data);
			validarCorreoElectronico(data);
			validarPais(data);
			validarFechaNacimiento(data);
			validarNumeroCelular(data);
		}
	}
	
	private void validarIdentificacion(ClienteDomain data) {
		if (!UtilObjeto.esNulo(data.getId())) {
			IdClienteRule.ejecutarValidacion(data.getId());
		}
		if (!UtilObjeto.esNulo(data.getIdentificacion().getNumeroIdentificacion())) {
			NumeroIdentificacionClienteRule.ejecutarValidacion(data.getIdentificacion().getNumeroIdentificacion());
		}
	}
	
	private void validarNombreCompleto(ClienteDomain data) {
		if (!UtilObjeto.esNulo(data.getNombreCompleto())) {
			if (!UtilObjeto.esNulo(data.getNombreCompleto().getPrimerNombre())) {
				PrimerNombreClienteRule.ejecutarValidacion(data.getNombreCompleto().getPrimerNombre());
			}
			if (!UtilObjeto.esNulo(data.getNombreCompleto().getSegundoNombre())) {
				SegundoNombreClienteRule.ejecutarValidacion(data.getNombreCompleto().getSegundoNombre());
			}
			if (!UtilObjeto.esNulo(data.getNombreCompleto().getPrimerApellido())) {
				PrimerApellidoClienteRule.ejecutarValidacion(data.getNombreCompleto().getPrimerApellido());
			}
			if (!UtilObjeto.esNulo(data.getNombreCompleto().getSegundoApellido())) {
				SegundoApellidoClienteRule.ejecutarValidacion(data.getNombreCompleto().getSegundoApellido());
			}
		}
	}
	
	private void validarCorreoElectronico(ClienteDomain data) {
		if (!UtilObjeto.esNulo(data.getCorreoElectronico().getCorreoElectronico())) {
				CorreoElectronicoClienteRule.ejecutarValidacion(data.getCorreoElectronico().getCorreoElectronico());
		}
	}
	
	private void validarPais(ClienteDomain data) {
		if (!UtilObjeto.esNulo(data.getPais())) {
			PaisClienteRule.ejecutarValidacion(data.getPais());
		}
	}
	
	private void validarFechaNacimiento(ClienteDomain data) {
		if (!UtilObjeto.esNulo(data.getFechaNacimiento())) {
			FechaNacimientoClienteRule.ejecutarValidacion(data.getFechaNacimiento());
		}
	}
	
	private void validarNumeroCelular(ClienteDomain data) {
		if (!UtilObjeto.esNulo(data.getNumeroCelular())) {
			NumeroCelularClienteRule.ejecutarValidacion(data.getNumeroCelular().getNumeroCelular());
		}
	}
}
