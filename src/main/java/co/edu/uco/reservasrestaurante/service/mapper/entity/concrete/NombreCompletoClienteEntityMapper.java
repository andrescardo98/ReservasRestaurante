package co.edu.uco.reservasrestaurante.service.mapper.entity.concrete;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.entity.support.NombreCompletoClienteEntity;
import co.edu.uco.reservasrestaurante.service.domain.support.NombreCompletoClienteDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.EntityMapper;

public final class NombreCompletoClienteEntityMapper implements EntityMapper<NombreCompletoClienteEntity, NombreCompletoClienteDomain>{

	private static final EntityMapper<NombreCompletoClienteEntity, NombreCompletoClienteDomain> instancia = new 
			NombreCompletoClienteEntityMapper();
	
	private NombreCompletoClienteEntityMapper() {
		super();
	}
	
	@Override
	public NombreCompletoClienteDomain toDomain(NombreCompletoClienteEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000094);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return NombreCompletoClienteDomain.crear(entity.getPrimerNombre(), entity.getSegundoNombre(), 
				entity.getPrimerApellido(), entity.getSegundoApellido());
	}

	@Override
	public NombreCompletoClienteEntity toEntity(NombreCompletoClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000095);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return NombreCompletoClienteEntity.crear(domain.getPrimerNombre(), domain.getSegundoNombre(), domain.getPrimerApellido(), domain.getSegundoApellido());
	}
	
	public static final NombreCompletoClienteDomain convertToDomain(final NombreCompletoClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final NombreCompletoClienteEntity convertToEntity(final NombreCompletoClienteDomain domain) {
		return instancia.toEntity(domain);
	}

	
}
