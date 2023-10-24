package co.edu.uco.reservasrestaurante.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;


import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.CrossCuttingReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CategoriaMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.TipoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;

public final class CatalogoMensajes {
	
	private static final String VERIFICAR_TRAZA = "Por favor verifique la traza completa del error presentado, para así poder "
				+ "diagnosticar con mayor certeza, qué sucedió...";
	private static final String PROBLEMA_SQLEXCEPCION = "Se ha presentado un problema de tipo SQLException ";
	private static final String PROBLEMA_EXCEPCION = "Se ha presentado un problema inesperado de tipo Exception ";
	private static final String  METODO_CONSULTAR_POR_ID= " en el método consultarPorID de la clase TipoIdentificacionSQLServer tratando de ";
	private static final Map<CodigoMensaje, Mensaje> MENSAJES = new HashMap<>();
	
	static {
		cargarMensajes();
	}
	
	private CatalogoMensajes() {
		super();
	}
	
	private static final void cargarMensajes() {
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000001, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No se recibió el código de mensaje que se quería crear. No es posible continuar con el proceso..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000002, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No existe un mensaje con el código indicado. No es posible continuar con el proceso..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000003, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible obtener un mensaje con un código vacío o nulo. No es posible continuar con el proceso..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000004, TipoMensaje.USUARIO, CategoriaMensaje.FATAL, 
				"Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada. Por favor "
				+ "intente de nuevo y si el problema persiste, contacte al administrador de la aplicación"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000005, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " tratando de validar si la conexión SQL estaba abierta. " 
				+ VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000006, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " tratando de validar si la conexión SQL estaba abierta. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000007, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cerrar una conexión que está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000008, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cerrar una conexión que ya está cerrada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000009, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible validar si una conexión está abierta cuando es nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000010, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				PROBLEMA_SQLEXCEPCION + "Se ha presentado un problema tratando de cerrar una conexión SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000011, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " tratando de cerrar la conexión. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000012, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible iniciar una transacción con una conexión que está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000013, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible iniciar una transaccion con una conexión cerrada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000014, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible iniciar una transaccion que ya ha sido iniciada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000015, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				PROBLEMA_SQLEXCEPCION + " tratando de iniciar la transacción de una conexión SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000016, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " tratando de iniciar una transacción de una conexión. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000017, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible confirmar una transacción con una conexión que está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000018, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible confirmar una transaccion con una conexión cerrada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000019, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible confirmar una transaccion que no fue iniciada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000020, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				PROBLEMA_SQLEXCEPCION + " tratando de confirmar la transacción de una conexión SQL. "
				+ VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000021, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " tratando de confirmar la transacción de una conexión. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000022, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cancelar una transacción con una conexión que está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000023, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cancelar una transaccion con una conexión cerrada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000024, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cancelar una transaccion que no fue iniciada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000025, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				PROBLEMA_SQLEXCEPCION + " tratando de cancelar la transacción de una conexión SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000026, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " tratando de cancelar la transacción de una conexión. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000027, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible abrir la conexión. Se ha presentado un prooblema SQL..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000028, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible encontrar la clase para abrir la conexión..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000029, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " tratando de abrir la conexión. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000030, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de leer el archivo de configuración."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000031, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo IOException en la clase Configuración tratando de leer el archivo "
				+ "de configuración. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000032, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de registar la información del nuevo tipo de identificación."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000033, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método crear de la clase TipoIdentificacionSQLServer tratando de llevar "
				+ "a cabo el registro del nuevo Tipo de Identificación. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000034, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método crear de la clase TipoIdentificacionSQLServer tratando de llevar a cabo "
				+ "el registro del nuevo Tipo de Identificación. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000035, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de crear el DAO deseado, debido a que la conexiòn actualmente está cerrada, "
				+ "por lo que no hay una conexiòn vàlida disponible..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000036, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de actualizar la información del tipo de identificación deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000037, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método modificar de la clase TipoIdentificacionSQLServer tratando de llevar "
				+ "a cabo la actualización del Tipo de Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000038, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método modificar de la clase TipoIdentificacionSQLServer tratando de llevar a "
				+ "cabo la actualización del Tipo de Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000039, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del tipo de identificación por el "
				+ "identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000040, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + METODO_CONSULTAR_POR_ID + "recuperar los datos de la consulta Tipo de Identificación "
				+ "deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000041, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + METODO_CONSULTAR_POR_ID + "preparar la sentencia SQL de la consulta del Tipo de "
				+ "Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000042, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + METODO_CONSULTAR_POR_ID + "preparar la sentencia SQL de la consulta del Tipo de "
				+ "Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000043, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar la información del tipo de identificación por el identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000044, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método eliminar de la clase TipoIdentificacionSQLServer tratando de llevar "
				+ "a cabo la eliminación del Tipo de Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000045, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método eliminar de la clase TipoIdentificacionSQLServer tratando de llevar a "
				+ "cabo la eliminación del Tipo de Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000046, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + METODO_CONSULTAR_POR_ID + "recuperar los datos de la consulta Tipo de Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000047, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de llevar a cabo la consulta de los Tipos de Identificación..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000048, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método prepararEjecutarSentenciaConsulta de la clase "
				+ "TipoIdentificacionSQLServerDAO tratando de preparar la sentencia SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000049, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método prepararEjecutarSentenciaConsulta de la clase "
				+ "TipoIdentificacionSQLServerDAO tratando de preparar la sentencia SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000050, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método colocarParametrosConsulta de la clase TipoIdentificacionSQLServerDAO "
				+ "tratando de colocar los parámetros de la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000051, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método colocarParametrosConsulta de la clase TipoIdentificacionSQLServerDAO "
				+ "tratando de colocar los parámetros de la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000052, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método ejecutarConsulta de la clase TipoIdentificacionSQLServerDAO tratando "
				+ "de ejecutar la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000053, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método ejecutarConsulta de la clase TipoIdentificacionSQLServerDAO tratando "
				+ "de ejecutar la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000054, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de registar la información del nuevo Cliente."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000055, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método crear de la clase ClienteSQLServerDAO tratando de llevar "
				+ "a cabo el registro del nuevo Cliente. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000056, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método crear de la clase ClienteSQLServerDAO tratando de llevar a cabo "
				+ "el registro del nuevo Cliente. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000057, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de actualizar la información del Cliente deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000058, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método modificar de la clase ClienteSQLServerDAO tratando de llevar "
				+ "a cabo la actualización del Cliente deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000059, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método modificar de la clase ClienteSQLServerDAO tratando de llevar a "
				+ "cabo la actualización del Cliente deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000060, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar la información del cliente por el identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000061, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método eliminar de la clase ClienteSQLServerDAO tratando de llevar "
				+ "a cabo la eliminación del Cliente deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000062, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método eliminar de la clase ClienteSQLServerDAO tratando de llevar a "
				+ "cabo la eliminación del Cliente deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000063, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del cliente por el "
				+ "identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000064, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + METODO_CONSULTAR_POR_ID + "preparar la sentencia SQL de la consulta del Cliente "
						+ "deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000065, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + METODO_CONSULTAR_POR_ID + "preparar la sentencia SQL de la consulta del Cliente "
						+ "deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000066, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + METODO_CONSULTAR_POR_ID + "recuperar los datos de la consulta Cliente "
				+ "deseado. " + VERIFICAR_TRAZA));		
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000067, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + METODO_CONSULTAR_POR_ID + "recuperar los datos de la consulta Cliente deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000068, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método toDomain en la clase TipoIdentificacionEntityMapper.No es posible "
				+ "mappear un tipo de identificación dominio a partir de una entidad de tipo identificación entity nula."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000069, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método toEntity en la clase TipoIdentificacionEntityMapper.No es posible "
				+ "mappear un tipo de identificación entity a partir de un dominio de tipo identificación domain nulo."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000070, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema llevando a cabo el registr de la información del nuevo tipo de identificación..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000071, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase RegistrarTipoIdentificacionUseCase, debido a que "
				+ "la factoría con la que se desea crear está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000072, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud del código del tipo de identificación no es válida. La logitud máxima "
						+ "son 50 caracteres "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000073, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El código del tipo de identificación es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000074, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El código del tipo de identificación solo puede contener letras..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000075, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud del nombre del tipo de identificación no es válida. La logitud máxima "
						+ "son 100 caracteres "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000076, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El nombre del tipo de identificación es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000077, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El nombre de tipo identificación solo puede contener letras, digitos y espacios internos"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000078, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El id del tipo de identificación es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000079, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El id del tipo de identificación no puede ser igual al id por defecto..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000080, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No es posible llevar a cabo la operación deseada con el tipo de identificación,"
				+ " debido a que no existen datos para llevarla a cabo..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000081, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
		"Se presento un problema tratando de registrar el nuevo tipo de identificación"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000082, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase RegistrarTipoIdentificacionFacade, "
						+ "tratando de registrar el nuevo tipo de identificación." + VERIFICAR_TRAZA));
	}
	
	private static final void agregarMensaje(final Mensaje mensaje) {
		MENSAJES.put(mensaje.getCodigo(), mensaje);
	}
	
	
	public static final Mensaje obtenerMensaje(final CodigoMensaje codigo) {
		if (UtilObjeto.esNulo(codigo)) {
			var mensajeUsuario = obtenerMensaje(CodigoMensaje.M00000004).getContenido();
			var mensajeTecnico = obtenerMensaje(CodigoMensaje.M00000003).getContenido();
			throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		if (!MENSAJES.containsKey(codigo)) {
			var mensajeUsuario = obtenerMensaje(CodigoMensaje.M00000004).getContenido();
			var mensajeTecnico = obtenerMensaje(CodigoMensaje.M00000002).getContenido();
			throw CrossCuttingReservasRestauranteException.crear(mensajeUsuario, mensajeTecnico);
		}
		return MENSAJES.get(codigo);
	}
	
	public static final String obtenerContenidoMensaje(final CodigoMensaje codigo) {
		return obtenerMensaje(codigo).getContenido();
	}
}
