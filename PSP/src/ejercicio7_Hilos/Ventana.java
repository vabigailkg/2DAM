package ejercicio7_Hilos;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Frame que muestra y oculta los paneles.
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

		// Instancia las clases de los paneles
		Carrera panelProgreso = new Carrera(this);
		Trampas panelTrampas = new Trampas(this);

		// Obtiene los parámetros de cada panel
		JPanel panel1 = panelProgreso.getJPanel(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT, "panelProgreso");
		JPanel panel2 = panelTrampas.getJPanel(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT, "panelTrampas");

		// Agregamos los paneles
		ventana.getContentPane().add(panel1);
		ventana.getContentPane().add(panel2);

		// Panel Trampas visible por defecto
		panel1.setVisible(false);
		panel2.setVisible(true);

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
