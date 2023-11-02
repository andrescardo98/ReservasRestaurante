package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.mesa;

import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.MesaDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.FindUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.mesa.ConsultarMesaValidator;
import co.edu.uco.reservasrestaurante.service.domain.mesa.MesaDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.MesaEntityMapper;

public class ConsultarMesaUseCase implements FindUseCase<MesaDomain> {
	
	private DAOFactory factoria;	

	public ConsultarMesaUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}


	@Override
	public List<MesaDomain> execute(MesaDomain domain) {
		ConsultarMesaValidator.ejecutar(domain);
		final var resultados = getTipoIdentificacionDAO().consultar(MesaEntityMapper.convertToEntity(domain));
		
		return MesaEntityMapper.convertToListDomain(resultados);
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
