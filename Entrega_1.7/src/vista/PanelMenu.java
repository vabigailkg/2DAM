package vista;

import javax.swing.JPanel;

import controlador.MensajeController;
import modelo.GestorFicheros;
import modelo.GestorMensajes;
import modelo.Mensaje;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

/**
 * El panel principal donde están los botones.
 */
public class PanelMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	// Creamos el objeto para usar sus métodos
	private Ventana ventana;
	private GestorFicheros gestorFicheros;
	private GestorMensajes gestorMensajes;
	private MensajeController mensajeController;

	public PanelMenu(Ventana ventana, MensajeController mensajeController) {
		// Pasamos la referencia del objeto al constructor
		this.ventana = ventana;
		this.gestorFicheros = new GestorFicheros();
		this.gestorMensajes = new GestorMensajes();
		this.mensajeController = mensajeController; // Inicializa el controlador

		setBounds(new Rectangle(0, 0, 640, 480));
		setLayout(null);

		// Botón "Cargar mensajes"
		JButton botonCargar = new JButton("Cargar mensajes");
		botonCargar.setBounds(125, 123, 180, 23);
		add(botonCargar);
		// PopUp
		botonCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GestorFicheros gestorFicheros = new GestorFicheros();
				ArrayList<Mensaje> mensajes = gestorFicheros.cargarMensajes();

				// Mostrar un pop-up con el número de mensajes cargados
				JOptionPane.showMessageDialog(null, "Se han cargado en memoria " + mensajes.size() + " mensajes.");
			}
		});

		// Botón "Guardar mensajes"
		JButton botonGuardar = new JButton("Guardar mensajes");
		botonGuardar.setBounds(368, 123, 180, 23);
		add(botonGuardar);
		// PopUp
		botonGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					gestorFicheros.guardarMensajes(gestorMensajes.getListaMensajes());
					JOptionPane.showMessageDialog(null,
							"Los mensajes en memoria han sido guardados en el fichero MENSAJES.TXT");
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(null, "Error al guardar los mensajes: " + ex.getMessage());
				}
			}
		});

		// Botón "Imprimir mensajes"
		JButton botonImprimir = new JButton("Imprimir mensajes");
		botonImprimir.setBounds(368, 251, 180, 23);
		add(botonImprimir);
		// Cambia de panel y muestra los mensajes
		botonImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Llamar al método del controlador para mostrar los mensajes
				mensajeController.mostrarMensajes();
				ventana.mostrarPanel("panelImprimirMensaje");
			}
		});

		// Botón "Nuevo mensaje"
		JButton botonNuevo = new JButton("Añadir mensajes");
		botonNuevo.setBounds(125, 251, 180, 23);
		add(botonNuevo);
		// Cambia de panel
		botonNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.mostrarPanel("panelNuevoMensaje");
			}
		});

		// Botón "Salir"
		JButton botonSalir = new JButton("Salir");
		botonSalir.setBounds(497, 390, 89, 23);
		add(botonSalir);
		// Cierra la app
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

	/**
	 * Devuelve el JPanel transformándolo con los parámetros y coordenadas que le
	 * pasamos
	 * 
	 * @param x      Nueva coordenada x
	 * @param y      Nueva coordenada y
	 * @param width  Nueva anchura
	 * @param height Nueva altura
	 * @param name   Nombre del panel
	 * @return El PanelMenu con sus componentes añadidos
	 */
	public JPanel getJPanel(int x, int y, int width, int height, String name) {
		// Usamos this para coger este panel ya creado con todos sus elementos
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(Color.pink);
		this.setName(name);

		return this;
	}

}
