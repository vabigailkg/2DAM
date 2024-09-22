package basicTextEditor.file;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Una clase que gestiona ficheros de forma sencilla
 */
public class BasicFileManager {

	private String filePath;

	/**
	 * Constructor negado
	 */
	@SuppressWarnings("unused")
	private BasicFileManager() {
	}

	/**
	 * Constructor. Requiere que se le introduzca el path del fichero que vamos a
	 * gestionar. Por ejemplo: "C:\\Trastero\\Text.txt"
	 * 
	 * @param filePath
	 */
	public BasicFileManager(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Escribe un texto en el fichero, borrando lo anterior
	 * 
	 * @param text El texto
	 * @throws IOException
	 */
	public void write(String text) throws IOException {
		FileWriter fileWriter = new FileWriter(filePath);
		doWrite(fileWriter, text);
		fileWriter.close();
	}

	/**
	 * Aniade nuevo texto al final del texto del fichero
	 * 
	 * @param text el texto
	 * @throws IOException
	 */
	public void append(String text) throws IOException {
		FileWriter fileWriter = new FileWriter(filePath, true);
		doWrite(fileWriter, text);
		fileWriter.close();
	}

	/**
	 * Lee el texto del fichero. Retorna null si el fichero esta vacio.
	 * 
	 * @return Null o el texto del fichero
	 * @throws IOException
	 */
	public String read() throws IOException {
		String ret = "";
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;

		try {
			fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);

			String linea = null;
			while ((linea = bufferedReader.readLine()) != null) {
				ret += linea;
			}

		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		} finally {
			try {
				if (null != bufferedReader)
					bufferedReader.close();
			} catch (IOException e) {
				// Nothing to see here...
			}
			try {
				if (null != fileReader)
					fileReader.close();
			} catch (IOException e) {
				// Nothing to see here...
			}
		}
		return ret;
	}

	/**
	 * Escribe un texto en el fichero o lo aniade el final del texto del fichero,
	 * dependiendo del FileWriter
	 * 
	 * @param fileWriter el FileWriter en modo escritura o append
	 * @param text       el texto
	 */
	private void doWrite(FileWriter fileWriter, String text) {
		PrintWriter printWriter = new PrintWriter(fileWriter);
		printWriter.println(text);
		printWriter.close();
	}
}
