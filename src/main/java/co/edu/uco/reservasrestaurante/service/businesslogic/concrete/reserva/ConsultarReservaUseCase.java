package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.reserva;

import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.ReservaDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.FindUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.reserva.ConsultarReservaValidator;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.ReservaEntityMapper;

public class ConsultarReservaUseCase implements FindUseCase<ReservaDomain> {
	
	private DAOFactory factoria;	

	public ConsultarReservaUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}


	@Override
	public List<ReservaDomain> execute(ReservaDomain domain) {
		ConsultarReservaValidator.ejecutar(domain);
		final var resultados = getReservaDAO().consultar(ReservaEntityMapper.convertToEntity(domain));
		return ReservaEntityMapper.convertToListDomain(resultados);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final ReservaDAO getReservaDAO() {
		return getFactoria().obtenerReservaDAO();
	}


	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000249);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000250);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
