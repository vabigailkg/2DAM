package processBuilder;

import java.io.IOException;
import java.util.Map;

public class ProcessBuilderNotepad {

	public static void main(String[] args) {
		System.out.println("Vamos a lanzar el Notepad...");

		String infoProceso = "Notepad.exe";

		try {

			// Preparamos el Proceso
			ProcessBuilder processBuilder = new ProcessBuilder(infoProceso);

			// Si quisiéramos obtener información sobre el entorno de ejecución del proceso
			Map<String, String> environment = processBuilder.environment();
			System.out.println("Numero de Procesadores: " + environment.get("NUMBER_OF_PROCESSORS"));

			// Ejecutamos el Proceso
			Process proceso = processBuilder.start();

			// Si quisiéramos recoger el número de proceso
			System.out.println("El ID del proceso es " + proceso.pid());

			// Esperamos a que finalice el proceso. Cogemos el codigo de retorno
			int codigoRetorno = proceso.waitFor();
			System.out.println("Fin del Proceso con el codigo " + codigoRetorno);

		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
