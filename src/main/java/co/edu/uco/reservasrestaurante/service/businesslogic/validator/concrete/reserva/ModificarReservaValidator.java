package co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.reserva;

import co.edu.uco.reservasrestaurante.service.businesslogic.validator.Validator;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.CantidadPersonasReservaRule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.ClienteReservaRule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.FechaReservaRule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.HoraReservaRule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.IdReservaRule;
import co.edu.uco.reservasrestaurante.service.domain.reserva.rules.ReservaRule;

public class ModificarReservaValidator implements Validator<ReservaDomain>{

private static final Validator<ReservaDomain> instancia = new ModificarReservaValidator();
	
	private ModificarReservaValidator() {
		super();
	}
	
	public static final void ejecutar(final ReservaDomain data) {
		instancia.execute(data);
	}

	@Override
	public void execute(ReservaDomain data) {
		ReservaRule.ejecutarValidacion(data);
		IdReservaRule.ejecutarValidacion(data.getId());
		ClienteReservaRule.ejecutarValidacion(data.getCliente());
		FechaReservaRule.ejecutarValidacion(data.getFecha());
		HoraReservaRule.ejecutarValidacion(data.getHora());
		CantidadPersonasReservaRule.ejecutarValidacion(data.getCantidadPersonas());
	}
}
