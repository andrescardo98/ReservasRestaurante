package co.edu.uco.reservasrestaurante.data.entity.support;

import co.edu.uco.reservasrestaurante.data.entity.TipoIdentificacionEntity;

public final class IdentificacionClienteEntity {
	private TipoIdentificacionEntity tipoIdentificacion;
	private String numeroIdentificacion;
	
	
	private IdentificacionClienteEntity(final TipoIdentificacionEntity tipoIdentificacion, final String numeroIdentificacion) {
		setTipoIdentificacion(tipoIdentificacion);
		setNumeroIdentificacion(numeroIdentificacion);
	}
	
	
	public static final IdentificacionClienteEntity crear(final TipoIdentificacionEntity tipoIdentificacion, final String numeroIdentificacion) {
		return new IdentificacionClienteEntity(tipoIdentificacion, numeroIdentificacion);
	}
	
	public final TipoIdentificacionEntity getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	
	
	private final void setTipoIdentificacion(final TipoIdentificacionEntity tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	private final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	
}