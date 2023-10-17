package co.edu.uco.reservasrestaurante.data.dao.concrete.sqlserver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.DataReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.data.dao.ClienteDAO;
import co.edu.uco.reservasrestaurante.data.dao.base.SQLDAO;
import co.edu.uco.reservasrestaurante.data.entity.ClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.TipoIdentificacionEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.IdentificacionClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.NumeroCelularClienteEntity;

public final class ClienteSQLServerDAO extends SQLDAO implements ClienteDAO{
	
	private static final String SENTENCIA_WHERE = "WHERE id = ? ";

	public ClienteSQLServerDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final ClienteEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO Cliente (id, identificacion, nombreCompleto, correoElectronico, fechaNacimiento,"
				+ " pais, numeroCelular)");
		sentencia.append("VALUES (?, ?, ?, ?, ?, ?, ?)");
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2, entity.getIdentificacion());
			sentenciaPreparada.setObject(3, entity.getNombreCompleto());
			sentenciaPreparada.setObject(4, entity.getCorreoElectronico());
			sentenciaPreparada.setDate(5, entity.getFechaNacimiento());
			sentenciaPreparada.setString(6, entity.getPais());
			sentenciaPreparada.setObject(7, entity.getNumeroCelular());
			
			sentenciaPreparada.executeUpdate();			
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000054);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000055);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000054);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000056);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
	}

	@Override
	public final void modificar(final ClienteEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("UPDATE Cliente ");
		sentencia.append("SET identificacion = ?, nombreCompleto = ?, correoElectronico = ?, fechaNacimiento = ?,"
				+ " pais = ?, numeroCelular = ? ");
		sentencia.append(SENTENCIA_WHERE);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setObject(1, entity.getIdentificacion());
			sentenciaPreparada.setObject(2, entity.getNombreCompleto());
			sentenciaPreparada.setObject(3, entity.getCorreoElectronico());
			sentenciaPreparada.setDate(4, entity.getFechaNacimiento());
			sentenciaPreparada.setString(5, entity.getPais());
			sentenciaPreparada.setObject(6, entity.getNumeroCelular());
			sentenciaPreparada.setObject(7, entity.getId());
			
			sentenciaPreparada.executeUpdate();			
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000057);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000058);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000057);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000059);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
	}

	@Override
	public final void eliminar(final UUID id) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("DELETE FROM Cliente ");
		sentencia.append(SENTENCIA_WHERE);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setObject(1, id);
			
			sentenciaPreparada.executeUpdate();			
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000060);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000061);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000060);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000062);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
	}

	@Override
	public final Optional<ClienteEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM Cliente ");
		sentencia.append(SENTENCIA_WHERE);
		
		Optional<ClienteEntity> resultado = Optional.empty();
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
			
		}catch (final DataReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000063);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000064);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000063);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000065);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
		return resultado;
	}

	@Override
	public final List<ClienteEntity> consultar(final ClienteEntity entity) {
		return null;
	}
	
	private final Optional<ClienteEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		
		Optional<ClienteEntity> resultado = Optional.empty();
		
		try(final var resultados = sentenciaPreparada.executeQuery()) {
			if (resultados.next()) {
				var clienteEntity = ClienteEntity.crear(UUID.fromString(resultados.getObject("id").toString()), 
						IdentificacionClienteEntity.crear(TipoIdentificacionEntity.crear(UUID.fromString(resultados.getObject("id").toString()),
								resultados.getString("nombre"), resultados.getString("codigo"), resultados.getBoolean("estado")),resultados.getString("numeroIdentificacion")),								
						NombreCompletoClienteEntity.crear(resultados.getString("primerNombre"), resultados.getString("segundoNombre"), 
								resultados.getString("primerApellido"), resultados.getString("segundoApellido")),
						CorreoElectronicoClienteEntity.crear(resultados.getString("correoElectronico"), resultados.getBoolean("correoElectronicoConfirmado"), resultados.getString("clave")),
						resultados.getDate("fechaNacimiento"), resultados.getString("pais"),
						NumeroCelularClienteEntity.crear(resultados.getInt("numeroCelular"), resultados.getBoolean("numeroCelularConfirmado")));
						
				
				resultado = Optional.of(clienteEntity);
			}
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000063);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000066);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000063);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000067);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
		return resultado;
	}
}
