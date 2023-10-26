package co.edu.uco.reservasrestaurante.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.entity.ClienteEntity;
import co.edu.uco.reservasrestaurante.service.domain.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.EntityMapper;

public final class ClienteEntityMapper implements EntityMapper<ClienteEntity, ClienteDomain>{
	
	private static final EntityMapper<ClienteEntity, ClienteDomain> instancia = new ClienteEntityMapper();
	
	private ClienteEntityMapper() {
		super();
	}

	@Override
	public final ClienteDomain toDomain(final ClienteEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000128);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return ClienteDomain.crear(entity.getId(), 
				IdentificacionClienteEntityMapper.convertToDomain(entity.getIdentificacion()), 
				NombreCompletoClienteEntityMapper.convertToDomain(entity.getNombreCompleto()), 
				CorreoElectronicoClienteEntityMapper.convertToDomain(entity.getCorreoElectronico()), 
				entity.getFechaNacimiento(), 
				entity.getPais(), 
				NumeroCelularClienteEntityMapper.convertToDomain(entity.getNumeroCelular()));
	}

	@Override
	public final ClienteEntity toEntity(final ClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000129);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return ClienteEntity.crear(domain.getId(), 
				IdentificacionClienteEntityMapper.convertToEntity(domain.getIdentificacion()), 
				NombreCompletoClienteEntityMapper.convertToEntity(domain.getNombreCompleto()), 
				CorreoElectronicoClienteEntityMapper.convertToEntity(domain.getCorreoElectronico()), 
				domain.getFechaNacimiento(), 
				domain.getPais(), 
				NumeroCelularClienteEntityMapper.convertToEntity(domain.getNumeroCelular()));
	}

	public static final ClienteDomain convertToDomain(final ClienteEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final ClienteEntity converttoEntity(final ClienteDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<ClienteDomain> convertToListDomain(final List<ClienteEntity> entity){
		List<ClienteDomain> resultados = new ArrayList<>();
		
		for (int indice = 0; indice < entity.size(); indice++) {
			resultados.add(convertToDomain(entity.get(indice)));
		}
		return resultados;
	}
	
}
