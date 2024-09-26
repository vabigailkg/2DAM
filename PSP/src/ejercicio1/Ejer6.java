package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Programa que ejecuta un “.bat” previamente preparado y recoge la salida en un
 * archivo y los errores en otro.
 */
public class Ejer6 {

	// Declaramos las rutas de los ficheros
	public static final String RUTA_FICHERO_BAT = "C:\\EclipseFicheros\\Comandos.bat";
	public static final String RUTA_FICHERO_SALIDA = "C:\\EclipseFicheros\\Comandos.txt";
	public static final String RUTA_FICHERO_ERRORES = "C:\\EclipseFicheros\\Errores.txt";

	public static void main(String[] args) {

		// Preparamos el fichero .bat
		ProcessBuilder ficheroBat = new ProcessBuilder(RUTA_FICHERO_BAT);

		System.out.println("Ejecutando 'Comandos.bat'...");

		try {
			Process proceso = ficheroBat.start();

			// Recogemos con IS y leemos en BFR la salida y los errores del proceso
			InputStream salida = proceso.getInputStream();
			BufferedReader readerSalida = new BufferedReader(new InputStreamReader(salida));
			InputStream errores = proceso.getErrorStream();
			BufferedReader readerErrores = new BufferedReader(new InputStreamReader(errores));

			// Recogemos la salida y los errores en BFW y los llevamos a los ficheros
			BufferedWriter writerSalida = new BufferedWriter(new FileWriter(RUTA_FICHERO_SALIDA));
			BufferedWriter writerErrores = new BufferedWriter(new FileWriter("C:\\EclipseFicheros\\Errores.txt"));

			// Leemos los datos recogidos y los escribimos línea a línea en el fichero
			leerYEscribirFichero(readerSalida, writerSalida);
			leerYEscribirFichero(readerErrores, writerErrores);

			// Cerramos los streams
			readerSalida.close();
			readerErrores.close();
			writerSalida.close();
			writerErrores.close();
			System.out.println("Se ha actualizado 'Comandos.txt' y 'Errores.txt'.");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Método que lee y escribe el contenido leído de un BufferedReader en un
	 * archivo
	 * 
	 * @param reader Recibe un BF.
	 * @param writer Recibe un BW.
	 * @throws IOException
	 */
	private static void leerYEscribirFichero(BufferedReader reader, BufferedWriter writer) throws IOException {
		String linea;
		while ((linea = reader.readLine()) != null) {
			writer.write(linea);
			writer.newLine(); // Salto de línea
		}
	}
}
