package co.edu.uco.reservasrestaurante.service.domain;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.IdentificacionClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.NombreCompletoClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.NumeroCelularClienteDomain;


public final class ClienteDomain {
	private UUID id;
	private IdentificacionClienteDomain identificacion;
	private NombreCompletoClienteDomain nombreCompleto;
	private CorreoElectronicoClienteDomain correoElectronico;
	private Date fechaNacimiento;
	private String pais;
	private NumeroCelularClienteDomain numeroCelular;
	
	
	private ClienteDomain(final UUID id, final IdentificacionClienteDomain identificacion, final NombreCompletoClienteDomain nombreCompleto,
			final CorreoElectronicoClienteDomain correoElectronico, final Date fechaNacimiento, final String pais,
			final NumeroCelularClienteDomain numeroCelular) {
		setId(id);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setFechaNacimiento(fechaNacimiento);
		setPais(pais);
		setNumeroCelular(numeroCelular);
	}

	
	public static final ClienteDomain crear(final UUID id, final IdentificacionClienteDomain identificacion, final NombreCompletoClienteDomain nombreCompleto,
			final CorreoElectronicoClienteDomain correoElectronico, final Date fechaNacimiento, final String pais,
			final NumeroCelularClienteDomain numeroCelular) {
		return new ClienteDomain(id, identificacion, nombreCompleto, correoElectronico, fechaNacimiento, pais, numeroCelular);
	}

	public final UUID getId() {
		return id;
	}


	public final IdentificacionClienteDomain getIdentificacion() {
		return identificacion;
	}


	public final NombreCompletoClienteDomain getNombreCompleto() {
		return nombreCompleto;
	}


	public final CorreoElectronicoClienteDomain getCorreoElectronico() {
		return correoElectronico;
	}


	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public final String getPais() {
		return pais;
	}


	public final NumeroCelularClienteDomain getNumeroCelular() {
		return numeroCelular;
	}


	private final void setId(final UUID id) {
		this.id = id;
	}


	private final void setIdentificacion(final IdentificacionClienteDomain identificacion) {
		this.identificacion = identificacion;
	}


	private final void setNombreCompleto(final NombreCompletoClienteDomain nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	private final void setCorreoElectronico(final CorreoElectronicoClienteDomain correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	private final void setPais(final String pais) {
		this.pais = pais;
	}


	private final void setNumeroCelular(final NumeroCelularClienteDomain numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	
}
