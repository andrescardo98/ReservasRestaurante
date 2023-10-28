package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.tipoidentificacion;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.rules.CodigoTipoIdentificacionRule;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.rules.IdTipoIdentificacionRule;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.rules.NombreTipoIdentificacionRule;

public final class ConsultarTipoIdentificacionValidator implements Validator<TipoIdentificacionDomain>{

	private static final Validator<TipoIdentificacionDomain> instancia = new ConsultarTipoIdentificacionValidator();
	
	private ConsultarTipoIdentificacionValidator() {
		super();
	}
	
	public static final void ejecutar(final TipoIdentificacionDomain data) {
		instancia.execute(data);
	}
	
	@Override
	public final void execute(final TipoIdentificacionDomain data) {

		if (!UtilObjeto.esNulo(data)) {
			if (!UtilObjeto.esNulo(data.getId())) {
				IdTipoIdentificacionRule.ejecutarValidacion(data.getId());
			}
			
			if (!UtilObjeto.esNulo(data.getNombre())) {
				NombreTipoIdentificacionRule.ejecutarValidacion(data.getNombre());
			}
			
			if (!UtilObjeto.esNulo(data.getCodigo())) {
				CodigoTipoIdentificacionRule.ejecutarValidacion(data.getCodigo());
			}
		}
	}

}
