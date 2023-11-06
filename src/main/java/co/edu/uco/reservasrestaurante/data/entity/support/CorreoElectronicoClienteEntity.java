package co.edu.uco.reservasrestaurante.data.entity.support;

public final class CorreoElectronicoClienteEntity {
	private String correoElectronico;
	private BooleanEntity correoElectronicoConfirmado;
	private String clave;
	
	
	private CorreoElectronicoClienteEntity(final String correoElectronico, final BooleanEntity correoElectronicoConfirmado, final String clave) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		setClave(clave);
	}
	
	
	public static final CorreoElectronicoClienteEntity crear(final String correoElectronico, 
			final BooleanEntity correoElectronicoConfirmado, final String clave) {
		return new CorreoElectronicoClienteEntity(correoElectronico, correoElectronicoConfirmado, clave);
	}


	public final String getCorreoElectronico() {
		return correoElectronico;
	}
	

	public final String getClave() {
		return clave;
	}

	public final BooleanEntity isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}


	private final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	private final void setCorreoElectronicoConfirmado(final BooleanEntity correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}

	private final void setClave(final String clave) {
		this.clave = clave;
	}
	
}