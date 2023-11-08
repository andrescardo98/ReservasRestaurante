package co.edu.uco.reservasrestaurante.controller.tipoidentificacion.concrete;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.reservasrestaurante.controller.support.mapper.TipoIdentificacionResponse;
import co.edu.uco.reservasrestaurante.controller.support.request.SolicitarTipoIdentificacion;
import co.edu.uco.reservasrestaurante.controller.support.response.Respuesta;
import co.edu.uco.reservasrestaurante.controller.tipoidentificacion.TipoIdentificacionController;
import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.service.dto.BooleanDTO;
import co.edu.uco.reservasrestaurante.service.dto.TipoIdentificacionDTO;
import co.edu.uco.reservasrestaurante.service.facade.concrete.tipoidentificacion.ConsultarTipoIdentificacionFacade;
import co.edu.uco.reservasrestaurante.service.facade.concrete.tipoidentificacion.EliminarTipoIdentificacionFacade;
import co.edu.uco.reservasrestaurante.service.facade.concrete.tipoidentificacion.ModificarTipoIdentificacionFacade;
import co.edu.uco.reservasrestaurante.service.facade.concrete.tipoidentificacion.RegistrarTipoIdentificacionFacade;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/tipoidentificacion")
public final class TipoIdentificacionControllerImpl implements TipoIdentificacionController{
	
	private final Logger logger = LoggerFactory.getLogger(TipoIdentificacionControllerImpl.class);
	
	@GetMapping("/dummy")
	public final SolicitarTipoIdentificacion obtenerDummy() {
		return new SolicitarTipoIdentificacion();
	}
	
	
	@PostMapping
	public final ResponseEntity<Respuesta<SolicitarTipoIdentificacion>> registrar(@RequestBody TipoIdentificacionDTO dto) {
		
		Respuesta<SolicitarTipoIdentificacion> respuesta = new Respuesta<>();
		HttpStatusCode codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			RegistrarTipoIdentificacionFacade facade = new RegistrarTipoIdentificacionFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000244));
		} catch (final ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());

		} catch (final Exception excepcion) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000081));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000032), excepcion);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	
	@PutMapping("/{id}")
	@Override
	public final ResponseEntity<Respuesta<SolicitarTipoIdentificacion>> modificar(@PathVariable("id") UUID id, @RequestBody SolicitarTipoIdentificacion request) {
		final Respuesta<SolicitarTipoIdentificacion> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			ModificarTipoIdentificacionFacade facade = new ModificarTipoIdentificacionFacade();
			var dto = TipoIdentificacionDTO.crear()
			.setId(id)
			.setNombre(request.getNombre())
			.setCodigo(request.getCodigo())
			.setEstado(BooleanDTO.crear().setValor(request.isEstado()).setValorDefecto(false));
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000316));
		} catch (final ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
		} catch (Exception excepcion) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000190));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000190), excepcion);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	
	
	@Override
	@GetMapping
	public ResponseEntity<Respuesta<SolicitarTipoIdentificacion>> consultar(
			@RequestParam(name = "id", required = false) UUID id,
			@RequestParam(name = "nombre", required = false) String nombre,
			@RequestParam(name = "codigo", required = false) String codigo,
			@RequestParam(name = "estado", required = false) Boolean estado) {
		
		final Respuesta<SolicitarTipoIdentificacion> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		var dto = TipoIdentificacionDTO.crear()
				.setId(id)
				.setNombre(nombre)
				.setCodigo(codigo)
				.setEstado(BooleanDTO.crear().setValor(estado != null && estado).setValorDefecto(estado == null));
		try {
			ConsultarTipoIdentificacionFacade facade = new ConsultarTipoIdentificacionFacade();
			respuesta.setDatos(TipoIdentificacionResponse.convertListToResponse(facade.execute(dto)));
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000312));
		} catch (final ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
		} catch (Exception excepcion) {
			codigoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000313));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000313), excepcion);
		}
		return new ResponseEntity<>(respuesta,codigoHttp);
	}
	
	@DeleteMapping("/{id}")
	public final ResponseEntity<Respuesta<SolicitarTipoIdentificacion>> eliminar(@PathVariable("id") UUID id) {
		
		final Respuesta<SolicitarTipoIdentificacion> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			EliminarTipoIdentificacionFacade facade = new EliminarTipoIdentificacionFacade();
			var dto = TipoIdentificacionDTO.crear()
			.setId(id);
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000314));
		} catch (ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
		} catch (Exception excepcion) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000315));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000315), excepcion);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}

}
