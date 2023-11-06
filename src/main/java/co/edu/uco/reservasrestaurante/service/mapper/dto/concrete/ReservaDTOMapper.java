package co.edu.uco.reservasrestaurante.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;
import co.edu.uco.reservasrestaurante.service.dto.ReservaDTO;
import co.edu.uco.reservasrestaurante.service.mapper.dto.DTOMapper;

public final class ReservaDTOMapper implements DTOMapper<ReservaDTO, ReservaDomain>{
	
	private static final DTOMapper<ReservaDTO, ReservaDomain> instancia = new ReservaDTOMapper();
	
	private ReservaDTOMapper() {
		super();
	}

	@Override
	public ReservaDomain toDomain(ReservaDTO dto) {
		if (UtilObjeto.esNulo(null)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000195);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ReservaDomain.crear(dto.getId(), ClienteDTOMapper.convertToDomain(dto.getCliente()), dto.getFecha(),
				dto.getHora(), MesaDTOMapper.convertToDomain(dto.getMesa()), dto.getCantidadPersonas(), 
				BooleanDTOMapper.convertToDomain(dto.isEstado()));
	}

	@Override
	public ReservaDTO toDto(ReservaDomain domain) {
		if (UtilObjeto.esNulo(null)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000195);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ReservaDTO.crear().setId(domain.getId()).setCliente(ClienteDTOMapper.convertToDTO(domain.getCliente()))
				.setFecha(domain.getFecha()).setHora(domain.getHora()).setMesa(MesaDTOMapper.convertToDTO(domain.getMesa())).
				setCantidadPersonas(domain.getCantidadPersonas()).setEstado(BooleanDTOMapper.convertToDTO(domain.isEstado()));
	}

	public static final ReservaDomain convertToDomain(final ReservaDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final ReservaDTO convertToDTO(final ReservaDomain domain) {
		return instancia.toDto(domain);
	}
	
	public static final List<ReservaDTO> convertToListDTO(final List<ReservaDomain> dto){
		List<ReservaDTO> resultados = new ArrayList<>();
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToDTO(dto.get(indice)));
		}
		return resultados;
	}
}
