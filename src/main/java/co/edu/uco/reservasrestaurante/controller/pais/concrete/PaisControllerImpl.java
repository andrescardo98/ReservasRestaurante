package co.edu.uco.reservasrestaurante.controller.pais.concrete;

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

import co.edu.uco.reservasrestaurante.controller.pais.PaisController;
import co.edu.uco.reservasrestaurante.controller.support.mapper.PaisResponse;
import co.edu.uco.reservasrestaurante.controller.support.request.SolicitarPais;
import co.edu.uco.reservasrestaurante.controller.support.response.Respuesta;
import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.service.dto.PaisDTO;
import co.edu.uco.reservasrestaurante.service.facade.concrete.pais.ConsultarPaisFacade;
import co.edu.uco.reservasrestaurante.service.facade.concrete.pais.EliminarPaisFacade;
import co.edu.uco.reservasrestaurante.service.facade.concrete.pais.ModificarPaisFacade;
import co.edu.uco.reservasrestaurante.service.facade.concrete.pais.RegistrarPaisFacade;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/pais")
public final class PaisControllerImpl implements PaisController{
	
	private final Logger logger = LoggerFactory.getLogger(PaisControllerImpl.class);

	@Override
	@GetMapping("/dummy")
	public SolicitarPais obtenerDummy() {
		return new SolicitarPais();
	}

	@Override
	@PostMapping
	public ResponseEntity<Respuesta<SolicitarPais>> registrar(@RequestBody PaisDTO dto) {
		
		Respuesta<SolicitarPais> respuesta = new Respuesta<>();
		HttpStatusCode codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			RegistrarPaisFacade facade = new RegistrarPaisFacade();
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000324));
		} catch (final ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
		} catch (final Exception excepcion) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000203));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000203), excepcion);
		}
		return new ResponseEntity<>(respuesta, codigoHttp);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Respuesta<SolicitarPais>> modificar(@PathVariable("id") UUID id, @RequestBody SolicitarPais request) {
		final Respuesta<SolicitarPais> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			ModificarPaisFacade facade = new ModificarPaisFacade();
			var dto = PaisDTO.crear()
			.setId(id)
			.setNombre(request.getNombre())
			.setCodigoIndicativo(request.getCodigoIndicativo())
			.setCodigoIso3(request.getcodigoIso3());
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000323));
		} catch (final ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
		} catch (final Exception excepcion) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000205));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000205), excepcion);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}

	@Override
	@GetMapping
	public ResponseEntity<Respuesta<SolicitarPais>> consultar(
			@RequestParam(name = "id", required = false) UUID id,
			@RequestParam(name = "nombre", required = false) String nombre,
			@RequestParam(name = "codigo_indicativo", required = false) String codigoIndicativo,
			@RequestParam(name = "codigo_iso3", required = false) String codigoIso3) {
		
		final Respuesta<SolicitarPais> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		var dto = PaisDTO.crear().setId(id).
				setNombre(nombre).
				setCodigoIndicativo(codigoIndicativo).
				setCodigoIso3(codigoIso3);
		
		try {
			ConsultarPaisFacade facade = new ConsultarPaisFacade();
			respuesta.setDatos(PaisResponse.convertListToResponse(facade.execute(dto)));
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000325));
		} catch (final ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
		} catch (final Exception excepcion) {
			codigoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000108));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000108), excepcion);
		}
		return new ResponseEntity<>(respuesta, codigoHttp);
	}


	@Override	
	@DeleteMapping("/{id}")
	public ResponseEntity<Respuesta<SolicitarPais>> eliminar(@PathVariable("id") UUID id) {
		final Respuesta<SolicitarPais> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			EliminarPaisFacade facade = new EliminarPaisFacade();
			var dto = PaisDTO.crear().setId(id);
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000326));
			
		} catch (final ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
		} catch (final Exception excepcion) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000102));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000102), excepcion);
		}
		return new ResponseEntity<>(respuesta, codigoHttp);
	}	
}
