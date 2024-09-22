package modelo;

import java.util.ArrayList;

/**
 * Clase con la lógica de los mensajes, como almacenar los mensajes en memoria,
 * añadir o eliminar mensajes, etc.
 */
public class GestorMensajes {
	private ArrayList<Mensaje> listaMensajes;

	public GestorMensajes() {
		this.listaMensajes = new ArrayList<>();
	}

	public void agregarMensaje(Mensaje mensaje) {
		listaMensajes.add(mensaje);
	}

	public int numeroDeMensajes() {
		return listaMensajes.size();
	}

	public ArrayList<Mensaje> getListaMensajes() {
		return listaMensajes;
	}
}
