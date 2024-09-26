package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Haz un programa que muestre los procesos en ejecución.
 */
public class Ejer4 {

	public static void main(String[] args) {
		// Le decimos que ejecute el cmd y le pasamos el comando con '/c'
		ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "tasklist");

		System.out.println("Ejecutando 'tasklist'...");

		try {
			// Ejecuta el proceso
			Process proceso = processBuilder.start();

			// Obtiene la señal de entrada del proceso (como el teclado) y la muestra
			InputStream entrada = proceso.getInputStream();
			System.out.println();

			// Leer y mostrar línea a línea
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entrada));
			String linea = null;
			while ((linea = bufferedReader.readLine()) != null)
				System.out.println(linea);
			entrada.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
