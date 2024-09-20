package ficheros_AccesoAleatorio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFicheroRASecuencial {

	public static void main(String[] args) throws IOException {
		// Declara el fichero de acceso aleatorio
		File fichero = new File("AleatorioEmple.dat");

		RandomAccessFile file = new RandomAccessFile(fichero, "r");

		int id, dep, posicion;

		Double salario;

		char apellido[] = new char[10], aux;

		posicion = 0; // para situarnos al principio

		while (file.getFilePointer() != file.length()) { // mientras el puntero no sea = al tamaño del fichero
			file.seek(posicion); // nos posicionamos en posicion
			id = file.readInt(); // obtengo id de empleado
			// recorro uno a uno los chars del apellido
			for (int i = 0; i < apellido.length; i++) {
				aux = file.readChar();
				apellido[i] = aux; // los voy guardando en el array
			}

			// convierto a String el array
			String apellidos = new String(apellido);
			dep = file.readInt(); // obtengo dep
			salario = file.readDouble(); // obtengo salario

			if (id > 0) {
				System.out.printf("ID: %s,Apellido: %s, Departamento:%d, Salario: %.2f %n", id, apellidos.trim(), dep,
						salario);
				// me posiciono para el sig empleado, cada empleado ocupa 36 bytes
				posicion = posicion + 36;

			}

		}
		// fin del bucle for
		file.close(); // cerrar fichero

	}

}
