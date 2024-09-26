package ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Haz un programa que llame a otro que envíe una cadena de caracteres y muestre
 * el texto.
 * 
 * Para ello, primero se creará un programa que llama a “EjemploLectura” que
 * recoge una cadena de caracteres y escribe el resultado.
 * 
 * Una vez que el programa funcione, probaremos que se ejecuta en el cmd (Ir al
 * directorio del .java y en el terminal usar javac EjemploLectura.java -debo
 * tener el jdk instalado, así compilaremos el .java-, luego usaremos java
 * EjemploLectura.java para ejecutarlo)
 * 
 * Después, crearemos otro programa que llame Ejer7.
 * 
 * Este programa pedirá un texto al usuario y lo enviará al programa
 * EjemploLectura.
 * 
 * Se recogerá la salida y se mostrará por pantalla.
 * 
 */
public class Ejer7 {

	private static Scanner teclado = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Ejecutando 'EjemploLectura' en el terminal...");

		try {
			// Le decimos que queremos ejecutar 'EjemploLectura' (comando, ruta)
			ProcessBuilder pb = new ProcessBuilder("java", "ejercicio1.EjemploLectura");
			pb.directory(new File("bin")); // La carpeta donde está el .class de EjemploLectura

			// Iniciamos
			Process proceso = pb.start();

			System.out.print("Escribe lo que quieras: ");
			String input = teclado.nextLine();

			// Enviamos el texto a 'EjemploLectura'
			OutputStream salidaProceso = proceso.getOutputStream();
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(salidaProceso));
			writer.write(input);
			writer.newLine();
			writer.flush(); // Aseguramos que se envía el texto
			writer.close();

			// Recogemos la salida (bytes) de 'EjemploLectura' y la leemos con BFR
			InputStream entradaProceso = proceso.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(entradaProceso));

			System.out.println("Salida del programa 'EjemploLectura': ");
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea);
			}

			// Esperamos a que el proceso termine
			int valorRetorno = proceso.waitFor();

			// Comprobamos si terminó correctamente
			if (valorRetorno == 0) {
				System.out.println("'EjemploLectura' finalizado con éxito.");
			} else {
				System.out.println("'EjemploLectura' ha fallado. Código de error: " + valorRetorno);
			}

			// Cerramos streams
			reader.close();
			teclado.close();

			// Ahora deberíamos compilar los dos programas (javac
			// ejercicio1/EjemploLectura.java ejercicio1/Ejer7.java)
			// Luego ejecutar el Ejer7 (java java ejercicio1.Ejer7)

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
