package ficheros_AccesoAleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFicheroRARegistro {

	public static void main(String[] args) throws IOException {
		// Declara el fichero de acceso aleatorio
		File fichero = new File("AleatorioEmple.dat");

		RandomAccessFile file = new RandomAccessFile(fichero, "rw");

		StringBuffer buffer = null;

		String apellido = "KLIE";

		Double salario = 1230.87;

		int dep = 10;

		int id = 2; // La posicion que queremos para escribir el apellido

		long posicion = (id - 1) * 36; // Calculamos la posicion 2

		file.seek(posicion); // Situamos el puntero ahí

		file.writeInt(id); // Uso id para identificar empleado
		buffer = new StringBuffer(apellido);
		buffer.setLength(10); // 10 caracteres para el apellido
		file.writeChars(buffer.toString()); // Insertar apellido
		file.writeInt(dep);
		file.writeDouble(salario); // insertar salario
		file.close();

	}

}
