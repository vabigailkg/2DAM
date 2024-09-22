package views;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ModifyAuthorPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTextField textFieldName;
	private JTextField textFieldDescription;
	private JTextField textFieldImage;

	public ModifyAuthorPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabelName = new JLabel("Nombre");
		lblNewLabelName.setBounds(91, 109, 46, 14);
		panel.add(lblNewLabelName);

		JLabel lblNewLabelDescription = new JLabel("Descripcion");
		lblNewLabelDescription.setBounds(91, 157, 46, 14);
		panel.add(lblNewLabelDescription);

		JLabel lblNewLabelImage = new JLabel("Imagen");
		lblNewLabelImage.setBounds(91, 206, 46, 14);
		panel.add(lblNewLabelImage);

		textFieldName = new JTextField();
		textFieldName.setBounds(147, 106, 86, 20);
		panel.add(textFieldName);
		textFieldName.setColumns(10);

		textFieldDescription = new JTextField();
		textFieldDescription.setText("");
		textFieldDescription.setBounds(147, 154, 86, 20);
		panel.add(textFieldDescription);
		textFieldDescription.setColumns(10);

		textFieldImage = new JTextField();
		textFieldImage.setBounds(147, 203, 86, 20);
		panel.add(textFieldImage);
		textFieldImage.setColumns(10);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Grupo de Musica", "Podcaster" }));
		comboBox.setBounds(151, 48, 114, 20);
		panel.add(comboBox);

		JButton btnNewButtonCancel = new JButton("Cancelar");
		btnNewButtonCancel.setBounds(248, 242, 89, 23);
		panel.add(btnNewButtonCancel);

		JButton btnNewButtonRemove = new JButton("Eliminar");
		btnNewButtonRemove.setBounds(122, 242, 89, 23);
		panel.add(btnNewButtonRemove);

		panel.setLayout(null);
	}

	public JPanel getPanel() {
		return panel;
	}

}