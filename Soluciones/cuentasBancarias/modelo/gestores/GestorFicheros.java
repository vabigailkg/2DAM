package cuentasBancarias.modelo.gestores;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import cuentasBancarias.modelo.pojos.CuentaBancaria;

public class GestorFicheros implements GestorFicherosInterface{

	// RUTAEN PC DE FICHEROS (va en clase abstract si lo pide)
	protected String path = "c://Trastero//";
	
	// NOMBRE FICHEROS (va en clase abstract si lo pide)
	protected String filenameAhorro = path + "ahorro.txt";
	protected String filenameEmpresa = path + "empresa.txt";
	protected String filenameInversion = path + "inversion.txt";
	
// ------------------- CUENTAS AHORRO ----------------------------------
	// Llama a leer el fichero
	@Override
	public List<CuentaBancaria> leerFicheroAhorro() throws FileNotFoundException, ClassNotFoundException, IOException {
		return leer(filenameAhorro);
	}
	
	// Llama a escribir para imprimir en su filename los datos. OJO que usamos el padre = en interface
	@Override
	public void escribirFicheroAhorro(List<CuentaBancaria> cuentas, boolean append)
			throws FileNotFoundException, IOException {
		escribir(cuentas, filenameAhorro, append);
	}
	
	// Llama a borrar el fichero que le pasamos
	@Override
	public void borrarFicheroAhorro() {
		borrarFichero(filenameAhorro);
	}

// ------------------- CUENTAS EMPRESA ----------------------------------
	@Override
	public List<CuentaBancaria> leerFicheroEmpresa() throws FileNotFoundException, ClassNotFoundException, IOException {
		return leer(filenameEmpresa);
	}
	
	@Override
	public void escribirFicheroEmpresa(List<CuentaBancaria> cuentas, boolean append)
			throws FileNotFoundException, IOException {
		escribir(cuentas, filenameEmpresa, append);
	}

	@Override
	public void borrarFicheroEmpresa(){
		borrarFichero(filenameEmpresa);
	}
	
// ------------------- CUENTAS INVERSION ----------------------------------
	@Override
	public List<CuentaBancaria> leerFicheroInversion()
			throws FileNotFoundException, ClassNotFoundException, IOException {
		return leer(filenameInversion);
	}

	@Override
	public void escribirFicheroInversion(List<CuentaBancaria> cuentas, boolean append)
			throws FileNotFoundException, IOException {
		escribir(cuentas, filenameInversion, append);
	}

	@Override
	public void borrarFicheroInversion() {
		borrarFichero(filenameInversion);
	}
// ------------------- BASE ----------------------------------
	
	// Append false = destruir y reescribir / True = actualizar fichero
	private void escribir(List<CuentaBancaria> cuenta, String file, boolean append) throws FileNotFoundException, IOException {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		MyObjectOutputStream myObjectOutputStream = null;

		try {
			File myFile = new File(file);
			fileOutputStream = new FileOutputStream(myFile, append);
			if (fileIsEmpty(file)) {
				objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(cuenta);
				objectOutputStream.flush();
			} else {
				myObjectOutputStream = new MyObjectOutputStream(fileOutputStream);
				myObjectOutputStream.writeObject(cuenta);
				myObjectOutputStream.flush();
			}

		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (null != objectOutputStream)
					objectOutputStream.close();
			} catch (IOException e1) {
				// Nos da igual
			}
			try {
				if (null != myObjectOutputStream)
					myObjectOutputStream.close();
			} catch (IOException e1) {
				// Nos da igual
			}
			try {
				if (null != fileOutputStream)
					fileOutputStream.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}
	}
	
	// Parche, va en abstract si lo pide NO TOCAR
	protected class MyObjectOutputStream extends ObjectOutputStream {

		public MyObjectOutputStream() throws IOException {
			super();
		}

		public MyObjectOutputStream(OutputStream o) throws IOException {
			super(o);
		}

		public void writeStreamHeader() throws IOException {
			return;
		}
	}
	
	// Parche, va en abstract si lo pide NO TOCAR
	protected boolean fileIsEmpty(String file) {
		return (new File(file)).length() == 0? true : false;
	}

	// Lee un archivo y nos devuelve el contenido
	private List<CuentaBancaria> leer(String file) throws FileNotFoundException, ClassNotFoundException, IOException {
		List<CuentaBancaria> ret = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		try {
			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);

			ret = new ArrayList<CuentaBancaria>();
			try {
				for (;;) {
					ret.add((CuentaBancaria) objectInputStream.readObject());
				}
			} catch (EOFException e) {
				// End of stream
			}

		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} catch (ClassNotFoundException e) {
			throw e;
		} finally {
			try {
				if (null != objectInputStream)
					objectInputStream.close();
			} catch (IOException e1) {
				// Nos da igual
			}
			try {
				if (null != fileInputStream)
					fileInputStream.close();
			} catch (IOException e) {
				// Nos da igual
			}
		}
		return ret;
	}
	
	// Accion de borrar fichero
	public void borrarFichero(String file) {
		File myFile = new File(file);
		if (myFile.delete()) {
			System.out.println("Fichero " + myFile.getName() + " borrado");
		}
	}
}
