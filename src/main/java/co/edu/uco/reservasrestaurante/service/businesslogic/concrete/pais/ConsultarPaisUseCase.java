package co.edu.uco.reservasrestaurante.service.businesslogic.concrete.pais;

import java.util.List;

import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.ServiceReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.CatalogoMensajes;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;
import co.edu.uco.reservasrestaurante.data.dao.PaisDAO;
import co.edu.uco.reservasrestaurante.data.dao.daofactory.DAOFactory;
import co.edu.uco.reservasrestaurante.service.businesslogic.FindUseCase;
import co.edu.uco.reservasrestaurante.service.businesslogic.validator.concrete.pais.ConsultarPaisValidator;
import co.edu.uco.reservasrestaurante.service.domain.pais.PaisDomain;
import co.edu.uco.reservasrestaurante.service.mapper.entity.concrete.PaisClienteEntityMapper;

public class ConsultarPaisUseCase implements FindUseCase<PaisDomain>{
	
	private DAOFactory factoria;
	
	public ConsultarPaisUseCase(final DAOFactory factoria) {
		setFactoria(factoria);
	}

	@Override
	public List<PaisDomain> execute(PaisDomain domain) {
		ConsultarPaisValidator.ejecutar(domain);
		final var resultados = getPaisDAO().consultar(PaisClienteEntityMapper.convertToEntity(domain));
		
		return PaisClienteEntityMapper.convertToListDomain(resultados);
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
			var mensajeTecnico = CatalogoMensajes.obtenerContenidoMensaje(CodigoMensaje.M00000186);
			throw ServiceReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		this.factoria = factoria;
	}
}
