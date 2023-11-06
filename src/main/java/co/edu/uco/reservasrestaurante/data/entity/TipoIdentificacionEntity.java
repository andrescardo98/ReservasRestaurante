package co.edu.uco.reservasrestaurante.data.entity;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.data.entity.support.BooleanEntity;

public final class TipoIdentificacionEntity {
	
	private UUID id;
	private String nombre;
	private String codigo;
	private BooleanEntity estado;
	
	
	private TipoIdentificacionEntity(final UUID id, final String nombre, final String codigo, final BooleanEntity estado) {
		super();
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setEstado(estado);
	}

	public static final TipoIdentificacionEntity crear(final UUID id, final String nombre, final String codigo, final BooleanEntity estado) {
		return new TipoIdentificacionEntity(id, nombre, codigo, estado);
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




	public final BooleanEntity isEstado() {
		return estado;
	}




	private final void setId(final UUID id) {
		this.id = id;
	}


	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}


	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}


	private final void setEstado(final BooleanEntity estado) {
		this.estado = estado;
	}
	
	

}
