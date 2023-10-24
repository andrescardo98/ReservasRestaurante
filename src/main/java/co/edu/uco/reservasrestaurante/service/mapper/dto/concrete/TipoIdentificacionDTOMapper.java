package co.edu.uco.reservasrestaurante.service.mapper.dto.concrete;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TipoIdentificacionDTO toDto(final TipoIdentificacionDomain domain) {
		// TODO Auto-generated method stub
		return null;
	}

	public static final TipoIdentificacionDomain convertToDomain(final TipoIdentificacionDTO dto) {
		return instancia.toDomain(dto);
	}
	
	public static final TipoIdentificacionDTO convertToDTO(final TipoIdentificacionDomain domain) {
		return instancia.toDto(domain);
	}
}
