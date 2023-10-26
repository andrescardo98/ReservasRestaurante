package co.edu.uco.reservasrestaurante.service.mapper.entity.concrete;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.entity.support.IdentificacionClienteEntity;
import co.edu.uco.reservasrestaurante.service.domain.support.IdentificacionClienteDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.EntityMapper;

public final class IdentificacionClienteEntityMapper implements EntityMapper<IdentificacionClienteEntity, IdentificacionClienteDomain>{

	private static final EntityMapper<IdentificacionClienteEntity, IdentificacionClienteDomain> instancia = new 
			IdentificacionClienteEntityMapper();
	
	private IdentificacionClienteEntityMapper() {
		super();
	}
	
	@Override
	public IdentificacionClienteDomain toDomain(IdentificacionClienteEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000094);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return IdentificacionClienteDomain.crear(null, null);
	}

	@Override
	public IdentificacionClienteEntity toEntity(IdentificacionClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000095);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return IdentificacionClienteEntity.crear(null, null);
	}
	
	public static final IdentificacionClienteDomain convertToDomain(final IdentificacionClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final IdentificacionClienteEntity convertToEntity(final IdentificacionClienteDomain domain) {
		return instancia.toEntity(domain);
	}

	
}
