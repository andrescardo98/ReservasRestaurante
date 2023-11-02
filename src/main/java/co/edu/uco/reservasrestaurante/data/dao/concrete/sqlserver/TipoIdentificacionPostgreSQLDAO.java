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
import co.edu.uco.reservasrestaurante.data.dao.TipoIdentificacionDAO;
import co.edu.uco.reservasrestaurante.data.dao.base.SQLDAO;
import co.edu.uco.reservasrestaurante.data.entity.TipoIdentificacionEntity;

public final class TipoIdentificacionPostgreSQLDAO extends SQLDAO implements TipoIdentificacionDAO {
	
	private static final String SENTENCIA_WHERE = "WHERE id = ? ";

	public TipoIdentificacionPostgreSQLDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final TipoIdentificacionEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO TipoIdentificacion (id, codigo, nombre, estado)");
		sentencia.append("VALUES (?, ?, ?, ?)");
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString()) ) {
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setString(2, entity.getCodigo());
			sentenciaPreparada.setString(3, entity.getNombre());
			sentenciaPreparada.setBoolean(4, entity.isEstado());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000032);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000033);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000032);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000034);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
	}

	@Override
	public final void modificar(final TipoIdentificacionEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("UPDATE TipoIdentificacion ");
		sentencia.append("SET codigo = ?, nombre = ?, estado = ? ");
		sentencia.append(SENTENCIA_WHERE);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setString(1, entity.getCodigo());
			sentenciaPreparada.setString(2, entity.getNombre());
			sentenciaPreparada.setBoolean(3, entity.isEstado());
			sentenciaPreparada.setObject(4, entity.getId());
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000036);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000037);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000036);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000038);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
	}

	@Override
	public final void eliminar(final UUID id) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("DELETE FROM TipoIdentificacion ");
		sentencia.append(SENTENCIA_WHERE);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setObject(1, id);
			
			sentenciaPreparada.executeUpdate();
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000043);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000044);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000043);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000045);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
	}

	@Override
	public final Optional<TipoIdentificacionEntity> consultarPorId(final UUID id) {
		final var sentencia = new StringBuilder();
		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM TipoIdentificacion ");
		sentencia.append(SENTENCIA_WHERE);
		
		Optional<TipoIdentificacionEntity> resultado = Optional.empty();
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setObject(1, id);
			resultado = ejecutarConsultaPorId(sentenciaPreparada);
			
		}catch (final DataReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000039);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000041);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000039);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000042);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
		return resultado;
	}

	@Override
	public final List<TipoIdentificacionEntity> consultar(final TipoIdentificacionEntity entity) {
		
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(entity, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
			
		} catch (final DataReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000047);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000048);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000047);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000049);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}

	private final Optional<TipoIdentificacionEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		
		Optional<TipoIdentificacionEntity> resultado = Optional.empty();
		
		try(final var resultados = sentenciaPreparada.executeQuery()) {
			if (resultados.next()) {
				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(UUID.fromString(resultados.getObject("id").toString()), 
						resultados.getString("codigo"), resultados.getString("nombre"), resultados.getBoolean("estado"));
				
				resultado = Optional.of(tipoIdentificacionEntity);
			}
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000039);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000040);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000039);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000046);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		
		return resultado;
	}
	
	private final String formarSentenciaConsulta(final TipoIdentificacionEntity entity, final List<Object> parametros) {
		
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE ";
		
		sentencia.append("SELECT id, codigo, nombre, estado ");
		sentencia.append("FROM TipoIdentificacion ");
		
		if (!UtilObjeto.esNulo(entity)) {
			
			if (!UtilObjeto.esNulo(entity.getId())) {
				sentencia.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getId());
			}
			
			if (!UtilTexto.estaVacio(entity.getCodigo())) {
				sentencia.append(operadorCondicional).append(" codigo = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getCodigo());
			}
			
			if (!UtilTexto.estaVacio(entity.getNombre())) {
				sentencia.append(operadorCondicional).append(" nombre = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getNombre());
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
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000047);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000050);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000047);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000051);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	private final List<TipoIdentificacionEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		
		final var listaResultados = new ArrayList<TipoIdentificacionEntity>();
		
		try(final var resultados = sentenciaPreparada.executeQuery()) {
			while (resultados.next()) {
				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(UUID.fromString(resultados.getObject("id").toString()), 
						resultados.getString("codigo"), resultados.getString("nombre"), resultados.getBoolean("estado"));
				
				listaResultados.add(tipoIdentificacionEntity);
			}
			
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000047);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000052);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000039);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000053);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return listaResultados;
	}
}
