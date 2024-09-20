package ejercicio1;

import java.io.IOException;
import java.io.InputStream;

/**
 * Haz un programa que obtenga la dirección MAC y la muestre por pantalla
 * 
 * NOTA: Como es lo mismo que el Ejer2, hago que lo muestre línea a línea para hacer
 * algo diferente.
 */
public class Ejer3 {

	public static void main(String[] args) {
		// tasklist

		// Le decimos que ejecute el cmd y le pasamos el comando con '/c'
		ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "getmac");

		System.out.println("Ejecutando 'getmac'...");

		try {
			// Ejecuta el proceso
			Process proceso = processBuilder.start();

			// Obtiene la señal de entrada del proceso (como el teclado) y la muestra
			InputStream entrada = proceso.getInputStream();
			System.out.println();

//			//
//			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entrada));
//
//			String linea = null;
//			while ((linea = bufferedReader.readLine()) != null)
//				System.out.println(linea);

			entrada.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
