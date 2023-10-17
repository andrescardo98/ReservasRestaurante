package co.edu.uco.reservasrestaurante.service.dto;

import java.util.Date;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
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
	private String pais;
	private NumeroCelularClienteDTO numeroCelular;
	
	
	public ClienteDTO() {
		setId(id);//TODO: ¿Cómo lograr que por defecto se asigne un UUID que sea todo con 0? Es decir, los 32 caracteres 
				//con 0. COnstruir UtilUUID
		setIdentificacion(new IdentificacionClienteDTO());
		setNombreCompleto(new NombreCompletoClienteDTO());
		setCorreoElectronico(new CorreoElectronicoClienteDTO());
		setFechaNacimiento(fechaNacimiento);//TODO: ¿Cómo lograr que por defecto se asigne una fecha que sepa que 
											//no es válida y que pueda ser facilmente identificable. Contruir UtilFecha
		setPais(UtilTexto.VACIO);
		setNumeroCelular(new NumeroCelularClienteDTO());
	}
	
	public ClienteDTO(final UUID id, final IdentificacionClienteDTO identificacion, final NombreCompletoClienteDTO nombreCompleto,
			final CorreoElectronicoClienteDTO correoElectronico, final Date fechaNacimiento, final String pais,
			final NumeroCelularClienteDTO numeroCelular) {
		setId(id);
		setIdentificacion(identificacion);
		setNombreCompleto(nombreCompleto);
		setCorreoElectronico(correoElectronico);
		setFechaNacimiento(fechaNacimiento);
		setPais(pais);
		setNumeroCelular(numeroCelular);
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
	public final String getPais() {
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
	public final ClienteDTO setPais(final String pais) {
		this.pais = pais;
		return this;
	}
	public final ClienteDTO setNumeroCelular(final NumeroCelularClienteDTO numeroCelular) {
		this.numeroCelular = numeroCelular;
		return this;
	}
	
	
	
}
