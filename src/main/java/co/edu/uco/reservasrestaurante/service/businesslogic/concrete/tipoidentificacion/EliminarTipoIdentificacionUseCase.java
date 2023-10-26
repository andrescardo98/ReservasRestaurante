package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.tipoidentificacion;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.TipoIdentificacionDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.tipoidentificacion.EliminarTipoIdentificacionValidator;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;

public class EliminarTipoIdentificacionUseCase implements UseCase<TipoIdentificacionDomain> {
	
	private DAOFactory factoria;	

	public EliminarTipoIdentificacionUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}


	@Override
	public void execute(TipoIdentificacionDomain domain) {
		EliminarTipoIdentificacionValidator.ejecutar(domain);
		validarRegistroExistente(domain.getId());
		eliminar(domain.getId());
	}
	
	private final void eliminar(final UUID uuid) {
		getTipoIdentificacionDAO().eliminar(uuid);
	}
	
	private final void validarRegistroExistente(final UUID uuid) {
		final var resultados = getTipoIdentificacionDAO().consultarPorId(uuid);
		
		if (resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000123);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
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
