package views;

import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class RemoveAuthorPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTextField textFieldName;
	/**
	 * Create the panel.
	 */
	public RemoveAuthorPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		JLabel lblNewLabelName = new JLabel("Nombre");
		lblNewLabelName.setBounds(99, 125, 46, 14);
		panel.add(lblNewLabelName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(196, 122, 86, 20);
		panel.add(textFieldName);
		textFieldName.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Grupo de Musica", "Podcaster"}));
		comboBox.setBounds(151, 48, 114, 20);
		panel.add(comboBox);
		
		JLabel lblNewLabelConfirmationQuestion = new JLabel("¿Seguro que quieres eliminar?");
		lblNewLabelConfirmationQuestion.setBounds(123, 210, 159, 14);
		panel.add(lblNewLabelConfirmationQuestion);
		
		JButton btnNewButtonRemove = new JButton("Eliminar");
		btnNewButtonRemove.setBounds(99, 243, 89, 23);
		panel.add(btnNewButtonRemove);
		
		JButton btnNewButtonCancel = new JButton("Cancelar");
		btnNewButtonCancel.setBounds(233, 243, 89, 23);
		panel.add(btnNewButtonCancel);
		
		panel.setLayout(null);
	}
	public JPanel getPanel() {
		return panel;
	}

}
