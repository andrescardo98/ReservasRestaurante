package co.edu.uco.reservasrestaurante.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.support.IdentificacionClienteDomain;
import co.edu.uco.reservasrestaurante.service.dto.support.IdentificacionClienteDTO;
import co.edu.uco.reservasrestaurante.service.mapper.dto.DTOMapper;

public final class IdentificacionClienteDTOMapper implements DTOMapper<IdentificacionClienteDTO, IdentificacionClienteDomain> {

	private static final DTOMapper<IdentificacionClienteDTO, IdentificacionClienteDomain> instancia = new IdentificacionClienteDTOMapper(); 
	
	private IdentificacionClienteDTOMapper() {
		super();
	}
	
	@Override
	public IdentificacionClienteDomain toDomain(final IdentificacionClienteDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000092);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return IdentificacionClienteDomain.crear(TipoIdentificacionDTOMapper.convertToDomain(dto.getTipoIdentificacion()), 
				dto.getNumeroIdentificacion());
	}

	@Override
	public IdentificacionClienteDTO toDto(final IdentificacionClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000093);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return IdentificacionClienteDTO.crear().
				setTipoIdentificacion(TipoIdentificacionDTOMapper.convertToDTO(domain.getTipoIdentificacion())).
				setNumeroIdentificacion(domain.getNumeroIdentificacion());
	}

	public static final IdentificacionClienteDomain convertToDomain(final IdentificacionClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final IdentificacionClienteDTO convertToDTO(final IdentificacionClienteDomain domain) {
		return instancia.toDto(domain);
	}
	
	public static final List<IdentificacionClienteDTO> convertToListDTO(final List<IdentificacionClienteDomain> dto){
		List<IdentificacionClienteDTO> resultados = new ArrayList<>();
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToDTO(dto.get(indice)));
		}
		return resultados;
	}
}
