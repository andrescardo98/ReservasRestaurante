package co.edu.uco.reservasrestaurante.service.dto;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilFecha;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilUUID;
import co.edu.uco.reservasrestaurante.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.reservasrestaurante.service.dto.support.IdentificacionClienteDTO;
import co.edu.uco.reservasrestaurante.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.reservasrestaurante.service.dto.support.NumeroCelularClienteDTO;


public class ClienteDTO {
	private UUID id;
	private IdentificacionClienteDTO identificacion;
	private NombreCompletoClienteDTO nombreCompleto;
	private CorreoElectronicoClienteDTO correoElectronico;
	private Date fechaNacimiento;
	private PaisDTO pais;
	private NumeroCelularClienteDTO numeroCelular;
	
	
	public ClienteDTO() {
		setId(UtilUUID.generarUUIDVacio());
		setIdentificacion(new IdentificacionClienteDTO());
		setNombreCompleto(new NombreCompletoClienteDTO());
		setCorreoElectronico(new CorreoElectronicoClienteDTO());
		setFechaNacimiento(UtilFecha.FECHA_DEFECTO);
		setPais(pais);
		setNumeroCelular(new NumeroCelularClienteDTO());
	}
	
	public ClienteDTO(final UUID id, final IdentificacionClienteDTO identificacion, final NombreCompletoClienteDTO nombreCompleto,
			final CorreoElectronicoClienteDTO correoElectronico, final Date fechaNacimiento, final PaisDTO pais,
			final NumeroCelularClienteDTO numeroCelular) {
		setId(id);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setFechaNacimiento(fechaNacimiento);
		setPais(pais);
		setNumeroCelular(numeroCelular);
	}
	
	public static final ClienteDTO crear() {
		return new ClienteDTO();
	}
	
	
	public final UUID getId() {
		return id;
	}
	public final IdentificacionClienteDTO getIdentificacion() {
		return identificacion;
	}
	public final NombreCompletoClienteDTO getNombreCompleto() {
		return nombreCompleto;
	}
	public final CorreoElectronicoClienteDTO getCorreoElectronico() {
		return correoElectronico;
	}
	public final Date getFechaNacimiento() {
		return fechaNacimiento;
	}
	public final PaisDTO getPais() {
		return pais;
	}
	public final NumeroCelularClienteDTO getNumeroCelular() {
		return numeroCelular;
	}
	
	
	public final ClienteDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final ClienteDTO setIdentificacion(final IdentificacionClienteDTO identificacion) {
		this.identificacion = identificacion;
		return this;
	}
	public final ClienteDTO setNombreCompleto(final NombreCompletoClienteDTO nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
		return this;
	}
	public final ClienteDTO setCorreoElectronico(final CorreoElectronicoClienteDTO correoElectronico) {
		this.correoElectronico = correoElectronico;
		return this;
	}
	public final ClienteDTO setFechaNacimiento(final Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
		return this;
	}
	public final ClienteDTO setPais(final PaisDTO pais) {
		this.pais = pais;
		return this;
	}
	public final ClienteDTO setNumeroCelular(final NumeroCelularClienteDTO numeroCelular) {
		this.numeroCelular = numeroCelular;
		return this;
	}
}
