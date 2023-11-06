package co.edu.uco.reservasrestaurante.service.mapper.entity.concrete;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.entity.support.CorreoElectronicoClienteEntity;
import co.edu.uco.reservasrestaurante.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.EntityMapper;

public final class CorreoElectronicoClienteEntityMapper implements EntityMapper<CorreoElectronicoClienteEntity, CorreoElectronicoClienteDomain>{

	private static final EntityMapper<CorreoElectronicoClienteEntity, CorreoElectronicoClienteDomain> instancia = new 
			CorreoElectronicoClienteEntityMapper();
	
	private CorreoElectronicoClienteEntityMapper() {
		super();
	}
	
	@Override
	public CorreoElectronicoClienteDomain toDomain(CorreoElectronicoClienteEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000094);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return CorreoElectronicoClienteDomain.crear(entity.getCorreoElectronico(), 
				BooleanEntityMapper.convertToDomain(entity.isCorreoElectronicoConfirmado()),
				entity.getClave());
	}

	@Override
	public CorreoElectronicoClienteEntity toEntity(CorreoElectronicoClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000095);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return CorreoElectronicoClienteEntity.crear(domain.getCorreoElectronico(), 
				BooleanEntityMapper.convertToEntity(domain.isCorreoElectronicoConfirmado()), domain.getClave());
	}
	
	public static final CorreoElectronicoClienteDomain convertToDomain(final CorreoElectronicoClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final CorreoElectronicoClienteEntity convertToEntity(final CorreoElectronicoClienteDomain domain) {
		return instancia.toEntity(domain);
	}

	
}
