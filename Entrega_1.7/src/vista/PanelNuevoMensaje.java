package vista;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.MensajeController;
import modelo.GestorFicheros;
import modelo.Mensaje;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

/**
 * El panel donde se introduce un nuevo mensaje.
 */
public class PanelNuevoMensaje extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField campoFecha;
	private JTextField campoContenido;
	private JTextField campoAsunto;
	private JTextField campoPara;
	private JTextField campoDe;
	private MensajeController mensajeController;

	public PanelNuevoMensaje(MensajeController mensajeController) {
		this.mensajeController = mensajeController; // Guardar referencia al controlador
		setBounds(new Rectangle(0, 0, 640, 480));
		setLayout(null);

		JButton botonCancel = new JButton("Cancel");
		botonCancel.setBounds(467, 390, 127, 23);
		add(botonCancel);

		JButton botonOK = new JButton("Ok");
		botonOK.setBounds(368, 390, 89, 23);
		add(botonOK);
		// Botón llama a método para actualizar fichero
		botonOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					añadirMensaje();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel textoFecha = new JLabel("Fecha");
		textoFecha.setBounds(80, 88, 46, 14);
		add(textoFecha);

		JLabel textoHora = new JLabel("Hora");
		textoHora.setBounds(80, 139, 46, 14);
		add(textoHora);

		JLabel textoDe = new JLabel("De");
		textoDe.setBounds(80, 195, 46, 14);
		add(textoDe);

		JLabel textoPara = new JLabel("Para");
		textoPara.setBounds(80, 240, 46, 14);
		add(textoPara);

		JLabel textoAsunto = new JLabel("Asunto");
		textoAsunto.setBounds(80, 278, 46, 14);
		add(textoAsunto);

		JLabel textoContenido = new JLabel("Contenido");
		textoContenido.setBounds(80, 317, 69, 14);
		add(textoContenido);

		campoFecha = new JTextField();
		campoFecha.setBounds(136, 85, 86, 20);
		add(campoFecha);
		campoFecha.setColumns(10);

		campoContenido = new JTextField();
		campoContenido.setBounds(136, 314, 458, 58);
		add(campoContenido);
		campoContenido.setColumns(10);

		campoAsunto = new JTextField();
		campoAsunto.setBounds(136, 275, 458, 20);
		add(campoAsunto);
		campoAsunto.setColumns(10);

		campoPara = new JTextField();
		campoPara.setBounds(136, 237, 458, 20);
		add(campoPara);
		campoPara.setColumns(10);

		campoDe = new JTextField();
		campoDe.setBounds(136, 192, 458, 20);
		add(campoDe);
		campoDe.setColumns(10);

		JComboBox comboHora = new JComboBox();
		comboHora.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03" }));
		comboHora.setMaximumRowCount(3);
		comboHora.setBounds(136, 135, 58, 22);
		add(comboHora);

		JLabel textoPuntos = new JLabel(":");
		textoPuntos.setBounds(214, 139, 13, 14);
		add(textoPuntos);

		JComboBox comboMinuto = new JComboBox();
		comboMinuto.setModel(new DefaultComboBoxModel(new String[] { "00", "15", "30", "45" }));
		comboMinuto.setMaximumRowCount(4);
		comboMinuto.setBounds(237, 135, 58, 22);
		add(comboMinuto);

		JComboBox comboMes = new JComboBox();
		comboMes.setModel(new DefaultComboBoxModel(new String[] { "Enero", "Febrero", "Marzo" }));
		comboMes.setMaximumRowCount(12);
		comboMes.setBounds(254, 84, 103, 22);
		add(comboMes);

		JComboBox comboDia = new JComboBox();
		comboDia.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03" }));
		comboDia.setToolTipText("");
		comboDia.setMaximumRowCount(31);
		comboDia.setBounds(427, 84, 46, 22);
		add(comboDia);
	}

	private void añadirMensaje() throws IOException {
		String de = campoDe.getText().trim();
		String para = campoPara.getText().trim();
		String fecha = campoFecha.getText().trim();

		String hora = String.format("%s:%s", ((JComboBox<String>) getComponent(3)).getSelectedItem(),
				((JComboBox<String>) getComponent(4)).getSelectedItem());

		String asunto = campoAsunto.getText().trim();
		String contenido = campoContenido.getText().trim();

		// Validar campos
		if (de.isEmpty() || para.isEmpty() || fecha.isEmpty() || hora.isEmpty() || asunto.isEmpty()
				|| contenido.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Crear el mensaje y añadirlo al controlador
		Mensaje mensaje = new Mensaje(de, para, fecha, hora, asunto, contenido);
		mensajeController.agregarMensaje(mensaje); // Agregar al GestorMensajes
		mensajeController.guardarMensajes(); // Guardar en el fichero

		// Limpiar campos
		campoDe.setText("");
		campoPara.setText("");
		campoFecha.setText("");
		((JComboBox<String>) getComponent(3)).setSelectedIndex(0); // Resetear hora
		((JComboBox<String>) getComponent(4)).setSelectedIndex(0); // Resetear minuto
		campoAsunto.setText("");
		campoContenido.setText("");

		JOptionPane.showMessageDialog(this, "Mensaje añadido correctamente.");
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
	 * @return El PanelNuevoMensaje con sus componentes añadidos
	 */
	public JPanel getJPanel(int x, int y, int width, int height, String name) {
		// Usamos this para coger este panel ya creado con todos sus elementos
		this.setBounds(x, y, width, height);
		this.setLayout(null);
		this.setBackground(Color.blue);
		this.setName(name);

		return this;
	}
}
