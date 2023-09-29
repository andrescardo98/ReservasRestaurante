package co.edu.uco.reservasrestaurante.data.entity.support;

public final class NumeroCelularClienteEntity {
	private int numeroCelular;
	private boolean numeroCelularConfirmado;
	
	
	private NumeroCelularClienteEntity(final int numeroCelular, final boolean numeroCelularConfirmado) {
		super();
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}

	
	public static final NumeroCelularClienteEntity crear(final int numeroCelular, final boolean numeroCelularConfirmado) {
		return new NumeroCelularClienteEntity(numeroCelular, numeroCelularConfirmado);
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