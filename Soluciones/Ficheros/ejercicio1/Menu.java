package ejercicio1;

import java.util.Scanner;

/**
 * Clase que muestra el menu de opciones, lee del teclado, y muestra resultados
 * por pantalla los resultados
 */
public class Menu {

	private Scanner teclado = null;
	private GestorDeFicherosDeTexto gestorDeFicherosDeTexto = null;

	public Menu() {
		teclado = new Scanner(System.in);
		gestorDeFicherosDeTexto = new GestorDeFicherosDeTexto();
	}

	private int escribirMenu() {
		int ret = 0;
		do {
			try {
				pintarMenu();
				System.out.print("Escoge una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				System.out.println("Error!!! Opcion incorrecta");
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) || (ret > 3));
		return ret;
	}

	private void pintarMenu() {
		System.out.println(" ");
		System.out.println("- Menu Inicial -");
		System.out.println("----------------");
		System.out.println("1. Escribir fichero");
		System.out.println("2. Mostrar todo el fichero");
		System.out.println("3. Añadir al final");
		System.out.println("0. Salir");
		System.out.println(" ");
	}

	public void mostrarMenu() {
		int opcionMenu = 0;

		do {
			opcionMenu = escribirMenu();

			switch (opcionMenu) {
			case 0:
				System.out.println("Adios !!!");
				break;
			case 1:
				String texto = leerDeTeclado();
				gestorDeFicherosDeTexto.guardarTextoEnFichero(texto);
				System.out.println("Fichero escrito...");
				break;
			case 2:
				String textoLeido = null;
				textoLeido = gestorDeFicherosDeTexto.abrirFicheroDeTexto();
				System.out.println("El contenido es: " + textoLeido);
				break;
			case 3:
				String textoAActualizar = null;
				textoAActualizar = leerDeTeclado();
				gestorDeFicherosDeTexto.actualizarFichero(textoAActualizar);
				System.out.println("Fichero actualizado...");
				break;
			default:
				System.out.println("Esta opcion no deberia salir");
			}

		} while (opcionMenu != 0);
		teclado.close();
	}

	private String leerDeTeclado() {
		String ret = null;
		System.out.print("Dame un texto: ");
		ret = teclado.nextLine();
		return ret;
	}
}
