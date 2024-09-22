package views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FavoritePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTable table;
	private JTextField textField;

	public FavoritePanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabelFavoriteList = new JLabel("Listas de Favoritos");
		lblNewLabelFavoriteList.setBounds(52, 36, 97, 14);
		panel.add(lblNewLabelFavoriteList);

		table = new JTable();
		table.setBounds(52, 61, 97, 163);
		panel.add(table);

		JButton btnNewButtonCreate = new JButton("Crear");
		btnNewButtonCreate.setBounds(230, 57, 89, 23);
		panel.add(btnNewButtonCreate);

		JButton btnNewButtonRemove = new JButton("Borrar");
		btnNewButtonRemove.setBounds(230, 91, 89, 23);
		panel.add(btnNewButtonRemove);

		JButton btnNewButtonSee = new JButton("Ver");
		btnNewButtonSee.setBounds(230, 125, 89, 23);
		panel.add(btnNewButtonSee);

		JButton btnNewButtonExport = new JButton("Exportar");
		btnNewButtonExport.setBounds(230, 159, 89, 23);
		panel.add(btnNewButtonExport);

		JButton btnNewButtonImport = new JButton("Importar");
		btnNewButtonImport.setBounds(230, 193, 89, 23);
		panel.add(btnNewButtonImport);

		textField = new JTextField();
		textField.setBounds(354, 58, 86, 20);
		panel.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("NombreListaNueva");
		lblNewLabel.setBounds(372, 36, 46, 14);
		panel.add(lblNewLabel);

		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(36, 268, 89, 23);
		btnNewButtonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(4).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonGoBack);

		panel.setLayout(null);

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(329, 268, 89, 23);
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(4).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel.add(btnPerfil);

	}

	public JPanel getPanel() {
		return panel;
	}
}