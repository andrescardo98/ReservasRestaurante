package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.reserva;

import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.IdReservaRule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.ReservaRule;

public class EliminarReservaValidator implements Validator<ReservaDomain>{

private static final Validator<ReservaDomain> instancia = new EliminarReservaValidator();
	
	private EliminarReservaValidator() {
		super();
	}
	
	public static final void ejecutar(final ReservaDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(ReservaDomain data) {
		ReservaRule.ejecutarValidacion(data);
		IdReservaRule.ejecutarValidacion(data.getId());
	}
}
