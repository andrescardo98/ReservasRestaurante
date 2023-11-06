package co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.service.domain.support.BooleanDomain;

public final class TipoIdentificacionDomain {
	
	private UUID id;
	private String nombre;
	private String codigo;
	private BooleanDomain estado;
	
	
	private TipoIdentificacionDomain(final UUID id, final String nombre, final String codigo, final BooleanDomain estado) {
		setId(id);
		setCodigo(codigo);
		setNombre(nombre);
		setEstado(estado);
	}

	public static final TipoIdentificacionDomain crear(final UUID id, final String nombre, final String codigo, final BooleanDomain estado) {
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




	public final BooleanDomain isEstado() {
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


	private final void setEstado(final BooleanDomain estado) {
		this.estado = estado;
	}

}
