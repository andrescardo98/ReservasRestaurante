package co.edu.uco.reservasrestaurante.controller.support.mapper;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.reservasrestaurante.controller.support.request.SolicitarCliente;
import co.edu.uco.reservasrestaurante.service.dto.ClienteDTO;

public class ClienteResponse {

	public static final SolicitarCliente convertToResponse(ClienteDTO dto) {
		return new SolicitarCliente(dto.getId(), dto.getIdentificacion().getTipoIdentificacion().getId(),
				dto.getIdentificacion().getNumeroIdentificacion(), dto.getNombreCompleto().getPrimerNombre(),
				dto.getNombreCompleto().getSegundoNombre(), dto.getNombreCompleto().getPrimerApellido(),
				dto.getNombreCompleto().getSegundoApellido(), dto.getCorreoElectronico().getCorreoElectronico(),
				dto.getCorreoElectronico().isCorreoElectronicoConfirmado(), dto.getCorreoElectronico().getClave(),
				dto.getFechaNacimiento(), dto.getPais().getId(), dto.getNumeroCelular().getNumeroCelular(),
				dto.getNumeroCelular().isNumeroCelularConfirmado());
	}
	
	public static final List<SolicitarCliente> convertListToResponse(List<ClienteDTO> dto){
		List<SolicitarCliente> resultados = new ArrayList<>();
		
		for (int indice = 0; indice < dto.size(); indice++) {
			resultados.add(convertToResponse(dto.get(indice)));
		}
		return resultados;
	}
}
