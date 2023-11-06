package co.edu.uco.reservasrestaurante.service.dto;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilInt;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilUUID;

public final class MesaDTO {
	
	private UUID id;
	private int numero;
	private String ubicacion;
	private int capacidad;
	private BooleanDTO estado;
	
	public MesaDTO() {
		setId(UtilUUID.generarUUIDVacio());
		setNumero(UtilInt.DEFECTO_NUMERO);
		setUbicacion(UtilTexto.VACIO);
		setCapacidad(UtilInt.DEFECTO_NUMERO);
		setEstado(new BooleanDTO());
	}
	
	
	public MesaDTO(final UUID id, final String ubicacion, final int capacidad, final BooleanDTO estado) {
		setId(id);
		setNumero(numero);
		setUbicacion(ubicacion);
		setCapacidad(capacidad);
		setEstado(estado);
	}
	
	public static final MesaDTO crear(){
		return new MesaDTO();
	}


	public final UUID getId() {
		return id;
	}
	
	public int getNumero() {
		return numero;
	}


	public final String getUbicacion() {
		return ubicacion;
	}


	public final int getCapacidad() {
		return capacidad;
	}


	public final BooleanDTO isEstado() {
		return estado;
	}


	public final MesaDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id, UtilUUID.obtenerValorDefecto(id, UtilUUID.UUID_DEFECTO));
		return this;
	}

	public final MesaDTO setNumero(final int numero) {
		this.numero = UtilInt.obtenerValorDefecto(capacidad, UtilInt.DEFECTO_NUMERO);
		return this;
	}

	public final MesaDTO setUbicacion(final String ubicacion) {
		this.ubicacion = UtilTexto.obtenerValorDefecto(UtilTexto.aplicarTrim(ubicacion), UtilTexto.VACIO);
		return this;
	}


	public final MesaDTO setCapacidad(final int capacidad) {
		this.capacidad = UtilInt.obtenerValorDefecto(capacidad, UtilInt.DEFECTO_NUMERO);
		return this;
	}


	public final MesaDTO setEstado(final BooleanDTO estado) {
		this.estado = estado;
		return this;
	}
	
	
}
