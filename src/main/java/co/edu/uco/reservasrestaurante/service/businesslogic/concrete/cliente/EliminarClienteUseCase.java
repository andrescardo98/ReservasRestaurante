package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.cliente;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.ClienteDAO;
import co.edu.uco.reservasrestaurante.data.dao.TipoIdentificacionDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.tipoidentificacion.EliminarTipoIdentificacionValidator;
import co.edu.uco.reservasrestaurante.service.domain.ClienteDomain;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public class EliminarClienteUseCase implements UseCase<ClienteDomain> {
	
	private DAOFactory factoria;	

	public EliminarClienteUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}


	@Override
	public void execute(ClienteDomain domain) {
		//EliminarClienteValidator.ejecutar(domain);
		validarRegistroExistente(domain.getId());
		eliminar(domain.getId());
	}
	
	private final void eliminar(final UUID uuid) {
		getClienteDAO().eliminar(uuid);
	}
	
	private final void validarRegistroExistente(final UUID uuid) {
		final var resultados = getClienteDAO().consultarPorId(uuid);
		
		if (resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000123);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final ClienteDAO getClienteDAO() {
		return getFactoria().obtenerClienteDAO();
	}


	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000124);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000125);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
