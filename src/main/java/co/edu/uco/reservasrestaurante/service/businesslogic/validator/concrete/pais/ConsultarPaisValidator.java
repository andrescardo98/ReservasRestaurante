package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.pais;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilUUID;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;
import co.edu.uco.reservasrestaurante.service.domain.pais.rules.CodigoIndicativoPaisRule;
import co.edu.uco.reservasrestaurante.service.domain.pais.rules.IdPaisRule;
import co.edu.uco.reservasrestaurante.service.domain.pais.rules.NombrePaisRule;

public class ConsultarPaisValidator implements Validator<PaisDomain>{

	private static final Validator<PaisDomain> instancia = new ConsultarPaisValidator();
	
	private ConsultarPaisValidator() {
		super();
	}
	
	public static final void ejecutar(final PaisDomain data) {
		instancia.execute(data);

	}
	
	@Override
	public void execute(PaisDomain data) {
		if (!UtilObjeto.esNulo(data)) {
			if (!UtilUUID.esUUIDPorDefecto(data.getId())) {
				IdPaisRule.ejecutarValidacion(data.getId());
			}
			
			if (!UtilTexto.estaVacio(data.getNombre())) {
				NombrePaisRule.ejecutarValidacion(data.getNombre());
			}
			
			if (!UtilTexto.estaVacio(data.getCodigoIndicativo())) {
				CodigoIndicativoPaisRule.ejecutarValidacion(data.getCodigoIndicativo());
			}
			
			
		}
	}

}
