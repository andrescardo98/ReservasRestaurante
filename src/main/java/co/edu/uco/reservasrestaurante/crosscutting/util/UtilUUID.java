package co.edu.uco.reservasrestaurante.crosscutting.util;

import java.util.UUID;

public class UtilUUID {
	
	public static final UUID UUID_VACIO = new UUID(0L, 0L);
	
	private UtilUUID() {
		super();
	}
	
	public static final UUID obtenerUUIDDefecto(final UUID uuid) {
		return UtilObjeto.obtenerValorDefecto(uuid, UUID_VACIO);
	}
	
	public static final boolean uuidIgual(final UUID uuidUno, final UUID uuidDos) {
		return obtenerUUIDDefecto(uuidUno).equals(obtenerUUIDDefecto(uuidDos));
	}
	
	public static final UUID obtenerNuevoUUID() {
		UUID uuid;
		
		do {
			uuid = UUID.randomUUID();
		} while (esUUIDPorDefecto(uuid));
		return uuid;
	}
	
	public static final boolean esUUIDPorDefecto(final UUID uuid) {
		return uuidIgual(uuid, UUID_VACIO);
	}
	
	public static final UUID obtenerValorDefecto(final UUID valor, final UUID valorDefecto) {
		return UtilObjeto.obtenerValorDefecto(valor, valorDefecto);
	}
	
	public static final UUID obtenerValorDefecto(final UUID valor) {
		return obtenerValorDefecto(valor, UUID_VACIO);
	}
	
	public static final UUID generarUUIDVacio() {
		return UUID_VACIO;
	}

}
