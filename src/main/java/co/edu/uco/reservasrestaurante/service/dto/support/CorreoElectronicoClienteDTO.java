package co.edu.uco.reservasrestaurante.service.dto.support;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;

public class CorreoElectronicoClienteDTO {
	
	private String correoElectronico;
	private boolean correoElectronicoConfirmado;
	private String clave;
	
	public CorreoElectronicoClienteDTO() {
		setCorreoElectronico(UtilTexto.VACIO);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		setClave(UtilTexto.VACIO);
	}
	
	public CorreoElectronicoClienteDTO(final String correoElectronico, final boolean correoElectronicoConfirmado, final String clave) {
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		setClave(clave);
	}
	
	public static final CorreoElectronicoClienteDTO crear() {
		return new CorreoElectronicoClienteDTO();
	}
	
	public static final CorreoElectronicoClienteDTO crear(final String correoElectronico, 
			final boolean correoElectronicoConfirmado, final String clave) {
		return new CorreoElectronicoClienteDTO(correoElectronico, correoElectronicoConfirmado, clave);
	}


	public final String getCorreoElectronico() {
		return correoElectronico;
	}
	

	public final String getClave() {
		return clave;
	}

	public final boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}


	public final CorreoElectronicoClienteDTO setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = UtilTexto.obtenerValorDefecto(UtilTexto.aplicarTrim(correoElectronico), UtilTexto.VACIO);
		return this;
	}

	public final CorreoElectronicoClienteDTO setCorreoElectronicoConfirmado(final boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
		return this;
	}

	public final CorreoElectronicoClienteDTO setClave(final String clave) {
		this.clave = UtilTexto.obtenerValorDefecto(UtilTexto.aplicarTrim(clave), UtilTexto.VACIO);
		return this;
	}
	

}
