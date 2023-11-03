package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.reserva;

import java.sql.Date;
import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.ReservaDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.entity.ReservaEntity;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;
import co.edu.uco.reservasrestaurante.service.domain.reserva.ReservaDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.ReservaEntityMapper;

public class RegistrarReservaUseCase implements UseCase<ReservaDomain> {
	
	private DAOFactory factoria;	

	public RegistrarReservaUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}


	@Override
	public void execute(ReservaDomain domain) {
		validarNoExistenciaMismaHoraFechaMesa(domain.getFecha(), domain.getHora(), domain.getMesa());
		domain = obtenerIdentificadorTipoIdentificacion(domain);
		registrar(domain);
	}
	
	private final void registrar(final ReservaDomain domain) {
		var entity = ReservaEntityMapper.convertToEntity(domain);
		getReservaDAO().crear(entity);
	}
	
	private final void validarNoExistenciaMismaHoraFechaMesa(final Date fecha, final String hora, final MesaDomain mesa) {
		
		var domain = ReservaDomain.crear(null, null, fecha, hora, mesa, 0, false);
		var entity = ReservaEntityMapper.convertToEntity(domain);
		var resultados = getReservaDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000248);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final ReservaDomain obtenerIdentificadorTipoIdentificacion(final ReservaDomain domain) {
		Optional<ReservaEntity> optional;
		UUID uuid;
		
		do {
			uuid = UUID.randomUUID();
			optional = getReservaDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		
		return ReservaDomain.crear(uuid, domain.getCliente(), domain.getFecha(), domain.getHora(),domain.getMesa(),
				domain.getCantidadPersonas(), domain.isEstado());
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
