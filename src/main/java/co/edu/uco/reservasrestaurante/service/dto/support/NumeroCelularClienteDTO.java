package co.edu.uco.reservasrestaurante.service.dto.support;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.service.dto.BooleanDTO;

public class NumeroCelularClienteDTO {

	private String numeroCelular;
	private BooleanDTO numeroCelularConfirmado;
	
	public NumeroCelularClienteDTO() {
		setNumeroCelular(UtilTexto.VACIO);
		setNumeroCelularConfirmado(new BooleanDTO());
	}
	
	
	public NumeroCelularClienteDTO(final String numeroCelular, final BooleanDTO numeroCelularConfirmado) {
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}
	
	public static final NumeroCelularClienteDTO crear() {
		return new NumeroCelularClienteDTO();	
	}

	
	public static final NumeroCelularClienteDTO crear(final String numeroCelular, final BooleanDTO numeroCelularConfirmado) {
		return new NumeroCelularClienteDTO(numeroCelular, numeroCelularConfirmado);
	}

	
	public final String getNumeroCelular() {
		return numeroCelular;
	}


	public final BooleanDTO isNumeroCelularConfirmado() {
		return numeroCelularConfirmado;
	}


	public final NumeroCelularClienteDTO setNumeroCelular(final String numeroCelular) {
		this.numeroCelular = UtilTexto.obtenerValorDefecto(numeroCelular, UtilTexto.VACIO);
		return this;
	}


	public final NumeroCelularClienteDTO setNumeroCelularConfirmado(final BooleanDTO numeroCelularConfirmado) {
		this.numeroCelularConfirmado = numeroCelularConfirmado.isValorDefecto() ? BooleanDTO.crear() : 
			BooleanDTO.crear().setValor(numeroCelularConfirmado.isValor()).setValorDefecto(false);
		return this;
	}
}
