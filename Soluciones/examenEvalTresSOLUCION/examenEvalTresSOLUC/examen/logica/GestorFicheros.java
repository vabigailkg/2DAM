package examenEvalTresSOLUC.examen.logica;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import examenEvalTresSOLUC.examen.pojo.Producto;

public class GestorFicheros extends GestorFicherosAbstract implements GestorFicherosInterface {

	@Override
	public void escribirFicheroVideos(List<Producto> productos, boolean append)
			throws FileNotFoundException, IOException {
		escribir(productos, filenameVideo, append);
	}

	@Override
	public void escribirFicheroTeles(List<Producto> productos, boolean append)
			throws FileNotFoundException, IOException {
		escribir(productos, filenameTele, append);
	}

	@Override
	public void escribirFicheroPortas(List<Producto> productos, boolean append)
			throws FileNotFoundException, IOException {
		escribir(productos, filenamePorta, append);
	}

	@Override
	public List<Producto> leerFicheroVideos() throws FileNotFoundException, ClassNotFoundException, IOException {
		return leer(filenameVideo);
	}

	@Override
	public List<Producto> leerFicheroTeles() throws FileNotFoundException, ClassNotFoundException, IOException {
		return leer(filenameTele);
	}

	@Override
	public List<Producto> leerFicheroPortas() throws FileNotFoundException, ClassNotFoundException, IOException {
		return leer(filenamePorta);
	}

	@Override
	public void borrarFicheroVideos() {
		borrarFichero(filenameVideo);
	}

	@Override
	public void borrarFicheroTeles() {
		borrarFichero(filenameTele);
	}

	@Override
	public void borrarFicheroPortas() {
		borrarFichero(filenamePorta);
	}

	// ---------//
	// NO TOCAR //
	// ---------//

	/**
	 * Escribe una lista de Productos en el fichero indicado. El fichero es
	 * destruido y reescrito en el proceso.
	 * 
	 * @param productos
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void escribir(List<Producto> productos, String file, boolean append)
			throws FileNotFoundException, IOException {
		if (null != productos && productos.size() > 0) {
			escribir(productos.get(0), file, false);
			List<Producto> productos2 = productos;
			productos2.remove(0);
			for (Producto producto : productos2) {
				escribir(producto, file, true);
			}
		}
	}

	/**
	 * Escribe un Producto en el fichero indicado. Si append es FALSE, el fichero es
	 * destruido y reescrito en el proceso. Si append es TRUE, el fichero se
	 * actualiza con los nuevos valores.
	 * 
	 * @param producto
	 * @param file
	 * @param append
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private void escribir(Producto producto, String file, boolean append) throws FileNotFoundException, IOException {
		FileOutputStream fileOutputStream = null;
		ObjectOutputStream objectOutputStream = null;
		MyObjectOutputStream myObjectOutputStream = null;

		try {
			File myFile = new File(file);
			fileOutputStream = new FileOutputStream(myFile, append);
			if (fileIsEmpty(file)) {
				objectOutputStream = new ObjectOutputStream(fileOutputStream);
				objectOutputStream.writeObject(producto);
				objectOutputStream.flush();
			} else {
				myObjectOutputStream = new MyObjectOutputStream(fileOutputStream);
				myObjectOutputStream.writeObject(producto);
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

	/**
	 * Retorna la lista de productos del fichero indicado.
	 * 
	 * @param file
	 * @return Lista de productos
	 * @throws FileNotFoundException
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	private List<Producto> leer(String file) throws FileNotFoundException, ClassNotFoundException, IOException {
		List<Producto> ret = null;
		FileInputStream fileInputStream = null;
		ObjectInputStream objectInputStream = null;

		try {
			fileInputStream = new FileInputStream(file);
			objectInputStream = new ObjectInputStream(fileInputStream);

			ret = new ArrayList<Producto>();
			try {
				for (;;) {
					ret.add((Producto) objectInputStream.readObject());
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
	
	/**
	 * Elimina el fichero indicado 
	 * 
	 * @param file
	 */
	public void borrarFichero(String file) {
		File myFile = new File(file);
		if (myFile.delete()) {
			System.out.println("Fichero " + myFile.getName() + " borrado");
		}
	}
}
