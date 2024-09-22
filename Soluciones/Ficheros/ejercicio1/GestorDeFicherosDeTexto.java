package ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Lee y escribe ficheros de texto
 */
public class GestorDeFicherosDeTexto {

	private static final String NOMBRE_FICHERO = "ejemplo.txt";
	private static final String RUTA_FICHERO = "c://Trastero//";

	/**
	 * Escribe un texto pasado por parametro en el fichero
	 * 
	 * @param texto
	 */
	public void guardarTextoEnFichero(String texto) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(RUTA_FICHERO + NOMBRE_FICHERO);
			printWriter = new PrintWriter(fileWriter);
			printWriter.println(texto);
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

	/**
	 * Abre el fichero y retorna su contenido; o null si el fichero no existe o está
	 * vacio
	 * 
	 * @return El texto o null
	 */
	public String abrirFicheroDeTexto() {
		String ret = null;

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
					ret = new String ();
				ret = ret + linea + "\n";
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

	/**
	 * Añade un texto al final del fichero
	 * 
	 * @param textoAActualizar
	 */
	public void actualizarFichero(String textoAActualizar) {
		FileWriter fileWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(RUTA_FICHERO + NOMBRE_FICHERO, true);
			printWriter = new PrintWriter(fileWriter);
			printWriter.println(textoAActualizar);
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
