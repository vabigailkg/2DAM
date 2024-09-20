package vistas.ventanas;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import vistas.ventanas.paneles.JPanelEj1;
import vistas.ventanas.paneles.JPanelEj2;
import vistas.ventanas.paneles.JPanelEj3;

public class Ventana {

	// La ventana
	private JFrame frame = null;

	// Medidas estandar de la ventana
	private static final int FRAME_X = 100;
	private static final int FRAME_Y = 100;
	private static final int FRAME_WIDTH = 450;
	private static final int FRAME_HEIGHT = 300;

	// Medidas estandar de todos los paneles
	private static final int PANEL_X = 26;
	private static final int PANEL_Y = 21;
	private static final int PANEL_WIDTH = 356;
	private static final int PANEL_HEIGHT = 156;

	// Constructor
	public Ventana() {
		frame = new JFrame();
	}

	// Inicializamos la ventana y metemos los paneles
	public void initicialziar() {

		// Parametros de la ventana
		frame.setBounds(FRAME_X, FRAME_Y, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		// Botones de la ventana
		JButton jButtonPanel1 = new JButton("RED");
		jButtonPanel1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanel("panelRojo");
			}
		});
		jButtonPanel1.setBounds(42, 213, 89, 23);
		frame.getContentPane().add(jButtonPanel1);

		JButton jButtonPanel2 = new JButton("BLUE");
		jButtonPanel2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanel("panelAzul");
			}
		});
		jButtonPanel2.setBounds(162, 213, 89, 23);
		frame.getContentPane().add(jButtonPanel2);

		JButton jButtonPanel3 = new JButton("GREEN");
		jButtonPanel3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPanel("panelVerde");
			}
		});
		jButtonPanel3.setBounds(293, 213, 89, 23);
		frame.getContentPane().add(jButtonPanel3);

		// Las clases que generan los paneles
		JPanelEj1 jPanelEj1 = new JPanelEj1();
		JPanelEj2 jPanelEj2 = new JPanelEj2();
		JPanelEj3 jPanelEj3 = new JPanelEj3();

		// Paneles de la ventana
		JPanel panelEj1 = jPanelEj1.getJPanel(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT, "panelRojo");
		JPanel panelEj2 = jPanelEj2.getJPanel(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT, "panelAzul");
		JPanel panelEj3 = jPanelEj3.getJPanel(PANEL_X, PANEL_Y, PANEL_WIDTH, PANEL_HEIGHT, "panelVerde");

		// Aniadimos los paneles
		frame.getContentPane().add(panelEj1);
		frame.getContentPane().add(panelEj2);
		frame.getContentPane().add(panelEj3);

		// Ponemos todos los paneles no visibles salvo el Rojo
		panelEj1.setVisible(true);
		panelEj2.setVisible(false);
		panelEj3.setVisible(false);

		// Mostramos la ventana
		frame.setVisible(true);
	}

	/**
	 * Muestra el panel del nombre indicado. Oculta todos los demas paneles
	 * 
	 * @param panelName
	 */
	private void mostrarPanel(String panelName) {
		// Sacamos todos los componentes de JFrame: botones, paneles, etc...

		Component[] componentArray = frame.getContentPane().getComponents();
		List<Component> components = Arrays.asList(componentArray);

		// Recorremos los componentes
		for (Component component : components) {

			// Solo hacemos caso a los JPanel
			if (component instanceof JPanel) {
				if ((null != component.getName()) && (component.getName().equals(panelName))) {
					component.setVisible(true);
				} else {
					component.setVisible(false);
				}
			}
		}
	}

}
