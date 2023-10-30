package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.cliente;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.ClienteDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.entity.ClienteEntity;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.CorreoElectronicoClienteDomain;
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

public class RegistrarClienteUseCase implements UseCase<ClienteDomain> {
	
	private DAOFactory factoria;	

	public RegistrarClienteUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(ClienteDomain domain) {
		validarNoExistenciaCorreoElectronico(domain.getCorreoElectronico());
		validarNoExistenciaNumeroCelular(domain.getNumeroCelular());
		validarNoExistenciaMismaIdentificacion(domain);
		domain = obtenerIdentificadorCliente(domain);
		registrar(domain);
	}
	
	private final ClienteDomain obtenerIdentificadorCliente(final ClienteDomain domain) {
		Optional<ClienteEntity> optional;
		UUID uuid;
		
		do {
			uuid = UUID.randomUUID();
			optional = getClienteDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		
		return ClienteDomain.crear(uuid, domain.getIdentificacion(), domain.getNombreCompleto(), 
				domain.getCorreoElectronico(), domain.getFechaNacimiento(), domain.getPais(), 
				domain.getNumeroCelular());
	}
	
	private final void validarNoExistenciaCorreoElectronico(final CorreoElectronicoClienteDomain correoElectronico) {
		final var domain = ClienteDomain.crear(null, 
				IdentificacionClienteDTOMapper.convertToDomain(IdentificacionClienteDTO.crear()), 
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()), 
				correoElectronico, null, PaisDTOMapper.convertToDomain(PaisDTO.crear()),
				NumeroCelularClienteDTOMapper.convertToDomain(NumeroCelularClienteDTO.crear()));
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000131);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaNumeroCelular(final NumeroCelularClienteDomain numeroCelular) {
		final var domain = ClienteDomain.crear(null, 
				IdentificacionClienteDTOMapper.convertToDomain(IdentificacionClienteDTO.crear()), 
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()), 
				CorreoElectronicoClienteDTOMapper.convertToDomain(CorreoElectronicoClienteDTO.crear()), 
				null, PaisDTOMapper.convertToDomain(PaisDTO.crear()),
				numeroCelular);
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000132);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final void validarNoExistenciaMismaIdentificacion(final ClienteDomain cliente) {
		final var domain = ClienteDomain.crear(null, 
				cliente.getIdentificacion(), 
				NombreCompletoClienteDTOMapper.convertToDomain(NombreCompletoClienteDTO.crear()), 
				CorreoElectronicoClienteDTOMapper.convertToDomain(CorreoElectronicoClienteDTO.crear()), 
				null, PaisDTOMapper.convertToDomain(PaisDTO.crear()),
				NumeroCelularClienteDTOMapper.convertToDomain(NumeroCelularClienteDTO.crear()));
		final var entity = ClienteEntityMapper.convertToEntity(domain);
		final var resultados = getClienteDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000133);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private void registrar(final ClienteDomain domain) {
		getClienteDAO().crear(ClienteEntityMapper.convertToEntity(domain));
	}


	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}


	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000134);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000135);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
