package vista;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controlador.MensajeController;
import modelo.GestorMensajes;

/**
 * El JFrame que muestra/oculta los paneles.
 */
public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;

	// Declara la ventana
	public JFrame ventana = null;

	// Medidas de la ventana
	private static final int FRAME_X = 100;
	private static final int FRAME_Y = 100;
	private static final int FRAME_WIDTH = 640;
	private static final int FRAME_HEIGHT = 480;

	// Coordenadas y medidas de todos los paneles
	private static final int PANEL_X = 0;
	private static final int PANEL_Y = 0;
	private static final int PANEL_WIDTH = 640;
	private static final int PANEL_HEIGHT = 480;

	// Constructor que instancia la ventana (la crea)
	public Ventana() {
		ventana = new JFrame();
	}

	// Inicia la ventana con sus parámetros (dar forma)
	public void iniciar() {
		// Parámetros de la ventana
		ventana.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);

		// Instancia las clases de los paneles y gestores
		PanelImprimirMensaje panelImprimirMensaje = new PanelImprimirMensaje();
		GestorMensajes gestorMensajes = new GestorMensajes();
		MensajeController mensajeController = new MensajeController(gestorMensajes, panelImprimirMensaje);
		PanelMenu panelMenu = new PanelMenu(this, mensajeController);
		PanelNuevoMensaje panelNuevoMensaje = new PanelNuevoMensaje(mensajeController); // Pasar el controlador
		
		// Obtiene los parámetros de cada panel
		JPanel panel1 = panelMenu.getJPanel(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT, "panelMenu");
		JPanel panel2 = panelNuevoMensaje.getJPanel(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT, "panelNuevoMensaje");
		JPanel panel3 = panelImprimirMensaje.getJPanel(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT,
				"panelImprimirMensaje");

		// Agregamos los paneles
		ventana.getContentPane().add(panel1);
		ventana.getContentPane().add(panel2);
		ventana.getContentPane().add(panel3);

		// Panel Menu visible por defecto
		panel1.setVisible(true);
		panel2.setVisible(false);
		panel3.setVisible(false);

		// Hacer visible la ventana
		ventana.setVisible(true);

	}

	// Muestra el panel que le pasamos y oculta el resto
	public void mostrarPanel(String nombrePanel) {
		// Sacamos todos los componentes de JFrame: botones, paneles, etc...
		Component[] componentArray = ventana.getContentPane().getComponents();
		List<Component> components = Arrays.asList(componentArray);

		// Recorremos los componentes
		for (Component component : components) {

			// Ignoramos todo menos los JPanel
			if (component instanceof JPanel) {
				if ((null != component.getName()) && (component.getName().equals(nombrePanel))) {
					component.setVisible(true);
				} else {
					component.setVisible(false);
				}
			}
		}
	}
}
