package examenEvalTresSOLUC.examen;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import examenEvalTresSOLUC.examen.logica.GestorFicheros;
import examenEvalTresSOLUC.examen.pojo.Portatil;
import examenEvalTresSOLUC.examen.pojo.Producto;
import examenEvalTresSOLUC.examen.pojo.Television;
import examenEvalTresSOLUC.examen.pojo.Videoconsola;

/**
 * Clase de menus.
 */
public class Menu {

	private Scanner teclado = null;

	public Menu() {
		teclado = new Scanner(System.in);
	}

	public void iniciar() {
		int opcion = 0;
		do {
			opcion = opcionMenuInicial();
			if (opcion != 0) {
				ejecutarOpcionMenuInicial(opcion);
			}
		} while (opcion != 0);
	}

	private int opcionMenuInicial() {
		int ret = 0;
		do {
			try {
				escribirMenuInicial();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) || (ret > 5));
		return ret;
	}

	private void escribirMenuInicial() {
		System.out.println(" ");
		System.out.println("---- MENU ----");
		System.out.println("---- 0 - SALIR ");
		System.out.println("---- 1 - Mostrar todos los Productos ");
		System.out.println("---- 2 - Mostrar numero de Productos ");
		System.out.println("---- 3 - Aniadir Producto ");
		System.out.println("---- 4 - Eliminar Producto ");
		System.out.println("---- 5 - Resetear todo ");
		System.out.println("--------------");
	}

	// --------------------------
	// A modificar por el alumno
	// --------------------------

	private void ejecutarOpcionMenuInicial(int opcion) {
		System.out.println(" ");
		switch (opcion) {
		case 0:
			System.out.print("Adios!!!");
			break;
		case 1:
			listarProductos();
			break;
		case 2:
			mostrarCuantosProductosCadaTipo();
			break;
		case 3:
			aniadirProducto();
			break;
		case 4:
			eliminarProducto();
			break;
		case 5:
			resetearTodo();
			break;
		default:
			System.out.println("Esta opcion no deberia salir...");
		}
	}

	private void listarProductos() {
		listarVideos();
		listarTeles();
		listarPortas();
	}

	private void listarVideos() {
		List<Producto> ret = null;
		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			List<Producto> videos = gestorFicheros.leerFicheroVideos();
			if (null != videos) {
				ret = new ArrayList<Producto>();
				ret.addAll(videos);
			}
			mostrarProducto(ret);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero videoconsola.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero videoconsola.dat");
		}
	}

	private void listarTeles() {
		List<Producto> ret = null;
		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			List<Producto> teles = gestorFicheros.leerFicheroTeles();
			if (null != teles) {
				ret = new ArrayList<Producto>();
				ret.addAll(teles);
			}
			mostrarProducto(ret);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero televisiones.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero televisiones.dat");
		}
	}

	private void listarPortas() {
		List<Producto> ret = null;
		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			List<Producto> portas = gestorFicheros.leerFicheroPortas();

			if (null != portas) {
				ret = new ArrayList<Producto>();
				ret.addAll(portas);
			}

			mostrarProducto(ret);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero portatiles.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero portatiles.dat");
		}
	}

	private void mostrarProducto(List<Producto> productos) {
		for (Producto producto : productos) {
			mostrarProducto(producto);
		}
	}

	private void mostrarProducto(Producto producto) {
		System.out.println(producto.toString());
	}

	private void mostrarCuantosProductosCadaTipo() {
		mostrarCuantosVideos();
		mostrarCuantasTeles();
		mostrarCuantosPortas();
	}

	private void mostrarCuantosVideos() {
		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			List<Producto> videos = gestorFicheros.leerFicheroVideos();
			if ((null == videos) || (videos.size() == 0))
				System.out.println(" No hay videos");
			else
				System.out.println("Hay " + videos.size() + " videos");
		} catch (FileNotFoundException e) {
			System.out.println("El fichero videos.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero videos.dat");
		}
	}

	private void mostrarCuantasTeles() {
		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			List<Producto> teles = gestorFicheros.leerFicheroTeles();
			if ((null == teles) || (teles.size() == 0))
				System.out.println(" No hay televisiones");
			else
				System.out.println("Hay " + teles.size() + " televisiones");
		} catch (FileNotFoundException e) {
			System.out.println("El fichero televisiones.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero televisiones.dat");
		}
	}

	private void mostrarCuantosPortas() {
		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			List<Producto> portas = gestorFicheros.leerFicheroPortas();
			if ((null == portas) || (portas.size() == 0))
				System.out.println(" No hay portatiles");
			else
				System.out.println("Hay " + portas.size() + " portatiles");
		} catch (FileNotFoundException e) {
			System.out.println("El fichero portatiles.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero portatiles.dat");
		}
	}

	private void aniadirProducto() {
		int opcion = 0;
		opcion = opcionAniadirProducto();
		ejecutarAniadirProducto(opcion);
	}

	private int opcionAniadirProducto() {
		int ret = 0;
		do {
			try {
				escribirMenuAniadirProducto();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 1) || (ret > 3));
		return ret;
	}

	private void escribirMenuAniadirProducto() {
		System.out.println(" ");
		System.out.println("---- Producto a aniadir ----");
		System.out.println("---- 1 - Videoconsola ");
		System.out.println("---- 2 - Television ");
		System.out.println("---- 3 - Portatil ");
		System.out.println("--------------");
	}

	private void ejecutarAniadirProducto(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("---------");
			nuevaVideoconsola();
			break;
		case 2:
			System.out.println("---------");
			nuevaTelevision();
			break;
		case 3:
			System.out.println("---------");
			nuevoPortatil();
			break;
		}
	}

	private void nuevaVideoconsola() {
		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			Videoconsola nuevo = leerVideoconsola();
			List<Producto> videos = gestorFicheros.leerFicheroVideos();
			videos.add(nuevo);
			gestorFicheros.escribirFicheroVideos(videos, false);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero videos.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero videos.dat");
		}
	}

	private Videoconsola leerVideoconsola() {
		Videoconsola ret = new Videoconsola();
		System.out.print("Nombre: ");
		String nombre = teclado.nextLine();
		ret.setNombre(nombre);
		System.out.print("Marca: ");
		String marca = teclado.nextLine();
		ret.setMarca(marca);
		System.out.print("Precio: ");
		String precio = teclado.nextLine();
		ret.setPrecio(precio);
		System.out.print("Fecha Entrada: ");
		ret.setFechaEntrada(stringToDate(teclado.nextLine().trim()));
		System.out.print("Inteligente? [S/N]: ");
		String juegosDeRegalo = teclado.nextLine().trim().charAt(0) + "";
		ret.setJuegosDeRegalo(juegosDeRegalo.equalsIgnoreCase("S") ? true : false);
		return ret;
	}

	private void nuevaTelevision() {
		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			Television nuevo = leerTelevision();
			List<Producto> televisiones = gestorFicheros.leerFicheroTeles();
			televisiones.add(nuevo);
			gestorFicheros.escribirFicheroTeles(televisiones, false);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero televisiones.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero televisiones.dat");
		}
	}

	private Television leerTelevision() {
		Television ret = new Television();
		System.out.print("Nombre: ");
		String nombre = teclado.nextLine();
		ret.setNombre(nombre);
		System.out.print("Marca: ");
		String marca = teclado.nextLine();
		ret.setMarca(marca);
		System.out.print("Precio: ");
		String precio = teclado.nextLine();
		ret.setPrecio(precio);
		System.out.print("Inteligente? [S/N]: ");
		String inteligente = teclado.nextLine().trim().charAt(0) + "";
		ret.setInteligente(inteligente.equalsIgnoreCase("S") ? true : false);
		return ret;
	}

	private void nuevoPortatil() {
		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			Portatil nuevo = leerPortatil();
			List<Producto> portatiles = gestorFicheros.leerFicheroPortas();
			portatiles.add(nuevo);
			gestorFicheros.escribirFicheroPortas(portatiles, false);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero portatiles.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero portatiles.dat");
		}
	}

	private Portatil leerPortatil() {
		Portatil ret = new Portatil();
		System.out.print("Nombre: ");
		String nombre = teclado.nextLine();
		ret.setNombre(nombre);
		System.out.print("Marca: ");
		String marca = teclado.nextLine();
		ret.setMarca(marca);
		System.out.print("Precio: ");
		String precio = teclado.nextLine();
		ret.setPrecio(precio);
		System.out.print("Fecha Entrada: ");
		ret.setFechaEntrada(stringToDate(teclado.nextLine().trim()));
		System.out.print("Tipo: ");
		String tipo = teclado.nextLine();
		ret.setTipo(tipo);
		return ret;
	}

	private void eliminarProducto() {
		int opcion = 0;
		opcion = opcionBorrarProducto();
		ejecutarBorrarProducto(opcion);
	}

	private int opcionBorrarProducto() {
		int ret = 0;
		do {
			try {
				escribirMenuBorrarProducto();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 1) || (ret > 3));
		return ret;
	}

	private void escribirMenuBorrarProducto() {
		System.out.println(" ");
		System.out.println("---- Producto a borrar ----");
		System.out.println("---- 1 - Videoconsola ");
		System.out.println("---- 2 - Television ");
		System.out.println("---- 3 - Portatil ");
		System.out.println("--------------");
	}

	private void ejecutarBorrarProducto(int opcion) {
		switch (opcion) {
		case 1:
			System.out.println("---------");
			borrarVideoconsola();
			break;
		case 2:
			System.out.println("---------");
			borrarTelevision();
			break;
		case 3:
			System.out.println("---------");
			borrarPortatil();
			break;
		}
	}

	private void borrarVideoconsola() {
		System.out.print("Nombre a eliminar: ");
		String nombre = teclado.nextLine();

		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			List<Producto> videos = gestorFicheros.leerFicheroVideos();

			Producto delete = null;
			for (Producto producto : videos) {
				if (producto.getNombre().equals(nombre)) {
					delete = producto;
					break;
				}
			}
			if (null != delete) {
				videos.remove(delete);
				System.out.println("Videoconsola borrada");
			} else {
				System.out.println("No hay videoconsolas que borrar");
			}
			if (videos.size() == 0) {
				gestorFicheros.borrarFicheroVideos();
			} else
				gestorFicheros.escribirFicheroVideos(videos, false);

		} catch (FileNotFoundException e) {
			System.out.println("El fichero videoconsolas.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero videoconsolas.dat");
		}
	}

	private void borrarTelevision() {
		System.out.print("Nombre a eliminar: ");
		String nombre = teclado.nextLine();

		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			List<Producto> teles = gestorFicheros.leerFicheroTeles();

			Producto delete = null;
			for (Producto producto : teles) {
				if (producto.getNombre().equals(nombre)) {
					delete = producto;
					break;
				}
			}
			if (null != delete) {
				teles.remove(delete);
				System.out.println("Television borrada");
			} else {
				System.out.println("No hay televisiones que borrar");
			}
			if (teles.size() == 0) {
				gestorFicheros.borrarFicheroTeles();
			} else
				gestorFicheros.escribirFicheroTeles(teles, false);

		} catch (FileNotFoundException e) {
			System.out.println("El fichero televisiones.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero televisiones.dat");
		}
	}

	private void borrarPortatil() {
		System.out.print("Nombre a eliminar: ");
		String nombre = teclado.nextLine();

		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			List<Producto> portas = gestorFicheros.leerFicheroPortas();

			Producto delete = null;
			for (Producto producto : portas) {
				if (producto.getNombre().equals(nombre)) {
					delete = producto;
					break;
				}
			}
			if (null != delete) {
				portas.remove(delete);
				System.out.println("Porta borrado");
			} else {
				System.out.println("No hay portatiles que borrar");
			}
			if (portas.size() == 0) {
				gestorFicheros.borrarFicheroPortas();
			} else
				gestorFicheros.escribirFicheroPortas(portas, false);

		} catch (FileNotFoundException e) {
			System.out.println("El fichero portatiles.dat no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero portatiles.dat");
		}
	}

	private void resetearTodo() {
		try {
			GestorFicheros gestorFicheros = new GestorFicheros();

			Portatil portatil = new Portatil();
			portatil.setNombre("Porta 1");
			portatil.setMarca("Marca 1");
			portatil.setPrecio("600");
			portatil.setFechaEntrada(stringToDate(""));
			portatil.setTipo("G");
			List<Producto> portas = new ArrayList<Producto>();
			portas.add(portatil);
			gestorFicheros.escribirFicheroPortas(portas, false);

			Videoconsola videoconsola = new Videoconsola();
			videoconsola.setNombre("Video 1");
			videoconsola.setMarca("Marca 1");
			videoconsola.setPrecio("300");
			videoconsola.setFechaEntrada(stringToDate(""));
			videoconsola.setJuegosDeRegalo(true);
			List<Producto> videos = new ArrayList<Producto>();
			videos.add(videoconsola);
			gestorFicheros.escribirFicheroVideos(videos, false);

			Television television = new Television();
			television.setNombre("Tele 1");
			television.setMarca("Marca 1");
			television.setPrecio("400");
			television.setInteligente(true);
			List<Producto> teles = new ArrayList<Producto>();
			teles.add(television);
			gestorFicheros.escribirFicheroTeles(teles, false);

		} catch (IOException e) {
			System.out.println("Error en el fichero " + e);
		}
	}

	/**
	 * Este metodo esta preparado para que no fallen leer las fechas por teclado
	 * 
	 * @param fecha
	 * @return Una fecha
	 */
	private Date stringToDate(String fecha) {
		Date ret = null;
		try {
			String pattern = "yyyy/MM/dd";
			SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
			ret = formatter.parse(fecha);
		} catch (Exception e) {
			// Algo ha ido mal, devolvemos la fecha del sistema
			ret = new Date();
		}
		return ret;
	}

}