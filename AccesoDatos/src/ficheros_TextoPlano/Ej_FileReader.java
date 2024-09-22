package ficheros_TextoPlano;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Ej_FileReader {

	public static void main(String[] args) throws IOException {
		File fichero = new File("Fichero1.txt"); // declarar fichero
		FileReader fic = new FileReader(fichero); // crear el flujo de entrada
		int i;
		// se va leyendo un caracter
		while ((i = fic.read()) != -1) {
			System.out.println((char) i + "==>" + i);
		}

		fic.close(); // cerrar fichero

	}

}
