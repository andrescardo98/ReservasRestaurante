package co.edu.uco.reservasrestaurante.service.domain.support;


public final class NumeroCelularClienteDomain {
	private String numeroCelular;
	private BooleanDomain numeroCelularConfirmado;
	
	
	private NumeroCelularClienteDomain(final String numeroCelular, final BooleanDomain numeroCelularConfirmado) {
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}

	
	public static final NumeroCelularClienteDomain crear(final String numeroCelular, final BooleanDomain numeroCelularConfirmado) {
		return new NumeroCelularClienteDomain(numeroCelular, numeroCelularConfirmado);
	}

	
	public final String getNumeroCelular() {
		return numeroCelular;
	}


	public final BooleanDomain isNumeroCelularConfirmado() {
		return numeroCelularConfirmado;
	}


	private final void setNumeroCelular(final String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}


	private final void setNumeroCelularConfirmado(final BooleanDomain numeroCelularConfirmado) {
		this.numeroCelularConfirmado = numeroCelularConfirmado;
	}
	
}