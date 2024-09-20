package es;

import java.io.File;

/**
 * Esta clase simula un proceso principal que, ejecuta al proceso secundario
 * (exec) y se queda esperando a que termine (waitFor). Se recoge el valor
 * de finalización y se evalúa para tomar una decisión.
 */
public class ProcesoPrincipal {

	public static void main(String[] args) {
		System.out.println("Ejecutamos el proceso secundario...");

		try {
			//Con ProcessBuilder
			ProcessBuilder builder;

			builder = new ProcessBuilder("java", "es.ProcesoSecundario");
			builder.directory(new File("bin"));
			Process process = builder.start();

			//Esperamos a que termine (se bloquea la ejecución del proceso principal)
			int valorRetorno = process.waitFor();

			//¿Qué ocurre con el proceso secundario?
			if (valorRetorno == 0) {
				System.out.println("Proceso secundario finalizado con exito");

			} else {
				System.out.println("El proceso secundario ha fallado");
				System.out.println("Codigo de error: " + valorRetorno);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
