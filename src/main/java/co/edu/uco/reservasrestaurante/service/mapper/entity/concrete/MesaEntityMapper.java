package co.edu.uco.reservasrestaurante.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.entity.MesaEntity;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.EntityMapper;

public final class MesaEntityMapper implements EntityMapper<MesaEntity, MesaDomain>{

	private static final EntityMapper<MesaEntity, MesaDomain> instancia = new MesaEntityMapper();
	
	private MesaEntityMapper() {
		super();
	}
	
	@Override
	public MesaDomain toDomain(MesaEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000294);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return MesaDomain.crear(entity.getId(), entity.getNumero(), entity.getUbicacion(), entity.getCapacidad(), entity.isEstado());
	}

	@Override
	public MesaEntity toEntity(MesaDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000295);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return MesaEntity.crear(domain.getId(), domain.getNumero(), domain.getUbicacion(), domain.getCapacidad(), domain.isEstado());
	}
	
	public static final MesaDomain convertToDomain(final MesaEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final MesaEntity convertToEntity(final MesaDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<MesaDomain> convertToListDomain(final List<MesaEntity> entity){
		List<MesaDomain> resultados = new ArrayList<>();
		
		for (int indice = 0; indice < entity.size(); indice++) {
			resultados.add(convertToDomain(entity.get(indice)));
		}
		return resultados;
	}

	
}
