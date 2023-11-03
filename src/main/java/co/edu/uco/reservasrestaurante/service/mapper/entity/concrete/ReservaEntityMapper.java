package co.edu.uco.reservasrestaurante.service.mapper.entity.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.entity.ReservaEntity;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.EntityMapper;

public final class ReservaEntityMapper implements EntityMapper<ReservaEntity, ReservaDomain>{

	private static final EntityMapper<ReservaEntity, ReservaDomain> instancia = new ReservaEntityMapper();
	
	private ReservaEntityMapper() {
		super();
	}
	
	@Override
	public ReservaDomain toDomain(ReservaEntity entity) {
		if (UtilObjeto.esNulo(entity)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000094);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return ReservaDomain.crear(entity.getId(), ClienteEntityMapper.convertToDomain(entity.getCliente()), 
				entity.getFecha(), entity.getHora(), MesaEntityMapper.convertToDomain(entity.getMesa()), entity.getCantidadPersonas(),
				entity.isEstado());
	}

	@Override
	public ReservaEntity toEntity(ReservaDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000095);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		 
		return ReservaEntity.crear(domain.getId(), ClienteEntityMapper.convertToEntity(domain.getCliente()), 
				domain.getFecha(), domain.getHora(), MesaEntityMapper.convertToEntity(domain.getMesa()), domain.getCantidadPersonas(), 
				domain.isEstado());
	}
	
	public static final ReservaDomain convertToDomain(final ReservaEntity entity) {
		return instancia.toDomain(entity);
	}
	
	public static final ReservaEntity convertToEntity(final ReservaDomain domain) {
		return instancia.toEntity(domain);
	}
	
	public static final List<ReservaDomain> convertToListDomain(final List<ReservaEntity> entity){
		List<ReservaDomain> resultados = new ArrayList<>();
		
		for (int indice = 0; indice < entity.size(); indice++) {
			resultados.add(convertToDomain(entity.get(indice)));
		}
		return resultados;
	}

	
}
