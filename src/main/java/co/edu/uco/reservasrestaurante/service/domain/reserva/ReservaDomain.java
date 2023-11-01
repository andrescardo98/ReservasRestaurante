package co.edu.uco.reservasrestaurante.service.domain.reserva;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;


public class ReservaDomain {

	private UUID id;
	private ClienteDomain cliente;
	private Date fecha;
	private String hora;
	private int cantidadPersonas;
	
	
	private ReservaDomain(final UUID id, final ClienteDomain cliente, final Date fecha, final String hora, final int cantidadPersonas) {
		setId(id);
		setCliente(cliente);
		setFecha(fecha);
		setHora(hora);
		setCantidadPersonas(cantidadPersonas);
	}
	
	public static final ReservaDomain crear(final UUID id, final ClienteDomain cliente, final Date fecha, final String hora, final int cantidadPersonas) {
		return new ReservaDomain(id, cliente, fecha, hora, cantidadPersonas);
	}


	public final UUID getId() {
		return id;
	}


	public final ClienteDomain getCliente() {
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


	private final void setCliente(final ClienteDomain cliente) {
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
