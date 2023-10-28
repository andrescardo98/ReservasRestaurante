package co.edu.uco.reservasrestaurante.service.domain.support;

public final class NumeroCelularClienteDomain {
	private String numeroCelular;
	private boolean numeroCelularConfirmado;
	
	
	private NumeroCelularClienteDomain(final String numeroCelular, final boolean numeroCelularConfirmado) {
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}

	
	public static final NumeroCelularClienteDomain crear(final String numeroCelular, final boolean numeroCelularConfirmado) {
		return new NumeroCelularClienteDomain(numeroCelular, numeroCelularConfirmado);
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