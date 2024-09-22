package views;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import panelControllers.StatisticsPanelController;

public class StatisticsPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTable tableAuthor;
	private JTable tableContent;
	private JTable tableAgrupation;
	private static final String THE_IMAGE_FILE = new File("").getAbsolutePath() + "\\src\\img\\logo.png";

	public StatisticsPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabelSongsPodcastMostListened = new JLabel("10 canciones/podcast mas oidos");
		lblNewLabelSongsPodcastMostListened.setBounds(252, 19, 170, 30);
		panel.add(lblNewLabelSongsPodcastMostListened);

		JLabel lblNewLabelCDSeriesMostListened = new JLabel("10 discos/series mas oidos");
		lblNewLabelCDSeriesMostListened.setBounds(688, 19, 170, 30);
		panel.add(lblNewLabelCDSeriesMostListened);

		JLabel lblNewLabelGroupsPodcastersMostListened = new JLabel("10 grupos/podcasters mas oidos");
		lblNewLabelGroupsPodcastersMostListened.setBounds(473, 19, 170, 30);
		panel.add(lblNewLabelGroupsPodcastersMostListened);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(221, 59, 220, 200);
		panel.add(scrollPane);

		tableContent = new JTable();
		tableContent.setCellSelectionEnabled(true);
		scrollPane.setViewportView(tableContent);

		llenarTablacontent(panels);
		scrollPane.setViewportView(tableContent);

		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(473, 59, 180, 200);
		panel.add(scrollPane2);

		tableAgrupation = new JTable();
		tableAgrupation.setCellSelectionEnabled(true);
		scrollPane2.setViewportView(tableAgrupation);

		llenarTablaAgrupation(panels);
		scrollPane2.setViewportView(tableAgrupation);
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(688, 59, 180, 200);
		panel.add(scrollPane3);

		tableAuthor = new JTable();
		tableAuthor.setCellSelectionEnabled(true);
		scrollPane3.setViewportView(tableAuthor);
		llenarTablaAuthor(panels);
		scrollPane3.setViewportView(tableAuthor);
		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(48, 60, 150, 150);
		lblNewLabel.setIcon(new ImageIcon(THE_IMAGE_FILE));
		panel.add(lblNewLabel);

		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(414, 303, 100, 25);
		btnNewButtonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(18).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonGoBack);

		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setBounds(638, 303, 100, 25);
		btnNewButtonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(18).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel.add(btnNewButtonProfile);

		panel.setLayout(null);

		tableContent.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tableContent.getSelectedRow();
					if (selectedRow != -1) {
						Integer groupId = Integer.parseInt(tableContent.getValueAt(selectedRow, 0).toString());
						String groupName = (String) tableContent.getValueAt(selectedRow, 1);

					}
				}
			}
		});
	}

	private void llenarTablacontent(ArrayList<JPanel> panels) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("titulo");
		tableModel.addColumn("Reproducciones");

		StatisticsPanelController funcionalidades = new StatisticsPanelController();
		try {
			tableModel = funcionalidades.llenarTablaContent(panels, tableContent);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception patata1) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + patata1.getMessage());
		}

		tableContent.setModel(tableModel);
		tableContent.repaint();
	}

	private void llenarTablaAgrupation(ArrayList<JPanel> panels) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Titulo");
		tableModel.addColumn("Reproducciones");

		StatisticsPanelController funcionalidades = new StatisticsPanelController();
		try {
			tableModel = funcionalidades.llenarTablaagrupation(panels, tableAgrupation);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception patata1) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + patata1.getMessage());
		}

		tableContent.setModel(tableModel);
		tableContent.repaint();
	}

	private void llenarTablaAuthor(ArrayList<JPanel> panels) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Titulo");
		tableModel.addColumn("Reproducciones");

		StatisticsPanelController funcionalidades = new StatisticsPanelController();
		try {
			tableModel = funcionalidades.llenarTablaAutores(panels, tableAuthor);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception patata1) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + patata1.getMessage());
		}

		tableContent.setModel(tableModel);
		tableContent.repaint();
	}

	public JPanel getPanel() {
		return panel;
	}

}
