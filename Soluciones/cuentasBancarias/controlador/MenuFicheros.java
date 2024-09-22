package cuentasBancarias.controlador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import cuentasBancarias.modelo.gestores.GestorFicheros;
import cuentasBancarias.modelo.pojos.CuentaAhorro;
import cuentasBancarias.modelo.pojos.CuentaBancaria;
import cuentasBancarias.modelo.pojos.CuentaEmpresa;
import cuentasBancarias.modelo.pojos.CuentaInversion;


public class MenuFicheros {

	// DECLARAR GESTORES
	private GestorFicheros gestorFicheros = null;
	// OBJETOS
	private Scanner teclado = null;
	public static final int NUMERO_OPCIONES_MENU_INICIAL = 5;
	public static final int NUMERO_OPCIONES_MENU_TIPO = 3;

	// CONSTRUCTOR
	public MenuFicheros() {
		gestorFicheros = new GestorFicheros();
		teclado = new Scanner(System.in);
	}

// ------------------- INICIO ----------------------------------
	
	// Muestra menu inicial, si user mete opcion la ejecuta
	public void iniciar() {
		int opcion = 0;
		do {
			opcion = opcionMenuInicial();
			if (opcion != 0) {
				ejecutarOpcionMenuInicial(opcion);
			}
		} while (opcion != 0);
	}

	// Recoge opcion del usuario por teclado
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
		} while ((ret < 0) || (ret > NUMERO_OPCIONES_MENU_INICIAL));
		return ret;
	}

	private void escribirMenuInicial() {
		System.out.println(" ");
		System.out.println("---- MENU ----");
		System.out.println("---- 0 - SALIR ");
		System.out.println("---- 1 - Resetear todo");
		System.out.println("---- 2 - Mostrar todos");
		System.out.println("---- 3 - Buscar cuenta por id");
		System.out.println("---- 4 - Añadir cuenta por tipo");
		System.out.println("---- 5 - Borrar cuenta por id");
		System.out.println("--------------");
	}
	// Le pasamos la opcion del user y ejecuta su metodo
	private void ejecutarOpcionMenuInicial(int opcion) {
		System.out.println(" ");
		switch (opcion) {
		case 0:
			System.out.print("Adios!!!");
			break;
		case 1:
			System.out.println("Resetear todo");
			resetearTodo();
			break;
		case 2:
			System.out.println("Mostrar todos");
			mostrarTodo();
			break;
		case 3:
			System.out.println("Buscar cuenta por id");
			mostrarCuentaPorId();
			break;
		case 4:
			System.out.println("Añadir cuenta por tipo");
			aniadirCuenta();
			break;
		case 5:
			System.out.println("Borrar cuenta por id");
			eliminarCuentaPorId();
			break;
		default:
			System.out.println("Esta opcion no deberia salir...");
		}
	}
	
	// ------------------- OPCIÓN 1 ----------------------------------
	
	// Borra y crea los ficheros y les pone datos default
	private void resetearTodo() {
		try {
			GestorFicheros gestorFicheros = new GestorFicheros();

			CuentaAhorro cuentaAhorro = new CuentaAhorro();
			cuentaAhorro.setId(1);
			cuentaAhorro.setNumeroCuenta("123");
			cuentaAhorro.setTitular("abi");
			cuentaAhorro.setImporte(20);
			cuentaAhorro.setFechaApertura(stringToDate("2024-05-31"));
			List<CuentaBancaria> ahorros = new ArrayList<CuentaBancaria>();
			ahorros.add(cuentaAhorro);
			gestorFicheros.escribirFicheroAhorro(ahorros, false);

			CuentaEmpresa cuentaEmpresa = new CuentaEmpresa();
			cuentaEmpresa.setId(1);
			cuentaEmpresa.setNumeroCuenta("123");
			cuentaEmpresa.setTitular("abi");
			cuentaEmpresa.setImporte(20);
			cuentaEmpresa.setFechaApertura(stringToDate("2024-05-31"));
			cuentaEmpresa.setIban("123");
			List<CuentaBancaria> empresas = new ArrayList<CuentaBancaria>();
			empresas.add(cuentaEmpresa);
			gestorFicheros.escribirFicheroEmpresa(empresas, false);

			CuentaInversion cuentaInversion = new CuentaInversion();
			cuentaInversion.setId(1);
			cuentaInversion.setNumeroCuenta("123");
			cuentaInversion.setTitular("abi");
			cuentaInversion.setImporte(20);
			cuentaInversion.setFechaApertura(stringToDate("2024-05-31"));
			cuentaInversion.setInteres(5);
			List<CuentaBancaria> inversiones = new ArrayList<CuentaBancaria>();
			inversiones.add(cuentaInversion);
			gestorFicheros.escribirFicheroInversion(inversiones, false);

		} catch (IOException e) {
			System.out.println("Error en el fichero " + e);
		}
	}
	
	// De String a Date sin fallos
	private Date stringToDate(String fecha) {
		Date ret = null;
		try {
			String pattern = "yyyy-MM-dd";
			SimpleDateFormat formatter = new SimpleDateFormat(pattern, Locale.ENGLISH);
			ret = formatter.parse(fecha);
		} catch (Exception e) {
			// Algo ha ido mal, devolvemos la fecha del sistema
			ret = new Date();
		}
		return ret;
	}
	
	// ------------------- OPCIÓN 2 ----------------------------------
	
	// Como en bbdd, mostramos la lsta de cada uno
	private void mostrarTodo() {
		mostrarCuentasAhorro();
		mostrarCuentasEmpresa();
		mostrarCuentasInversion();
	}
	
	// Guarda en var datos del fichero y los manda a recorrer
	private void mostrarCuentasAhorro() {
		List<CuentaBancaria> ret = null;
		try {
			List<CuentaBancaria> ahorros = gestorFicheros.leerFicheroAhorro();
			if (null != ahorros) {
				ret = new ArrayList<CuentaBancaria>();
				ret.addAll(ahorros);
			}
			recorrerFicheroAhorro(ret);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero");
		}
	}
	
	private void mostrarCuentasEmpresa(){
		List<CuentaBancaria> ret = null;
		try {
			List<CuentaBancaria> empresas = gestorFicheros.leerFicheroEmpresa();
			if (null != empresas) {
				ret = new ArrayList<CuentaBancaria>();
				ret.addAll(empresas);
			}
			recorrerFicheroAhorro(ret);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero");
		}
	}
	
	private void mostrarCuentasInversion() {
		List<CuentaBancaria> ret = null;
		try {
			List<CuentaBancaria> inversiones = gestorFicheros.leerFicheroInversion();
			if (null != inversiones) {
				ret = new ArrayList<CuentaBancaria>();
				ret.addAll(inversiones);
			}
			recorrerFicheroAhorro(ret);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero");
		}
	}
	
	// Recorre la lista y coge 1 cuenta del tipo
	private void recorrerFicheroAhorro(List<CuentaBancaria> ahorros) {
		if (null != ahorros) {
			for (CuentaBancaria cuentaBancaria : ahorros) {
				mostrarUnaCuentaAhorro(cuentaBancaria);
			}
		} else {
			System.out.println("No hay cuentas que mostrar");
		}
	}
	
	private void recorrerFicheroEmpresa(List<CuentaBancaria> empresas) {
		if (null != empresas) {
			for (CuentaBancaria cuentaBancaria : empresas) {
				mostrarUnaCuentaEmpresa(cuentaBancaria);
			}
		} else {
			System.out.println("No hay cuentas que mostrar");
		}
	}
	
	private void recorrerFicheroInversion(List<CuentaBancaria> inversiones) {
		if (null != inversiones) {
			for (CuentaBancaria cuentaBancaria : inversiones) {
				mostrarUnaCuentaInversion(cuentaBancaria);
			}
		} else {
			System.out.println("No hay cuentas que mostrar");
		}
	}

	// Muestra datos del fichero como string
	private void mostrarUnaCuentaAhorro(CuentaBancaria cuentaAhorro) {
		System.out.println(cuentaAhorro.toString());
	}
	
	private void mostrarUnaCuentaEmpresa(CuentaBancaria cuentaEmpresa) {
		System.out.println(cuentaEmpresa.toString());
	}
	
	private void mostrarUnaCuentaInversion(CuentaBancaria cuentaInversion) {
		System.out.println(cuentaInversion.toString());
	}
	
	// ------------------- OPCIÓN 3 ----------------------------------
	
	// MIRAR EN BBDD COMO LO HICE, MISMA LOGICA
	private void mostrarCuentaPorId() {
		int opcion = opcionBuscarCuentaPorId();
		ejecutarBuscarCuentaPorId(opcion);
	}

	private int opcionBuscarCuentaPorId() {
		int ret = 0;
		do {
			try {
				escribirMenuBorrarCuenta();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) || (ret > NUMERO_OPCIONES_MENU_TIPO));
		return ret;
	}

	private void ejecutarBuscarCuentaPorId(int opcion) {
		switch (opcion) {
		case 0:
			System.out.println("---------");
			opcionMenuInicial();
			break;
		case 1:
			System.out.println("---------");
			mostrarCuentasAhorro();
			break;
		case 2:
			System.out.println("---------");
			mostrarCuentasEmpresa();
			break;
		case 3:
			System.out.println("---------");
			mostrarCuentasInversion();
			break;
		}
	}
	
	// ------------------- OPCIÓN 4 ----------------------------------
	
	private void aniadirCuenta() {
		int opcion = 0;
		opcion = opcionAniadirCuenta();
		ejecutarAniadirCuenta(opcion);
	}

	private int opcionAniadirCuenta() {
		int ret = 0;
		do {
			try {
				escribirMenuBorrarCuenta();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) || (ret > NUMERO_OPCIONES_MENU_TIPO));
		return ret;
	}

	private void ejecutarAniadirCuenta(int opcion) {
		switch (opcion) {
		case 0:
			System.out.println("---------");
			opcionMenuInicial();
			break;
		case 1:
			System.out.println("---------");
			nuevoAhorro();
			break;
		case 2:
			System.out.println("---------");
			nuevaEmpresa();
			break;
		case 3:
			System.out.println("---------");
			nuevaInversion();
			break;
		}
	}

	private void nuevoAhorro() {
		try {
			CuentaAhorro nuevo = leerCuentaAhorro();
			List<CuentaBancaria> ahorros = gestorFicheros.leerFicheroAhorro();
			ahorros.add(nuevo);
			gestorFicheros.escribirFicheroAhorro(ahorros, false);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero");
		}
	}

	private CuentaAhorro leerCuentaAhorro() {
		CuentaAhorro ahorro = new CuentaAhorro();

		System.out.print("Escribe la id:");
		int id = teclado.nextInt();
		ahorro.setId(id);
		teclado.nextLine();

		System.out.print("Escribe el numero:");
		String number = teclado.nextLine();
		ahorro.setNumeroCuenta(number);

		System.out.print("Escribe el titular:");
		String titular = teclado.nextLine();
		ahorro.setTitular(titular);

		System.out.print("Escribe el importe:");
		Long importe = teclado.nextLong();
		ahorro.setImporte(importe);
		teclado.nextLine();

		System.out.print("Escribe la Fecha(yy/mm/dd):");
		ahorro.setFechaApertura(stringToDate(teclado.nextLine().trim()));

		return ahorro;
	}

	private void nuevaEmpresa() {
		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			CuentaEmpresa nuevo = leerCuentaEmpresa();
			List<CuentaBancaria> empresas = gestorFicheros.leerFicheroEmpresa();
			empresas.add(nuevo);
			gestorFicheros.escribirFicheroEmpresa(empresas, false);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero");
		}
	}

	private CuentaEmpresa leerCuentaEmpresa() {
		CuentaEmpresa empresa = new CuentaEmpresa();

		System.out.print("Escribe la id:");
		int id = teclado.nextInt();
		empresa.setId(id);
		teclado.nextLine();

		System.out.print("Escribe el numero:");
		String number = teclado.nextLine();
		empresa.setNumeroCuenta(number);

		System.out.print("Escribe el titular:");
		String titular = teclado.nextLine();
		empresa.setTitular(titular);
		System.out.print("Escribe el importe:");
		Long importe = teclado.nextLong();
		empresa.setImporte(importe);
		teclado.nextLine();

		System.out.print("Escribe la Fecha(yy/mm/dd):");
		empresa.setFechaApertura(stringToDate(teclado.nextLine().trim()));
		System.out.print("Escribe el Iban:");
		String iban = teclado.nextLine();
		empresa.setIban(iban);

		return empresa;
	}

	private void nuevaInversion() {
		GestorFicheros gestorFicheros = new GestorFicheros();
		try {
			CuentaInversion nuevo = leerCuentaInversion();
			List<CuentaBancaria> inversiones = gestorFicheros.leerFicheroInversion();
			inversiones.add(nuevo);
			gestorFicheros.escribirFicheroInversion(inversiones, false);
		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero");
		}
	}

	private CuentaInversion leerCuentaInversion() {
		CuentaInversion inversion = new CuentaInversion();

		System.out.print("Escribe la id:");
		int id = teclado.nextInt();
		inversion.setId(id);
		teclado.nextLine();

		System.out.print("Escribe el numero:");
		String number = teclado.nextLine();
		inversion.setNumeroCuenta(number);

		System.out.print("Escribe el titular:");
		String titular = teclado.nextLine();
		inversion.setTitular(titular);

		System.out.print("Escribe el importe:");
		Long importe = teclado.nextLong();
		inversion.setImporte(importe);
		teclado.nextLine();

		System.out.print("Escribe la Fecha(yy/mm/dd):");
		inversion.setFechaApertura(stringToDate(teclado.nextLine().trim()));

		System.out.print("Escribe el Interes:");
		int interes = teclado.nextInt();
		inversion.setInteres(interes);

		return inversion;
	}
	
	// ------------------- OPCIÓN 5 ----------------------------------

	// Inicia borrar
	private void eliminarCuentaPorId() {
		int opcion = 0;
		opcion = opcionBorrarCuenta();
		ejecutarBorrarCuenta(opcion);
	}
	
	// Pide a user que cuenta borrar
	private int opcionBorrarCuenta() {
		int ret = 0;
		do {
			try {
				escribirMenuBorrarCuenta();
				System.out.print("Elija una opcion: ");
				ret = teclado.nextInt();
				teclado.nextLine();
			} catch (Exception e) {
				teclado.nextLine();
				ret = -1;
			}
		} while ((ret < 0) || (ret > NUMERO_OPCIONES_MENU_TIPO));
		return ret;
	}
	
	private void escribirMenuBorrarCuenta() {
		System.out.println(" ");
		System.out.println("---- Cuenta ----");
		System.out.println("---- 0 - Volver ");
		System.out.println("---- 1 - Ahorro ");
		System.out.println("---- 2 - Empresa ");
		System.out.println("---- 3 - Inversion ");
		System.out.println("--------------");
	}
	
	private void ejecutarBorrarCuenta(int opcion) {
		switch (opcion) {
		case 0:
			System.out.println("---------");
			opcionMenuInicial();
			break;
		case 1:
			System.out.println("---------");
			borrarAhorro();
			break;
		case 2:
			System.out.println("---------");
			borrarEmpresa();
			break;
		case 3:
			System.out.println("---------");
			borrarInversion();
			break;
		}
	}

	private void borrarAhorro() {
		System.out.print("Id a eliminar: ");
		int id = teclado.nextInt();

		try {
			List<CuentaBancaria> ahorros = gestorFicheros.leerFicheroAhorro();

			CuentaBancaria delete = null;
			for (CuentaBancaria cuenta : ahorros) {
				if (cuenta.getId()==(id)) {
					delete = cuenta;
					break;
				}
			}
			if (null != delete) {
				ahorros.remove(delete);
				System.out.println("Cuenta borrada");
			} else {
				System.out.println("No hay cuentas que borrar");
			}
			if (ahorros.size() == 0) {
				gestorFicheros.borrarFicheroAhorro();
			} else
				gestorFicheros.escribirFicheroAhorro(ahorros, false);

		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero");
		}
	}

	private void borrarEmpresa() {
		System.out.print("Id a eliminar: ");
		int id = teclado.nextInt();

		try {
			List<CuentaBancaria> empresas = gestorFicheros.leerFicheroEmpresa();

			CuentaBancaria delete = null;
			for (CuentaBancaria cuenta : empresas) {
				if (cuenta.getId()==(id)) {
					delete = cuenta;
					break;
				}
			}
			if (null != delete) {
				empresas.remove(delete);
				System.out.println("Cuenta borrada");
			} else {
				System.out.println("No hay cuentas que borrar");
			}
			if (empresas.size() == 0) {
				gestorFicheros.borrarFicheroEmpresa();
			} else
				gestorFicheros.escribirFicheroEmpresa(empresas, false);

		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero");
		}
	}

	private void borrarInversion() {
		System.out.print("Id a eliminar: ");
		int id = teclado.nextInt();

		try {
			List<CuentaBancaria> inversiones = gestorFicheros.leerFicheroInversion();

			CuentaBancaria delete = null;
			for (CuentaBancaria cuenta : inversiones) {
				if (cuenta.getId()==(id)) {
					delete = cuenta;
					break;
				}
			}
			if (null != delete) {
				inversiones.remove(delete);
				System.out.println("Cuenta borrada");
			} else {
				System.out.println("No hay cuentas que borrar");
			}
			if (inversiones.size() == 0) {
				gestorFicheros.borrarFicheroInversion();
			} else
				gestorFicheros.escribirFicheroInversion(inversiones, false);

		} catch (FileNotFoundException e) {
			System.out.println("El fichero no existe");
		} catch (Exception e) {
			System.out.println("Error en el fichero");
		}
	}

//	private void mostrarCuantosProductosCadaTipo() {
//		mostrarCuantosVideos();
//		mostrarCuantasTeles();
//		mostrarCuantosPortas();
//	}
//
//	private void mostrarCuantosVideos() {
//		GestorFicheros gestorFicheros = new GestorFicheros();
//		try {
//			List<Producto> videos = gestorFicheros.leerFicheroVideos();
//			if ((null == videos) || (videos.size() == 0))
//				System.out.println(" No hay videos");
//			else
//				System.out.println("Hay " + videos.size() + " videos");
//		} catch (FileNotFoundException e) {
//			System.out.println("El fichero videos.dat no existe");
//		} catch (Exception e) {
//			System.out.println("Error en el fichero videos.dat");
//		}
//	}
//
//	private void mostrarCuantasTeles() {
//		GestorFicheros gestorFicheros = new GestorFicheros();
//		try {
//			List<Producto> teles = gestorFicheros.leerFicheroTeles();
//			if ((null == teles) || (teles.size() == 0))
//				System.out.println(" No hay televisiones");
//			else
//				System.out.println("Hay " + teles.size() + " televisiones");
//		} catch (FileNotFoundException e) {
//			System.out.println("El fichero televisiones.dat no existe");
//		} catch (Exception e) {
//			System.out.println("Error en el fichero televisiones.dat");
//		}
//	}
//
//	private void mostrarCuantosPortas() {
//		GestorFicheros gestorFicheros = new GestorFicheros();
//		try {
//			List<Producto> portas = gestorFicheros.leerFicheroPortas();
//			if ((null == portas) || (portas.size() == 0))
//				System.out.println(" No hay portatiles");
//			else
//				System.out.println("Hay " + portas.size() + " portatiles");
//		} catch (FileNotFoundException e) {
//			System.out.println("El fichero portatiles.dat no existe");
//		} catch (Exception e) {
//			System.out.println("Error en el fichero portatiles.dat");
//		}
//	}
}
