package co.edu.uco.reservasrestaurante.service.domain;

import java.util.UUID;

public final class TipoIdentificacionDomain {
	
	private UUID id;
	private String nombre;
	private String codigo;
	private boolean estado;
	
	
	private TipoIdentificacionDomain(final UUID id, final String nombre, final String codigo, final boolean estado) {
		setId(id);
		setNombre(nombre);
		setCodigo(codigo);
		setEstado(estado);
	}

	public static final TipoIdentificacionDomain crear(final UUID id, final String nombre, final String codigo, final boolean estado) {
		return new TipoIdentificacionDomain(id, nombre, codigo, estado);
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




	private final void setId(final UUID id) {
		this.id = id;
	}


	private final void setNombre(final String nombre) {
		this.nombre = nombre;
	}


	private final void setCodigo(final String codigo) {
		this.codigo = codigo;
	}


	private final void setEstado(final boolean estado) {
		this.estado = estado;
	}
	
	

}
