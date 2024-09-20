package view.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Crea el panel para cargar todos los mensajes.
	 */
	public JPanelMenu() {
		setLayout(null);

		// Botones
		JButton btnNewButton_CargarMensajes = new JButton("Cargar mensajes");
		btnNewButton_CargarMensajes.setBounds(131, 194, 180, 36);
		add(btnNewButton_CargarMensajes);
		// Evento
//		btnNewButton_CargarMensajes.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//							mostrarPanel("panelRojo");
//			}
//		});

		JButton btnNewButton_GuardarMensajes = new JButton("Guardar mensajes");
		btnNewButton_GuardarMensajes.setBounds(488, 194, 180, 36);
		add(btnNewButton_GuardarMensajes);
		// Evento
//		btnNewButton_GuardarMensajes.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//						mostrarPanel("panelRojo");
//			}
//		});

		JButton btnNewButton_AñadirMensajes = new JButton("Añadir mensajes");
		btnNewButton_AñadirMensajes.setBounds(131, 291, 180, 36);
		add(btnNewButton_AñadirMensajes);
		// Evento
//		btnNewButton_AñadirMensajes.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//						mostrarPanel("panelRojo");
//			}
//		});

		JButton btnNewButton_Salir = new JButton("Salir");
		btnNewButton_Salir.setBounds(488, 457, 180, 36);
		add(btnNewButton_Salir);
		// Evento
//		btnNewButton_Salir.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//						mostrarPanel("panelRojo");
//			}
//		});

		JButton btnNewButton_ImprimirMensajes = new JButton("Imprimir mensajes");
		btnNewButton_ImprimirMensajes.setBounds(488, 291, 180, 36);
		add(btnNewButton_ImprimirMensajes);
		// Evento
//		btnNewButton_ImprimirMensajes.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//						mostrarPanel("panelRojo");
//			}
//		});
	}

}
