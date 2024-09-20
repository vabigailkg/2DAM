package ejercicio1;

import java.io.IOException;

/**
 * Ejecutar una aplicación de Windows (Paint)
 */
public class Ejer1 {

	public static void main(String[] args) {
		System.out.println("Lanzando Paint...");

		String ejecutable = "mspaint.exe";

		try {
			// Le pasamos el proceso que queremos arrancar al builder
			ProcessBuilder processBuilder = new ProcessBuilder(ejecutable);

			// Arrancamos el proceso
			processBuilder.start();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
