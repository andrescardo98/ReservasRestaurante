package co.edu.uco.reservasrestaurante.controller.tipoidentificacion;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.reservasrestaurante.controller.support.response.Respuesta;
import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.service.dto.TipoIdentificacionDTO;
import co.edu.uco.reservasrestaurante.service.facade.concrete.tipoidentificacion.RegistrarTipoIdentificacionFacade;

@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public final class TipoIdentificacionController {
	
	@GetMapping("/dummy")
	public final TipoIdentificacionDTO obtenerDummy() {
		return TipoIdentificacionDTO.crear();
	}
	
	@GetMapping
	public final TipoIdentificacionDTO consultar(@RequestBody TipoIdentificacionDTO dto) {
		return dto;
	}
	
	@GetMapping("/{id}")
	public final UUID consultarPorId(@PathVariable("id") UUID id) {
		return id;
	}
	
	@PostMapping
	public final ResponseEntity<Respuesta<TipoIdentificacionDTO>> registrar(@RequestBody TipoIdentificacionDTO dto) {
		
		Respuesta<TipoIdentificacionDTO> respuesta = new Respuesta<>();
		HttpStatusCode codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			RegistrarTipoIdentificacionFacade facade = new RegistrarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000244));
		} catch (final ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			System.err.println(excepcion.getMensajeUsuario());
			System.err.println(excepcion.getLugar());
			excepcion.getExcepcionRaiz().printStackTrace();
			
			//TODO: Hacer logging de la excepcion presentada
		} catch (final Exception e) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000245));
			
			//TODO: Hacer logging de la excepcion presentada
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	@PutMapping("/{id}")
	public final TipoIdentificacionDTO modificar(@PathVariable("id") UUID id, @RequestBody TipoIdentificacionDTO dto) {
		dto.setId(id);
		return dto;
	}
	
	@DeleteMapping("/{id}")
	public final UUID eliminar(@PathVariable("id") UUID id) {
		return id;
	}

}
