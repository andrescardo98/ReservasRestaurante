package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.tipoidentificacion;

import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionRule;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.rules.NombreTipoIdentificacionRule;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.rules.TipoIdentificacionRule;

public final class RegistrarTipoIdentificacionValidator implements Validator<TipoIdentificacionDomain>{

	private static final Validator<TipoIdentificacionDomain> instancia = new RegistrarTipoIdentificacionValidator();
	
	private RegistrarTipoIdentificacionValidator() {
		super();
	}
	
	public static final void ejecutar(final TipoIdentificacionDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public final void execute(final TipoIdentificacionDomain data) {
		TipoIdentificacionRule.ejecutarValidacion(data);
		NombreTipoIdentificacionRule.ejecutarValidacion(data.getNombre());
		CodigoTipoIdentificacionRule.ejecutarValidacion(data.getCodigo());
		
	}

}
