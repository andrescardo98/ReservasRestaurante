package co.edu.uco.reservasrestaurante.controller.cliente.concrete;

import java.sql.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uco.reservasrestaurante.controller.cliente.ClienteController;
import co.edu.uco.reservasrestaurante.controller.support.mapper.ClienteResponse;
import co.edu.uco.reservasrestaurante.controller.support.request.SolicitarCliente;
import co.edu.uco.reservasrestaurante.controller.support.response.Respuesta;
import co.edu.uco.reservasrestaurante.crosscutting.exception.ReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.service.dto.BooleanDTO;
import co.edu.uco.reservasrestaurante.service.dto.ClienteDTO;
import co.edu.uco.reservasrestaurante.service.dto.PaisDTO;
import co.edu.uco.reservasrestaurante.service.dto.TipoIdentificacionDTO;
import co.edu.uco.reservasrestaurante.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.reservasrestaurante.service.dto.support.IdentificacionClienteDTO;
import co.edu.uco.reservasrestaurante.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.reservasrestaurante.service.dto.support.NumeroCelularClienteDTO;
import co.edu.uco.reservasrestaurante.service.facade.concrete.cliente.ConsultarClienteFacade;
import co.edu.uco.reservasrestaurante.service.facade.concrete.cliente.EliminarClienteFacade;
import co.edu.uco.reservasrestaurante.service.facade.concrete.cliente.ModificarClienteFacade;
import co.edu.uco.reservasrestaurante.service.facade.concrete.cliente.RegistrarClienteFacade;


@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteControllerImpl implements ClienteController{
	
	private final Logger logger = LoggerFactory.getLogger(ClienteControllerImpl.class);

	@GetMapping("/dummy")
	@Override
	public SolicitarCliente obtenerDummy() {
		return new SolicitarCliente();
	}
	
	
	@Override
	@PostMapping
	public ResponseEntity<Respuesta<SolicitarCliente>> registrar(@RequestBody SolicitarCliente request) {
		final Respuesta<SolicitarCliente> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			RegistrarClienteFacade facade = new RegistrarClienteFacade();
			var dto = ClienteDTO.crear().
					setIdentificacion(IdentificacionClienteDTO.crear().
							setTipoIdentificacion(TipoIdentificacionDTO.crear().setId(request.getId())))
					.setNombreCompleto(NombreCompletoClienteDTO.crear().setPrimerNombre(request.getPrimerNombre()).
							setSegundoNombre(request.getSegundoNombre()).setPrimerApellido(request.getPrimerApellido()).
							setSegundoApellido(request.getSegundoApellido()))
					.setCorreoElectronico(CorreoElectronicoClienteDTO.crear().setCorreoElectronico(request.getCorreoElectronico())
							.setCorreoElectronicoConfirmado(BooleanDTO.crear().setValor(false).setValorDefecto(true)))
					.setFechaNacimiento(request.getFechaNacimiento()).
					setPais(PaisDTO.crear().setId(request.getId()))
					.setNumeroCelular(NumeroCelularClienteDTO.crear()
							.setNumeroCelular(request.getNumeroCelular())
							.setNumeroCelularConfirmado(BooleanDTO.crear().setValor(false).setValorDefecto(true)));
			
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000320));
			logger.info(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000320));
		} catch (final ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeUsuario());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
		} catch (final Exception excepcion) {
			codigoHttp = HttpStatus.INTERNAL_SERVER_ERROR;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000054));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000054), excepcion);
		}
		return new ResponseEntity<>(respuesta, codigoHttp);
	}
	

	@PutMapping("/id")
	@Override
	public ResponseEntity<Respuesta<SolicitarCliente>> modificar(@PathVariable("id") UUID id, @RequestBody SolicitarCliente request) {
		final Respuesta<SolicitarCliente> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			ModificarClienteFacade facade = new ModificarClienteFacade();
			var dto = ClienteDTO.crear().setId(id).
					setIdentificacion(IdentificacionClienteDTO.crear().
							setTipoIdentificacion(TipoIdentificacionDTO.crear().setId(request.getId()))).
					setNombreCompleto(NombreCompletoClienteDTO.crear().setPrimerNombre(request.getPrimerNombre()).
							setSegundoNombre(request.getSegundoNombre()).
							setPrimerApellido(request.getPrimerApellido()).
							setSegundoApellido(request.getSegundoApellido())).
					setCorreoElectronico(CorreoElectronicoClienteDTO.crear().
							setCorreoElectronico(request.getCorreoElectronico()).
							setCorreoElectronicoConfirmado(BooleanDTO.crear().setValor(request.
									isCorreoElectronicoConfirmado()).setValorDefecto(false)).
							setClave(request.getClave())).
					setFechaNacimiento(request.getFechaNacimiento()).
					setPais(PaisDTO.crear().setId(request.getId())).setNumeroCelular(NumeroCelularClienteDTO.crear().
							setNumeroCelular(request.getNumeroCelular()).
							setNumeroCelularConfirmado(BooleanDTO.crear().setValor(request.isCorreoElectronicoConfirmado()).
									setValorDefecto(false)));
									
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000318));
		} catch (final ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
		} catch (Exception excepcion) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000141));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000141), excepcion);
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}

	@Override
	@GetMapping
	public ResponseEntity<Respuesta<SolicitarCliente>> consultar(@RequestParam(name = "id", required = false) UUID id,
	        @RequestParam(name = "tipoIdentificacion", required = false) UUID tipoIdentificacion,
	        @RequestParam(name = "identificacion", required = false) String identificacion,
	        @RequestParam(name = "primerNombre", required = false) String primerNombre,
	        @RequestParam(name = "segundoNombre", required = false) String segundoNombre,
	        @RequestParam(name = "primerApellido", required = false) String primerApellido,
	        @RequestParam(name = "segundoApellido", required = false) String segundoApellido,
	        @RequestParam(name = "correoElectronico", required = false) String correoElectronico,
	        @RequestParam(name = "correoElectronicoConfirmado", required = false) Boolean correoElectronicoConfirmado,
	        @RequestParam(name = "clave", required = false) String clave,
	        @RequestParam(name = "fechaNacimiento", required = false) Date fechaNacimiento,
	        @RequestParam(name = "pais", required = false) UUID pais,
	        @RequestParam(name = "numeroCelular", required = false) String numeroCelular,
	        @RequestParam(name = "numeroCelularConfirmado", required = false) Boolean numeroCelularConfirmado) {


		final Respuesta<SolicitarCliente> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			var dto = ClienteDTO.crear().setId(id).
					setIdentificacion(IdentificacionClienteDTO.crear().
							setTipoIdentificacion(TipoIdentificacionDTO.crear().setId(id))).
					setNombreCompleto(NombreCompletoClienteDTO.crear().setPrimerNombre(primerNombre).
							setSegundoNombre(segundoNombre).
							setPrimerApellido(primerApellido).
							setSegundoApellido(segundoApellido)).
					setCorreoElectronico(CorreoElectronicoClienteDTO.crear().
							setCorreoElectronico(correoElectronico).
							setCorreoElectronicoConfirmado(BooleanDTO.crear().
									setValor(correoElectronicoConfirmado != null ? correoElectronicoConfirmado 
											: false).setValorDefecto(correoElectronicoConfirmado == null)).
							setClave(clave)).
					setFechaNacimiento(fechaNacimiento).
					setPais(PaisDTO.crear().setId(id)).setNumeroCelular(NumeroCelularClienteDTO.crear().
							setNumeroCelular(numeroCelular).
							setNumeroCelularConfirmado(BooleanDTO.crear().setValor(numeroCelularConfirmado != null ?
									numeroCelularConfirmado : false).setValorDefecto(
											numeroCelularConfirmado == null)));
			
			ConsultarClienteFacade facade = new ConsultarClienteFacade();
			respuesta.setDatos(ClienteResponse.convertListToResponse(facade.execute(dto)));
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000319));
		} catch (ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
		} catch (Exception excepcion) {
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000179), excepcion);
			
		}
		
		return new ResponseEntity<>(respuesta, codigoHttp);
	}


	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Respuesta<SolicitarCliente>> eliminar(@PathVariable("id") UUID id) {
		final Respuesta<SolicitarCliente> respuesta = new Respuesta<>();
		HttpStatus codigoHttp = HttpStatus.BAD_REQUEST;
		
		try {
			EliminarClienteFacade facade = new EliminarClienteFacade();
			var dto = ClienteDTO.crear().setId(id);
			facade.execute(dto);
			codigoHttp = HttpStatus.OK;
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000322));
		} catch (final ReservasRestauranteException excepcion) {
			respuesta.getMensajes().add(excepcion.getMensajeTecnico());
			logger.error(excepcion.getMensajeTecnico(), excepcion.getExcepcionRaiz());
		} catch (final Exception excepcion) {
			respuesta.getMensajes().add(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000060));
			logger.error(CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000060), excepcion);
		}
		return new ResponseEntity<>(respuesta, codigoHttp);
	}

}
