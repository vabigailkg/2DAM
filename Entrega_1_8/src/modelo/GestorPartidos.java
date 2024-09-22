package modelo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Gestiona los partidos del fichero.
 */
public class GestorPartidos {

	public static final String RUTA_FICHERO = "C:\\EclipseFicheros\\Resultados.dat";
	public String ruta = RUTA_FICHERO;

	// Constructor
	public GestorPartidos() {
		validarYCrearFichero();
	}

	// Método al que le pasamos la ruta para ver si el fichero existe
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

	// Método para cargar partidos desde el archivo
	public ArrayList<Partido> cargarPartidos() {
		ArrayList<Partido> partidos = new ArrayList<>();
		try (DataInputStream dis = new DataInputStream(new FileInputStream(ruta))) {
			while (true) {
				String equipoLocal = dis.readUTF();
				String equipoVisitante = dis.readUTF();
				int golLocal = dis.readInt();
				int golVisitante = dis.readInt();
				String lugar = dis.readUTF();
				String fecha = dis.readUTF();

				Partido partido = new Partido(equipoLocal, equipoVisitante, golLocal, golVisitante, lugar, fecha);
				partidos.add(partido);
			}
		} catch (EOFException e) {
			// Fin del archivo alcanzado
		} catch (IOException e) {
			System.out.println("Error al cargar los partidos: " + e.getMessage());
		}
		return partidos;
	}

	// Método para guardar partidos en el archivo
	public void guardarPartidos(ArrayList<Partido> partidos) {
		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(ruta, true))) {
			for (Partido partido : partidos) {
				dos.writeUTF(partido.getEquipoLocal());
				dos.writeUTF(partido.getEquipoVisitante());
				dos.writeInt(partido.getGolLocal());
				dos.writeInt(partido.getGolVisitante());
				dos.writeUTF(partido.getLugar());
				dos.writeUTF(partido.getFecha());
			}
		} catch (IOException e) {
			System.out.println("Error al guardar los partidos: " + e.getMessage());
		}
	}
}
