package ficheros_TextoPlano;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Ej_BufferedWriter {

	public static void main(String[] args) {
		try {
			BufferedWriter fichero = new BufferedWriter(new FileWriter("FichTexto1.txt"));
			for (int i = 1; i < 11; i++) {
				fichero.write("Fila numero: " + i); // escribe una línea
				fichero.newLine(); // escribe un salto de línea
			}
			fichero.close();
		} catch (FileNotFoundException fn) {
			System.out.println("No se encuentra el fichero");
		} catch (IOException io) {
			System.out.println("Error de E/S");
		}

	}

}
