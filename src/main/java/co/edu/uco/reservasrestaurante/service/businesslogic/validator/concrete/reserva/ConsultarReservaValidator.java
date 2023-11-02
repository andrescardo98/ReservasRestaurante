package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.reserva;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.CantidadPersonasReservaRule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.ClienteReservaRule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.FechaReservaRule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.HoraReservaRule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.IdReservaRule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.MesaReservaRule;

public class ConsultarReservaValidator implements Validator<ReservaDomain>{

private static final Validator<ReservaDomain> instancia = new ConsultarReservaValidator();
	
	private ConsultarReservaValidator() {
		super();
	}
	
	public static final void ejecutar(final ReservaDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(ReservaDomain data) {
		if (!UtilObjeto.esNulo(data)) {
			if (!UtilObjeto.esNulo(data.getId())) {
				IdReservaRule.ejecutarValidacion(data.getId());
			}
			
			if (!UtilObjeto.esNulo(data.getCliente())) {
				ClienteReservaRule.ejecutarValidacion(data.getCliente());
			}
			
			if (!UtilObjeto.esNulo(data.getFecha())) {
				FechaReservaRule.ejecutarValidacion(data.getFecha());
			}
			
			if (!UtilObjeto.esNulo(data.getHora())) {
				HoraReservaRule.ejecutarValidacion(data.getHora());
			}
			
			if (!UtilObjeto.esNulo(data.getMesa())) {
				MesaReservaRule.ejecutarValidacion(data.getMesa());
			}
			
			if (!UtilObjeto.esNulo(data.getCantidadPersonas())) {
				CantidadPersonasReservaRule.ejecutarValidacion(data.getCantidadPersonas());
			}
		}
	}
}
