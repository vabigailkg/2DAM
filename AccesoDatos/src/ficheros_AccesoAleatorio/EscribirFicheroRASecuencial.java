package ficheros_AccesoAleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class EscribirFicheroRASecuencial {

	public static void main(String[] args) throws IOException {
		File fichero = new File("AleatorioEmple.dat");

		// Declara el fichero de acceso aleatorio
		RandomAccessFile file = new RandomAccessFile(fichero, "rw");

		// Arrays con los datos
		String apellido[] = { "FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY" };
		int dep[] = { 10, 20, 10, 10, 30, 30, 20 };
		Double salario[] = { 1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0 };

		// Buffer para almacenar apellido siempre de 10 chars
		StringBuffer buffer = null;

		// Numero de elementos del array
		int n = apellido.length;

		// Recorro los arrays
		for (int i = 0; i < n; i++) {
			// Uso i+1 para identificar empleado
			file.writeInt(i + 1);
			buffer = new StringBuffer(apellido[i]);
			// 10 caracteres para el apellido
			buffer.setLength(10);
			// Insertar apellido
			file.writeChars(buffer.toString());
			// Insertar departamento
			file.writeInt(dep[i]);
			// Insertar salario
			file.writeDouble(salario[i]);
		}
		// Cerrar fichero
		file.close();

	}

}
