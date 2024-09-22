package views;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SeriesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTextField textFieldReplayAmount;
	private JTable table;
	private JTextField textFieldStartDate;
	private JTextField textFieldEndDate;

	public SeriesPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabelTitle = new JLabel("Titulo");
		lblNewLabelTitle.setBounds(36, 11, 92, 14);
		panel.add(lblNewLabelTitle);

		JLabel lblNewLabelTopic = new JLabel("Tematica");
		lblNewLabelTopic.setBounds(36, 39, 92, 14);
		panel.add(lblNewLabelTopic);

		JLabel lblNewLabelStartDate = new JLabel("Fecha de inicio");
		lblNewLabelStartDate.setBounds(36, 64, 92, 14);
		panel.add(lblNewLabelStartDate);

		JLabel lblNewLabelEndDate = new JLabel("Fecha fin");
		lblNewLabelEndDate.setBounds(36, 89, 92, 14);
		panel.add(lblNewLabelEndDate);

		JLabel lblNewLabelDescription = new JLabel("Descripcion");
		lblNewLabelDescription.setBounds(36, 114, 92, 14);
		panel.add(lblNewLabelDescription);

		JLabel lblNewLabelReplayAmount = new JLabel("Numero de Reproducciones");
		lblNewLabelReplayAmount.setBounds(36, 139, 136, 14);
		panel.add(lblNewLabelReplayAmount);

		textFieldReplayAmount = new JTextField();
		textFieldReplayAmount.setBounds(36, 164, 42, 20);
		panel.add(textFieldReplayAmount);
		textFieldReplayAmount.setColumns(10);

		table = new JTable();
		table.setBounds(283, 77, 96, 167);
		panel.add(table);

		JLabel lblNewLabelSongList = new JLabel("Lista de Canciones");
		lblNewLabelSongList.setBounds(282, 39, 97, 14);
		panel.add(lblNewLabelSongList);

		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(39, 266, 89, 23);
		panel.add(btnNewButtonGoBack);

		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setBounds(36, 221, 89, 23);
		panel.add(btnNewButtonProfile);

		textFieldStartDate = new JTextField();
		textFieldStartDate.setColumns(10);
		textFieldStartDate.setBounds(130, 64, 72, 20);
		panel.add(textFieldStartDate);

		textFieldEndDate = new JTextField();
		textFieldEndDate.setColumns(10);
		textFieldEndDate.setBounds(130, 89, 72, 20);
		panel.add(textFieldEndDate);

		panel.setLayout(null);
	}

	public JPanel getPanel() {
		return panel;
	}

}
