package co.edu.uco.reservasrestaurante.service.domain.support;


public final class CorreoElectronicoClienteDomain {
	private String correoElectronico;
	private BooleanDomain correoElectronicoConfirmado;
	private String clave;
	
	
	private CorreoElectronicoClienteDomain(final String correoElectronico, final BooleanDomain correoElectronicoConfirmado, final String clave) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		setClave(clave);
	}
	
	
	public static final CorreoElectronicoClienteDomain crear(final String correoElectronico, 
			final BooleanDomain correoElectronicoConfirmado, final String clave) {
		return new CorreoElectronicoClienteDomain(correoElectronico, correoElectronicoConfirmado, clave);
	}


	public final String getCorreoElectronico() {
		return correoElectronico;
	}
	

	public final String getClave() {
		return clave;
	}

	public final BooleanDomain isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}


	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private final void setCorreoElectronicoConfirmado(final BooleanDomain correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}

	private final void setClave(final String clave) {
		this.clave = clave;
	}
	
}