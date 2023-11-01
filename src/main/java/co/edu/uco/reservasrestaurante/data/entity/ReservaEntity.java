package co.edu.uco.reservasrestaurante.data.entity;

import java.sql.Date;
import java.util.UUID;

public final class ReservaEntity {

	private UUID id;
	private ClienteEntity cliente;
	private Date fecha;
	private String hora;
	private int cantidadPersonas;
	
	
	private ReservaEntity(final UUID id, final ClienteEntity cliente, final Date fecha, final String hora, final int cantidadPersonas) {
		setId(id);
		setCliente(cliente);
		setFecha(fecha);
		setHora(hora);
		setCantidadPersonas(cantidadPersonas);
	}
	
	public static final ReservaEntity crear(final UUID id, final ClienteEntity cliente, final Date fecha, final String hora, final int cantidadPersonas) {
		return new ReservaEntity(id, cliente, fecha, hora, cantidadPersonas);
	}


	public final UUID getId() {
		return id;
	}


	public final ClienteEntity getCliente() {
		return cliente;
	}


	public final Date getFecha() {
		return fecha;
	}


	public final String getHora() {
		return hora;
	}


	public final int getCantidadPersonas() {
		return cantidadPersonas;
	}
	


	private final void setId(final UUID id) {
		this.id = id;
	}


	private final void setCliente(final ClienteEntity cliente) {
		this.cliente = cliente;
	}


	private final void setFecha(final Date fecha) {
		this.fecha = fecha;
	}


	private final void setHora(final String hora) {
		this.hora = hora;
	}


	private final void setCantidadPersonas(final int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}
	
	
}
