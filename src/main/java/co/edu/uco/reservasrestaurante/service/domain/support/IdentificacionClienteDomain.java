package co.edu.uco.reservasrestaurante.service.domain.support;

import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public final class IdentificacionClienteDomain {
	private TipoIdentificacionDomain tipoIdentificacion;
	private String numeroIdentificacion;
	
	
	private IdentificacionClienteDomain(final TipoIdentificacionDomain tipoIdentificacion, final String numeroIdentificacion) {
		setTipoIdentificacion(tipoIdentificacion);
		setNumeroIdentificacion(numeroIdentificacion);
	}
	
	
	public static final IdentificacionClienteDomain crear(final TipoIdentificacionDomain tipoIdentificacion, final String numeroIdentificacion) {
		return new IdentificacionClienteDomain(tipoIdentificacion, numeroIdentificacion);
	}
	
	public final TipoIdentificacionDomain getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	
	
	private final void setTipoIdentificacion(final TipoIdentificacionDomain tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}
	private final void setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
}