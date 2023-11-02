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
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilTexto;
import co.edu.uco.reservasrestaurante.data.dao.MesaDAO;
import co.edu.uco.reservasrestaurante.data.dao.base.SQLDAO;
import co.edu.uco.reservasrestaurante.data.entity.MesaEntity;

public final class MesaPostgreSQLDAO extends SQLDAO implements MesaDAO {
	
	private static final String SENTENCIA_WHERE = "WHERE id = ? ";

	public MesaPostgreSQLDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final MesaEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO Mesa (id, ubicacion, capacidad, estado)");
		sentencia.append("VALUES (?, ?, ?, ?)");
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setInt(2, entity.getNumero());
			sentenciaPreparada.setString(3, entity.getUbicacion());
			sentenciaPreparada.setInt(4, entity.getCapacidad());
			sentenciaPreparada.setBoolean(5, entity.isEstado());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000264);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000265);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000264);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000266);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
	}

	@Override
	public final void modificar(final MesaEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("UPDATE Mesa ");
		sentencia.append("SET ubicacion = ?, capacidad = ?, estado = ? ");
		sentencia.append(SENTENCIA_WHERE);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setInt(1, entity.getNumero());
			sentenciaPreparada.setString(2, entity.getUbicacion());
			sentenciaPreparada.setInt(3, entity.getCapacidad());
			sentenciaPreparada.setBoolean(4, entity.isEstado());
			sentenciaPreparada.setObject(5, entity.getId());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000267);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000268);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000267);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000269);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
	}

	@Override
	public final void eliminar(final UUID id) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("DELETE FROM Mesa ");
		sentencia.append(SENTENCIA_WHERE);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setObject(1, id);
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000270);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000271);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000270);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000272);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
	}

	@Override
	public final Optional<MesaEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id = ?, ubicacion = ?, capacidad = ?, estado = ? ");
		sentencia.append("FROM Mesa ");
		sentencia.append(SENTENCIA_WHERE);
		
		Optional<MesaEntity> resultado = Optional.empty();
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
			
		}catch (final DataReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000273);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000274);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000273);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000275);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
		return resultado;
	}

	@Override
	public final List<MesaEntity> consultar(final MesaEntity entity) {
		
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(entity, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
			
		} catch (final DataReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000276);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000277);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000276);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000278);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	private final Optional<MesaEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		
		Optional<MesaEntity> resultado = Optional.empty();
		
		try(final var resultados = sentenciaPreparada.executeQuery()) {
			if (resultados.next()) {
				var mesaEntity = MesaEntity.crear(UUID.fromString((String) resultados.getObject("id")),
						resultados.getInt("numero"), resultados.getString("ubicacion"), resultados.getInt("capacidad"),
						resultados.getBoolean("estado"));
				
				resultado = Optional.of(mesaEntity);
			}
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000279);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000280);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000279);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000281);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
		return resultado;
	}
	
	private final String formarSentenciaConsulta(final MesaEntity entity, final List<Object> parametros) {
		
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE ";
		
		sentencia.append("SELECT id, ubicacion, capacidad, estado ");
		sentencia.append("FROM Mesa ");
		
		if (!UtilObjeto.esNulo(entity)) {
			
			if (!UtilObjeto.esNulo(entity.getId())) {
				sentencia.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getId());
			}
			if (!UtilObjeto.esNulo(entity.getNumero())) {
				sentencia.append(operadorCondicional).append(" numero = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getId());
			}
			
			if (!UtilTexto.estaVacio(entity.getUbicacion())) {
				sentencia.append(operadorCondicional).append(" ubicacion = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getUbicacion());
			}
			
			if (!UtilObjeto.esNulo(entity.getCapacidad())) {
				sentencia.append(operadorCondicional).append(" capacidad = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getCapacidad());
			}
			
			if (!UtilObjeto.esNulo(entity.isEstado())) {
				sentencia.append(operadorCondicional).append(" estado = ? ");
				parametros.add(entity.isEstado());
			}	
		}
		sentencia.append("ORDER BY codigo ASC ");
		return sentencia.toString();
	}
	
	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000282);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000283);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000282);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000284);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	private final List<MesaEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		
		final var listaResultados = new ArrayList<MesaEntity>();
		
		try(final var resultados = sentenciaPreparada.executeQuery()) {
			while (resultados.next()) {
				var mesaEntity = MesaEntity.crear(UUID.fromString((String) resultados.getObject("id")),
						resultados.getInt("numero"), resultados.getString("ubicacion"), resultados.getInt("capacidad"),
						resultados.getBoolean("estado"));
				
				listaResultados.add(mesaEntity);
			}
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000282);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000285);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000282);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000286);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return listaResultados;
	}
}
