package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Lee y escribe ficheros.
 */
public class GestorFicheros {

	// Ruta local y nombre del fichero
	public static final String RUTA_FICHERO = "C:\\EclipseFicheros\\Mensajes.txt";
	public String ruta = RUTA_FICHERO;

	// Constructor al que pasamos la ruta
	public GestorFicheros() {
		validarYCrearFichero();
	}

	// Verifica si el fichero existe y lo crea si no
	private void validarYCrearFichero() {
		File fichero = new File(ruta);
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
				System.out.println("Fichero creado: " + ruta);
			} catch (IOException e) {
				System.out.println("Error al crear el fichero: " + e.getMessage());
			}
		}
	}

	public void guardarMensajes(ArrayList<Mensaje> mensajes) throws IOException {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(ruta, true)); // 'false' para
																								// sobrescribir
			for (Mensaje mensaje : mensajes) {
				bufferedWriter.write("fecha:" + mensaje.getFecha() + "\n"); // escribe una línea
				bufferedWriter.write("hora:" + mensaje.getHora() + "\n");
				bufferedWriter.write("para:" + mensaje.getPara() + "\n");
				bufferedWriter.write("de:" + mensaje.getDe() + "\n");
				bufferedWriter.write("asunto:" + mensaje.getAsunto() + "\n");
				bufferedWriter.write("contenido:" + mensaje.getContenido() + "\n");
				bufferedWriter.write("******************\n");

			}
			bufferedWriter.close(); // Cerrar el bufferedWriter
		} catch (IOException e) {
			System.out.println("Error al guardar los mensajes: " + e.getMessage());
			throw e; // Propagar la excepción
		}
	}

	// Lee el fichero y devuelve un ArrayList de Strings con el contenido
	public ArrayList<Mensaje> cargarMensajes() {
	    ArrayList<Mensaje> mensajes = new ArrayList<>();
	    File fichero = new File(ruta);

	    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fichero))) {
	        String linea;
	        Mensaje mensaje = null;

	        while ((linea = bufferedReader.readLine()) != null) {
	            if (linea.equals("******************")) {
	                if (mensaje != null) { // Solo añade si el mensaje no es nulo
	                    mensajes.add(mensaje);
	                }
	                mensaje = null; // Reiniciar para el siguiente mensaje
	            } else {
	                if (mensaje == null) {
	                    mensaje = new Mensaje(linea, linea, linea, linea, linea, linea); // Crear un nuevo objeto Mensaje
	                }
	                if (linea.startsWith("fecha:")) {
	                    mensaje.setFecha(linea.substring(6).trim());
	                } else if (linea.startsWith("hora:")) {
	                    mensaje.setHora(linea.substring(6).trim());
	                } else if (linea.startsWith("para:")) {
	                    mensaje.setPara(linea.substring(6).trim());
	                } else if (linea.startsWith("de:")) {
	                    mensaje.setDe(linea.substring(4).trim());
	                } else if (linea.startsWith("asunto:")) {
	                    mensaje.setAsunto(linea.substring(8).trim());
	                } else if (linea.startsWith("contenido:")) {
	                    mensaje.setContenido(linea.substring(11).trim());
	                }
	            }
	        }

	        // Si el último mensaje no fue añadido
	        if (mensaje != null) {
	            mensajes.add(mensaje);
	        }

	    } catch (FileNotFoundException e) {
	        System.out.println("Fichero no encontrado: " + e.getMessage());
	    } catch (IOException e) {
	        System.out.println("Error de lectura: " + e.getMessage());
	    }

	    return mensajes;
	}

}
