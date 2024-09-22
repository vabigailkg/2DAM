package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.util.ArrayList;

import javax.swing.JButton;

public class SongPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldReplayAmount;
	private JTextField textFieldDuration;
	private JPanel panel = null;

	public SongPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabelSongTitle = new JLabel("TituloCancion");
		lblNewLabelSongTitle.setBounds(63, 52, 78, 14);
		panel.add(lblNewLabelSongTitle);

		JLabel lblNewLabelDuration = new JLabel("Duracion");
		lblNewLabelDuration.setBounds(63, 96, 78, 14);
		panel.add(lblNewLabelDuration);

		JLabel lblNewLabelReplayAmount = new JLabel("Numero de Reproducciones");
		lblNewLabelReplayAmount.setBounds(63, 172, 78, 14);
		panel.add(lblNewLabelReplayAmount);

		textFieldReplayAmount = new JTextField();
		textFieldReplayAmount.setBounds(55, 203, 86, 20);
		panel.add(textFieldReplayAmount);
		textFieldReplayAmount.setColumns(10);

		textFieldDuration = new JTextField();
		textFieldDuration.setBounds(55, 128, 86, 20);
		panel.add(textFieldDuration);
		textFieldDuration.setColumns(10);

		JButton btnNewButtonPlay = new JButton("Reproducir");
		btnNewButtonPlay.setBounds(260, 92, 89, 23);
		panel.add(btnNewButtonPlay);

		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(260, 148, 89, 23);
		panel.add(btnNewButtonGoBack);

		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setBounds(260, 202, 89, 23);
		panel.add(btnNewButtonProfile);

		panel.setLayout(null);

	}

	public JPanel getPanel() {
		return panel;
	}
}
