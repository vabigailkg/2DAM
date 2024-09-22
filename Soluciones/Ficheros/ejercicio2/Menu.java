package ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Clase que muestra el menu de opciones, lee del teclado, y muestra resultados
 * por pantalla los resultados
 */
public class Menu {

	private Scanner teclado = null;
	private GestorDeFicheros gestorDeFicheros = null;

	public Menu() {
		teclado = new Scanner(System.in);
		gestorDeFicheros = new GestorDeFicheros();
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
				cargarVideojuegosEnFichero();
				break;
			case 2:
				mostrarVideojuegosDelFichero();
				break;
			case 3: 
				aniadirVideojuegosEnFichero();
				break;
			default:
				System.out.println("Esta opcion no deberia salir");
			}

		} while (opcionMenu != 0);
		teclado.close();
	}

	private void cargarVideojuegosEnFichero() {
		ArrayList<Videojuego> videojuegos = pedirVideojuegosPorTeclado();
		gestorDeFicheros.escribirVideojuegosEnFichero(videojuegos);
		System.out.println("Fichero escrito");
	}

	private ArrayList<Videojuego> pedirVideojuegosPorTeclado() {
		ArrayList<Videojuego> ret = null;
		Videojuego videojuego = null;

		String opc = "n";
		do {

			if (null == ret)
				ret = new ArrayList<Videojuego>();

			videojuego = new Videojuego();

			System.out.print("Dame un titulo: ");
			String titulo = teclado.nextLine();
			videojuego.setTitulo(titulo);

			System.out.print("Dame una empresa: ");
			String empresa = teclado.nextLine();
			videojuego.setEmpresa(empresa);

			System.out.print("Dame una fecha: ");
			String fecha = teclado.nextLine();
			videojuego.setFecha(fecha);

			ret.add(videojuego);

			System.out.print("Desea continuar? [s/n]: ");
			opc = teclado.nextLine();

		} while (opc.trim().equals("s"));

		return ret;
	}

	private void mostrarVideojuegosDelFichero() {
		ArrayList<String> videojuegosText = gestorDeFicheros.leerVideojuegosDelFichero ();
		ArrayList<Videojuego> videojuegos = stringsToVideogame (videojuegosText);
		mostrarVideojuegos(videojuegos);
	}

	private ArrayList<Videojuego> stringsToVideogame(ArrayList<String> videojuegosText) {
		ArrayList<Videojuego> ret = null;
		
		for (String text : videojuegosText) {
			if (null == ret)
				ret = new ArrayList<Videojuego>();
			
			Videojuego videojuego = stringToVideogame (text);
			ret.add(videojuego);
		}
		
		return ret;
	}

	private Videojuego stringToVideogame(String text) {
		Videojuego ret = new Videojuego();
		
		String[] parts = text.split(", ");
		String titulo = getData(parts[0]);
		String empresa = getData(parts[1]);
		String fecha = getData(parts[2]);
		
		ret.setTitulo(titulo);
		ret.setEmpresa(empresa);
		ret.setFecha(fecha);
		
		return ret;
	}

	private String getData(String text) {
		String[] parts = text.split("=");
		return parts[1];
	}

	private void mostrarVideojuegos(ArrayList<Videojuego> videojuegos) {
		for (Videojuego videojuego : videojuegos) {
			mostrarVideojuego (videojuego);
		}
	}
	
	private void mostrarVideojuego(Videojuego videojuego) {
		System.out.println(" ");
		System.out.println("Titulo: " + videojuego.getTitulo());
		System.out.println("Empresa: " + videojuego.getEmpresa());
		System.out.println("Fecha: " + videojuego.getFecha());
	}
	
	private void aniadirVideojuegosEnFichero () {
		ArrayList<Videojuego> videojuegos = pedirVideojuegosPorTeclado();
		gestorDeFicheros.aniadirVideojuegosEnFichero(videojuegos);
		System.out.println("Aniadidos al fichero");
	}
}
