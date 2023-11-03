package co.edu.uco.reservasrestaurante.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.DataReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.ReservaDAO;
import co.edu.uco.reservasrestaurante.data.dao.base.SQLDAO;
import co.edu.uco.reservasrestaurante.data.entity.ClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.MesaEntity;
import co.edu.uco.reservasrestaurante.data.entity.PaisEntity;
import co.edu.uco.reservasrestaurante.data.entity.ReservaEntity;
import co.edu.uco.reservasrestaurante.data.entity.TipoIdentificacionEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.IdentificacionClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.NumeroCelularClienteEntity;

public final class ReservaPostgreSQLDAO extends SQLDAO implements ReservaDAO{
	
	private static final String SENTENCIA_WHERE = "WHERE id = ? ";

	public ReservaPostgreSQLDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(ReservaEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO Reserva (id, cliente, fecha, hora, cantidadPersonas, estado) ");
		sentencia.append("VALUES (?, ?, ?, ?, ?, ?) ");
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2, entity.getCliente());
			sentenciaPreparada.setDate(3, entity.getFecha());
			sentenciaPreparada.setString(4, entity.getHora());
			sentenciaPreparada.setObject(5, entity.getMesa());
			sentenciaPreparada.setInt(6, entity.getCantidadPersonas());
			sentenciaPreparada.setBoolean(7, entity.isEstado());
			
			sentenciaPreparada.executeUpdate();
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000209);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000210);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000209);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000211);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public void modificar(ReservaEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("UPDATE Reserva ");
		sentencia.append("SET id = ?, cliente = ?, fecha = ?, hora = ?, cantidadPersonas = ?, estado = ? ");
		sentencia.append(SENTENCIA_WHERE);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, entity.getCliente());
			sentenciaPreparada.setDate(2, entity.getFecha());
			sentenciaPreparada.setString(3, entity.getHora());
			sentenciaPreparada.setInt(4, entity.getCantidadPersonas());
			sentenciaPreparada.setObject(5, entity.getMesa());
			sentenciaPreparada.setBoolean(6, entity.isEstado());
			sentenciaPreparada.setObject(7, entity.getId());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000212);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000213);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000212);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000214);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public void eliminar(UUID id) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("DELETE FROM Reserva ");
		sentencia.append(SENTENCIA_WHERE);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, id);
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000215);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000216);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000215);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000217);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	@Override
	public Optional<ReservaEntity> consultarPorId(UUID id) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("SELECT id, cliente, fecha, hora, cantidadPersonas, estado");
		sentencia.append("FROM Reserva");
		sentencia.append(SENTENCIA_WHERE);
		
		Optional<ReservaEntity> resultado = Optional.empty();
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
						
		} catch (final DataReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000218);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000219);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000218);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000220);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}

	@Override
	public List<ReservaEntity> consultar(final ReservaEntity entity) {
		final var parametros = new ArrayList<>();
		final String sentencia = formarSentenciaConsulta(entity, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
			
		} catch (final DataReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000221);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000222);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000221);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000223);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	private final Optional<ReservaEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		Optional<ReservaEntity> resultado = Optional.empty();
		
		try(final var resultados = sentenciaPreparada.executeQuery()) {
			
			if (resultados.next()) {
				var reservaEntity = ReservaEntity.crear(UUID.fromString((String) resultados.getObject("id")), 
						ClienteEntity.crear(UUID.fromString((String) resultados.getObject("id")), 
								IdentificacionClienteEntity.crear(TipoIdentificacionEntity.crear
										(UUID.fromString((String) resultados.getObject("id")), 
												resultados.getString("nombre"), 
												resultados.getString("codigo"), resultados.getBoolean("estado")),
										resultados.getString("numeroIdentificacion")), 
								NombreCompletoClienteEntity.crear(resultados.getString("primerNombre"),
										resultados.getString("segundoNombre"), 
										resultados.getString("primerApellido"), resultados.getString("segundoApellido")),
								CorreoElectronicoClienteEntity.crear(resultados.getString("correoElectronico"),
										resultados.getBoolean("correoElectronicoConfirmado"), resultados.getString("clave")),
								resultados.getDate("fechaNacimiento"), PaisEntity.crear(UUID.fromString(
										(String) resultados.getObject("id")), resultados.getString("nombre"),
										resultados.getString("codigoIndicativo"), resultados.getString("codigoIso3")),
								NumeroCelularClienteEntity.crear(resultados.getString("numeroCelular"),
										resultados.getBoolean("numeroCelularConfirmado"))), resultados.getDate("fecha"),
						resultados.getString("hora"), 
						MesaEntity.crear(UUID.fromString((String) resultados.getObject("id")), 
								resultados.getInt("numero"), resultados.getString("ubicacion"), 
								resultados.getInt("capacidad"), resultados.getBoolean("estado")), 
						resultados.getInt("cantidadPersonas"),
						resultados.getBoolean("estado"));
				
				resultado = Optional.of(reservaEntity);
			}
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000224);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000225);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000224);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000226);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return resultado;
	}

	private String formarSentenciaConsulta(final ReservaEntity entity, final List<Object> parametros) {
		final var sentencia = new StringBuilder();
	    String operadorCondicional = "WHERE ";

	    sentencia.append("SELECT id, cliente, fecha, hora, cantidadPersonas, estado ");
	    sentencia.append("FROM Reserva ");

	    operadorCondicional = agregarCondiciones(entity.getId(), "id", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getId(), "id", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getIdentificacion().getTipoIdentificacion().getId(), "id", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getIdentificacion().getTipoIdentificacion().getNombre(), "nombre", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getIdentificacion().getTipoIdentificacion().getCodigo(), "codigo", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getIdentificacion().getTipoIdentificacion().isEstado(), "estado", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getIdentificacion().getNumeroIdentificacion(), "numeroIdentificacion", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getNombreCompleto().getPrimerNombre(), "primerNombre", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getNombreCompleto().getSegundoNombre(), "segundoNombre", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getNombreCompleto().getPrimerApellido(), "primerApellido", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getNombreCompleto().getSegundoApellido(), "segundoApellido", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getCorreoElectronico().getCorreoElectronico(), "correoElectronico", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getCorreoElectronico().isCorreoElectronicoConfirmado(), "correoElectronicoConfirmado", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getCorreoElectronico().getClave(), "clave", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getFechaNacimiento(), "fechaNacimiento", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getPais().getId(), "id", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getPais().getNombre(), "nombre", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getPais().getCodigoIndicativo(), "codigoIndicativo", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getPais().getCodigoiso3(), "codigoiso3", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getNumeroCelular().getNumeroCelular(), "numeroCelular", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCliente().getNumeroCelular().isNumeroCelularConfirmado(), "numeroCelularConfirmado", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getFecha(), "fecha", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getHora(), "hora", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getMesa(), "mesa", operadorCondicional, parametros, sentencia);
	    operadorCondicional = agregarCondiciones(entity.getCantidadPersonas(), "cantidadPersonas", operadorCondicional, parametros, sentencia);
	    agregarCondiciones(entity.isEstado(), "estado", operadorCondicional, parametros, sentencia);

	    sentencia.append("ORDER BY id");
	    return sentencia.toString();
	}
	
	private String agregarCondiciones(Object valor, String campo, String operadorCondicional, List<Object> parametros, StringBuilder sentencia) {
	    if (!UtilObjeto.esNulo(valor)) {
	        sentencia.append(operadorCondicional).append(" ").append(campo).append(" = ? ");
	        operadorCondicional = "AND";
	        parametros.add(valor);
	    }
	    return operadorCondicional;
	}
	
	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000227);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000228);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000227);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000229);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	private final List<ReservaEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		final var listaResultados = new ArrayList<ReservaEntity>();
		
		try(final var resultados = sentenciaPreparada.executeQuery()) {
			while (resultados.next()) {
				var reservaEntity = ReservaEntity.crear(UUID.fromString((String) resultados.getObject("id")), 
						ClienteEntity.crear(UUID.fromString((String) resultados.getObject("id")), 
								IdentificacionClienteEntity.crear(TipoIdentificacionEntity.crear
										(UUID.fromString((String) resultados.getObject("id")), 
												resultados.getString("nombre"), 
												resultados.getString("codigo"), resultados.getBoolean("estado")),
										resultados.getString("numeroIdentificacion")), 
								NombreCompletoClienteEntity.crear(resultados.getString("primerNombre"),
										resultados.getString("segundoNombre"), 
										resultados.getString("primerApellido"), resultados.getString("segundoApellido")),
								CorreoElectronicoClienteEntity.crear(resultados.getString("correoElectronico"),
										resultados.getBoolean("correoElectronicoConfirmado"), resultados.getString("clave")),
								resultados.getDate("fechaNacimiento"), PaisEntity.crear(UUID.fromString(
										(String) resultados.getObject("id")), resultados.getString("nombre"),
										resultados.getString("codigoIndicativo"), resultados.getString("codigoIso3")),
								NumeroCelularClienteEntity.crear(resultados.getString("numeroCelular"),
										resultados.getBoolean("numeroCelularConfirmado"))), resultados.getDate("fecha"),
						resultados.getString("hora"), 
						MesaEntity.crear(UUID.fromString((String) resultados.getObject("id")), 
								resultados.getInt("numero"), resultados.getString("ubicacion"), 
								resultados.getInt("capacidad"), resultados.getBoolean("estado")), 
						resultados.getInt("cantidadPersonas"),
						resultados.getBoolean("estado"));
						
				
				listaResultados.add(reservaEntity);
			}
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000230);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000231);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000230);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000232);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return listaResultados;
	}
}
