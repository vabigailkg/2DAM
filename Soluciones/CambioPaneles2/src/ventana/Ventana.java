package ventana;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ventana.paneles.GestorPanel1;
import ventana.paneles.GestorPanel2;
import ventana.paneles.GestorPanel3;

public class Ventana {

	private JFrame frame;
	private ArrayList <JPanel> paneles = null;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Ventana().frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.na
	 */
	public Ventana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		// Lista que contiene los paneles
		paneles = new ArrayList <JPanel> ();
		
		// Creamos los gestores y los paneles. Pasamos la lista por el constructor
		GestorPanel1 gestorPanel1 = new GestorPanel1(paneles);
		JPanel panel1 = gestorPanel1.getPanel();
		panel1.setVisible(true);
		
		// Lo metemos en la lista y en la ventana
		paneles.add(panel1);
		frame.getContentPane().add(panel1);
		
		// Creamos los gestores y los paneles. Pasamos la lista por el constructor
		GestorPanel2 gestorPanel2 = new GestorPanel2(paneles);
		JPanel panel2 = gestorPanel2.getPanel();
		panel2.setVisible(false);
		
		// Lo metemos en la lista y en la ventana
		paneles.add(panel2);
		frame.getContentPane().add(panel2);
		
		// Creamos los gestores y los paneles. Pasamos la lista por el constructor
		GestorPanel3 gestorPanel3 = new GestorPanel3(paneles);
		JPanel panel3 = gestorPanel3.getPanel();
		panel3.setVisible(false);
		
		// Lo metemos en la lista y en la ventana
		paneles.add(panel3);
		frame.getContentPane().add(panel3);
	}
}
