package co.edu.uco.reservasrestaurante.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.entity.support.BooleanEntity;
import co.edu.uco.reservasrestaurante.service.domain.support.BooleanDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.EntityMapper;

public class BooleanEntityMapper implements EntityMapper<BooleanEntity, BooleanDomain>{

private static final EntityMapper<BooleanEntity, BooleanDomain> instancia = new BooleanEntityMapper();
	
	private BooleanEntityMapper() {
		super();
	}
	
	@Override
	public BooleanDomain toDomain(BooleanEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000294);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return BooleanDomain.crear(entity.isValor(), entity.isValorDefecto());
	}

	@Override
	public BooleanEntity toEntity(BooleanDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000295);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return BooleanEntity.crear(domain.isValor(), domain.isValorDefecto());
	}
	
	public static final BooleanDomain convertToDomain(final BooleanEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final BooleanEntity convertToEntity(final BooleanDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<BooleanDomain> convertToListDomain(final List<BooleanEntity> entity){
		List<BooleanDomain> resultados = new ArrayList<>();
		
		for (int indice = 0; indice < entity.size(); indice++) {
			resultados.add(convertToDomain(entity.get(indice)));
		}
		return resultados;
	}

}
