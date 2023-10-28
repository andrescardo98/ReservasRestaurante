package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.pais;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.PaisDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.pais.EliminarPaisValidator;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;

public class EliminarPaisUseCase implements UseCase<PaisDomain>{
	
	private DAOFactory factoria;
	
	public EliminarPaisUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public void execute(PaisDomain domain) {
		EliminarPaisValidator.ejecutar(domain);
		validarRegistroExistente(domain.getId());
		eliminar(domain.getId());
	}

	private final void eliminar(final UUID uuid) {
		getPaisDAO().eliminar(uuid);
	}
	
	private final void validarRegistroExistente(final UUID uuid) {
		final var resultados = getPaisDAO().consultarPorId(uuid);
		
		if (resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000183);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final PaisDAO getPaisDAO() {
		return getFactoria().obtenerPaisDAO();
	}
	
	public DAOFactory getFactoria() {
		return factoria;
	}
	
	public void setFactoria(DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000181);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000185);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
