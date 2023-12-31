package co.edu.uco.reservasrestaurante.service.dto;

import java.sql.Date;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.util.UtilFecha;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilInt;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilUUID;

public class ReservaDTO {

	private UUID id;
	private ClienteDTO cliente;
	private Date fecha;
	private String hora;
	private MesaDTO mesa;
	private int cantidadPersonas;
	private BooleanDTO estado;
	
	public ReservaDTO() {
		setId(UtilUUID.generarUUIDVacio());
		setCliente(cliente);
		setFecha(UtilFecha.FECHA_DEFECTO);
		setHora(UtilTexto.PATTERN_HORA);
		setMesa(mesa);
		setCantidadPersonas(cantidadPersonas);
		setEstado(new BooleanDTO());
	}
	
	public ReservaDTO(final UUID id, final ClienteDTO cliente, final Date fecha, final String hora, final MesaDTO mesa, 
			final int cantidadPersonas, final BooleanDTO estado) {
		setId(id);
		setCliente(cliente);
		setFecha(fecha);
		setHora(hora);
		setMesa(mesa);
		setCantidadPersonas(cantidadPersonas);
		setEstado(estado);
	}
	
	public static final ReservaDTO crear() {
		return new ReservaDTO();
	}


	public final UUID getId() {
		return id;
	}


	public final ClienteDTO getCliente() {
		return cliente;
	}


	public final Date getFecha() {
		return fecha;
	}


	public final String getHora() {
		return hora;
	}
	
	public MesaDTO getMesa() {
		return mesa;
	}


	public final int getCantidadPersonas() {
		return cantidadPersonas;
	}


	public final BooleanDTO isEstado() {
		return estado;
	}


	public final ReservaDTO setId(final UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id, UtilUUID.obtenerValorDefecto(id, UtilUUID.UUID_DEFECTO));
		return this;
	}


	public final ReservaDTO setCliente(final ClienteDTO cliente) {
		this.cliente = cliente;
		return this;
	}


	public final ReservaDTO setFecha(final Date fecha) {
		this.fecha = UtilFecha.obtenerFechaDefecto(fecha, UtilFecha.obtenerFechaDefecto(fecha, UtilFecha.FECHA_DEFECTO));
		return this;
	}


	public final ReservaDTO setHora(final String hora) {
		this.hora = hora;
		return this;
	}

	public final ReservaDTO setMesa(final MesaDTO mesa) {
		this.mesa = mesa;
		return this;
	}

	public final ReservaDTO setCantidadPersonas(final int cantidadPersonas) {
		this.cantidadPersonas = UtilInt.obtenerValorDefecto(cantidadPersonas, UtilInt.DEFECTO_NUMERO);
		return this;
	}


	public final ReservaDTO setEstado(final BooleanDTO estado) {
		this.estado = estado.isValorDefecto() ? new BooleanDTO() : new BooleanDTO().
				setValor(estado.isValor()).setValorDefecto(false);
		return this;
	}
}
