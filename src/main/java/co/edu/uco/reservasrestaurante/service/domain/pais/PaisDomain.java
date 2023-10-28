package co.edu.uco.reservasrestaurante.service.domain.pais;

import java.util.UUID;

public final class PaisDomain {
	
	private UUID id;
	private String nombre;
	private String codigoIndicativo;
	private String codigoiso3;
	
	private PaisDomain(final UUID id, final String nombre, final String codigoIndicativo, final String codigoiso3) {
		super();
		setId(id);
		setNombre(nombre);
		setCodigoIndicativo(codigoIndicativo);
		setCodigoiso3(codigoiso3);
	}
	
	public static final PaisDomain crear(final UUID id, final String nombre, final String codigoIndicativo, final String codigoiso3) {
		return new PaisDomain(id, nombre, codigoIndicativo, codigoiso3);
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
	

}