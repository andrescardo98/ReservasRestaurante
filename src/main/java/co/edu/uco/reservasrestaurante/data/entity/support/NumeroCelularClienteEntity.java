package co.edu.uco.reservasrestaurante.data.entity.support;

public final class NumeroCelularClienteEntity {
	private String numeroCelular;
	private boolean numeroCelularConfirmado;
	
	
	private NumeroCelularClienteEntity(final String numeroCelular, final boolean numeroCelularConfirmado) {
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}

	
	public static final NumeroCelularClienteEntity crear(final String numeroCelular, final boolean numeroCelularConfirmado) {
		return new NumeroCelularClienteEntity(numeroCelular, numeroCelularConfirmado);
	}

	
	public final String getNumeroCelular() {
		return numeroCelular;
	}


	public final boolean isNumeroCelularConfirmado() {
		return numeroCelularConfirmado;
	}


	private final void setNumeroCelular(final String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}


	private final void setNumeroCelularConfirmado(final boolean numeroCelularConfirmado) {
		this.numeroCelularConfirmado = numeroCelularConfirmado;
	}
	
	

	
}