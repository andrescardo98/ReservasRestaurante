package co.edu.uco.reservasrestaurante.controller.support.request;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilFecha;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilUUID;


public class SolicitarCliente {

	private UUID id;
	private UUID tipoIdentificacion;
	private String identificacion;
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private String correoElectronico;
	private Boolean correoElectronicoConfirmado;
	private String clave;
	private Date fechaNacimiento;
	private UUID pais;
	private String numeroCelular;
	private Boolean numeroCelularConfirmado;
	
	public SolicitarCliente() {
		setId(UtilUUID.UUID_DEFECTO);
		setTipoIdentificacion(UtilUUID.UUID_DEFECTO);
		setIdentificacion(UtilTexto.VACIO);
		setPrimerNombre(UtilTexto.VACIO);
		setSegundoNombre(UtilTexto.VACIO);
		setPrimerApellido(UtilTexto.VACIO);
		setSegundoApellido(UtilTexto.VACIO);
		setCorreoElectronico(UtilTexto.VACIO);
		setCorreoElectronicoConfirmado(false);
		setClave(UtilTexto.VACIO);
		setFechaNacimiento(UtilFecha.FECHA_DEFECTO);
		setPais(UtilUUID.UUID_DEFECTO);
		setNumeroCelular(UtilTexto.VACIO);
		setNumeroCelularConfirmado(false);
	}
	
	public SolicitarCliente(UUID id, UUID tipoIdentificacion, String identificacion, String primerNombre,
			String segundoNombre, String primerApellido, String segundoApellido, String correoElectronico,
			Boolean correoElectronicoConfirmado, String clave, Date fechaNacimiento, UUID pais, String numeroCelular,
			Boolean numeroCelularConfirmado) {
		setId(id);
		setTipoIdentificacion(tipoIdentificacion);
		setIdentificacion(identificacion);
		setPrimerNombre(primerNombre);
		setSegundoNombre(segundoNombre);
		setPrimerApellido(primerApellido);
		setSegundoApellido(segundoApellido);
		setCorreoElectronico(correoElectronico);
		setCorreoElectronicoConfirmado(correoElectronicoConfirmado);
		setClave(clave);
		setFechaNacimiento(fechaNacimiento);
		setPais(pais);
		setNumeroCelular(numeroCelular);
		setNumeroCelularConfirmado(numeroCelularConfirmado);
	}

	public final UUID getId() {
		return id;
	}

	public final UUID getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public final String getIdentificacion() {
		return identificacion;
	}

	public final String getPrimerNombre() {
		return primerNombre;
	}

	public final String getSegundoNombre() {
		return segundoNombre;
	}

	public final String getPrimerApellido() {
		return primerApellido;
	}

	public final String getSegundoApellido() {
		return segundoApellido;
	}

	public final String getCorreoElectronico() {
		return correoElectronico;
	}

	public final Boolean isCorreoElectronicoConfirmado() {
		return correoElectronicoConfirmado;
	}
	
	public String getClave() {
		return clave;
	}

	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public final UUID getPais() {
		return pais;
	}

	public final String getNumeroCelular() {
		return numeroCelular;
	}

	public final Boolean getNumeroCelularConfirmado() {
		return numeroCelularConfirmado;
	}

	public final void setId(final UUID id) {
		this.id = id;
	}

	public final void setTipoIdentificacion(final UUID tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public final void setIdentificacion(final String identificacion) {
		this.identificacion = identificacion;
	}

	public final void setPrimerNombre(final String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public final void setSegundoNombre(final String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public final void setPrimerApellido(final String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public final void setSegundoApellido(final String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public final void setCorreoElectronico(final String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public final void setCorreoElectronicoConfirmado(final Boolean correoElectronicoConfirmado) {
		this.correoElectronicoConfirmado = correoElectronicoConfirmado;
	}
	
	public void setClave(final String clave) {
		this.clave = clave;
	}

	public final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public final void setPais(final UUID pais) {
		this.pais = pais;
	}

	public final void setNumeroCelular(final String numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public final void setNumeroCelularConfirmado(final boolean numeroCelularConfirmado) {
		this.numeroCelularConfirmado = numeroCelularConfirmado;
	}
	
	
	
}
