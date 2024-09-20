package ficheros_Binario;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ej_FileInputStream {

	public static void main(String[] args) throws IOException {
		File fichero = new File("FichBytes.dat"); // Declaración de fichero
		FileInputStream fic = new FileInputStream(fichero); // Declaración de stream
		int i;
		while ((i = fic.read()) != -1) {
			System.out.println(i);
		}
		fic.close();

	}
}
