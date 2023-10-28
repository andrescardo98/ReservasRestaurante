package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.pais;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.PaisDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.pais.ModificarPaisValidator;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.PaisClienteEntityMapper;

public class ModificarPaisUseCase implements UseCase<PaisDomain>{
	
	private DAOFactory factoria;
	
	public ModificarPaisUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(PaisDomain domain) {
		ModificarPaisValidator.ejecutar(domain);
		validarRegistroExistente(domain.getId());
		validarNoExistenciaMismoNombre(domain.getNombre());
		validarNoExistenciaMismoCodigoIndicativo(domain.getCodigoIndicativo());
		validarNoExistenciaMismoCodigoIso3(domain.getCodigoiso3());
		actualizar(domain);
	}

	private final void actualizar(final PaisDomain domain) {
		getPaisDAO().modificar(PaisClienteEntityMapper.convertToEntity(domain));
	}
	
	private final void validarRegistroExistente(final UUID uuid) {
		final var resultados = getPaisDAO().consultarPorId(uuid);
		
		if (resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000183);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaMismoNombre(final String nombre) {
		
		var domain = PaisDomain.crear(null, nombre, null, null);
		var entity = PaisClienteEntityMapper.convertToEntity(domain);
		var resultados = getPaisDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe un país con el nombre " + nombre;
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaMismoCodigoIndicativo(final String codigoIndicativo) {
		var domain = PaisDomain.crear(null, null, codigoIndicativo, null);
		var entity = PaisClienteEntityMapper.convertToEntity(domain);
		var resultados = getPaisDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe un país con el código indicativo " + codigoIndicativo;
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaMismoCodigoIso3(final String codigoIso3) {
		var domain = PaisDomain.crear(null, null, null, codigoIso3);
		var entity = PaisClienteEntityMapper.convertToEntity(domain);
		var resultados = getPaisDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = "Ya existe un país con el código ISO 3 " + codigoIso3;
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final PaisDAO getPaisDAO() {
		return getFactoria().obtenerPaisDAO();
	}
	
	public DAOFactory getFactoria() {
		return factoria;
	}
	
	public void setFactoria(DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000181);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000184);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
