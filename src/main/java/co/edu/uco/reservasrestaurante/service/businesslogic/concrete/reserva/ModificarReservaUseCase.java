package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.reserva;

import java.sql.Date;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.ReservaDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.ReservaEntityMapper;

public class ModificarReservaUseCase implements UseCase<ReservaDomain> {
	
	private DAOFactory factoria;	

	public ModificarReservaUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}


	@Override
	public void execute(ReservaDomain domain) {
		validarNoExistenciaMismaHoraFechaMesa(domain.getFecha(), domain.getHora(), domain.getMesa());
		actualizar(domain);
	}
	
	private final void actualizar(final ReservaDomain domain) {
		var entity = ReservaEntityMapper.convertToEntity(domain);
		getReservaDAO().modificar(entity);
	}
	
	private final void validarNoExistenciaMismaHoraFechaMesa(final Date fecha, final String hora, final int mesa) {
		
		var domain = ReservaDomain.crear(null, null, fecha, hora, mesa, 0, false);
		var entity = ReservaEntityMapper.convertToEntity(domain);
		var resultados = getReservaDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000248);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
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
