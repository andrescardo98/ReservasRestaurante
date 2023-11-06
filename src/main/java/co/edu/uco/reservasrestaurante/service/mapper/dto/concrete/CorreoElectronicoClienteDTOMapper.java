package co.edu.uco.reservasrestaurante.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.reservasrestaurante.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.reservasrestaurante.service.mapper.dto.DTOMapper;

public final class CorreoElectronicoClienteDTOMapper implements DTOMapper<CorreoElectronicoClienteDTO, CorreoElectronicoClienteDomain> {

	private static final DTOMapper<CorreoElectronicoClienteDTO, CorreoElectronicoClienteDomain> instancia = new CorreoElectronicoClienteDTOMapper(); 
	
	private CorreoElectronicoClienteDTOMapper() {
		super();
	}
	
	@Override
	public CorreoElectronicoClienteDomain toDomain(final CorreoElectronicoClienteDTO dto) {
		if (UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000092);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return CorreoElectronicoClienteDomain.crear(dto.getCorreoElectronico(), 
				BooleanDTOMapper.convertToDomain(dto.isCorreoElectronicoConfirmado()) ,
				dto.getClave());
	}

	@Override
	public CorreoElectronicoClienteDTO toDto(final CorreoElectronicoClienteDomain domain) {
		if (UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000093);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return CorreoElectronicoClienteDTO.crear().setCorreoElectronico(domain.getCorreoElectronico())
				.setCorreoElectronicoConfirmado(BooleanDTOMapper.convertToDTO(domain.isCorreoElectronicoConfirmado()))
				.setClave(domain.getClave());
	}

	public static final CorreoElectronicoClienteDomain convertToDomain(final CorreoElectronicoClienteDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final CorreoElectronicoClienteDTO convertToDTO(final CorreoElectronicoClienteDomain domain) {
		return instancia.toDto(domain);
	}
	
	public static final List<CorreoElectronicoClienteDTO> convertToListDTO(final List<CorreoElectronicoClienteDomain> dto){
		List<CorreoElectronicoClienteDTO> resultados = new ArrayList<>();
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToDTO(dto.get(indice)));
		}
		return resultados;
	}
}
