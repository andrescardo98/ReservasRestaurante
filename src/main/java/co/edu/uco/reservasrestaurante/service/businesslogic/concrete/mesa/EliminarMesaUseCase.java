package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.mesa;

import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.MesaDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.MesaEntityMapper;

public class EliminarMesaUseCase implements UseCase<MesaDomain> {
	
	private DAOFactory factoria;	

	public EliminarMesaUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}


	@Override
	public void execute(MesaDomain domain) {
		validarRegistroExistente(domain.getId());
		actualizar(domain);
	}
	
	private final void actualizar(final MesaDomain domain) {
		getTipoIdentificacionDAO().modificar(MesaEntityMapper.convertToEntity(domain));
	}
	
	private final void validarRegistroExistente(final UUID uuid) {
		final var resultados = getTipoIdentificacionDAO().consultarPorId(uuid);
		
		if (resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000298);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final MesaDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerMesaDAO();
	}


	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000296);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000297);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
