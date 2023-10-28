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
import co.edu.uco.reservasrestaurante.data.dao.ClienteDAO;
import co.edu.uco.reservasrestaurante.data.dao.base.SQLDAO;
import co.edu.uco.reservasrestaurante.data.entity.ClienteEntity;
import co.edu.uco.reservasrestaurante.data.entity.PaisEntity;
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
			sentenciaPreparada.setObject(6, entity.getPais());
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
			sentenciaPreparada.setObject(5, entity.getPais());
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
				var clienteEntity = ClienteEntity.crear(UUID.fromString(resultados.getObject("id").toString()), 
						IdentificacionClienteEntity.crear(TipoIdentificacionEntity.crear(UUID.fromString(resultados.getObject("id").toString()),
								resultados.getString("nombre"), resultados.getString("codigo"), resultados.getBoolean("estado")),resultados.getString("numeroIdentificacion")),								
						NombreCompletoClienteEntity.crear(resultados.getString("primerNombre"), resultados.getString("segundoNombre"), 
								resultados.getString("primerApellido"), resultados.getString("segundoApellido")),
						CorreoElectronicoClienteEntity.crear(resultados.getString("correoElectronico"), resultados.getBoolean("correoElectronicoConfirmado"), resultados.getString("clave")),
						resultados.getDate("fechaNacimiento"), 
						PaisEntity.crear(UUID.fromString((String) resultados.getObject("id")), 
								resultados.getString("nombre"), resultados.getString("codigoIndicativo"), 
								resultados.getString("codigoIso3")),
						NumeroCelularClienteEntity.crear(resultados.getString("numeroCelular"), resultados.getBoolean("numeroCelularConfirmado")));
						
				
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
		
		sentencia.append("SELECT id, identificacion, nombreCompleto, correoElectronico, fechaNacimiento, pais, numeroCelular ");
		sentencia.append("FROM Cliente ");
		
		if (!UtilObjeto.esNulo(entity)) {
			if (!UtilObjeto.esNulo(entity.getId())) {
				sentencia.append(operadorCondicional).append(" id = ? ");
				operadorCondicional = "AND";
				parametros.add(entity.getId());
			}
			if (!UtilObjeto.esNulo(entity.getIdentificacion())) {
				
				if (!UtilObjeto.esNulo(entity.getIdentificacion().getTipoIdentificacion())) {
					
					if (!UtilObjeto.esNulo(entity.getIdentificacion().getTipoIdentificacion().getId())) {
						sentencia.append(operadorCondicional).append(" id = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getIdentificacion().getTipoIdentificacion().getId());
					}
					if (!UtilObjeto.esNulo(entity.getIdentificacion().getTipoIdentificacion().getNombre())) {
						sentencia.append(operadorCondicional).append(" nombre = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getIdentificacion().getTipoIdentificacion().getNombre());
					}
					if (!UtilObjeto.esNulo(entity.getIdentificacion().getTipoIdentificacion().getCodigo())) {
						sentencia.append(operadorCondicional).append(" codigo = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getIdentificacion().getTipoIdentificacion().getCodigo());
					}
					if (!UtilObjeto.esNulo(entity.getIdentificacion().getTipoIdentificacion().isEstado())) {
						sentencia.append(operadorCondicional).append(" estado = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getIdentificacion().getTipoIdentificacion().isEstado());
					}
				if (!UtilObjeto.esNulo(entity.getIdentificacion().getNumeroIdentificacion())) {
					sentencia.append(operadorCondicional).append(" numeroIdentificacion = ? ");
					operadorCondicional = "AND";
					parametros.add(entity.getIdentificacion().getNumeroIdentificacion());
					}
				}
				if (!UtilObjeto.esNulo(entity.getNombreCompleto())) {
					if (!UtilObjeto.esNulo(entity.getNombreCompleto().getPrimerNombre())) {
						sentencia.append(operadorCondicional).append(" primerNombre = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNombreCompleto().getPrimerNombre());
					}
					if (!UtilObjeto.esNulo(entity.getNombreCompleto().getSegundoNombre())) {
						sentencia.append(operadorCondicional).append(" segundoNombre = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNombreCompleto().getSegundoNombre());
					}
					if (!UtilObjeto.esNulo(entity.getNombreCompleto().getPrimerApellido())) {
						sentencia.append(operadorCondicional).append(" primerApellido = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNombreCompleto().getSegundoNombre());
					}
					if (!UtilObjeto.esNulo(entity.getNombreCompleto().getSegundoApellido())) {
						sentencia.append(operadorCondicional).append(" segundoApellido= ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNombreCompleto().getSegundoApellido());
					}
				}
				if (!UtilObjeto.esNulo(entity.getCorreoElectronico())) {
					if (!UtilObjeto.esNulo(entity.getCorreoElectronico().getCorreoElectronico())) {
						sentencia.append(operadorCondicional).append(" correoElectronico = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getCorreoElectronico().getCorreoElectronico());
					}
					if (!UtilObjeto.esNulo(entity.getCorreoElectronico().isCorreoElectronicoConfirmado())) {
						sentencia.append(operadorCondicional).append(" correoElectronicoConfirmado = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getCorreoElectronico().isCorreoElectronicoConfirmado());
					}
					if (!UtilObjeto.esNulo(entity.getCorreoElectronico().getCorreoElectronico())) {
						sentencia.append(operadorCondicional).append(" clave = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getCorreoElectronico().getClave());
					}
				}
				if (!UtilObjeto.esNulo(entity.getFechaNacimiento())) {
					sentencia.append(operadorCondicional).append(" fechaNacimiento = ? ");
					operadorCondicional = "AND";
					parametros.add(entity.getFechaNacimiento());
				}
				if (!UtilObjeto.esNulo(entity.getPais())) {
					sentencia.append(operadorCondicional).append(" pais = ? ");
					operadorCondicional = "AND";
					parametros.add(entity.getPais());
				}
				if (!UtilObjeto.esNulo(entity.getNumeroCelular())) {
					if (!UtilObjeto.esNulo(entity.getNumeroCelular().getNumeroCelular())) {
						sentencia.append(operadorCondicional).append(" numeroCelular = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNumeroCelular().getNumeroCelular());
					}
					if (!UtilObjeto.esNulo(entity.getNumeroCelular().isNumeroCelularConfirmado())) {
						sentencia.append(operadorCondicional).append(" numeroCelularConfirmado = ? ");
						operadorCondicional = "AND";
						parametros.add(entity.getNumeroCelular().isNumeroCelularConfirmado());
					}
				}
			}
		}
		sentencia.append("ORDER BY id");
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
				var clienteEntity = ClienteEntity.crear(UUID.fromString(resultados.getObject("id").toString()), 
						IdentificacionClienteEntity.crear(TipoIdentificacionEntity.crear(UUID.fromString(resultados.getObject("id").toString()),
								resultados.getString("nombre"), resultados.getString("codigo"), resultados.getBoolean("estado")),resultados.getString("numeroIdentificacion")),								
						NombreCompletoClienteEntity.crear(resultados.getString("primerNombre"), resultados.getString("segundoNombre"), 
								resultados.getString("primerApellido"), resultados.getString("segundoApellido")),
						CorreoElectronicoClienteEntity.crear(resultados.getString("correoElectronico"), resultados.getBoolean("correoElectronicoConfirmado"), resultados.getString("clave")),
						resultados.getDate("fechaNacimiento"), 
						PaisEntity.crear(UUID.fromString((String) resultados.getObject("id")), resultados.getString("nombre"), resultados.getString("codigoIndicativo"), resultados.getString("codigoIso3")),
						NumeroCelularClienteEntity.crear(resultados.getString("numeroCelular"), resultados.getBoolean("numeroCelularConfirmado")));
						
				
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
