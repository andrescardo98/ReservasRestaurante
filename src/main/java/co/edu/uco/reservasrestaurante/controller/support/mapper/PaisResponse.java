package co.edu.uco.reservasrestaurante.controller.support.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.controller.support.request.SolicitarPais;
import co.edu.uco.reservasrestaurante.service.dto.PaisDTO;

public class PaisResponse {

	public static final SolicitarPais convertToResponse(PaisDTO dto) {
		return new SolicitarPais(dto.getId(),dto.getNombre(),dto.getCodigoIndicativo(),dto.getCodigoiso3());
	}
	
	public static final List<SolicitarPais> convertListToResponse(List<PaisDTO> dto){
		List<SolicitarPais> resultados = new ArrayList<>();
		
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToResponse(dto.get(indice)));
		}
		return resultados;
	}
}
