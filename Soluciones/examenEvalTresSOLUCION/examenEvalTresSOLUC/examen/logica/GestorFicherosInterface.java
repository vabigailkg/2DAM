package examenEvalTresSOLUC.examen.logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import examenEvalTresSOLUC.examen.pojo.Producto;

public interface GestorFicherosInterface {

	public void escribirFicheroVideos(List<Producto> productos, boolean append) throws FileNotFoundException, IOException;

	public void escribirFicheroTeles(List<Producto> productos, boolean append) throws FileNotFoundException, IOException;

	public void escribirFicheroPortas(List<Producto> productos, boolean append) throws FileNotFoundException, IOException;

	public List<Producto> leerFicheroVideos() throws FileNotFoundException, ClassNotFoundException, IOException;

	public List<Producto> leerFicheroTeles() throws FileNotFoundException, ClassNotFoundException, IOException;

	public List<Producto> leerFicheroPortas() throws FileNotFoundException, ClassNotFoundException, IOException;
	
	public void borrarFicheroVideos();

	public void borrarFicheroTeles();

	public void borrarFicheroPortas();
}
