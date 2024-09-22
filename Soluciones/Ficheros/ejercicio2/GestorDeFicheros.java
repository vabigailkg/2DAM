package ejercicio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Lee y escribe ficheros de texto
 */
public class GestorDeFicheros {

	private static final String NOMBRE_FICHERO = "ejemplo.txt";
	private static final String RUTA_FICHERO = "c://Trastero//";
	
	public void escribirVideojuegosEnFichero(ArrayList<Videojuego> videojuegos) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(RUTA_FICHERO + NOMBRE_FICHERO);
			printWriter = new PrintWriter(fileWriter);
			
			for (Videojuego videojuego : videojuegos) {
				printWriter.println(videojuego.toString());	
			}
			
		} catch (IOException e) {
			System.out.println("IOException - Error de escritura en el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} catch (Exception e) {
			System.out.println("Exception - Error de escritura en el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} finally {
			printWriter.close();
			try {
				fileWriter.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}
	}

	public ArrayList<String> leerVideojuegosDelFichero() {
		ArrayList<String> ret = null;

		File file = null;
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		file = new File(RUTA_FICHERO + NOMBRE_FICHERO);
		try {
			fileReader = new FileReader(file);
			bufferedReader = new BufferedReader(fileReader);

			String linea;
			while ((linea = bufferedReader.readLine()) != null) {
				if (null == ret)
					ret = new ArrayList<String> ();
				ret.add(linea);
			}

		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException - El fichero " + RUTA_FICHERO + NOMBRE_FICHERO + " no existe");
		} catch (IOException e) {
			System.out.println("IOException - Error de lectura del fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} catch (Exception e) {
			System.out.println("Exception - Error de lectura del fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				// Nos da igual
			}
			try {
				fileReader.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}
		return ret;
	}

	public void aniadirVideojuegosEnFichero(ArrayList<Videojuego> videojuegos) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(RUTA_FICHERO + NOMBRE_FICHERO);
			printWriter = new PrintWriter(fileWriter, true);
			
			for (Videojuego videojuego : videojuegos) {
				printWriter.println(videojuego.toString());	
			}
			
		} catch (IOException e) {
			System.out.println("IOException - Error de escritura en el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} catch (Exception e) {
			System.out.println("Exception - Error de escritura en el fichero " + RUTA_FICHERO + NOMBRE_FICHERO);
		} finally {
			printWriter.close();
			try {
				fileWriter.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}
	}

	
}
