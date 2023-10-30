package co.edu.uco.reservasrestaurante.service.dto.support;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.service.dto.TipoIdentificacionDTO;

public class IdentificacionClienteDTO {
	
	private TipoIdentificacionDTO tipoIdentificacion;
	private String numeroIdentificacion;
	
	public IdentificacionClienteDTO() {
		setTipoIdentificacion(new TipoIdentificacionDTO());
		setNumeroIdentificacion(UtilTexto.VACIO);
	}
	
	public IdentificacionClienteDTO(final TipoIdentificacionDTO tipoIdentificacion, final String numeroIdentificacion) {
		setTipoIdentificacion(tipoIdentificacion);
		setNumeroIdentificacion(numeroIdentificacion);
	}
	
	public static final IdentificacionClienteDTO crear() {
		return new IdentificacionClienteDTO();
	}
	
	
	public final TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	
	public final String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}
	
	
	public final IdentificacionClienteDTO setTipoIdentificacion(final TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = UtilObjeto.obtenerValorDefecto(tipoIdentificacion, new TipoIdentificacionDTO());
		return this;
	}
	public final IdentificacionClienteDTO setNumeroIdentificacion(final String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
		return this;
	}

}
