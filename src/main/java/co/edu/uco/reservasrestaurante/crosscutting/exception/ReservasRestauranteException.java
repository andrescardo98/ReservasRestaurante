package co.edu.uco.reservasrestaurante.crosscutting.exception;

import co.edu.uco.reservasrestaurante.crosscutting.exception.enumerator.LugarException;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;

public class ReservasRestauranteException extends RuntimeException{

	private static final long serialVersionUID = -5050614833514406883L;

	private LugarException lugar;
	private Throwable excepcionRaiz;
	private String mensajeUsuario;
	private String mensajeTecnico;
	private boolean tieneExcepcionRaiz;

	
	protected ReservasRestauranteException(final LugarException lugar, final Throwable excepcionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		setLugar(lugar);
		setExcepcionRaiz(excepcionRaiz);
		setMensajeUsuario(mensajeUsuario);
		setMensajeTecnico(mensajeTecnico);
		setTieneExcepcionRaiz(tieneExcepcionRaiz);
	}
	
	public static final ReservasRestauranteException crear (final LugarException lugar, final Throwable excepcionRaiz, final String mensajeUsuario,
			final String mensajeTecnico) {
		return new ReservasRestauranteException(lugar, excepcionRaiz, mensajeUsuario, mensajeTecnico);
	}
	
	
	public static final long getSerialversionuid() {
		return serialVersionUID;
	}
	public final LugarException getLugar() {
		return lugar;
	}
	public final Throwable getExcepcionRaiz() {
		return excepcionRaiz;
	}
	public final String getMensajeUsuario() {
		return mensajeUsuario;
	}
	public final String getMensajeTecnico() {
		return mensajeTecnico;
	}
	public final boolean isTieneExcepcionRaiz() {
		return tieneExcepcionRaiz;
	}
	

	private final void setLugar(final LugarException lugar) {
		this.lugar = UtilObjeto.obtenerValorDefecto(lugar, LugarException.GENERAL);
	}
	private final void setExcepcionRaiz(final Throwable excepcionRaiz) {
		setTieneExcepcionRaiz(!UtilObjeto.esNulo(excepcionRaiz));
		this.excepcionRaiz = UtilObjeto.obtenerValorDefecto(excepcionRaiz, new Exception());
	}
	private final void setMensajeUsuario(final String mensajeUsuario) {
		this.mensajeUsuario = UtilTexto.aplicarTrim(mensajeUsuario);
	}
	private final void setMensajeTecnico(final String mensajeTecnico) {
		this.mensajeTecnico = UtilTexto.aplicarTrim(mensajeTecnico);
	}
	private final void setTieneExcepcionRaiz(final boolean tieneExcepcionRaiz) {
		this.tieneExcepcionRaiz = tieneExcepcionRaiz;
	}
	
	
	
}
