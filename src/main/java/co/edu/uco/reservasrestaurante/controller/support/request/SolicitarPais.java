package co.edu.uco.reservasrestaurante.controller.support.request;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilUUID;

public class SolicitarPais {

	private UUID id;
	private String nombre;
	private String codigoIndicativo;
	private String codigoiso3;
	
	public SolicitarPais() {
		setId(UtilUUID.generarUUIDVacio());
		setNombre(UtilTexto.VACIO);
		setCodigoIndicativo(UtilTexto.VACIO);
		setCodigoiso3(UtilTexto.VACIO);
	}
	
	public SolicitarPais(final UUID id, final String nombre, final String codigoIndicativo, final String codigoiso3) {
		setId(id);
		setNombre(nombre);
		setCodigoIndicativo(codigoIndicativo);
		setCodigoiso3(codigoiso3);
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
	public final String getCodigoiso3() {
		return codigoiso3;
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
	
	public final void setCodigoiso3(final String codigoiso3) {
		this.codigoiso3 = codigoiso3;
	}
	
}
