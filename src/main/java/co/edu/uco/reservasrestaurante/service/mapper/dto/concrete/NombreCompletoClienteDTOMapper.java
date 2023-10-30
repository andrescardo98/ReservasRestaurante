package co.edu.uco.reservasrestaurante.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.support.NombreCompletoClienteDomain;
import co.edu.uco.reservasrestaurante.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.reservasrestaurante.service.mapper.dto.DTOMapper;

public final class NombreCompletoClienteDTOMapper implements DTOMapper<NombreCompletoClienteDTO, NombreCompletoClienteDomain> {

	private static final DTOMapper<NombreCompletoClienteDTO, NombreCompletoClienteDomain> instancia = new NombreCompletoClienteDTOMapper(); 
	
	private NombreCompletoClienteDTOMapper() {
		super();
	}
	
	@Override
	public NombreCompletoClienteDomain toDomain(final NombreCompletoClienteDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000092);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NombreCompletoClienteDomain.crear(dto.getPrimerNombre(), dto.getSegundoNombre(), 
				dto.getPrimerApellido(), dto.getSegundoApellido());
	}

	@Override
	public NombreCompletoClienteDTO toDto(final NombreCompletoClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000093);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return NombreCompletoClienteDTO.crear().setPrimerNombre(domain.getPrimerNombre())
				.setSegundoNombre(domain.getSegundoNombre()).setPrimerApellido(domain.getPrimerApellido())
				.setSegundoApellido(domain.getSegundoApellido());
	}

	public static final NombreCompletoClienteDomain convertToDomain(final NombreCompletoClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final NombreCompletoClienteDTO convertToDTO(final NombreCompletoClienteDomain domain) {
		return instancia.toDto(domain);
	}
	
	public static final List<NombreCompletoClienteDTO> convertToListDTO(final List<NombreCompletoClienteDomain> dto){
		List<NombreCompletoClienteDTO> resultados = new ArrayList<>();
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToDTO(dto.get(indice)));
		}
		return resultados;
	}
}
