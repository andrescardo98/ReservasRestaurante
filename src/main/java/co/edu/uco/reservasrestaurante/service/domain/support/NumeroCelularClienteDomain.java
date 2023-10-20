package co.edu.uco.reservasrestaurante.service.domain.support;

public final class NumeroCelularClienteDomain {
	private int numeroCelular;
	private boolean numeroCelularConfirmado;
	
	
	private NumeroCelularClienteDomain(final int numeroCelular, final boolean numeroCelularConfirmado) {
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}

	
	public static final NumeroCelularClienteDomain crear(final int numeroCelular, final boolean numeroCelularConfirmado) {
		return new NumeroCelularClienteDomain(numeroCelular, numeroCelularConfirmado);
	}

	
	public final int getNumeroCelular() {
		return numeroCelular;
	}


	public final boolean isNumeroCelularConfirmado() {
		return numeroCelularConfirmado;
	}


	private final void setNumeroCelular(final int numeroCelular) {
		this.numeroCelular = numeroCelular;
	}


	private final void setNumeroCelularConfirmado(final boolean numeroCelularConfirmado) {
		this.numeroCelularConfirmado = numeroCelularConfirmado;
	}
	
}