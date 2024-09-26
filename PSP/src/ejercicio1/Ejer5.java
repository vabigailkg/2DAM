package ejercicio1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Haz un programa que detecte si el bloc de notas se está ejecutando y en caso
 * afirmativo cree un proceso que lo elimine de la ejecución (matar el proceso).
 */
public class Ejer5 {

	public static void main(String[] args) {
		// Preparamos el tasklist para ver los procesos
		ProcessBuilder tasklist = new ProcessBuilder("cmd", "/c", "tasklist");

		System.out.println("Ejecutando 'tasklist'...");

		// Guardamos el nombre del proceso en una variable
		String notepad = "notepad.exe";

		// Usamos un flag para avisar cuando se detecte el notepad
		boolean notepadDetectado = false;

		try {
			// Ejecuta el proceso
			Process proceso = tasklist.start();

			// Obtiene la salida del comando tasklist
			InputStream entrada = proceso.getInputStream();
			// La leemos línea a línea
			BufferedReader reader = new BufferedReader(new InputStreamReader(entrada));
			String linea;
			while ((linea = reader.readLine()) != null) {

				// Si encontramos "notepad.exe" en alguna línea, lo marcamos como encontrado
				if (linea.toLowerCase().contains(notepad)) {
					System.out.println("Se ha detectado el Notepad. Deteniendo el proceso...");

					// Matar el proceso (taskkill /IM notepad.exe /F)
					ProcessBuilder detector = new ProcessBuilder("cmd", "/c", "taskkill /IM notepad.exe /F");
					Process proceso2 = detector.start();

					System.out.println("El proceso Notepad ha sido detenido.");

					entrada.close();

					break;
				}
			}

			// Si no está ejecutándose, fuera del bucle comprobamos el flag y mostramos el
			// mensaje 1 vez
			if (notepadDetectado == false) {
				System.out.println("Notepad no está en ejecución.");
			}

			entrada.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
