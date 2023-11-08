package co.edu.uco.reservasrestaurante.controller.pais;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.uco.reservasrestaurante.controller.support.request.SolicitarPais;
import co.edu.uco.reservasrestaurante.controller.support.response.Respuesta;
import co.edu.uco.reservasrestaurante.service.dto.PaisDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Pais", description = "Ofrece apis de consumo para el pais")
public interface PaisController {
	
	@Operation(summary = "Obtener dummy", description = "Servicio encargado de obtener la estructura de un país")
	SolicitarPais obtenerDummy();

	
	@Operation(summary = "Registrar País", description = "Servicio encargado de registrar la información de un país")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "País registrado exitosamente"),
			@ApiResponse(responseCode = "400", description = "País no registrado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado al registrar País") })
	ResponseEntity<Respuesta<SolicitarPais>> registrar(@RequestBody PaisDTO dto);
	
	
	@Operation(summary = "Modificar País", description = "Servicio encargado de modificar un país a partir de su id")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "País modificado exitosamente"),
			@ApiResponse(responseCode = "400", description = "País no modificado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado al modificar País") })
	ResponseEntity<Respuesta<SolicitarPais>> modificar(@PathVariable("id") UUID id, @RequestBody SolicitarPais req);
	
	
	@Operation(summary = "Obtener país", description = "Servicio encargado de obtener la información de los países que cumplen los parámetros de consulta")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "País consultado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Problema con consulta de País"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado al consultar país") })
	ResponseEntity<Respuesta<SolicitarPais>> consultar(
			@RequestParam(name = "id", required = false) UUID id,
			@RequestParam(name = "nombre", required = false) String nombre,
			@RequestParam(name = "codigo_indicativo", required = false) String codigoIndicativo,
			@RequestParam(name = "codigo_iso3", required = false) String codigoIso3);
	

	@Operation(summary = "Eliminar país", description = "Servicio encargado de eliminar de forma definitiva un país")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "País eliminado exitosamente"),
			@ApiResponse(responseCode = "400", description = "País no eliminado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado al eliminar País") })
	ResponseEntity<Respuesta<SolicitarPais>> eliminar(@PathVariable("id") UUID id);
}
