package ficheros_Binario;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Ej_DataInputStream {

	public static void main(String[] args) throws IOException {

		File fichero = new File("FichData.dat");
		FileInputStream fi = new FileInputStream(fichero);
		DataInputStream dataIS = new DataInputStream(fi);
		
		String n;
		int e;
		
		try {
			while (fi.getChannel().position() < fi.getChannel().size()) { // lo recorre hasta el final del archivo
				n = dataIS.readUTF(); // recupera el nombre
				e = dataIS.readInt(); // recupera la edad
				System.out.println("Nombre: " + n + ", edad: " + e);
			}
		} catch (EOFException eo) {
			
		}
		
		dataIS.close(); // cerrar el stream
	}

}
