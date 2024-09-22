package ficherosDeTexto.ejericioCuatro;

import java.util.Scanner;
import java.util.prefs.Preferences;

/**
 * Crea un programa que permita: <br>
 * - Escribir en un fichero tus videojuegos favoritos.<br>
 * - Mostrar el listado de juegos del fichero.<br>
 * - Añadir un juego al final del fichero.<br>
 * - Buscar un videojuego por título.<br>
 * - Buscar todos los videojuegos de una empresa concreta.<br>
 * - Borrar un videojuego concreto del fichero. <br>
 * - Al arrancarse, el programa pregunta qué fichero quiere abrir. El usuario le
 * da la ruta donde está ese fichero. Si no puede abrirlo o hay cualquier
 * problema, le da un error.<br>
 * - El programa ‘recuerda’ cuál es el último fichero que ha abierto, y lo abre
 * por de fecto si existe. Obviamente, el usuario siempre puede escoger abrir
 * otro fichero.<br>
 * 
 * Cada videojuego tiene que tener un titulo, una empresa y una fecha de
 * edición. Cada videojuego se guardara como una linea de texto en el fichero;
 * por tanto, si hay cinco ficheros habra cinco lineas de texto.
 * 
 * NOTA: el truco es darse cuenta de que tiene que haber LO MISMO en el array de
 * videojuegos que en el fichero.
 */
public class GestorDeVideojuegos {

	private Scanner teclado = null;
	private String[] videojuegos = null;

	// Para manejar los ficheros de texto
	private ManejadorFicherosTexto manejadorFicherosTexto = null;

	public static final int MAX_VIDEOJUEGOS = 20;
	public static final String NOMBRE_FICHERO_DEFAULT = "videojuegos.txt";
	public static final String RUTA_FICHERO_DEFAULT = "c://Trastero//";

	// Usamos este nombre. El de arriba es el de por defecto
	public String nombreFichero = null;

	// Vamos a guardar cosas en las Preferencias del Sistema de Windows...
	private Preferences preferences = null;

	public GestorDeVideojuegos() {
		teclado = new Scanner(System.in);

		// Usamos las preferences para guardar info
		// ¿Tenemos abierto un fichero por defecto? Entonces, debería haber algo en
		// LAST_FILE_OPENED. Si no, que devuelva null
		preferences = Preferences.userRoot();
		nombreFichero = preferences.get("LAST_FILE_OPENED", null);
	}

	private void run() {
		int opcion = 0;

		if (null == nombreFichero) {
			// No había nada en el Preferences, osea, que nos tiene que decir el usuario qué
			// fichero abrir

			// Este es un buen uso de static... usar una funcion pequeña
			// que no modifica nada sin que tengas que instanciar el objeto
			String nuevoFichero = opcionNuevoFichero();
			nombreFichero = ManejadorFicherosTexto.ifFileExist(RUTA_FICHERO_DEFAULT + nuevoFichero) ? nuevoFichero
					: NOMBRE_FICHERO_DEFAULT;

			// Ya tenemos el fichero que me ha dicho el usuario...
			// Guardamos en el preferences el fichero
			preferences.put("LAST_FILE_OPENED", nombreFichero);

		} else {
			// Si llega hasta aquí es que había algo en el Preferences...
			// y no hace falta pedir nada al usuario
		}

		manejadorFicherosTexto = new ManejadorFicherosTexto(nombreFichero, RUTA_FICHERO_DEFAULT, MAX_VIDEOJUEGOS);

		// Carga inicial del array
		videojuegos = manejadorFicherosTexto.cargarVideojuegosDelFichero();
		System.out.println("Bienvenido. " + numeroVideojuegos() + " se han leido del fichero " + nombreFichero);

		do {
			opcion = opcionMenuInicial();
			if (opcion != 0) {
				ejecutarOpcionMenuInicial(opcion);
			}
		} while (opcion != 0);
	}

	private String opcionNuevoFichero() {
		System.out.println(" ");
		System.out.println("Directorio de trabajo: " + RUTA_FICHERO_DEFAULT);
		System.out.print("Fichero a abrir: ");
		return teclado.nextLine();
	}

	private int opcionMenuInicial() {
		int ret = 0;
		do {
			try {
				escribirMenuInicial();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) && (ret > 6));
		return ret;
	}

	private void escribirMenuInicial() {
		System.out.println(" ");
		System.out.println("---- MENU ----");
		System.out.println("---- 0 - SALIR ");
		System.out.println("---- 1 - Añadir videojuegos  ");
		System.out.println("---- 2 - Mostrar videojuegos ");
		System.out.println("---- 3 - Añadir videjouego al final ");
		System.out.println("---- 4 - Buscar videjouego por titulo ");
		System.out.println("---- 5 - Buscar videjouegos por empresa");
		System.out.println("---- 6 - Borrar videojuego ");
		System.out.println("--------------");
	}

	private void ejecutarOpcionMenuInicial(int opcion) {
		switch (opcion) {
		case 0:
			System.out.print("Adios!!!");
			break;
		case 1:
			introducirVideojuegosEnArray();
			manejadorFicherosTexto.guardarVideojuegosEnElFichero(videojuegos);
			// Tanto el array como el fichero tienen lo mismo. Todo OK!
			// Date cuenta de que guardarVideojuegosEnElFichero() reescribe el fichero
			// siempre, pero como le metemos todo el rato el array, no se nota
			break;
		case 2:
			videojuegos = manejadorFicherosTexto.cargarVideojuegosDelFichero();
			mostrarVideojuegos();
			// No nos fiamos de que haya lo mismo en el array que el fichero, asi que
			// refrescamos el array con lo que haya en el fichero
			break;
		case 3:
			String nuevoVideojuego = nuevoVideojuego();
			manejadorFicherosTexto.guardarVideojuegoEnElFicheroAlFinal(nuevoVideojuego);

			// Hecho... pero como NO tenemos lo mismo en el array que en el fichero, hay que
			// refrescar el array
			videojuegos = manejadorFicherosTexto.cargarVideojuegosDelFichero();

			// Ya esta...
			break;
		case 4:
			// NO NECESITAMOS buscarlo en el fichero. Tenemos el array actualizado con lo
			// mismo que en el fichero. Pero vamos... porque se supone que trabajamos con
			// ficheros...

			String titulo = pedirTituloVideojuego();
			videojuegos = manejadorFicherosTexto.cargarVideojuegosDelFichero();
			String videojuego = buscarVideojuegoPorTitulo(titulo);
			if (null == videojuego) {
				System.out.print("El videojuego " + titulo + " no existe");
			} else {
				mostrarVideojuego(videojuego);
			}
			break;
		case 5:
			// NO NECESITAMOS buscarlo en el fichero. Tenemos el array actualizado con lo
			// mismo que en el fichero. Pero vamos... porque se supone que trabajamos con
			// ficheros...

			String empresa = pedirEmpresaVideojuego();
			String[] juegos = buscarVideojuegosPorEmpresa(empresa);
			mostrarVideojuegos(juegos);
			break;
		case 6:

			// Vamos a hacer trampas...
			// Buscamos primero en el array el juego...
			String tituloABorrar = pedirTituloVideojuego();
			videojuegos = manejadorFicherosTexto.cargarVideojuegosDelFichero();
			String videojuegoABorrar = buscarVideojuegoPorTitulo(tituloABorrar);
			if (null == videojuegoABorrar) {
				System.out.print("El videojuego " + tituloABorrar + " no existe");
			} else {

				// En vez de hacer movidas extrañas para borrarlo del fichero, simplemente lo
				// borramos del array
				eliminarVideojuegos(videojuegoABorrar);

				// Ahora machacamos el fichero con el array
				manejadorFicherosTexto.guardarVideojuegosEnElFichero(videojuegos);

				// -----------------
				// Otra forma de hacerlo es: eliminas del array lo que no quieras, creas un
				// fichero temporal con el array, borras el fichero y luego renombras el
				// temporal
				//
				// Esta forma es un poco retorcida... pero funciona.
				// -----------------
			}

			break;
		}
	}

	/**
	 * Pide al usuario videojuegos hasta que decide no seguir introduciendo nuevos
	 * 
	 */
	private void introducirVideojuegosEnArray() {
		boolean choice = false;
		do {
			String nuevoVideojuego = nuevoVideojuego();
			añadirVideojuegoEnArray(nuevoVideojuego);
			System.out.println("");
			System.out.print("Desea seguir introduciendo videojuegos? [S/N]: ");
			choice = (teclado.nextLine().trim().charAt(0) + "").equalsIgnoreCase("S") ? true : false;
		} while (choice);
	}

	/**
	 * Pide al usuario un videojuego y lo retorna
	 * 
	 * @return el videojuego
	 */
	private String nuevoVideojuego() {
		String ret = "";
		System.out.println("Nuevo videojuego: ");
		System.out.print("Titulo: ");
		ret += teclado.nextLine() + "-";
		System.out.print("Empresa: ");
		ret += teclado.nextLine() + "-";
		System.out.print("Fecha: ");
		ret += teclado.nextLine();
		return ret;
	}

	/**
	 * Pide al usuario un titulo de videojuego
	 * 
	 * @return el titulo
	 */
	private String pedirTituloVideojuego() {
		String ret = "";
		System.out.print("Titulo: ");
		ret += teclado.nextLine().trim();
		return ret;
	}

	/**
	 * Pide al usuario una empresa de videojuego
	 * 
	 * @return la empresa
	 */
	private String pedirEmpresaVideojuego() {
		String ret = "";
		System.out.print("Empresa: ");
		ret += teclado.nextLine().trim();
		return ret;
	}

	/**
	 * Muestra todos los videjouegos del array
	 */
	private void mostrarVideojuegos() {
		mostrarVideojuegos(videojuegos);
	}

	/**
	 * Muestra todos los videjouegos pasados por parametro
	 * 
	 * @param juegos
	 */
	private void mostrarVideojuegos(String[] juegos) {
		for (int i = 0; i < juegos.length; i++) {
			if (juegos[i] != null) {
				System.out.println("");
				mostrarVideojuego(juegos[i]);
			}
		}
	}

	/**
	 * Muestra un videojuego
	 * 
	 * @param videojuego
	 */
	private void mostrarVideojuego(String videojuego) {
		String texts[] = videojuego.split("-");
		System.out.println("Videojuego: ");
		System.out.println("Titulo: " + texts[0]);
		System.out.println("Empresa: " + texts[1]);
		System.out.println("Fecha: " + texts[2]);
	}

	/**
	 * Añade un videojuego en un huevo libre del array. Si no hay hueco, informa al
	 * usuario y no lo introduce.
	 * 
	 * @param nuevoVideojuego
	 * @return El array de videojuegos
	 */
	private String[] añadirVideojuegoEnArray(String nuevoVideojuego) {
		int i = 0;
		for (i = 0; i < MAX_VIDEOJUEGOS; i++) {
			if (videojuegos[i] == null) {
				videojuegos[i] = nuevoVideojuego;
				break;
			}
		}

		if (i == MAX_VIDEOJUEGOS) {
			System.out.println("No hay huecos en el array. El videojuego no se guardara");
		}

		return videojuegos;
	}

	/**
	 * Retorna el videojuego buscado por titulo, o null si no lo encuentra en el
	 * array
	 * 
	 * @param titulo
	 * @return el videojuego
	 */
	private String buscarVideojuegoPorTitulo(String titulo) {
		String ret = null;
		for (int i = 0; i < MAX_VIDEOJUEGOS; i++) {
			if ((videojuegos[i] != null) && (seTitula(videojuegos[i], titulo))) {
				ret = videojuegos[i];
				break;
			}
		}
		return ret;
	}

	/**
	 * Retorna los videojuegos buscado por empresa, o un array vacio si no hay
	 * ninguno
	 * 
	 * @param empresa
	 * @return los videojuegos
	 */
	private String[] buscarVideojuegosPorEmpresa(String empresa) {
		String[] ret = new String[MAX_VIDEOJUEGOS];
		int cont = 0;
		for (int i = 0; i < MAX_VIDEOJUEGOS; i++) {
			if ((videojuegos[i] != null) && (esDeLaEmpresa(videojuegos[i], empresa))) {
				ret[cont] = videojuegos[i];
				cont++;
			}
		}
		return ret;
	}

	/**
	 * Retorna true si el videojuego contiene el titulo pasado, false en cualquier
	 * otro caso
	 * 
	 * @param videojuego
	 * @param titulo
	 * @return true o false
	 */
	private boolean seTitula(String videojuego, String titulo) {
		return ((videojuego.split("-"))[0].equals(titulo) ? true : false);
	}

	/**
	 * Retorna true si el videojuego contiene la empresa pasado, false en cualquier
	 * otro caso
	 * 
	 * @param videojuego
	 * @param empresa
	 * @return true o false
	 */
	private boolean esDeLaEmpresa(String videojuego, String empresa) {
		return ((videojuego.split("-"))[1].equals(empresa) ? true : false);
	}

	/**
	 * Retorna el numero de videojuegos en el array. Basicamente, el numero de
	 * posiciones no nulas del array, dado que null significa 'vacio'.
	 * 
	 * @return Numero de videojuegos
	 */
	private int numeroVideojuegos() {
		int ret = 0;
		for (int i = 0; i < MAX_VIDEOJUEGOS; i++) {
			if (videojuegos[i] != null)
				ret++;
		}
		return ret;
	}

	/**
	 * Elimina un videojuego del array
	 * 
	 * @param videojuegoABorrar
	 */
	private void eliminarVideojuegos(String videojuegoABorrar) {
		for (int i = 0; i < MAX_VIDEOJUEGOS; i++) {
			if ((videojuegos[i] != null) && (videojuegoABorrar.equals(videojuegos[i]))) {
				videojuegos[i] = null;
				break;
			}
		}
	}

	public static void main(String[] args) {
		(new GestorDeVideojuegos()).run();
	}
}
