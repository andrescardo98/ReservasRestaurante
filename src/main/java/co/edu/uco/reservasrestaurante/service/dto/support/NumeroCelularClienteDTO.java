package co.edu.uco.reservasrestaurante.service.dto.support;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;

public class NumeroCelularClienteDTO {

	private String numeroCelular;
	private boolean numeroCelularConfirmado;
	
	public NumeroCelularClienteDTO() {
		setNumeroCelular(UtilTexto.VACIO);
		setNumeroCelularConfirmado(false);
	}
	
	
	public NumeroCelularClienteDTO(final String numeroCelular, final boolean numeroCelularConfirmado) {
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}
	
	public static final NumeroCelularClienteDTO crear() {
		return new NumeroCelularClienteDTO();	
	}

	
	public static final NumeroCelularClienteDTO crear(final String numeroCelular, final boolean numeroCelularConfirmado) {
		return new NumeroCelularClienteDTO(numeroCelular, numeroCelularConfirmado);
	}

	
	public final String getNumeroCelular() {
		return numeroCelular;
	}


	public final boolean isNumeroCelularConfirmado() {
		return numeroCelularConfirmado;
	}


	public final NumeroCelularClienteDTO setNumeroCelular(final String numeroCelular) {
		this.numeroCelular = UtilTexto.obtenerValorDefecto(numeroCelular, UtilTexto.VACIO);
		return this;
	}


	public final NumeroCelularClienteDTO setNumeroCelularConfirmado(final boolean numeroCelularConfirmado) {
		this.numeroCelularConfirmado = numeroCelularConfirmado;
		return this;
	}
}
