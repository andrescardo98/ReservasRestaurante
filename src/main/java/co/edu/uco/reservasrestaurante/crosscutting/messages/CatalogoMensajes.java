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
	private static final String  METODO_CONSULTAR_POR_ID= " en el método consultarPorID de la clase TipoIdentificacionPostgreSQL tratando de ";
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
				PROBLEMA_SQLEXCEPCION + " en el método crear de la clase TipoIdentificacionPostgreSQL tratando de llevar "
				+ "a cabo el registro del nuevo Tipo de Identificación. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000034, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método crear de la clase TipoIdentificacionPostgreSQL tratando de llevar a cabo "
				+ "el registro del nuevo Tipo de Identificación. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000035, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de crear el DAO deseado, debido a que la conexiòn actualmente está cerrada, "
				+ "por lo que no hay una conexiòn vàlida disponible..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000036, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de actualizar la información del tipo de identificación deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000037, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método modificar de la clase TipoIdentificacionPostgreSQL tratando de llevar "
				+ "a cabo la actualización del Tipo de Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000038, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método modificar de la clase TipoIdentificacionPostgreSQL tratando de llevar a "
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
				PROBLEMA_SQLEXCEPCION + " en el método eliminar de la clase TipoIdentificacionPostgreSQL tratando de llevar "
				+ "a cabo la eliminación del Tipo de Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000045, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método eliminar de la clase TipoIdentificacionPostgreSQL tratando de llevar a "
				+ "cabo la eliminación del Tipo de Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000046, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + METODO_CONSULTAR_POR_ID + "recuperar los datos de la consulta Tipo de Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000047, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de llevar a cabo la consulta de los Tipos de Identificación..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000048, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método consultar de la clase TipoIdentificacionPostgreSQLDAO "
						+ "tratando de consultar el tipo de identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000049, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método consultar de la clase TipoIdentificacionPostgreSQLDAO "
					+ "tratando de consultar el tipo de identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000050, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método colocarParametrosConsulta de la clase TipoIdentificacionPostgreSQLDAO "
				+ "tratando de colocar los parámetros de la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000051, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método colocarParametrosConsulta de la clase TipoIdentificacionPostgreSQLDAO "
				+ "tratando de colocar los parámetros de la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000052, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método ejecutarConsulta de la clase TipoIdentificacionPostgreSQLDAO tratando "
				+ "de ejecutar la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000053, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método ejecutarConsulta de la clase TipoIdentificacionPostgreSQLDAO tratando "
				+ "de ejecutar la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000054, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de registar la información del nuevo Cliente."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000055, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método crear de la clase ClientePostgreSQLDAO tratando de llevar "
				+ "a cabo el registro del nuevo Cliente. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000056, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método crear de la clase ClientePostgreSQLDAO tratando de llevar a cabo "
				+ "el registro del nuevo Cliente. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000057, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de actualizar la información del Cliente deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000058, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método modificar de la clase ClientePostgreSQLDAO tratando de llevar "
				+ "a cabo la actualización del Cliente deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000059, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método modificar de la clase ClientePostgreSQLDAO tratando de llevar a "
				+ "cabo la actualización del Cliente deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000060, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar la información del cliente por el identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000061, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método eliminar de la clase ClientePostgreSQLDAO tratando de llevar "
				+ "a cabo la eliminación del Cliente deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000062, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método eliminar de la clase ClientePostgreSQLDAO tratando de llevar a "
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
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000083, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de consultar la información del cliente deseado..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000084, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
			PROBLEMA_SQLEXCEPCION + " en el método colocarParametrosConsulta de la clase ClientePostgreSQLDAO "
					+ "tratando de consultar el cliente." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000085, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				PROBLEMA_EXCEPCION + " en el método colocarParametrosConsulta de la clase ClientePostgreSQLDAO "
						+ "tratando de consultar el cliente." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000086, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				PROBLEMA_SQLEXCEPCION + " en el método ejecutarConsulta de la clase ClientePostgreSQLDAO tratando "
						+ "de consultar el cliente. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000087, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				PROBLEMA_EXCEPCION + " en el método ejecutarConsulta de la clase ClientePostgreSQLDAO tratando "
						+ "de consultar el cliente. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000088, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de llevar a cabo la consulta del Cliente..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000089, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método consultar de la clase ClientePostgreSQLDAO tratando de "
						+ "consultar el Cliente. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000090, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método consultar de la clase ClientePostgreSQLDAO tratando de "
						+ "consultar el Cliente. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000091, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de conectar con la base de datos. Motor de base de datos que se "
				+ "trata de conectar no usado por la app..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000092, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase TipoIdentificaciónDTOMapper. No es "
				+ "posible mapear un tipo de identificación domain a partir de una entidad de tipo identificación dto nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000093, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDto de la clase TipoIdentificaciónDTOMapper. No es "
				+ "posible mapear un tipo de identificación dto a partir de una entidad de tipo identificación domain nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000094, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método toDomain en la clase NumeroCelularClienteEntityMapper. No es posible "
				+ "mappear un Numero de Celular dominio a partir de una entidad de Numero de Celular entity nula."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000095, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método toEntity en la clase NumeroCelularClienteEntityMapper. No es posible "
				+ "mappear un Numero de Celular entity a partir de un dominio de Numero de Celular domain nulo."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000096, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de registar la información del nuevo País."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000097, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método crear de la clase PaisPostgreSQL tratando de llevar "
				+ "a cabo el registro del nuevo País. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000098, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método crear de la clase PaisPostgreSQL tratando de llevar a cabo "
				+ "el registro del nuevo País. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000099, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de actualizar la información del País deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000100, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método modificar de la clase PaisPostgreSQL tratando de llevar "
				+ "a cabo la actualización del País deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000101, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método modificar de la clase PaisPostgreSQL tratando de llevar a "
				+ "cabo la actualización del País deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000102, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar la información del País por el identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000103, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método eliminar de la clase PaisPostgreSQL tratando de llevar "
				+ "a cabo la eliminación del País deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000104, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método eliminar de la clase PaisPostgreSQL tratando de llevar a "
				+ "cabo la eliminación del País deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000105, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del País por el "
				+ "identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000106, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método consultarPorId de la clase PaisPostgreSQL tratando de llevar "
						+ "a cabo la consulta del País deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000107, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método consultarPorId de la clase PaisPostgreSQL tratando de llevar a "
						+ "cabo la consulta del País deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000108, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de llevar a cabo la consulta de los Paises..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000109, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método consultar de la clase PaisPostgreSQL "
						+ "tratando de consultar el País deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000110, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método consultar de la clase PaisPostgreSQL "
					+ "tratando de consultar el País deseado. " + VERIFICAR_TRAZA));

		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000111, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del País por el "
				+ "identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000112, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + METODO_CONSULTAR_POR_ID + "recuperar los datos de la consulta País "
				+ "deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000113, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + METODO_CONSULTAR_POR_ID + "recuperar los datos de la consulta País deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000114, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de llevar a cabo la consulta de los Paises..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000115, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método colocarParametrosConsulta de la clase PaisPostgreSQL "
				+ "tratando de colocar los parámetros de la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000116, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método colocarParametrosConsulta de la clase PaisPostgreSQL "
				+ "tratando de colocar los parámetros de la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000117, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del País deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000118, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				PROBLEMA_SQLEXCEPCION + " en el método ejecutarConsulta de la clase PaisPostgreSQL tratando de "
				+ "consultar tipos de identificación. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000119, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				PROBLEMA_EXCEPCION + " en el método ejecutarConsulta de la clase PaisPostgreSQL tratando de "
				+ "consultar tipos de identificación. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000120, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No existe un tipo de identificación a modificar"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000121, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema llevando a cabo la actualización de la información del nuevo tipo de identificación..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000122, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase ModificarTipoIdentificacionUseCase, debido a que "
				+ "la factoría con la que se desea actualizar está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000123, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No existe un tipo de identificación a eliminar"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000124, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema llevando a cabo la eliminación de la información del tipo de identificación..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000125, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase EliminarTipoIdentificacionUseCase, debido a que "
				+ "la factoría con la que se desea eliminar está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000126, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema llevando a cabo la consulta de la información del tipo de identificación..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000127, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase ConsultarTipoIdentificacionUseCase, debido a que "
				+ "la factoría con la que se desea eliminar está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000128, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método toDomain en la clase ClienteEntityMapper.No es posible "
				+ "mappear un Cliente dominio a partir de una entidad de Cliente entity nula."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000129, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método toEntity en la clase ClienteEntityMapper. No es posible "
				+ "mappear un Cliente entity a partir de un dominio de Cliente domain nulo."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000130, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede registrar el cliente. Ya existe un tipo cliente con ese nombre completo registrado"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000131, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede registrar el cliente. Ya existe un tipo cliente con el correo electronico registrado"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000132, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede registrar el cliente. Ya existe un tipo cliente con el número de celular registrado"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000133, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede registrar el cliente. Ya existe un tipo cliente con el tipo de identificación e "
				+ "identificación registrado"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000134, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo el registro de datos del nuevo cliente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000135, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase RegistrarClienteUseCase, debido a "
				+ "que la factoria con la cual se desea crear esta nula"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000136, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No existe un cliente existente a modificar"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000137, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede modificar el cliente. Ya existe un tipo cliente con ese nombre completo a modificar"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000138, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede modificar el cliente. Ya existe un tipo cliente con el correo electronico a modificar"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000139, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede modificar el cliente. Ya existe un tipo cliente con el número de celular a modificar"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000140, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No se puede modificar el cliente. Ya existe un tipo cliente con el tipo de identificación e "
				+ "identificación a modificar"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000141, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de modificar los datos de un nuevo cliente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000142, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo setFactoria de la clase ModificarClienteUseCase, debido a "
				+ "que la factoria con la cual se desea crear esta nula"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000143, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El id del Cliente es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000144, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El id del Cliente no puede ser igual al id por defecto..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000145, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No es posible llevar a cabo la operación deseada con la identificación del cliente, debido a"
				+ " que no existen datos para llevarla a cabo..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000146, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud del primer nombre del cliente no es válido. La logitud máxima son 50 caracteres "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000147, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El primer nombre del cliente es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000148, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El primer nombre del cliente solo puede contener letras, digitos y espacios internos"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000149, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud del segundo nombre del cliente no es válido. La logitud máxima son 50 caracteres "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000150, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El segundo nombre del cliente solo puede contener letras, digitos y espacios internos"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000151, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud del primer apellido del cliente no es válido. La logitud máxima son 50 caracteres "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000152, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El primer apellido del cliente es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000153, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El primer apellido del cliente solo puede contener letras, digitos y espacios internos"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000154, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud del segundo apellido del cliente no es válido. La logitud máxima son 50 caracteres "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000155, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El segundo apellido del cliente es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000156, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El segundo apellido del cliente solo puede contener letras, digitos y espacios internos"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000157, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud del correo electrónico del cliente no es válido. La logitud mínima es de "
				+ "30 caracteres y la longitud máxima son 250 caracteres "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000158, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El correo electrónico del cliente es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000159, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El correo electrónico del cliente puede contener letras, digitos, @ caracteres especiales"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000160, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud de la clave del cliente no es válida. La logitud mínima es de 8 caracteres "
				+ "y la longitud máxima es de 50 caracteres "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000161, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La clave del cliente es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000162, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La clave del cliente puede contener letras, digitos y caracteres especiales (#,*,-,etc.)"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000163, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La fecha de nacimiento del cliente es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000164, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La fecha de nacimiento del cliente debe estar en formato dd/mm/aaaa"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000165, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No es posible llevar a cabo la operación deseada con el país del cliente, debido a"
				+ " que no existen datos para llevarla a cabo..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000166, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud del número de celular del cliente no es válido. La logitud máxima son 20 caracteres "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000167, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El número de celular del cliente es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000168, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El número de celular del cliente solo puede contener letras, digitos y espacios internos"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000169, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El id del País es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000170, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El id del País no puede ser igual al id por defecto..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000171, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud del nombre del país no es válida. La logitud mínima es de 5 caracteres y la "
				+ "longitud máxima son 50 caracteres"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000172, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El nombre del país es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000173, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El nombre del país solo puede contener letras, digitos y espacios internos"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000171, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud del código indicativo del país no es válida. La logitud mínima es de 3 caracteres y la "
				+ "longitud máxima son 5 caracteres"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000172, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El código indicativo del país es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000173, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El código indicativo del país solo puede contener digitos y espacios internos"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000174, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud del código ISO 3 del país no es válida. La logitud máxima son 3 caracteres"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000175, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El nombre del país es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000176, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El nombre del país solo puede contener letras en mayúscula"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000177, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El número de identificación del cliente es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000178, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El número de identificación del cliente solo puede contener letras y digitos"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000179, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema llevando a cabo la consulta de la información del cliente..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000180, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase ConsultarClienteUseCase,"
				+ " debido a que la factoría con la que se desea eliminar está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000181, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema llevando a cabo el registro de la información del nuevo país..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000182, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase RegistrarPaisUseCase, debido a que "
				+ "la factoría con la que se desea crear está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000184, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase ModificarPaisUseCase, debido a que "
				+ "la factoría con la que se desea crear está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000185, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase EliminarPaisUseCase, debido a que "
				+ "la factoría con la que se desea crear está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000186, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase ConsultarPaisUseCase, debido a que "
				+ "la factoría con la que se desea crear está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000183, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No existe un país a modificar"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000187, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de consultar el tipo de identificación"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000188, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase ConsultarTipoIdentificacionFacade, "
						+ "tratando de consultar el tipo de identificación." + VERIFICAR_TRAZA));

		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000189, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de modificar el tipo de identificación"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000190, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase ModificarTipoIdentificacionFacade, "
						+ "tratando de modificar el tipo de identificación." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000191, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de eliminar el tipo de identificación"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000192, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase EliminarTipoIdentificacionFacade, "
						+ "tratando de eliminar el tipo de identificación." + VERIFICAR_TRAZA));

		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000193, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase ClienteDTOMapper. No es "
				+ "posible mapear un Cliente domain a partir de una entidad de Cliente dto nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000194, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDto de la clase ClienteDTOMapper. No es "
				+ "posible mapear un Cliente dto a partir de una entidad de Cliente domain nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000195, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDomain de la clase PaisDTOMapper. No es "
				+ "posible mapear un Pais domain a partir de una entidad de Pais dto nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000196, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema en el metodo toDto de la clase PaisDTOMapper. No es "
				+ "posible mapear un Pais dto a partir de una entidad de Pais domain nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000197, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de registrar el nuevo Cliente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000198, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase RegistrarClienteFacade, "
						+ "tratando de registrar el nuevo cliente." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000199, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de modificar el cliente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000200, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase ModificarClienteFacade, "
						+ "tratando de modificar el cliente." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000201, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de eliminar el cliente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000202, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase EliminarClienteFacade, "
						+ "tratando de eliminar el cliente." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000207, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de consultar el cliente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000208, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase ConsultarClienteFacade, "
						+ "tratando de consultar el cliente." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000203, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de registrar el nuevo país"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000204, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase RegistrarPaisFacade, "
						+ "tratando de registrar el nuevo país." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000205, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de modificar el país"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000206, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase ModificarPaisFacade, "
						+ "tratando de modificar el país." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000209, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de registar la información de la reserva."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000210, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método crear de la clase ReservaPostgreSQLDAO tratando de llevar "
				+ "a cabo el registro de la nueva Reserva. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000211, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método crear de la clase ReservaPostgreSQLDAO tratando de llevar "
				+ "a cabo el registro de la nueva Reserva. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000212, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de actualizar la información de la reserva deseada."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000213, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método modificar de la clase ReservaPostgreSQLDAO tratando de llevar "
				+ "a cabo la actualización de la Reserva deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000214, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método modificar de la clase ReservaPostgreSQLDAO tratando de llevar a "
				+ "cabo la actualización de la Reserva deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000215, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar la información de la reserva por el identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000216, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método eliminar de la clase ReservaPostgreSQLDAO tratando de llevar "
				+ "a cabo la eliminación de la Reserva deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000217, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método eliminar de la clase ReservaPostgreSQLDAO tratando de llevar a "
				+ "cabo la eliminación de la Reserva deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000218, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información de la reserva por el "
				+ "identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000219, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + "en el método consultarPorId de la clase ReservaPostgreSQLDAO tratando de "
						+ "preparar la sentencia SQL de la consulta del Cliente deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000220, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + "en el método consultarPorId de la clase ReservaPostgreSQLDAO tratando de "
						+ "preparar la sentencia SQL de la consulta del Cliente deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000221, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de llevar a cabo la consulta de la Reserva..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000222, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método consultar de la clase ReservaPostgreSQLDAO tratando de "
						+ "consultar la Reserva. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000223, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método consultar de la clase ReservaPostgreSQLDAO tratando de "
						+ "consultar la Reserva. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000224, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información de la reserva por el "
				+ "identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000225, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + "en el método consultar de la clase ReservaPostgreSQLDAO tratando de "
						+ "recuperar los datos de la consulta Reserva deseado. " + VERIFICAR_TRAZA));		
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000226, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + "en el método consultar de la clase ReservaPostgreSQLDAO tratando de "
						+ "recuperar los datos de la consulta Reserva deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000227, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de consultar la información de la reserva deseada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000228, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
			PROBLEMA_SQLEXCEPCION + " en el método colocarParametrosConsulta de la clase ReservaPostgreSQLDAO "
					+ "tratando de consultar la reserva." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000229, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				PROBLEMA_EXCEPCION + " en el método colocarParametrosConsulta de la clase ReservaPostgreSQLDAO "
						+ "tratando de consultar la reserva." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000230, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de consultar la información de la reserva deseada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000231, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				PROBLEMA_SQLEXCEPCION + " en el método ejecutarConsulta de la clase ReservaPostgreSQLDAO tratando "
						+ "de consultar la reserva. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000232, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				PROBLEMA_EXCEPCION + " en el método ejecutarConsulta de la clase ReservaPostgreSQLDAO tratando "
						+ "de consultar la reserva. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000233, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El id de la reserva es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000234, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El id dela reserva no puede ser igual al id por defecto..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000235, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La fecha para la reserva es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000236, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El formato de la hora es inválido. Use HH:mm (por ejemplo, 14:30)"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000237, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La hora en que desea hacer la reserva es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000238, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Los rangos para la hora son inválidos... El valor mínimo de las horas es 0 y el máximo es 23, "
				+ "el valor mínimo de los mintos es 0 y el máximo 59."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000239, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Error. No se permiten reservas para horas pasadas"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000240, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Error. No se permiten reservas para fechas pasadas"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000241, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No es posible llevar a cabo la operación deseada con la reserva,"
				+ " debido a que no existen datos para llevarla a cabo..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000242, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El número de personas ingresado es inválido. Intente de nuevo e ingrese un valor correcto"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000243, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El número de personas ingresado es inválido. La cantidad máxima de personas por mesa es 4"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000244, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El tipo de identificación fue registrado exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000244, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema inesperado tratando de registrar el tipo de identificación deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000245, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El número de mesa ingresado es inválido. Intente de nuevo e ingrese un valor correcto"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000246, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El número de mesa ingresado no es válido. La cantidad máxima de mesas es 15"));

		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000247, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La mesa para la reserva es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000248, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
		"Ya existe una reserva para la fecha, hora y mesa indicada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000249, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema llevando a cabo el registro de la información de la nueva reserva..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000250, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase RegistrarReservaUseCase, debido a que "
				+ "la factoría con la que se desea crear está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000251, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No existe una reserva a eliminar"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000252, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de registrar la nueva reserva"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000253, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método execute de la clase RegistrarReservaFacade, "
						+ "tratando de registrar la nueva reserva." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000254, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de modificar la reserva"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000255, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase ModificarReservaFacade, "
						+ "tratando de modificar la reserva." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000256, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de eliminar el país"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000257, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase EliminarPaisFacade, "
						+ "tratando de eliminar el país." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000258, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de eliminar la reserva"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000259, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase EliminarReservaFacade, "
						+ "tratando de eliminar la reserva." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000260, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de consular los países."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000261, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase ConsultarPaisFacade, "
						+ "tratando de consular los países." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000262, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de consular las reservas."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000263, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase ConsultarReservaFacade, "
						+ "tratando de consular las reservas." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000264, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de registar la información de la nueva mesa."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000265, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método crear de la clase MesaPostgreSQL tratando de llevar "
				+ "a cabo el registro de la nueva mesa. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000266, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método crear de la clase MesaPostgreSQL tratando de llevar "
				+ "a cabo el registro de la nueva mesa. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000267, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de actualizar la información de la mesa deseada."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000268, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método modificar de la clase MesaPostgreSQL tratando de llevar "
				+ "a cabo la actualización de la mesa deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000269, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método modificar de la clase MesaPostgreSQL tratando de llevar a "
				+ "cabo la actualización de la mesa deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000270, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar la información de la mesa por el identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000271, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método eliminar de la clase MesaPostgreSQL tratando de llevar "
				+ "a cabo la eliminación de la mesa deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000272, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método eliminar de la clase MesaPostgreSQL tratando de llevar a "
				+ "cabo la eliminación de la mesa deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000273, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información de la mesa por el "
				+ "identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000274, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + METODO_CONSULTAR_POR_ID + "preparar la sentencia SQL de la consulta de la mesa por el "
				+ "Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000275, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + METODO_CONSULTAR_POR_ID + "preparar la sentencia SQL de la consulta de la mesa por el "
					+ "Identificación deseado. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000276, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de llevar a cabo la consulta de las mesas..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000277, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método consultar de la clase MesaPostgreSQL "
						+ "tratando de consultar la mesa deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000278, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método consultar de la clase MesaPostgreSQL "
					+ "tratando de consultar la mesa deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000279, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información de la mesa por el "
				+ "identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000280, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + METODO_CONSULTAR_POR_ID + "recuperar los datos de la consulta Mesa "
				+ "deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000281, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + METODO_CONSULTAR_POR_ID + "recuperar los datos de la consulta Mesa deseada. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000282, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de llevar a cabo la consulta de las mesas..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000283, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método colocarParametrosConsulta de la clase MesaPostgreSQL "
				+ "tratando de colocar los parámetros de la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000284, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método colocarParametrosConsulta de la clase MesaPostgreSQL "
				+ "tratando de colocar los parámetros de la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000285, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_SQLEXCEPCION + " en el método ejecutarConsulta de la clase MesaPostgreSQL tratando "
				+ "de ejecutar la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000286, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en el método ejecutarConsulta de la clase MesaPostgreSQL tratando "
				+ "de ejecutar la consulta SQL. " + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000287, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El id de la mesa es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000288, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"El id de la mesa no puede ser igual al id por defecto..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000289, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La longitud de la ubicación de la mesa no es válida. La logitud máxima "
						+ "son 100 caracteres "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000290, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La ubicación de la mesa es un dato obligatorio..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000291, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"La ubicación de la mesa no puede ser igual al id por defecto..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000292, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"La capacidad ingresada de la mesa es inválido. Intente de nuevo e ingrese un valor correcto"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000293, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No es posible llevar a cabo la operación deseada con la mesa, debido a que no existen datos "
				+ "para llevarla a cabo..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000294, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método toDomain en la clase MesaEntityMapper. No es posible "
				+ "mappear una mesa dominio a partir de una entidad de mesa entity nula."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000295, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método toEntity en la clase MesaEntityMapper. No es posible "
				+ "mappear una mesa entity a partir de un dominio de mesa domain nulo."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000296, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema llevando a cabo el registro de la información de la nueva mesa..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000297, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase RegistrarMesaUseCase, debido a que "
				+ "la factoría con la que se desea crear está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000298, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"No existe una mesa a modificar"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000299, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El número de la mesa debe estar entre 1 y 10."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000296, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema llevando a cabo la consulta de la información de la mesa..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000297, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema en el método setFactoria de la clase ConsultarMesaUseCase, debido a que "
				+ "la factoría con la que se desea crear está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000300, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de registrar la nueva mesa"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000301, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase RegistrarMesaFacade, "
						+ "tratando de registrar la nueva mesa." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000302, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de modificar la mesa."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000303, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase ModificarMesaFacade, "
						+ "tratando de modificar la mesa." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000304, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se presento un problema tratando de eliminar la mesa."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000305, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				PROBLEMA_EXCEPCION + " en la el método execute de la clase EliminarMesaFacade, "
						+ "tratando de eliminar la mesa." + VERIFICAR_TRAZA));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000306, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Ya existe un país con el nombre "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000307, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Ya existe un país con el código indicativo "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000308, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Ya existe un país con el código ISO 3 "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000309, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Ya existe una mesa con el número "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000310, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Ya existe un tipo de identificación con el nombre "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000311, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Ya existe un tipo de identificación con el codigo "));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000312, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Tipo de identificación consultado exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000313, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de llevar a cabo la consulta de datos de un tipo de identificación"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000314, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El tipo de identificación fue eliminado exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000315, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de eliminar un tipo de identificación"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000316, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El tipo de identificación fue modificado exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000318, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El cliente fue modificado exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000319, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El cliente fue consultado exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000320, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El cliente fue registrado exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000321, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El dummy de cliente se generó exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000322, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El cliente fue eliminado exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000323, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El país fue modificado exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000324, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El país fue registrado exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000325, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El país fue consultado exitosamente"));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000326, TipoMensaje.USUARIO, CategoriaMensaje.ERROR,
				"El país fue eliminado exitosamente"));
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

