package co.edu.uco.reservasrestaurante.controller.support.request;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilUUID;

public class SolicitarTipoIdentificacion {
	private UUID id;
	private String nombre;
	private String codigo;
	private boolean estado;
	
	public SolicitarTipoIdentificacion() {
		setId(UtilUUID.generarUUIDVacio());
		setCodigo(UtilTexto.VACIO);
		setNombre(UtilTexto.VACIO);
		setEstado(false);
	}
	
	
	public SolicitarTipoIdentificacion(final UUID id, final String nombre, final String codigo, final Boolean estado) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setEstado(estado);
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
	public final Boolean isEstado() {
		return estado;
	}
	
	public final void setId(final UUID id) {
		this.id = id;
	}
	
	public final void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	
	public final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}
	
	public final void setEstado(final Boolean estado) {
		this.estado = estado;
	}
	
	
}
