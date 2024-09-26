package processBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Para leer y/o mostrar en pantalla la señal del proceso.
 */
public class Ej_ProcessLeer {

	public static void main(String[] args) {
		ProcessBuilder pb = new ProcessBuilder("CMD");

		try {
			Process p = pb.start();
			System.out.println("parte 1");

			// mostramos en pantalla caracter a caracter
			InputStream is = p.getInputStream();
			System.out.println();

			int c;
			while ((c = is.read()) != -1)
				System.out.print((char) c);
			is.close();

			System.out.println("parte 2");

			// mostrar línea a línea
			InputStream er = p.getInputStream();
			BufferedReader brer = new BufferedReader(new InputStreamReader(er));

			String line = null;
			while ((line = brer.readLine()) != null)
				System.out.println(line);

			er.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
