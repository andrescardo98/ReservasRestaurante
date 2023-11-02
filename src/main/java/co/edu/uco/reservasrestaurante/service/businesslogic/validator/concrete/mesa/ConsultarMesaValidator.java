package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.mesa;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;
import co.edu.uco.reservasrestaurante.service.domain.mesa.rules.CapacidadMesaRule;
import co.edu.uco.reservasrestaurante.service.domain.mesa.rules.NumeroMesaRule;
import co.edu.uco.reservasrestaurante.service.domain.mesa.rules.UbicacionMesaRule;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.rules.IdTipoIdentificacionRule;

public final class ConsultarMesaValidator implements Validator<MesaDomain>{

	private static final Validator<MesaDomain> instancia = new ConsultarMesaValidator();
	
	private ConsultarMesaValidator() {
		super();
	}
	
	public static final void ejecutar(final MesaDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(final MesaDomain data) {
		if (!UtilObjeto.esNulo(data)) {
			if (!UtilObjeto.esNulo(data.getId())) {
				IdTipoIdentificacionRule.ejecutarValidacion(data.getId());
			}
			
			if (!UtilObjeto.esNulo(data.getNumero())) {
				NumeroMesaRule.ejecutarValidacion(data.getNumero());
			}
			
			if (!UtilTexto.estaVacio(data.getUbicacion())) {
				UbicacionMesaRule.ejecutarValidacion(data.getUbicacion());
			}
			
			if (!UtilObjeto.esNulo(data.getCapacidad())) {
				CapacidadMesaRule.ejecutarValidacion(data.getCapacidad());
			}
		}
	}

}
