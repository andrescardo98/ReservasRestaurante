package co.edu.uco.reservasrestaurante.service.domain.reserva;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;


public class ReservaDomain {

	private UUID id;
	private ClienteDomain cliente;
	private Date fecha;
	private String hora;
	private MesaDomain mesa;
	private int cantidadPersonas;
	private boolean estado;
	
	
	private ReservaDomain(final UUID id, final ClienteDomain cliente, final Date fecha, final String hora, 
			final MesaDomain mesa, final int cantidadPersonas, final boolean estado) {
		setId(id);
		setCliente(cliente);
		setFecha(fecha);
		setHora(hora);
		setMesa(mesa);
		setCantidadPersonas(cantidadPersonas);
		setEstado(estado);
	}
	
	public static final ReservaDomain crear(final UUID id, final ClienteDomain cliente, final Date fecha, 
			final String hora, final MesaDomain mesa, final int cantidadPersonas, final boolean estado) {
		return new ReservaDomain(id, cliente, fecha, hora, mesa, cantidadPersonas, estado);
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

	public MesaDomain getMesa() {
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


	private final void setCliente(final ClienteDomain cliente) {
		this.cliente = cliente;
	}


	private final void setFecha(final Date fecha) {
		this.fecha = fecha;
	}


	private final void setHora(final String hora) {
		this.hora = hora;
	}

	private void setMesa(final MesaDomain mesa) {
		this.mesa = mesa;
	}

	private final void setCantidadPersonas(final int cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}
	
	private final void setEstado(final boolean estado) {
		this.estado = estado;
	}
}
