package co.edu.uco.reservasrestaurante.data.entity.support;

public final class NumeroCelularClienteEntity {
	private String numeroCelular;
	private BooleanEntity numeroCelularConfirmado;
	
	
	private NumeroCelularClienteEntity(final String numeroCelular, final BooleanEntity numeroCelularConfirmado) {
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}

	
	public static final NumeroCelularClienteEntity crear(final String numeroCelular, final BooleanEntity numeroCelularConfirmado) {
		return new NumeroCelularClienteEntity(numeroCelular, numeroCelularConfirmado);
	}

	
	public final String getNumeroCelular() {
		return numeroCelular;
	}


	public final BooleanEntity isNumeroCelularConfirmado() {
		return numeroCelularConfirmado;
	}


	private final void setNumeroCelular(final String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}


	private final void setNumeroCelularConfirmado(final BooleanEntity numeroCelularConfirmado) {
		this.numeroCelularConfirmado = numeroCelularConfirmado;
	}
	
	

	
}