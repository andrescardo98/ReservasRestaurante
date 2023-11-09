package co.edu.uco.reservasrestaurante.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.entity.PaisEntity;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.EntityMapper;

public final class PaisClienteEntityMapper implements EntityMapper<PaisEntity, PaisDomain>{

	private static final EntityMapper<PaisEntity, PaisDomain> instancia = new PaisClienteEntityMapper();
	
	private PaisClienteEntityMapper() {
		super();
	}
	
	@Override
	public PaisDomain toDomain(PaisEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000094);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return PaisDomain.crear(entity.getId(),entity.getNombre(),entity.getCodigoIndicativo(),entity.getCodigoIso3());
	}

	@Override
	public PaisEntity toEntity(PaisDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000095);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return PaisEntity.crear(domain.getId(), domain.getNombre(), domain.getCodigoIndicativo(), domain.getCodigoIso3());
	}
	
	public static final PaisDomain convertToDomain(final PaisEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final PaisEntity convertToEntity(final PaisDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<PaisDomain> convertToListDomain(final List<PaisEntity> entity){
		List<PaisDomain> resultados = new ArrayList<>();
		
		for (int indice = 0; indice < entity.size(); indice++) {
			resultados.add(convertToDomain(entity.get(indice)));
		}
		return resultados;
	}

	
}
