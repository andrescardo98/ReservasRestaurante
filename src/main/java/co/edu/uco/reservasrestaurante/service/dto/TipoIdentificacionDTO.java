package co.edu.uco.reservasrestaurante.service.dto;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;

public final class TipoIdentificacionDTO {
	private UUID id;
	private String nombre;
	private String codigo;
	private boolean estado;
	
	public TipoIdentificacionDTO() {
		setId(id); //TODO: ¿Cómo lograr que por defecto se asigne un UUID que sea todo con 0? Es decir, los 32 caracteres con 0. COnstruir UtilUUID
		setCodigo(UtilTexto.VACIO);
		setNombre(UtilTexto.VACIO);
		setEstado(false);
	}
	
	
	public TipoIdentificacionDTO(final UUID id, final String nombre, final String codigo, final boolean estado) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setEstado(estado);
	}
	
	public static final TipoIdentificacionDTO crear() {
		return new TipoIdentificacionDTO();
	}
	
	
	public final UUID getId() {
		return id;
	}
	public final String getNombre() {
		return nombre;
	}
	public final String getCodigo() {
		return codigo;
	}
	public final boolean isEstado() {
		return estado;
	}
	
	public final TipoIdentificacionDTO setId(final UUID id) {
		this.id = id;
		return this;
	}
	public final TipoIdentificacionDTO setNombre(final String nombre) {
		this.nombre = nombre;
		return this;
	}
	public final TipoIdentificacionDTO setCodigo(final String codigo) {
		this.codigo = codigo;
		return this;
	}
	public final TipoIdentificacionDTO setEstado(final boolean estado) {
		this.estado = estado;
		return this;
	}
	
	

}
