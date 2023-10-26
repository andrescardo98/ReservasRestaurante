package co.edu.uco.reservasrestaurante.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.reservasrestaurante.service.dto.TipoIdentificacionDTO;
import co.edu.uco.reservasrestaurante.service.mapper.dto.DTOMapper;

public final class TipoIdentificacionDTOMapper implements DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> {

	private static final DTOMapper<TipoIdentificacionDTO, TipoIdentificacionDomain> instancia = new TipoIdentificacionDTOMapper(); 
	
	private TipoIdentificacionDTOMapper() {
		super();
	}
	
	@Override
	public TipoIdentificacionDomain toDomain(final TipoIdentificacionDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000092);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return TipoIdentificacionDomain.crear(dto.getId(), dto.getNombre(), dto.getCodigo(), dto.isEstado());
	}

	@Override
	public TipoIdentificacionDTO toDto(final TipoIdentificacionDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000093);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return TipoIdentificacionDTO.crear().setId(domain.getId())
				.setNombre(domain.getNombre()).setCodigo(domain.getCodigo())
				.setEstado(domain.isEstado());
	}

	public static final TipoIdentificacionDomain convertToDomain(final TipoIdentificacionDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final TipoIdentificacionDTO convertToDTO(final TipoIdentificacionDomain domain) {
		return instancia.toDto(domain);
	}
	
	public static final List<TipoIdentificacionDTO> convertToListDTO(final List<TipoIdentificacionDomain> dto){
		List<TipoIdentificacionDTO> resultados = new ArrayList<>();
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToDTO(dto.get(indice)));
		}
		return resultados;
	}
}
