package ejercicio1;

import java.io.IOException;
import java.io.InputStream;

/**
 * Ejecutar un comando de windows. (ipconfig) y mostrar su resultado por
 * pantalla.
 */
public class Ejer2 {

	public static void main(String[] args) {
		// Le decimos que ejecute el cmd y le pasamos el comando con '/c'
		ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "ipconfig");

		System.out.println("Ejecutando 'ipconfig'...");

		try {
			// Ejecuta el proceso
			Process proceso = processBuilder.start();

			// Obtiene la señal de entrada del proceso (como el teclado) y la muestra
			InputStream entrada = proceso.getInputStream();
			System.out.println();

			// Lee la entrada en ASCII, la convierte en char para que sea legible, la
			// imprime 1 a 1
			int caracter;
			while ((caracter = entrada.read()) != -1)
				System.out.print((char) caracter);

			entrada.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
