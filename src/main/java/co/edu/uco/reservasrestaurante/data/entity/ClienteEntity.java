package co.edu.uco.reservasrestaurante.data.entity;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.IdentificacionClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.NumeroCelularClienteEntity;

public final class ClienteEntity {
	private UUID id;
	private IdentificacionClienteEntity identificacion;
	private NombreCompletoClienteEntity nombreCompleto;
	private CorreoElectronicoClienteEntity correoElectronico;
	private Date fechaNacimiento;
	private String pais;
	private NumeroCelularClienteEntity numeroCelular;
	
	
	private ClienteEntity(final UUID id, final IdentificacionClienteEntity identificacion, final NombreCompletoClienteEntity nombreCompleto,
			final CorreoElectronicoClienteEntity correoElectronico, final Date fechaNacimiento, final String pais,
			final NumeroCelularClienteEntity numeroCelular) {
		super();
		setId(id);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setFechaNacimiento(fechaNacimiento);
		setPais(pais);
		setNumeroCelular(numeroCelular);
	}

	
	public static final ClienteEntity crear(final UUID id, final IdentificacionClienteEntity identificacion, final NombreCompletoClienteEntity nombreCompleto,
			final CorreoElectronicoClienteEntity correoElectronico, final Date fechaNacimiento, final String pais,
			final NumeroCelularClienteEntity numeroCelular) {
		return new ClienteEntity(id, identificacion, nombreCompleto, correoElectronico, fechaNacimiento, pais, numeroCelular);
	}

	public final UUID getId() {
		return id;
	}


	public final IdentificacionClienteEntity getIdentificacion() {
		return identificacion;
	}


	public final NombreCompletoClienteEntity getNombreCompleto() {
		return nombreCompleto;
	}


	public final CorreoElectronicoClienteEntity getCorreoElectronico() {
		return correoElectronico;
	}


	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public final String getPais() {
		return pais;
	}


	public final NumeroCelularClienteEntity getNumeroCelular() {
		return numeroCelular;
	}


	private final void setId(final UUID id) {
		this.id = id;
	}


	private final void setIdentificacion(final IdentificacionClienteEntity identificacion) {
		this.identificacion = identificacion;
	}


	private final void setNombreCompleto(final NombreCompletoClienteEntity nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}


	private final void setCorreoElectronico(final CorreoElectronicoClienteEntity correoElectronico) {
		this.correoElectronico = correoElectronico;
	}


	private final void setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	private final void setPais(final String pais) {
		this.pais = pais;
	}


	private final void setNumeroCelular(final NumeroCelularClienteEntity numeroCelular) {
		this.numeroCelular = numeroCelular;
	}
	
	
	
	
	
}
