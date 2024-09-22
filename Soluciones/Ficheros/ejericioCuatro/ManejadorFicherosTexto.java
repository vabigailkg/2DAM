package ficherosDeTexto.ejericioCuatro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Maneja los ficheros de texto
 */
public class ManejadorFicherosTexto {

	private int maxVideojuegos = 0;
	private String nombreFichero = null;
	private String rutaFichero = null;

	/**
	 * Impedimos que nadie use el constructor por defecto
	 */
	@SuppressWarnings("unused")
	private ManejadorFicherosTexto() {
	}

	/**
	 * Constructor sobrecargado
	 * 
	 * @param nombreFichero
	 * @param rutaFichero
	 * @param maxVideojuegos
	 */
	public ManejadorFicherosTexto(String nombreFichero, String rutaFichero, int maxVideojuegos) {
		this.nombreFichero = nombreFichero;
		this.rutaFichero = rutaFichero;
		this.maxVideojuegos = maxVideojuegos;
	}

	/**
	 * Carga todos los videojuegos del fichero en el array. Si el fichero no existe,
	 * esta vacio o hay cualquier problema, el array se pone entero a null
	 */
	public String[] cargarVideojuegosDelFichero() {
		String[] ret = new String[maxVideojuegos];

		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		file = new File(rutaFichero + nombreFichero);
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);
			int leidos = 0;
			String linea;
			while ((linea = bufferedReader.readLine()) != null) {
				ret[leidos] = linea;
				leidos++;
			}
		} catch (FileNotFoundException e) {
			// El fichero no existe. Solucion? Informamos al usuario y seguimos adelante
			System.out.println("El fichero " + rutaFichero + nombreFichero + " no existe");
		} catch (IOException e) {
			// Problemas con el fichero. Solucion? Informamos al usuario y seguimos adelante
			System.out.println("Error de lectura del fichero " + rutaFichero + nombreFichero);
		} catch (Exception e) {
			// Fallo de otro tipo. Solucion? Resetear el array, informamos al usuario y
			// seguimos adelante. Es posible que esto pase si metemos en el array mas
			// Strings de lo debido...
			ret = new String[maxVideojuegos];
			System.out.println("Error desconocido en la lectura del fichero " + rutaFichero + nombreFichero);
		} finally {
			try {
				if (null != bufferedReader)
					bufferedReader.close();
			} catch (IOException e) {
				// Nos da igual
			}
			try {
				if (null != fileReader)
					fileReader.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}
		return ret;
	}

	/**
	 * Guarda los videojuegos del fichero en el array. Si el fichero no existe, lo
	 * crea. El fichero es reescrito por entero, y se pierde todo lo que habia antes
	 * en el. Si hay cualquier problema, se informa al usuario y no se hace nada.
	 * 
	 * @param videojuegos
	 */
	public void guardarVideojuegosEnElFichero(String[] videojuegos) {

		// Preparamos las clases necesarias para escribir un fichero
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;

		try {
			fileWriter = new FileWriter(rutaFichero + nombreFichero);
			printWriter = new PrintWriter(fileWriter);

			for (int i = 0; i < videojuegos.length; i++) {
				if (videojuegos[i] != null)
					printWriter.println(videojuegos[i]);
			}

		} catch (IOException e) {
			// Problemas con el fichero. Solucion? Informamos al usuario y seguimos adelante
			System.out.println("Error de escritura en el fichero " + rutaFichero + nombreFichero);
		} catch (Exception e) {
			// Fallo de otro tipo. Solucion? Informamos al usuario y seguimos adelante
			System.out.println("Error desconocido en la escritura del fichero " + rutaFichero + nombreFichero);
		} finally {
			if (null != printWriter)
				printWriter.close();
			try {
				if (null != fileWriter)
					fileWriter.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}
	}

	/**
	 * Guarda un videojuego nuevo en el fichero al final. Si el fichero no existe,
	 * lo crea. El fichero NO es reescrito por entero, se mantiene lo que habia
	 * antes. Si hay cualquier problema, se informa al usuario y no se hace nada.
	 * 
	 * @param videojuego
	 */
	public void guardarVideojuegoEnElFicheroAlFinal(String videojuego) {

		// Preparamos las clases necesarias para escribir un fichero
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;

		try {
			fileWriter = new FileWriter(rutaFichero + nombreFichero, true);
			printWriter = new PrintWriter(fileWriter);
			printWriter.println(videojuego);
		} catch (IOException e) {
			// Problemas con el fichero. Solucion? Informamos al usuario y seguimos adelante
			System.out.println("Error de escritura en el fichero " + rutaFichero + nombreFichero);
		} catch (Exception e) {
			// Fallo de otro tipo. Solucion? Informamos al usuario y seguimos adelante
			System.out.println("Error desconocido en la escritura del fichero " + rutaFichero + nombreFichero);
		} finally {
			if (null != printWriter)
				printWriter.close();
			try {
				if (null != fileWriter)
					fileWriter.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}
	}

	/**
	 * Retorna true si el fichero existe, false en cualquier otro caso
	 * 
	 * @param filepath
	 * @return True o False
	 */
	public static boolean ifFileExist(String filepath) {
		boolean ret = false;
		try {
			File file = new File(filepath);
			if (file.getAbsoluteFile().exists() && !file.isDirectory()) {
				ret = true;
			}
		} catch (Exception e) {
			// Algo ha ido mal... luego no existe
		}
		return ret;
	}
}
