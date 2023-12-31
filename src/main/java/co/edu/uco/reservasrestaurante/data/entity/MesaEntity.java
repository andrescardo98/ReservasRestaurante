package co.edu.uco.reservasrestaurante.data.entity;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.data.entity.support.BooleanEntity;

public final class MesaEntity {
	
	private UUID id;
	private int numero;
	private String ubicacion;
	private int capacidad;
	private BooleanEntity estado;
	
	
	private MesaEntity(final UUID id, final int numero, final String ubicacion, final int capacidad, final BooleanEntity estado) {
		setId(id);
		setNumero(numero);
		setUbicacion(ubicacion);
		setCapacidad(capacidad);
		setEstado(estado);
	}
	
	public static final MesaEntity crear(final UUID id, final int numero, final String ubicacion, final int capacidad, final BooleanEntity estado){
		return new MesaEntity(id, numero, ubicacion, capacidad, estado);
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


	public final BooleanEntity isEstado() {
		return estado;
	}


	private final void setId(final UUID id) {
		this.id = id;
	}

	private void setNumero(final int numero) {
		this.numero = numero;
	}

	private final void setUbicacion(final String ubicacion) {
		this.ubicacion = ubicacion;
	}


	private final void setCapacidad(final int capacidad) {
		this.capacidad = capacidad;
	}


	private final void setEstado(final BooleanEntity estado) {
		this.estado = estado;
	}
	
	
}
