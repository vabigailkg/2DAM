package ejercicio1;

import java.util.Scanner;

public class EjemploLectura {

	public static void main(String[] args) {
		// Leemos el teclado
		Scanner teclado = new Scanner(System.in);

		// Pedimos un string
		System.out.print("Escribe lo que quieras: ");
		String input = teclado.nextLine();

		// Mostramos el string en la consola
		System.out.println("El texto que has ingresado es: " + input);

		// Cerramos el scanner
		teclado.close();
	}

}
