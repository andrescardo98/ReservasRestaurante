package co.edu.uco.reservasrestaurante.data.dao.concrete.postgresql;

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
import co.edu.uco.reservasrestaurante.data.dao.ClienteDAO;
import co.edu.uco.reservasrestaurante.data.dao.base.SQLDAO;
import co.edu.uco.reservasrestaurante.data.entity.ClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.PaisEntity;
import co.edu.uco.reservasrestaurante.data.entity.TipoIdentificacionEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.BooleanEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.IdentificacionClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.support.NumeroCelularClienteEntity;

public final class ClientePostgreSQLDAO extends SQLDAO implements ClienteDAO{
	
	private static final String SENTENCIA_WHERE = "WHERE id = ? ";

	public ClientePostgreSQLDAO(final Connection conexion) {
		super(conexion);
	}

	@Override
	public final void crear(final ClienteEntity entity) {
		final var sentencia = new StringBuilder();
		
		sentencia.append("INSERT INTO Cliente (id, tipo_identificacion_id, numero_identificacion, primer_nombre, segundo_nombre, "
				+ "primer_apellido, segundo_apellido, correo_electronico, correo_electronico_confirmado, clave, fecha_nacimiento,"
				+ " pais_id, numero_celular, numero_celular_confirmado)");
		sentencia.append("VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setObject(1, entity.getId());
			sentenciaPreparada.setObject(2, entity.getIdentificacion().getTipoIdentificacion().getId());
			sentenciaPreparada.setString(3, entity.getIdentificacion().getNumeroIdentificacion());
			sentenciaPreparada.setString(4, entity.getNombreCompleto().getPrimerNombre());
			sentenciaPreparada.setString(5, entity.getNombreCompleto().getSegundoNombre());
			sentenciaPreparada.setString(6, entity.getNombreCompleto().getPrimerApellido());
			sentenciaPreparada.setString(7, entity.getNombreCompleto().getSegundoApellido());
			sentenciaPreparada.setString(8, entity.getCorreoElectronico().getCorreoElectronico());
			sentenciaPreparada.setBoolean(9, entity.getCorreoElectronico().isCorreoElectronicoConfirmado().isValor());
			sentenciaPreparada.setString(10, entity.getCorreoElectronico().getClave());
			sentenciaPreparada.setDate(11, entity.getFechaNacimiento());
			sentenciaPreparada.setObject(12, entity.getPais().getId());
			sentenciaPreparada.setString(13, entity.getNumeroCelular().getNumeroCelular());
			sentenciaPreparada.setBoolean(14, entity.getNumeroCelular().isNumeroCelularConfirmado().isValor());
			
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
		sentencia.append("SET tipo_identificacion_id = ?, ");
		sentencia.append("SET numero_identificacion = ?, ");
		sentencia.append(" primer_nombre = ?, ");
		sentencia.append(" segundo_nombre = ?, ");
		sentencia.append(" primer_apellido = ?, ");
		sentencia.append(" segundo_apellido = ?, ");
		sentencia.append(" correo_electronico = ?, "); 
		sentencia.append(" correo_electronico_confirmado = ? ");
		sentencia.append(" clave = ? ");
		sentencia.append(" fecha_nacimiento = ? ");
		sentencia.append(" pais_id = ? ");
		sentencia.append(" numero_celular = ? ");
		sentencia.append(" numero_celular_confirmado = ? ");
		sentencia.append(SENTENCIA_WHERE);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			
			sentenciaPreparada.setObject(1, entity.getIdentificacion().getTipoIdentificacion().getId());
			sentenciaPreparada.setString(2, entity.getIdentificacion().getNumeroIdentificacion());
			sentenciaPreparada.setString(3, entity.getNombreCompleto().getPrimerNombre());
			sentenciaPreparada.setString(4, entity.getNombreCompleto().getSegundoNombre());
			sentenciaPreparada.setString(5, entity.getNombreCompleto().getPrimerApellido());
			sentenciaPreparada.setString(6, entity.getNombreCompleto().getSegundoApellido());
			sentenciaPreparada.setString(7, entity.getCorreoElectronico().getCorreoElectronico());
			sentenciaPreparada.setBoolean(8, entity.getCorreoElectronico().isCorreoElectronicoConfirmado().isValor());
			sentenciaPreparada.setString(9, entity.getCorreoElectronico().getClave());
			sentenciaPreparada.setDate(10, entity.getFechaNacimiento());
			sentenciaPreparada.setObject(11, entity.getPais().getId());
			sentenciaPreparada.setString(12, entity.getNumeroCelular().getNumeroCelular());
			sentenciaPreparada.setBoolean(13, entity.getNumeroCelular().isNumeroCelularConfirmado().isValor());
			sentenciaPreparada.setObject(14, entity.getId());
			
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
		
		sentencia.append("SELECT cl.id, cl.tipo_identificacion_id, cl.numero_identificacion, cl.primer_nombre, cl.segundo_nombre, "
				+ "cl.primer_apellido, CL.segundo_apellido, cl.correo_electronico, cl.correo_electronico_confirmado, cl.clave, "
				+ "cl.fecha_nacimiento, cl.pais_id, cl.numero_celular, cl.numero_celular_confirmado ");
		sentencia.append("FROM Cliente cl ");
		sentencia.append("JOIN TipoIdentificacion ti ");
		sentencia.append(" ON cl.tipo_identificacion_id = ti.id ");
		sentencia.append(" WHERE cl.id = ? ");
		
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
		
		final var parametros = new ArrayList<Object>();
		final String sentencia = formarSentenciaConsulta(entity, parametros);
		
		try(final var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			colocarParametrosConsulta(sentenciaPreparada, parametros);
			return ejecutarConsulta(sentenciaPreparada);
			
		} catch (final DataReservasRestauranteException excepcion) {
			throw excepcion;
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000088);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000089);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000088);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000090);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	private final Optional<ClienteEntity> ejecutarConsultaPorId(final PreparedStatement sentenciaPreparada){
		
		Optional<ClienteEntity> resultado = Optional.empty();
		
		try(final var resultados = sentenciaPreparada.executeQuery()) {
			if (resultados.next()) {
				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(UUID.fromString(
						resultados.getObject("tipo_identificacion_id").toString()), 
						resultados.getString("nombre"), resultados.getString("codigo"), 
						BooleanEntity.crear(resultados.getBoolean("estado"), false));
				var identificacionClienteEntity = IdentificacionClienteEntity.crear(tipoIdentificacionEntity, 
						resultados.getString("numero_identificacion"));
				var nombreCompletoClienteEntity = NombreCompletoClienteEntity.crear(resultados.getString("primer_nombre"), 
						resultados.getString("segundo_nombre"), resultados.getString("primer_apellido"), 
						resultados.getString("segundo_apellido"));
				var correoElectronicoClienteEntity = CorreoElectronicoClienteEntity.crear(resultados.getString("correo_electronico"),
						BooleanEntity.crear(resultados.getBoolean("correoElectronicoConfirmado"), false), 
						resultados.getString("clave"));
				var paisEntity = PaisEntity.crear(UUID.fromString(resultados.getObject("id").toString()), 
						resultados.getString("nombre"), resultados.getString("codigo_indicativo"), 
						resultados.getString("codigo_iso3"));
				var numeroCelularClienteEntity = NumeroCelularClienteEntity.crear(resultados.getString("numero_celular"), 
						BooleanEntity.crear(resultados.getBoolean("numero_celular_confirmado"), false));
				
				var clienteEntity = ClienteEntity.crear(UUID.fromString(resultados.getObject("id").toString()), 
						identificacionClienteEntity, nombreCompletoClienteEntity, correoElectronicoClienteEntity, 
						resultados.getDate("fecha_nacimiento"), paisEntity, numeroCelularClienteEntity);
						
				
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
	
	private final String formarSentenciaConsulta(final ClienteEntity entity, final List<Object> parametros) {
		final var sentencia = new StringBuilder();
		String operadorCondicional = "WHERE ";
		
		sentencia.append("SELECT cl.id, cl.tipo_identificacion_id, cl.numero_identificacion, cl.primer_nombre, cl.segundo_nombre, "
				+ "cl.primer_apellido, CL.segundo_apellido, cl.correo_electronico, cl.correo_electronico_confirmado, cl.clave, "
				+ "cl.fecha_nacimiento, cl.pais_id, cl.numero_celular, cl.numero_celular_confirmado ");
		sentencia.append("FROM Cliente cl ");
		sentencia.append("JOIN TipoIdentificacion ti ");
		sentencia.append("ON cl.tipo_identificacion_id = ti.id ");
		sentencia.append("JOIN Pais pa ");
		sentencia.append("ON cl.pais_id = pa.id");
		
		if (!UtilObjeto.esNulo(entity)) {
			if (!UtilObjeto.esNulo(entity.getId())) {
				sentencia.append(operadorCondicional).append(" cl.id = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getId());
			}
			if (!UtilObjeto.esNulo(entity.getIdentificacion())) {
				
				if (!UtilObjeto.esNulo(entity.getIdentificacion().getTipoIdentificacion())) {
					
					if (!UtilObjeto.esNulo(entity.getIdentificacion().getTipoIdentificacion().getId())) {
						sentencia.append(operadorCondicional).append(" ti.tipo_identificacion_id = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getIdentificacion().getTipoIdentificacion().getId());
					}
					
				if (!UtilObjeto.esNulo(entity.getIdentificacion().getNumeroIdentificacion())) {
					sentencia.append(operadorCondicional).append(" cl.numero_identificacion = ? ");
					operadorCondicional = "AND";
					parametros.add(entity.getIdentificacion().getNumeroIdentificacion());
					}
				}
				
				if (!UtilObjeto.esNulo(entity.getNombreCompleto())) {
					if (!UtilObjeto.esNulo(entity.getNombreCompleto().getPrimerNombre())) {
						sentencia.append(operadorCondicional).append(" cl.primer_nombre = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNombreCompleto().getPrimerNombre());
					}
					if (!UtilObjeto.esNulo(entity.getNombreCompleto().getSegundoNombre())) {
						sentencia.append(operadorCondicional).append(" cl.segundo_nombre = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNombreCompleto().getSegundoNombre());
					}
					if (!UtilObjeto.esNulo(entity.getNombreCompleto().getPrimerApellido())) {
						sentencia.append(operadorCondicional).append(" cl.primer_apellido = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNombreCompleto().getSegundoNombre());
					}
					if (!UtilObjeto.esNulo(entity.getNombreCompleto().getSegundoApellido())) {
						sentencia.append(operadorCondicional).append(" cl.segundo_apellido= ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNombreCompleto().getSegundoApellido());
					}
				}
				if (!UtilObjeto.esNulo(entity.getCorreoElectronico())) {
					if (!UtilObjeto.esNulo(entity.getCorreoElectronico().getCorreoElectronico())) {
						sentencia.append(operadorCondicional).append(" cl.correo_electronico = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getCorreoElectronico().getCorreoElectronico());
					}
					if (!UtilObjeto.esNulo(entity.getCorreoElectronico().isCorreoElectronicoConfirmado().isValorDefecto())) {
						sentencia.append(operadorCondicional).append(" cl.correo_electronico_confirmado = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getCorreoElectronico().isCorreoElectronicoConfirmado().isValor());
					}
					if (!UtilObjeto.esNulo(entity.getCorreoElectronico().getClave())) {
						sentencia.append(operadorCondicional).append(" cl.clave = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getCorreoElectronico().getClave());
					}
				}
				if (!UtilObjeto.esNulo(entity.getFechaNacimiento())) {
					sentencia.append(operadorCondicional).append(" cl.fecha_nacimiento = ? ");
					operadorCondicional = "AND";
					parametros.add(entity.getFechaNacimiento());
				}
				if (!UtilObjeto.esNulo(entity.getPais())) {
					sentencia.append(operadorCondicional).append(" pa.id = ? ");
					operadorCondicional = "AND";
					parametros.add(entity.getPais());
				}
				if (!UtilObjeto.esNulo(entity.getNumeroCelular())) {
					if (!UtilObjeto.esNulo(entity.getNumeroCelular().getNumeroCelular())) {
						sentencia.append(operadorCondicional).append(" cl.numero_celular = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNumeroCelular().getNumeroCelular());
					}
					if (!UtilObjeto.esNulo(entity.getNumeroCelular().isNumeroCelularConfirmado().isValorDefecto())) {
						sentencia.append(operadorCondicional).append(" cl.numero_celular_confirmado = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNumeroCelular().isNumeroCelularConfirmado().isValor());
					}
				}
			}
		}
		sentencia.append("ORDER BY cl.primer_nombre");
		return sentencia.toString();
	}
	
	private final void colocarParametrosConsulta(final PreparedStatement sentenciaPreparada, final List<Object> parametros) {
		
		try {
			for (int indice = 0; indice < parametros.size(); indice++) {
				sentenciaPreparada.setObject(indice + 1, parametros.get(indice));
			}
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000083);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000084);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000083);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000085);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
	}
	
	private final List<ClienteEntity> ejecutarConsulta(final PreparedStatement sentenciaPreparada){
		
		final var listaResultados = new ArrayList<ClienteEntity>();
		
		try(final var resultados = sentenciaPreparada.executeQuery()) {
			while (resultados.next()) {
				var tipoIdentificacionEntity = TipoIdentificacionEntity.crear(UUID.fromString(
						resultados.getObject("tipo_identificacion_id").toString()), 
						resultados.getString("nombre"), resultados.getString("codigo"), 
						BooleanEntity.crear(resultados.getBoolean("estado"), false));
				var identificacionClienteEntity = IdentificacionClienteEntity.crear(tipoIdentificacionEntity, 
						resultados.getString("numero_identificacion"));
				var nombreCompletoClienteEntity = NombreCompletoClienteEntity.crear(resultados.getString("primer_nombre"), 
						resultados.getString("segundo_nombre"), resultados.getString("primer_apellido"), 
						resultados.getString("segundo_apellido"));
				var correoElectronicoClienteEntity = CorreoElectronicoClienteEntity.crear(resultados.getString("correo_electronico"),
						BooleanEntity.crear(resultados.getBoolean("correoElectronicoConfirmado"), false), 
						resultados.getString("clave"));
				var paisEntity = PaisEntity.crear(UUID.fromString(resultados.getObject("id").toString()), 
						resultados.getString("nombre"), resultados.getString("codigo_indicativo"), 
						resultados.getString("codigo_iso3"));
				var numeroCelularClienteEntity = NumeroCelularClienteEntity.crear(resultados.getString("numero_celular"), 
						BooleanEntity.crear(resultados.getBoolean("numero_celular_confirmado"), false));
				
				var clienteEntity = ClienteEntity.crear(UUID.fromString(resultados.getObject("id").toString()), 
						identificacionClienteEntity, nombreCompletoClienteEntity, correoElectronicoClienteEntity, 
						resultados.getDate("fecha_nacimiento"), paisEntity, numeroCelularClienteEntity);
				
				listaResultados.add(clienteEntity);
			}
		} catch (final SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000083);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000086);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		} catch (final Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000083);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000087);
			throw DataReservasRestauranteException.crear(excepcion, mensajeUsuario, mensajeTecnico);
		}
		return listaResultados;
	}
}
