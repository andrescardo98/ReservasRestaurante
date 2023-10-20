package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.tipoidentificacion;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.TipoIdentificacionDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.entity.TipoIdentificacionEntity;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.domain.TipoIdentificacionDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public class RegistrarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain> {
	
	private DAOFactory factoria;	

	public RegistrarTipoIdentificacionUseCase(DAOFactory factoria) {
		setFactoria(factoria);
	}


	@Override
	public void execute(TipoIdentificacionDomain domain) {
		// 1. Validar integridad de datos (tipo de dato, longitud, obligatoriedad, formato, rango, etc.)
		//TODO: ¿Cómo lo hago?
		
		// 2. No debe existir otro tipo de identificación con el mismo codigo
		validarNoExistenciaTipoIdentificacionConMismoCodigo(domain.getCodigo());
		
		// 3. No debe existir otro tipo de identificación con el mismo nombre
		validarNoExistenciaTipoIdentificacionConMismoNombre(domain.getNombre());
		
		// 4. No debe existir otro tipo de identificación con el mismo identificador
				domain = obtenerIdentificadorTipoIdentificacion(domain);
		
		// 5. Registrar el nuevo tipo de identificación
		registrar(domain);
	}
	
	private final void registrar(final TipoIdentificacionDomain domain) {
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		getTipoIdentificacionDAO().crear(entity);
	}
	
	private final void validarNoExistenciaTipoIdentificacionConMismoNombre(final String nombre) {
		
		//TODO: ¿Cómo lograr que esto no quede tan feo?
		var domain = TipoIdentificacionDomain.crear(null, nombre, null, false);
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe un tipo de identificación con el nombre " + nombre;
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaTipoIdentificacionConMismoCodigo(final String codigo) {
		
		//TODO: ¿Cómo lograr que esto no quede tan feo?
		var domain = TipoIdentificacionDomain.crear(null, null, codigo, false);
		var entity = TipoIdentificacionEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe un tipo de identificación con el codigo " + codigo;
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final TipoIdentificacionDomain obtenerIdentificadorTipoIdentificacion(final TipoIdentificacionDomain domain) {
		Optional<TipoIdentificacionEntity> optional;
		UUID uuid;
		
		do {
			uuid = UUID.randomUUID();
			optional = getTipoIdentificacionDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		
		return TipoIdentificacionDomain.crear(uuid, domain.getNombre(), domain.getCodigo(), domain.isEstado());
	}


	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}


	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000070);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000071);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
	
	
	
}
