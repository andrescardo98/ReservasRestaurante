package co.edu.uco.reservasrestaurante.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.dto.ClienteDTO;
import co.edu.uco.reservasrestaurante.service.mapper.dto.DTOMapper;

public final class ClienteDTOMapper implements DTOMapper<ClienteDTO, ClienteDomain> {
	
	private static final DTOMapper<ClienteDTO, ClienteDomain> instancia = new ClienteDTOMapper();
	
	private ClienteDTOMapper() {
		super();
	}

	@Override
	public ClienteDomain toDomain(ClienteDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000193);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ClienteDomain.crear(dto.getId(),
				IdentificacionClienteDTOMapper.convertToDomain(dto.getIdentificacion()),
				NombreCompletoClienteDTOMapper.convertToDomain(dto.getNombreCompleto()),
				CorreoElectronicoClienteDTOMapper.convertToDomain(dto.getCorreoElectronico()),
				dto.getFechaNacimiento(), PaisDTOMapper.convertToDomain(dto.getPais()), 
				NumeroCelularClienteDTOMapper.convertToDomain(dto.getNumeroCelular()));
	}

	@Override
	public ClienteDTO toDto(ClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000194);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return ClienteDTO.crear().setId(domain.getId()).
				setIdentificacion(IdentificacionClienteDTOMapper.convertToDTO(domain.getIdentificacion())).
				setNombreCompleto(NombreCompletoClienteDTOMapper.convertToDTO(domain.getNombreCompleto())).
				setCorreoElectronico(CorreoElectronicoClienteDTOMapper.convertToDTO(domain.getCorreoElectronico())).
				setFechaNacimiento(domain.getFechaNacimiento()).
				setPais(PaisDTOMapper.convertToDTO(domain.getPais())).
				setNumeroCelular(NumeroCelularClienteDTOMapper.convertToDTO(domain.getNumeroCelular()));
	}
	
	public static final ClienteDomain convertToDomain(final ClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final ClienteDTO convertToDTO(final ClienteDomain domain) {
		return instancia.toDto(domain);
	}
	
	public static final List<ClienteDTO> convertToListDTO(final List<ClienteDomain> dto){
		List<ClienteDTO> resultados = new ArrayList<>();
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToDTO(dto.get(indice)));
		}
		return resultados;
	}

}
