package co.edu.uco.reservasrestaurante.data.entity;

import java.awt.Image;
import java.util.UUID;

public final class PaisEntity {
	
	private UUID id;
	private String nombre;
	private String codigoIndicativo;
	private String codigoiso3;
	private Image bandera;
	
	private PaisEntity(final UUID id, final String nombre, final String codigoIndicativo, final String codigoiso3, 
			final Image bandera) {
		super();
		setId(id);
		setNombre(nombre);
		setCodigoIndicativo(codigoIndicativo);
		setCodigoiso3(codigoiso3);
		setBandera(bandera);
	}
	
	public static final PaisEntity crear(final UUID id, final String nombre, final String codigoIndicativo, final String codigoiso3, 
			final Image bandera) {
		return new PaisEntity(id, nombre, codigoIndicativo, codigoiso3, bandera);
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

	public final Image getBandera() {
		return bandera;
	}

	private final void setId(final UUID id) {
		this.id = id;
	}

	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}

	private final void setCodigoIndicativo(final String codigoIndicativo) {
		this.codigoIndicativo = codigoIndicativo;
	}

	private final void setCodigoiso3(final String codigoiso3) {
		this.codigoiso3 = codigoiso3;
	}

	private final void setBandera(final Image bandera) {
		this.bandera = bandera;
	}
	
	

}
