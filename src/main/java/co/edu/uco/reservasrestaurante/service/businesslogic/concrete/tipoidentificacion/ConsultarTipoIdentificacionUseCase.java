package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.tipoidentificacion;

import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.TipoIdentificacionDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.FindUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.tipoidentificacion.ConsultarTipoIdentificacionValidator;
import co.edu.uco.reservasrestaurante.service.domain.tipoidentificacion.TipoIdentificacionDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.TipoIdentificacionEntityMapper;

public class ConsultarTipoIdentificacionUseCase implements FindUseCase<TipoIdentificacionDomain> {
	
	private DAOFactory factoria;	

	public ConsultarTipoIdentificacionUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}
	
	@Override
	public List<TipoIdentificacionDomain> execute(TipoIdentificacionDomain domain) {
		ConsultarTipoIdentificacionValidator.ejecutar(domain);
		final var resultados = getTipoIdentificacionDAO().consultar(TipoIdentificacionEntityMapper.convertToEntity(domain));
		
		return TipoIdentificacionEntityMapper.convertToListDomain(resultados);
	}

	private final DAOFactory getFactoria() {
		return factoria;
	}


	private final TipoIdentificacionDAO getTipoIdentificacionDAO() {
		return getFactoria().obtenerTipoIdentificacionDAO();
	}


	private final void setFactoria(final DAOFactory factoria) {
		if (UtilObjeto.esNulo(factoria)) {
			var mensajeUsuario = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000126);
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000127);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
