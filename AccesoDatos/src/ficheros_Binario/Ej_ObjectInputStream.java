package ficheros_Binario;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class Ej_ObjectInputStream {

	public static void main(String[] args) {

		Persona persona; // defino la variable persona
		File fichero = new File("FichPersona.dat");
		FileInputStream fi = new FileInputStream(fichero);
		ObjectInputStream dataIS = new ObjectInputStream(fi);

		int i = 1;
		try {
			while (fi.getChannel().position() < fi.getChannel().size()) // lectura del fichero
			{
				persona = (Persona) dataIS.readObject(); // leer una Persona
				System.out.print(i + "=>");
				i++;
				System.out.printf("Nombre: %s, edad: %d %n", persona.getNombre(), persona.getEdad());
			}
		} catch (EOFException eo) {
			System.out.println("FIN DE LECTURA.");
		} catch (StreamCorruptedException x) {

		}

		dataIS.close(); // cerrar stream de entrada
	}

}
