package co.edu.uco.reservasrestaurante.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;
import co.edu.uco.reservasrestaurante.service.dto.MesaDTO;
import co.edu.uco.reservasrestaurante.service.mapper.dto.DTOMapper;

public final class MesaDTOMapper implements DTOMapper<MesaDTO, MesaDomain> {

	private static final DTOMapper<MesaDTO, MesaDomain> instancia = new MesaDTOMapper(); 
	
	private MesaDTOMapper() {
		super();
	}
	
	@Override
	public MesaDomain toDomain(final MesaDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000092);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return MesaDomain.crear(dto.getId(), dto.getNumero(), dto.getUbicacion(), dto.getCapacidad(),
				BooleanDTOMapper.convertToDomain(dto.isEstado()));
	}

	@Override
	public MesaDTO toDto(final MesaDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000093);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return MesaDTO.crear().setId(domain.getId()).setNumero(domain.getNumero()).setUbicacion(domain.getUbicacion())
				.setCapacidad(domain.getCapacidad()).setEstado(BooleanDTOMapper.convertToDTO(domain.isEstado()));
	}

	public static final MesaDomain convertToDomain(final MesaDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final MesaDTO convertToDTO(final MesaDomain domain) {
		return instancia.toDto(domain);
	}
	
	public static final List<MesaDTO> convertToListDTO(final List<MesaDomain> dto){
		List<MesaDTO> resultados = new ArrayList<>();
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToDTO(dto.get(indice)));
		}
		return resultados;
	}
}
