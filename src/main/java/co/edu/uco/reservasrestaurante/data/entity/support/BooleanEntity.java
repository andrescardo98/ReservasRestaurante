package co.edu.uco.reservasrestaurante.data.entity.support;

public class BooleanEntity {

	private boolean valor;
	private boolean valorDefecto;
	
	private BooleanEntity(final boolean valor, final boolean valorDefecto) {
		setValor(valor);
		setValorDefecto(valorDefecto);
	}
	
	public static final BooleanEntity crear(final boolean valor, final boolean valorDefecto) {
		return new BooleanEntity(valor, valorDefecto);
	}


	public final boolean isValor() {
		return valor;
	}


	public final boolean isValorDefecto() {
		return valorDefecto;
	}


	public final void setValor(final boolean valor) {
		this.valor = valor;
	}


	public final void setValorDefecto(final boolean valorDefecto) {
		this.valorDefecto = valorDefecto;
	}
	
	

}
