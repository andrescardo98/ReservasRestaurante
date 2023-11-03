package co.edu.uco.reservasrestaurante.controller.tipoidentificacion;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.uco.reservasrestaurante.controller.support.request.SolicitarTipoIdentificacion;
import co.edu.uco.reservasrestaurante.controller.support.response.Respuesta;
import co.edu.uco.reservasrestaurante.service.dto.TipoIdentificacionDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "TipoIdentificacion", description = "Ofrece apis de consumo para el tipo de identificación")
public interface TipoIdentificacionController {

	@Operation(summary = "Obtener dummy", description = "Servicio encargado de obtener la estructura de un tipo de identificación")
	SolicitarTipoIdentificacion obtenerDummy();
	
	@Operation(summary = "Obtener tipo de identificación", description = "Servicio encargado de obtener la información de los tipo de identificación que cumplen los parámetros de consulta")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tipo identificación consultado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Problema con consulta de tipo de identificación"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado") })
	
	
	ResponseEntity<Respuesta<SolicitarTipoIdentificacion>> consultar(
			@RequestParam(name = "id", required = false) UUID id,
			@RequestParam(name = "nombre", required = false) String codigo,
			@RequestParam(name = "codigo", required = false) String nombre,
			@RequestParam(name = "estado", required = false) Boolean estado);
		
	
	@Operation(summary = "Registrar tipo de identificación", description = "Servicio encargado de registrar la información de un tipo de identificación")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tipo identificación registrado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Tipo identificación no registrado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado al registrar tipo de identificación") })
	ResponseEntity<Respuesta<SolicitarTipoIdentificacion>> registrar(@RequestBody TipoIdentificacionDTO dto);
	
	
	@Operation(summary = "Modificar tipo de identificación", description = "Servicio encargado de modificar la información de un tipo de identificación")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tipo identificación modificado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Tipo identificación no modificado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado al modificar tipo de identificación") })
	ResponseEntity<Respuesta<SolicitarTipoIdentificacion>> modificar(@PathVariable("id") UUID id, @RequestBody SolicitarTipoIdentificacion req);
	
	
	@Operation(summary = "Eliminar tipo de identificación", description = "Servicio encargado de eliminar de forma definitiva un tipo de identificación")
	@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tipo identificación eliminado exitosamente"),
			@ApiResponse(responseCode = "400", description = "Tipo identificación no eliminado"),
			@ApiResponse(responseCode = "500", description = "Problema inesperado al eliminar tipo de identificación") })
	ResponseEntity<Respuesta<SolicitarTipoIdentificacion>> eliminar(@PathVariable("id") UUID id);

}
