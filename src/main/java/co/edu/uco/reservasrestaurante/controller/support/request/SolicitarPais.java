package co.edu.uco.reservasrestaurante.controller.support.request;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilUUID;

public class SolicitarPais {

	private UUID id;
	private String nombre;
	private String codigoIndicativo;
	private String codigoIso3;
	
	public SolicitarPais() {
		setId(UtilUUID.generarUUIDVacio());
		setNombre(UtilTexto.VACIO);
		setCodigoIndicativo(UtilTexto.VACIO);
		setCodigoIso3(UtilTexto.VACIO);
	}
	
	public SolicitarPais(final UUID id, final String nombre, final String codigoIndicativo, final String codigoIso3) {
		setId(id);
		setNombre(nombre);
		setCodigoIndicativo(codigoIndicativo);
		setCodigoIso3(codigoIso3);
	}
	
	public final UUID getId() {
		return id;
	}
	public final String getNombre() {
		return nombre;
	}
	public final String getCodigoIndicativo() {
		return codigoIndicativo;
	}
	public final String getCodigoIso3() {
		return codigoIso3;
	}
	
	
	public final void setId(final UUID id) {
		this.id = id;
	}
	
	public final void setNombre(final String nombre) {
		this.nombre = nombre;
	}
	
	public final void setCodigoIndicativo(final String codigoIndicativo) {
		this.codigoIndicativo = codigoIndicativo;
	}
	
	public final void setCodigoIso3(final String codigoIso3) {
		this.codigoIso3 = codigoIso3;
	}
	
}
