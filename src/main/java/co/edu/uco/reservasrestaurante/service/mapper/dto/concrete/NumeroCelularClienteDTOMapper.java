package co.edu.uco.reservasrestaurante.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.support.NumeroCelularClienteDomain;
import co.edu.uco.reservasrestaurante.service.dto.support.NumeroCelularClienteDTO;
import co.edu.uco.reservasrestaurante.service.mapper.dto.DTOMapper;

public final class NumeroCelularClienteDTOMapper implements DTOMapper<NumeroCelularClienteDTO, NumeroCelularClienteDomain> {

	private static final DTOMapper<NumeroCelularClienteDTO, NumeroCelularClienteDomain> instancia = new NumeroCelularClienteDTOMapper(); 
	
	private NumeroCelularClienteDTOMapper() {
		super();
	}
	
	@Override
	public NumeroCelularClienteDomain toDomain(final NumeroCelularClienteDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000092);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NumeroCelularClienteDomain.crear(dto.getNumeroCelular(), BooleanDTOMapper.convertToDomain(dto.isNumeroCelularConfirmado()));
	}

	@Override
	public NumeroCelularClienteDTO toDto(final NumeroCelularClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000093);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NumeroCelularClienteDTO.crear().setNumeroCelular(domain.getNumeroCelular()).
				setNumeroCelularConfirmado(BooleanDTOMapper.convertToDTO(domain.isNumeroCelularConfirmado()));
	}

	public static final NumeroCelularClienteDomain convertToDomain(final NumeroCelularClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final NumeroCelularClienteDTO convertToDTO(final NumeroCelularClienteDomain domain) {
		return instancia.toDto(domain);
	}
	
	public static final List<NumeroCelularClienteDTO> convertToListDTO(final List<NumeroCelularClienteDomain> dto){
		List<NumeroCelularClienteDTO> resultados = new ArrayList<>();
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToDTO(dto.get(indice)));
		}
		return resultados;
	}
}
