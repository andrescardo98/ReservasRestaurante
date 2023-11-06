package co.edu.uco.reservasrestaurante.service.mapper.entity.concrete;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.entity.support.NumeroCelularClienteEntity;
import co.edu.uco.reservasrestaurante.service.domain.support.NumeroCelularClienteDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.EntityMapper;

public final class NumeroCelularClienteEntityMapper implements EntityMapper<NumeroCelularClienteEntity, NumeroCelularClienteDomain>{

	private static final EntityMapper<NumeroCelularClienteEntity, NumeroCelularClienteDomain> instancia = new 
			NumeroCelularClienteEntityMapper();
	
	private NumeroCelularClienteEntityMapper() {
		super();
	}
	
	@Override
	public NumeroCelularClienteDomain toDomain(NumeroCelularClienteEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000094);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return NumeroCelularClienteDomain.crear(entity.getNumeroCelular(), 
				BooleanEntityMapper.convertToDomain(entity.isNumeroCelularConfirmado()));
	}

	@Override
	public NumeroCelularClienteEntity toEntity(NumeroCelularClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000095);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return NumeroCelularClienteEntity.crear(domain.getNumeroCelular(), 
				BooleanEntityMapper.convertToEntity(domain.isNumeroCelularConfirmado()));
	}
	
	public static final NumeroCelularClienteDomain convertToDomain(final NumeroCelularClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final NumeroCelularClienteEntity convertToEntity(final NumeroCelularClienteDomain domain) {
		return instancia.toEntity(domain);
	}

	
}
