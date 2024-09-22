package vista;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

/**
 * JFrame con los paneles.
 */
public class Ventana extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public JFrame ventana = null;

	private JTextField textFieldEquipoLocal;
	private JTextField textFieldEquipoVisitante;
	private JTextField textFieldGolesLocal;
	private JTextField textFieldGolesVisitante;
	private JTextField textFieldLugar;
	private JTextField textFieldFecha;

	// Medidas estándar de ventana
	private static final int FRAME_X = 0;
	private static final int FRAME_Y = 0;
	private static final int FRAME_WIDTH = 640;
	private static final int FRAME_HEIGHT = 480;

	// Medidas estándar de panel
	private static final int PANEL_X = 0;
	private static final int PANEL_Y = 0;
	private static final int PANEL_WIDTH = 640;
	private static final int PANEL_HEIGHT = 480;

	private JTable tabla;

	// Constructor
	public Ventana() {
		ventana = new JFrame();
	}

	// Inicia la ventana con sus parámetros
	public void iniciar() {
		// Parámetros de la ventana
		ventana.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.getContentPane().setLayout(null);

		// Instancia las clases de los paneles y gestores
		Panel panel = new Panel(this);

		// Obtiene los parámetros del panel
		JPanel panel1 = panel.getJPanel(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT, "panel");

		// Agregamos el panel a la ventana
		ventana.getContentPane().add(panel1);

		// Panel visible por defecto
		panel1.setVisible(true);

		// Hacemos visible la ventana
		ventana.setVisible(true);
	}

}
