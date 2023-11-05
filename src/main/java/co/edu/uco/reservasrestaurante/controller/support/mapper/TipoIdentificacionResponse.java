package co.edu.uco.reservasrestaurante.controller.support.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.controller.support.request.SolicitarTipoIdentificacion;
import co.edu.uco.reservasrestaurante.service.dto.TipoIdentificacionDTO;

public class TipoIdentificacionResponse {

	public static final SolicitarTipoIdentificacion convertToResponse(TipoIdentificacionDTO dto) {
		return new SolicitarTipoIdentificacion(dto.getId(),dto.getNombre(),dto.getCodigo(),dto.isEstado());
	}
	
	public static final List<SolicitarTipoIdentificacion> convertListToResponse(List<TipoIdentificacionDTO> dto){
		List<SolicitarTipoIdentificacion> resultados = new ArrayList<>();
		
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToResponse(dto.get(indice)));
		}
		return resultados;
	}
}
