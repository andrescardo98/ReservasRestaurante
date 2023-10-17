package co.edu.uco.reservasrestaurante.crosscutting.messages;

import java.util.HashMap;
import java.util.Map;


import co.edu.uco.reservasrestaurante.crosscutting.exception.concrete.CrossCuttingReservasRestauranteException;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CategoriaMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.CodigoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.messages.enumerator.TipoMensaje;
import co.edu.uco.reservasrestaurante.crosscutting.util.UtilObjeto;

public final class CatalogoMensajes {
	
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
				"Se ha presentado un problema tratando de validar si la conexión SQL estaba abierta. Se presentó una "
				+ "excepeción de SQLException. Por favor verifique la traza completa del error presentado, para así poder "
				+ "diagnosticar con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000006, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de validar si la conexión SQL estaba abierta. Se presentó una "
				+ "excepeción genérica de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder "
				+ "diagnosticar con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000007, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cerrar una conexión que está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000008, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cerrar una conexión que ya está cerrada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000009, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible validar si una conexión está abierta cuando es nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000010, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"Se ha presentado un problema tratando de cerrar una conexión SQL. Se presentó una excepeción de SQLException. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor "
				+ "certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000011, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de cerrar la conexión. Se presentó una excepeción genérica "
				+ "de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder "
				+ "diagnosticar con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000012, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible iniciar una transacción con una conexión que está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000013, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible iniciar una transaccion con una conexión cerrada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000014, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible iniciar una transaccion que ya ha sido iniciada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000015, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"Se ha presentado un problema tratando de iniciar la transacción de una conexión SQL. Se presentó una excepeción de SQLException. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor "
				+ "certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000016, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de iniciar una transacción de una conexión. Se presentó una excepeción genérica "
				+ "de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000017, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible confirmar una transacción con una conexión que está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000018, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible confirmar una transaccion con una conexión cerrada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000019, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible confirmar una transaccion que no fue iniciada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000020, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"Se ha presentado un problema tratando de confirmar la transacción de una conexión SQL. Se presentó una excepeción de SQLException. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor "
				+ "certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000021, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de confirmar la transacción de una conexión. Se presentó una excepeción genérica "
				+ "de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000022, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cancelar una transacción con una conexión que está nula..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000023, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cancelar una transaccion con una conexión cerrada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000024, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible cancelar una transaccion que no fue iniciada..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000025, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"Se ha presentado un problema tratando de cancelar la transacción de una conexión SQL. Se presentó una excepeción de SQLException. "
				+ "Por favor verifique la traza completa del error presentado, para así poder diagnosticar con mayor "
				+ "certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000026, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de cancelar la transacción de una conexión. Se presentó una excepeción genérica "
				+ "de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000027, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible abrir la conexión. Se ha presentado un prooblema SQL..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000028, TipoMensaje.TECNICO, CategoriaMensaje.FATAL, 
				"No es posible encontrar la clase para abrir la conexión..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000029, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado tratando de abrir la conexión. Se presentó una excepeción genérica "
				+ "de tipo Exception. Por favor verifique la traza completa del error presentado, para así poder diagnosticar "
				+ "con mayor certeza, qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000030, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de leer el archivo de configuración."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000031, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo IOException en la clase Configuración tratando de leer el archivo de configuración. "
				+ "Por favor revise la traza completa del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000032, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de registar la información del nuevo tipo de identificación."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000033, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método crear de la clase TipoIdentificacionSQLServer "
				+ "tratando de llevar a cabo el registro del nuevo Tipo de Identificación. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000034, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método crear de la clase TipoIdentificacionSQLServer "
				+ "tratando de llevar a cabo el registro del nuevo Tipo de Identificación. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000035, TipoMensaje.TECNICO, CategoriaMensaje.ERROR,
				"Se ha presentado un problema tratando de crear el DAO deseado, debido a que la conexiòn actualmente está cerrada, "
				+ "por lo que no hay una conexiòn vàlida disponible..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000036, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de actualizar la información del tipo de identificación deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000037, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método modificar de la clase TipoIdentificacionSQLServer "
				+ "tratando de llevar a cabo la actualización del Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000038, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método modificar de la clase TipoIdentificacionSQLServer "
				+ "tratando de llevar a cabo la actualización del Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000039, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de consultar la información del tipo de identificación por el identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000040, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método consultarPorID de la clase TipoIdentificacionSQLServer "
				+ "tratando de recuperar los datos de la consulta Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000041, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método consultarPorID de la clase TipoIdentificacionSQLServer "
				+ "tratando de preparar la sentencia SQL de la consulta del Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000042, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método consultarPorID de la clase TipoIdentificacionSQLServer "
				+ "tratando de preparar la sentencia SQL de la consulta del Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000043, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de eliminar la información del tipo de identificación por el identificador deseado."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000044, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método eliminar de la clase TipoIdentificacionSQLServer "
				+ "tratando de llevar a cabo la eliminación del Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000045, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método eliminar de la clase TipoIdentificacionSQLServer "
				+ "tratando de llevar a cabo la eliminación del Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000046, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método consultarPorID de la clase TipoIdentificacionSQLServer "
				+ "tratando de recuperar los datos de la consulta Tipo de Identificación deseado. Por favor revise la traza completa "
				+ "del problema presentado para así poder identificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000047, TipoMensaje.USUARIO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema tratando de llevar a cabo la consulta de los Tipos de Identificación..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000048, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método prepararEjecutarSentenciaConsulta "
				+ "de la clase TipoIdentificacionSQLServerDAO tratando de preparar la sentencia SQL. Por favor revise "
				+ "la traza completa del problema presentado, con el fin de verificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000049, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método prepararEjecutarSentenciaConsulta "
				+ "de la clase TipoIdentificacionSQLServerDAO tratando de preparar la sentencia SQL. Por favor revise "
				+ "la traza completa del problema presentado, con el fin de verificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000050, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método colocarParametrosConsulta "
				+ "de la clase TipoIdentificacionSQLServerDAO tratando de colocar los parámetros de la consulta SQL. "
				+ "Por favor revise la traza completa del problema presentado, con el fin de verificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000051, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método colocarParametrosConsulta "
				+ "de la clase TipoIdentificacionSQLServerDAO tratando de colocar los parámetros de la consulta SQL. "
				+ "Por favor revise la traza completa del problema presentado, con el fin de verificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000052, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema de tipo SQLException en el método ejecutarConsulta de la clase "
				+ "TipoIdentificacionSQLServerDAO tratando de ejecutar la consulta SQL. Por favor revise la traza completa "
				+ "del problema presentado, con el fin de verificar qué sucedió..."));
		
		agregarMensaje(Mensaje.crear(CodigoMensaje.M00000053, TipoMensaje.TECNICO, CategoriaMensaje.ERROR, 
				"Se ha presentado un problema inesperado de tipo Exception en el método ejecutarConsulta de la "
				+ "clase TipoIdentificacionSQLServerDAO tratando de ejecutar la consulta SQL. Por favor revise la traza "
				+ "completa del problema presentado, con el fin de verificar qué sucedió..."));
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
