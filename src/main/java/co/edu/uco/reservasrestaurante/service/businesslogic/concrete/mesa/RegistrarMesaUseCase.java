package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.mesa;

import java.util.Optional;
import java.util.UUID;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.MesaDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.data.entity.MesaEntity;
import co.edu.uco.reservasrestaurante.service.businesslogic.UseCase;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;
import co.edu.uco.reservasrestaurante.service.domain.support.BooleanDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.MesaEntityMapper;

public class RegistrarMesaUseCase implements UseCase<MesaDomain> {
	
	private DAOFactory factoria;	

	public RegistrarMesaUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}


	@Override
	public void execute(MesaDomain domain) {
		validarNoExistenciaMismoNumero(domain.getNumero());
		domain = obtenerIdentificadorTipoIdentificacion(domain);
		registrar(domain);
	}
	
	private final void registrar(final MesaDomain domain) {
		var entity = MesaEntityMapper.convertToEntity(domain);
		getTipoIdentificacionDAO().crear(entity);
	}
	
	private final void validarNoExistenciaMismoNumero(final int numero) {
		
		var domain = MesaDomain.crear(null, numero, null, 0, BooleanDomain.crear(false, true));
		var entity = MesaEntityMapper.convertToEntity(domain);
		var resultados = getTipoIdentificacionDAO().consultar(entity);
		
		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000309) + numero;
			throw ServiceReservasRestauranteException.crear(mensajeUsuario);
		}
	}
	
	private final MesaDomain obtenerIdentificadorTipoIdentificacion(final MesaDomain domain) {
		Optional<MesaEntity> optional;
		UUID uuid;
		
		do {
			uuid = UUID.randomUUID();
			optional = getTipoIdentificacionDAO().consultarPorId(uuid);
		}while(optional.isPresent());
		
		return MesaDomain.crear(uuid, domain.getNumero(), domain.getUbicacion(), domain.getCapacidad(), 
				domain.isEstado());
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
