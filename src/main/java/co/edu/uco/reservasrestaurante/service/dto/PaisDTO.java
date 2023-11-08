package co.edu.uco.reservasrestaurante.service.dto;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilUUID;

public class PaisDTO {

	private UUID id;
	private String nombre;
	private String codigoIndicativo;
	private String codigoIso3;
	
	public PaisDTO() {
		setId(UtilUUID.generarUUIDVacio());
		setNombre(UtilTexto.VACIO);
		setCodigoIndicativo(UtilTexto.VACIO);
		setCodigoIso3(UtilTexto.VACIO);
	}
	
	public PaisDTO(final UUID id, final String nombre, final String codigoIndicativo, final String codigoIso3) {
		setId(id);
		setNombre(nombre);
		setCodigoIndicativo(codigoIndicativo);
		setCodigoIso3(codigoIso3);
	}
	
	public static final PaisDTO crear() {
		return new PaisDTO();
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
	
	
	public final PaisDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id, UtilUUID.obtenerValorDefecto(id, UtilUUID.UUID_DEFECTO));
		return this;
	}
	public final PaisDTO setNombre(final String nombre) {
		this.nombre = UtilTexto.obtenerValorDefecto(UtilTexto.aplicarTrim(nombre), UtilTexto.VACIO);
		return this;
	}
	public final PaisDTO setCodigoIndicativo(final String codigoIndicativo) {
		this.codigoIndicativo = UtilTexto.obtenerValorDefecto(UtilTexto.aplicarTrim(codigoIndicativo), 
				UtilTexto.VACIO);
		return this;
	}
	public final PaisDTO setCodigoIso3(final String codigoIso3) {
		this.codigoIso3 = UtilTexto.obtenerValorDefecto(UtilTexto.aplicarTrim(codigoIso3), 
				UtilTexto.VACIO);
		return this;
	}
	
	
}
