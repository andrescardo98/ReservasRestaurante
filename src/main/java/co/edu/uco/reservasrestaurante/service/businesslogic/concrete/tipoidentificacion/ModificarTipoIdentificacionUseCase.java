package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.tipoidentificacion;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.TipoIdentificacionDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.tipoidentificacion.ModificarTipoIdentificacionValidator;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public class ModificarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain> {
	
	private DAOFactory factoria;	

	public ModificarTipoIdentificacionUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}


	@Override
	public void execute(TipoIdentificacionDomain domain) {
		ModificarTipoIdentificacionValidator.ejecutar(domain);
		validarRegistroExistente(domain.getId());
		validarNoExistenciaTipoIdentificacionConMismoCodigo(domain.getCodigo());
		validarNoExistenciaTipoIdentificacionConMismoNombre(domain.getNombre());
		actualizar(domain);
	}
	
	private final void actualizar(final TipoIdentificacionDomain domain) {
		getTipoIdentificacionDAO().modificar(TipoIdentificacionEntityMapper.convertToEntity(domain));
	}
	
	private final void validarRegistroExistente(final UUID uuid) {
		final var resultados = getTipoIdentificacionDAO().consultarPorId(uuid);
		
		if (resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000120);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
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

	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}


	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000121);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000122);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
