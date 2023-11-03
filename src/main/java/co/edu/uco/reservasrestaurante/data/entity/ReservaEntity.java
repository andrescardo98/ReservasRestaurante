package co.edu.uco.reservasrestaurante.data.entity;

import java.sql.Date;
import java.util.UUID;

public final class ReservaEntity {

	private UUID id;
	private ClienteEntity cliente;
	private Date fecha;
	private String hora;
	private MesaEntity mesa;
	private int cantidadPersonas;
	private boolean estado;
	
	
	private ReservaEntity(final UUID id, final ClienteEntity cliente, final Date fecha, final String hora, 
			final MesaEntity mesa, final int cantidadPersonas, final boolean estado) {
		setId(id);
		setCliente(cliente);
		setFecha(fecha);
		setHora(hora);
		setMesa(mesa);
		setCantidadPersonas(cantidadPersonas);
		setEstado(estado);
	}
	
	public static final ReservaEntity crear(final UUID id, final ClienteEntity cliente, final Date fecha, final String hora, 
			final MesaEntity mesa, final int cantidadPersonas, final boolean estado) {
		return new ReservaEntity(id, cliente, fecha, hora, mesa, cantidadPersonas, estado);
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
	
	public MesaEntity getMesa() {
		return mesa;
	}


	public final int getCantidadPersonas() {
		return cantidadPersonas;
	}
	
	public boolean isEstado() {
		return estado;
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
	
	private void setMesa(final MesaEntity mesa) {
		this.mesa = mesa;
	}


	private final void setCantidadPersonas(final int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}
	
	private void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	
}
