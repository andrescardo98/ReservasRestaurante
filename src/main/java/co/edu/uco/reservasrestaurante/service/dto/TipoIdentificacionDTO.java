package co.edu.uco.reservasrestaurante.service.dto;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilUUID;

public final class TipoIdentificacionDTO {
	private UUID id;
	private String nombre;
	private String codigo;
	private boolean estado;
	
	public TipoIdentificacionDTO() {
		setId(UtilUUID.generarUUIDVacio());
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
		this.id = UtilUUID.obtenerValorDefecto(id, UtilUUID.obtenerValorDefecto(id, UtilUUID.UUID_DEFECTO));
		return this;
	}
	public final TipoIdentificacionDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.obtenerValorDefecto(UtilTexto.aplicarTrim(nombre), UtilTexto.VACIO);
		return this;
	}
	public final TipoIdentificacionDTO setCodigo(final String codigo) {
		this.codigo = UtilTexto.obtenerValorDefecto(UtilTexto.aplicarTrim(codigo), UtilTexto.VACIO);
		return this;
	}
	public final TipoIdentificacionDTO setEstado(final boolean estado) {
		this.estado = estado;
		return this;
	}
	
	

}
