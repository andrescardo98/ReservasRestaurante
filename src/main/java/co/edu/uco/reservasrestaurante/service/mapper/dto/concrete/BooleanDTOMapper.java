package co.edu.uco.reservasrestaurante.service.mapper.dto.concrete;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.service.domain.support.BooleanDomain;
import co.edu.uco.reservasrestaurante.service.dto.BooleanDTO;
import co.edu.uco.reservasrestaurante.service.mapper.dto.DTOMapper;

public class BooleanDTOMapper implements DTOMapper<BooleanDTO, BooleanDomain>{

	private static final DTOMapper<BooleanDTO, BooleanDomain> instancia = new BooleanDTOMapper();
	
	private BooleanDTOMapper() {
		super();
	}
	
	@Override
	public BooleanDomain toDomain(BooleanDTO dto) {
		if(UtilObjeto.esNulo(dto)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000328);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return BooleanDomain.crear(dto.isValor(), dto.isValorDefecto());
	}

	@Override
	public BooleanDTO toDto(BooleanDomain domain) {
		if(UtilObjeto.esNulo(domain)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000004);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000329);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		
		return BooleanDTO.crear()
				.setValor(domain.isValor())
				.setValorDefecto(domain.isValorDefecto());
	}
	
	public static final BooleanDomain convertToDomain(final BooleanDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final BooleanDTO convertToDTO(final BooleanDomain domain) {
		return instancia.toDto(domain);
	}
	
	public static final List<BooleanDTO>  convertToListDTO(final List<BooleanDomain> dto){
		List<BooleanDTO> resultados = new ArrayList<>();
		for (int i = 0; i < dto.size(); i++) {
			resultados.add(convertToDTO(dto.get(i)));
		}
		
		return resultados;
	}

}
