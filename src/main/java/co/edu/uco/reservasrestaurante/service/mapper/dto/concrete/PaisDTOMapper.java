package co.edu.uco.reservasrestaurante.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;
import co.edu.uco.reservasrestaurante.service.dto.PaisDTO;
import co.edu.uco.reservasrestaurante.service.mapper.dto.DTOMapper;

public final class PaisDTOMapper implements DTOMapper<PaisDTO, PaisDomain>{
	
	private static final DTOMapper<PaisDTO, PaisDomain> instancia = new PaisDTOMapper();
	
	private PaisDTOMapper() {
		super();
	}

	@Override
	public PaisDomain toDomain(final PaisDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000195);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return PaisDomain.crear(dto.getId(), dto.getNombre(), dto.getCodigoIndicativo(), dto.getCodigoIso3());
	}

	@Override
	public PaisDTO toDto(PaisDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000195);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return PaisDTO.crear().setId(domain.getId()).
				setNombre(domain.getNombre()).
				setCodigoIndicativo(domain.getCodigoIndicativo()).
				setCodigoIso3(domain.getCodigoiso3());
	}

	public static final PaisDomain convertToDomain(final PaisDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final PaisDTO convertToDTO(final PaisDomain domain) {
		return instancia.toDto(domain);
	}
	
	public static final List<PaisDTO> convertToListDTO(final List<PaisDomain> dto){
		List<PaisDTO> resultados = new ArrayList<>();
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToDTO(dto.get(indice)));
		}
		return resultados;
	}
}
