package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;

import java.util.ArrayList;

import javax.swing.JButton;

public class CDPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTextField textField;
	private JTable table;

	public CDPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabel = new JLabel("ImagenDisco");
		lblNewLabel.setBounds(36, 11, 92, 14);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Titulo Disco");
		lblNewLabel_1.setBounds(36, 39, 92, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Fecha Publicacion");
		lblNewLabel_1_1.setBounds(36, 64, 92, 14);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Genero");
		lblNewLabel_1_1_1.setBounds(36, 89, 92, 14);
		panel.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Descripcion");
		lblNewLabel_1_1_1_1.setBounds(36, 114, 92, 14);
		panel.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Numero de Reproducciones");
		lblNewLabel_1_1_1_2.setBounds(36, 139, 136, 14);
		panel.add(lblNewLabel_1_1_1_2);

		textField = new JTextField();
		textField.setBounds(36, 164, 42, 20);
		panel.add(textField);
		textField.setColumns(10);

		table = new JTable();
		table.setBounds(283, 77, 96, 167);
		panel.add(table);

		JLabel lblListaDeCanciones = new JLabel("Lista de Canciones");
		lblListaDeCanciones.setBounds(282, 39, 97, 14);
		panel.add(lblListaDeCanciones);

		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(39, 266, 89, 23);
		panel.add(btnNewButtonGoBack);

		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setBounds(36, 221, 89, 23);
		panel.add(btnNewButtonProfile);

		panel.setLayout(null);

	}

	public JPanel getPanel() {
		return panel;
	}
}