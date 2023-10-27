package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.cliente;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.ClienteDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.entity.ClienteEntity;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.domain.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.IdentificacionClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.NombreCompletoClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.NumeroCelularClienteDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.ClienteEntityMapper;

public class ModificarClienteUseCase implements UseCase<ClienteDomain> {
	
	private DAOFactory factoria;	

	public ModificarClienteUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(ClienteDomain domain) {
		validarExistenciaRegistro(domain.getId());
		validarNoExistenciaMismoNombre(domain.getNombreCompleto());
		validarNoExistenciaCorreoElectronico(domain.getCorreoElectronico());
		validarNoExistenciaNumeroCelular(domain.getNumeroCelular());
		validarNoExistenciaMismoCodigo(domain.getIdentificacion());
		domain = obtenerIdentificadorCliente(domain);
		actualizar(domain);
	}
	
	private final void actualizar(final ClienteDomain domain) {
		getClienteDAO().modificar(ClienteEntityMapper.converttoEntity(domain));
	}
	
	private final void validarExistenciaRegistro(final UUID id) {
		final var resultados = getClienteDAO().consultarPorId(id);
		
		if (resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000136);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	
	private final ClienteDomain obtenerIdentificadorCliente(final ClienteDomain domain) {
		Optional<ClienteEntity> optional;
		UUID uuid;
		
		do {
			uuid = UUID.randomUUID();
			optional = getClienteDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		
		return ClienteDomain.crear(uuid, domain.getIdentificacion(), domain.getNombreCompleto(), 
				domain.getCorreoElectronico(), domain.getFechaNacimiento(), domain.getPais(), 
				domain.getNumeroCelular());
	}
	
	private final void validarNoExistenciaMismoNombre(final NombreCompletoClienteDomain nombre) {
		final var domain = ClienteDomain.crear(null, null, nombre, null, null, null, null);
		final var entity = ClienteEntityMapper.converttoEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000137);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaCorreoElectronico(final CorreoElectronicoClienteDomain correoElectronico) {
		final var domain = ClienteDomain.crear(null, null, null, correoElectronico, null, null, null);
		final var entity = ClienteEntityMapper.converttoEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000138);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaNumeroCelular(final NumeroCelularClienteDomain numeroCelular) {
		final var domain = ClienteDomain.crear(null, null, null, null, null, null, numeroCelular);
		final var entity = ClienteEntityMapper.converttoEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000139);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaMismoCodigo(final IdentificacionClienteDomain codigo) {
		final var domain = ClienteDomain.crear(null, codigo, null, null, null, null, null);
		final var entity = ClienteEntityMapper.converttoEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000140);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}


	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}


	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000141);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000142);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
