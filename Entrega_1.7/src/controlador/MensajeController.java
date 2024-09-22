package controlador;

import java.io.IOException;
import java.util.ArrayList;

import modelo.GestorFicheros;
import modelo.GestorMensajes;
import modelo.Mensaje;
import vista.PanelImprimirMensaje;

/**
 * Recibe los eventos de la vista (botones, inputs) y los comunica con el modelo
 * (por ejemplo, leyendo o escribiendo en el fichero).
 */
public class MensajeController {
	private GestorMensajes gestorMensajes;
	private GestorFicheros gestorFicheros;
	private PanelImprimirMensaje panelImprimirMensaje;

	public MensajeController(GestorMensajes gestorMensajes, PanelImprimirMensaje panelImprimirMensaje) {
		this.gestorMensajes = gestorMensajes;
		this.gestorFicheros = new GestorFicheros(); // Inicializa el gestor de ficheros
		this.panelImprimirMensaje = panelImprimirMensaje;
	}

	public void mostrarMensajes() {
		cargarMensajes(); // Carga los mensajes desde el fichero y los agrega al gestor
		ArrayList<Mensaje> mensajes = gestorMensajes.getListaMensajes();
		panelImprimirMensaje.actualizarTabla(mensajes);
	}

	public void cargarMensajes() {
		ArrayList<Mensaje> mensajes = gestorFicheros.cargarMensajes();

		// Agregar los mensajes al gestor
		for (Mensaje mensaje : mensajes) {
			gestorMensajes.agregarMensaje(mensaje);
		}
	}

	public void guardarMensajes() throws IOException {
		gestorFicheros.guardarMensajes(gestorMensajes.getListaMensajes()); // Guardar en el fichero
	}

	// Nuevo método para agregar un mensaje
	public void agregarMensaje(Mensaje mensaje) {
		gestorMensajes.agregarMensaje(mensaje); // Agregar el mensaje al gestor
	}

}