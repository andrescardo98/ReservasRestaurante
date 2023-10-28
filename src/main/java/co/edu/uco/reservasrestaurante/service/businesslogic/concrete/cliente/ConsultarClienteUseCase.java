package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.cliente;

import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.ClienteDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.FindUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.cliente.ConsultarClienteValidator;
import co.edu.uco.reservasrestaurante.service.domain.cliente.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.ClienteEntityMapper;

public final class ConsultarClienteUseCase implements FindUseCase<ClienteDomain>{
	
	private DAOFactory factoria;	

	public ConsultarClienteUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public List<ClienteDomain> execute(ClienteDomain domain) {
		ConsultarClienteValidator.ejecutar(domain);
		final var resultados = getClienteDAO().consultar(ClienteEntityMapper.convertToEntity(domain));
		
		return ClienteEntityMapper.convertToListDomain(resultados);
	}

	
	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}
	
	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000179);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000180);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
