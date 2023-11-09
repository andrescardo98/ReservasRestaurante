package co.edu.uco.reservasrestaurante.service.domain.pais;

import java.util.UUID;

public final class PaisDomain {
	
	private UUID id;
	private String nombre;
	private String codigoIndicativo;
	private String codigoIso3;
	
	private PaisDomain(final UUID id, final String nombre, final String codigoIndicativo, final String codigoIso3) {
		super();
		setId(id);
		setNombre(nombre);
		setCodigoIndicativo(codigoIndicativo);
		setCodigoIso3(codigoIso3);
	}
	
	public static final PaisDomain crear(final UUID id, final String nombre, final String codigoIndicativo, final String codigoIso3) {
		return new PaisDomain(id, nombre, codigoIndicativo, codigoIso3);
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

	public final String getCodigoIso3() {
		return codigoIso3;
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

	private final void setCodigoIso3(final String codigoIso3) {
		this.codigoIso3 = codigoIso3;
	}
	

}
