package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.pais;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.PaisDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.entity.PaisEntity;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.pais.RegistrarPaisValidator;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.PaisClienteEntityMapper;

public class RegistrarPaisUseCase implements UseCase<PaisDomain>{
	
	private DAOFactory factoria;
	
	public RegistrarPaisUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(PaisDomain domain) {
		RegistrarPaisValidator.ejecutar(domain);
		validarNoExistenciaMismoNombre(domain.getNombre());
		validarNoExistenciaMismoCodigoIndicativo(domain.getCodigoIndicativo());
		validarNoExistenciaMismoCodigoIso3(domain.getCodigoiso3());
		domain = obtenerIdentificadorPais(domain);
		registrar(domain);
	}

	private final void registrar(final PaisDomain domain) {
		var entity = PaisClienteEntityMapper.convertToEntity(domain);
		getPaisDAO().crear(entity);
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
	
	private final PaisDomain obtenerIdentificadorPais(final PaisDomain domain) {
		Optional<PaisEntity> optional;
		UUID uuid;
		
		do {
			uuid = UUID.randomUUID();
			optional = getPaisDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		
		return PaisDomain.crear(uuid, domain.getNombre(), domain.getCodigoIndicativo(), domain.getCodigoiso3());
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
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000182);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
