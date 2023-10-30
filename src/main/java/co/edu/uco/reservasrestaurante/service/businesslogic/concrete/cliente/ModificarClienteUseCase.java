package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.cliente;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.ClienteDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.CorreoElectronicoClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.NombreCompletoClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.NumeroCelularClienteDomain;
import co.edu.uco.reservasrestaurante.service.dto.PaisDTO;
import co.edu.uco.reservasrestaurante.service.dto.support.CorreoElectronicoClienteDTO;
import co.edu.uco.reservasrestaurante.service.dto.support.IdentificacionClienteDTO;
import co.edu.uco.reservasrestaurante.service.dto.support.NombreCompletoClienteDTO;
import co.edu.uco.reservasrestaurante.service.dto.support.NumeroCelularClienteDTO;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.CorreoElectronicoClienteDTOMapper;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.IdentificacionClienteDTOMapper;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.NombreCompletoClienteDTOMapper;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.NumeroCelularClienteDTOMapper;
import co.edu.uco.reservasrestaurante.service.mapper.dto.concrete.PaisDTOMapper;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.ClienteEntityMapper;

public class ModificarClienteUseCase implements UseCase<ClienteDomain> {
	
	private DAOFactory factoria;	

	public ModificarClienteUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(ClienteDomain domain) {
		validarExistenciaRegistro(domain.getId());
		validarNoExistenciaMismoNombre(domain.getNombreCompleto());
		validarNoExistenciaCorreoElectronico(domain.getCorreoElectronico());
		validarNoExistenciaNumeroCelular(domain.getNumeroCelular());
		validarNoExistenciaMismaIdentificacion(domain);
		actualizar(domain);
	}
	
	private final void validarExistenciaRegistro(final UUID id) {
		final var resultados = getClienteDAO().consultarPorId(id);
		
		if (resultados.isEmpty()) {
			final var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000136);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaMismoNombre(final NombreCompletoClienteDomain nombre) {
		final var domain = ClienteDomain.crear(null, IdentificacionClienteDTOMapper.convertToDomain(IdentificacionClienteDTO.crear()),
				nombre, CorreoElectronicoClienteDTOMapper.convertToDomain(CorreoElectronicoClienteDTO.crear()), 
				null, PaisDTOMapper.convertToDomain(PaisDTO.crear()), 
				NumeroCelularClienteDTOMapper.convertToDomain(NumeroCelularClienteDTO.crear()));
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000137);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaCorreoElectronico(final CorreoElectronicoClienteDomain correoElectronico) {
		final var domain = ClienteDomain.crear(null, IdentificacionClienteDTOMapper.convertToDomain(IdentificacionClienteDTO.crear()),
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()), correoElectronico, 
				null, PaisDTOMapper.convertToDomain(PaisDTO.crear()), 
				NumeroCelularClienteDTOMapper.convertToDomain(NumeroCelularClienteDTO.crear()));
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000138);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaNumeroCelular(final NumeroCelularClienteDomain numeroCelular) {
		final var domain = ClienteDomain.crear(null, IdentificacionClienteDTOMapper.convertToDomain(IdentificacionClienteDTO.crear()),
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()),
				CorreoElectronicoClienteDTOMapper.convertToDomain(CorreoElectronicoClienteDTO.crear()), 
				null, PaisDTOMapper.convertToDomain(PaisDTO.crear()), 
				numeroCelular);
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000139);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaMismaIdentificacion(final ClienteDomain cliente) {
		final var domain = ClienteDomain.crear(null, cliente.getIdentificacion(),
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()),
				CorreoElectronicoClienteDTOMapper.convertToDomain(CorreoElectronicoClienteDTO.crear()), 
				null, PaisDTOMapper.convertToDomain(PaisDTO.crear()), 
				NumeroCelularClienteDTOMapper.convertToDomain(NumeroCelularClienteDTO.crear()));
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000140);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	

	private final void actualizar(final ClienteDomain domain) {
		getClienteDAO().modificar(ClienteEntityMapper.convertToEntity(domain));
	}


	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}


	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000141);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000142);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
