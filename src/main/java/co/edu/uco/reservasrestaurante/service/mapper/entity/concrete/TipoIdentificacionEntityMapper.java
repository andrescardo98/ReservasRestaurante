package co.edu.uco.reservasrestaurante.service.mapper.entity.concrete;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.entity.TipoIdentificacionEntity;
import co.edu.uco.reservasrestaurante.service.domain.TipoIdentificacionDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.EntityMapper;

public final class TipoIdentificacionEntityMapper implements EntityMapper<TipoIdentificacionEntity, TipoIdentificacionDomain> {

	private static final EntityMapper<TipoIdentificacionEntity, TipoIdentificacionDomain> instancia = new TipoIdentificacionEntityMapper(); 
	
	
	private TipoIdentificacionEntityMapper() {
		super();
	}
	
	@Override
	public final TipoIdentificacionDomain toDomain(final TipoIdentificacionEntity entity) {
		
		if (UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000068);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return TipoIdentificacionDomain.crear(entity.getId(), entity.getNombre(), entity.getCodigo(), entity.isEstado());
	}

	@Override
	public final TipoIdentificacionEntity toEntity(final TipoIdentificacionDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000069);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return TipoIdentificacionEntity.crear(domain.getId(), domain.getNombre(), domain.getCodigo(), domain.isEstado());
	}
	
	public final TipoIdentificacionDomain convertToDomain(final TipoIdentificacionEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public final static TipoIdentificacionEntity convertToEntity(final TipoIdentificacionDomain domain) {
		return instancia.toEntity(domain);
	}

}
