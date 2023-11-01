package co.edu.uco.reservasrestaurante.service.domain.reserva.rules;


import java.util.Calendar;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.service.domain.Rule;

public final class HoraReservaRule implements Rule<String>{
	
	private static final Rule<String> instancia = new HoraReservaRule();
	
	private HoraReservaRule() {
		super();
	}
	
	public static final void ejecutarValidacion(final String dato) {
		instancia.validar(dato);
	}

	@Override
	public void validar(String dato) {
		validarFormato(dato);
		validarObligatoriedad(dato);
		validarIntervalo(dato);
		validarHoraPresente(dato);
	}
	
	private final void validarFormato(final String dato) {
		if (!UtilTexto.formatoHora(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000236);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarObligatoriedad(final String dato) {
		if (!UtilTexto.estaVacio(dato)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000237);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarIntervalo(final String dato) {
		String[] partes = dato.split(":");
		int horas = Integer.parseInt(partes[0]);
		int minutos = Integer.parseInt(partes[1]);
		
		if (horas < 0 || horas > 23 || minutos < 0 || minutos > 59) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000238);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarHoraPresente(final String dato) {
		String[] partes = dato.split(":");
		int horas = Integer.parseInt(partes[0]);
		int minutos = Integer.parseInt(partes[1]);
		Calendar calendar = Calendar.getInstance();
		int horaActual = calendar.get(Calendar.HOUR_OF_DAY);
		int minutosActuales = calendar.get(Calendar.MINUTE);
		
		if (horas < horaActual || (horas == horaActual && minutos <= minutosActuales)) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000239);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
}
