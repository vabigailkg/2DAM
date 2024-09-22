package views;

import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import db.pojos.*;
import panelControllers.MainPanelController;
import utils.functionalities.Functionalities;
import utils.functionalities.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;

public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private Album album = null;
	private Group grupo = null;
	private MainPanelController mainController = null;
	private Functionalities functionalities = null;
	private JButton lblNewLabelAdministrationFunction = new JButton("Funciones de administrador");
	private JButton btnNewButtonStatisticConsult = new JButton("Consultar Estadisticas");
	private JButton btnNewButtonGroupManagement = new JButton("Gestionar Grupos");
	private Sesion sesion = Sesion.getInstance();

	public MainPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBackground(new Color(58, 58, 58));
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		album = new Album();
		grupo = new Group();
		panel.setLayout(null);
		mainController = new MainPanelController();
		functionalities = new Functionalities();
		try {
			mainController.getAdd(album, grupo);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception patata1) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + patata1.getMessage());
		}

		JButton btnNewButtonGroups = new JButton("Descubre Grupos");
		btnNewButtonGroups.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButtonGroups.setBounds(600, 30, 250, 50);
		btnNewButtonGroups.setForeground(new Color(62, 202, 27));
		btnNewButtonGroups.setBackground(new Color(58, 58, 58));
		btnNewButtonGroups.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(5).setVisible(true);
			}
		});
		panel.setLayout(null);
		panel.add(btnNewButtonGroups);

		JButton btnNewButtonPodcast = new JButton("Descubre Podcast");
		btnNewButtonPodcast.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButtonPodcast.setBounds(600, 100, 250, 50);
		btnNewButtonPodcast.setForeground(new Color(62, 202, 27));
		btnNewButtonPodcast.setBackground(new Color(58, 58, 58));
		btnNewButtonPodcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(12).setVisible(true);
			}
		});
		panel.add(btnNewButtonPodcast);

		JButton btnNewButtonFavorites = new JButton("Mis Favoritos");
		btnNewButtonFavorites.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButtonFavorites.setBounds(600, 170, 250, 50);
		btnNewButtonFavorites.setForeground(new Color(62, 202, 27));
		btnNewButtonFavorites.setBackground(new Color(58, 58, 58));
		btnNewButtonFavorites.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(4).setVisible(true);
			}
		});
		panel.add(btnNewButtonFavorites);

		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButtonProfile.setBounds(600, 240, 250, 50);
		btnNewButtonProfile.setForeground(new Color(62, 202, 27));
		btnNewButtonProfile.setBackground(new Color(58, 58, 58));
		btnNewButtonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel.add(btnNewButtonProfile);

		JButton btnNewButtonExit = new JButton("Salir");
		btnNewButtonExit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButtonExit.setBounds(600, 310, 250, 50);
		btnNewButtonExit.setForeground(new Color(62, 202, 27));
		btnNewButtonExit.setBackground(new Color(58, 58, 58));
		btnNewButtonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(8).setVisible(false);
				panels.get(1).setVisible(true);
			}
		});
		panel.add(btnNewButtonExit);
		JLabel lblNewLabelGroupImage = new JLabel();
		lblNewLabelGroupImage.setBounds(50, 25, 200, 200);
		panel.add(lblNewLabelGroupImage);
		lblNewLabelGroupImage.setForeground(new Color(62, 202, 27));
		lblNewLabelGroupImage.setBackground(new Color(58, 58, 58));
		lblNewLabelGroupImage.setIcon(new ImageIcon(mainController.imageConverter(album)));

		JLabel lblNewLabelGroupName = new JLabel();
		lblNewLabelGroupName.setBounds(50, 260, 100, 20);
		lblNewLabelGroupName.setForeground(new Color(62, 202, 27));
		lblNewLabelGroupName.setBackground(new Color(58, 58, 58));
		panel.add(lblNewLabelGroupName);

		JLabel lblNewLabelCDTitle = new JLabel();
		lblNewLabelCDTitle.setBounds(50, 300, 100, 20);
		lblNewLabelCDTitle.setForeground(new Color(62, 202, 27));
		lblNewLabelCDTitle.setBackground(new Color(58, 58, 58));
		panel.add(lblNewLabelCDTitle);

		JLabel lblNewLabelCDDate = new JLabel();
		lblNewLabelCDDate.setBounds(50, 340, 100, 20);
		lblNewLabelCDDate.setForeground(new Color(62, 202, 27));
		lblNewLabelCDDate.setBackground(new Color(58, 58, 58));
		panel.add(lblNewLabelCDDate);

		JLabel lblNewLabelCDGenre = new JLabel();
		lblNewLabelCDGenre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabelCDGenre.setBounds(50, 380, 100, 20);
		lblNewLabelCDGenre.setForeground(new Color(62, 202, 27));
		lblNewLabelCDGenre.setBackground(new Color(58, 58, 58));
		panel.add(lblNewLabelCDGenre);

		lblNewLabelGroupName.setText(grupo.getName());
		lblNewLabelCDTitle.setText(album.getTitle());
		lblNewLabelCDDate.setText(functionalities.date(album));
		lblNewLabelCDGenre.setText(album.getGenre());
		lblNewLabelAdministrationFunction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sesion.isAdmin()) {
					btnNewButtonStatisticConsult.setVisible(true);
					btnNewButtonGroupManagement.setVisible(true);
				}
			}
		});
		btnNewButtonGroupManagement.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButtonGroupManagement.setBounds(50, 500, 300, 50);
		btnNewButtonGroupManagement.setForeground(new Color(62, 202, 27));
		btnNewButtonGroupManagement.setBackground(new Color(58, 58, 58));
		btnNewButtonGroupManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panels.get(8).setVisible(false);
				panels.get(6).setVisible(true);

			}
		});

		panel.add(btnNewButtonGroupManagement);

		btnNewButtonStatisticConsult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButtonStatisticConsult.setBounds(640, 500, 300, 50);
		btnNewButtonStatisticConsult.setForeground(new Color(62, 202, 27));
		btnNewButtonStatisticConsult.setBackground(new Color(58, 58, 58));
		btnNewButtonStatisticConsult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panels.get(8).setVisible(false);
				panels.get(18).setVisible(true);
			}
		});
		panel.add(btnNewButtonStatisticConsult);

		lblNewLabelAdministrationFunction.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabelAdministrationFunction.setBounds(355, 430, 280, 56);
		lblNewLabelAdministrationFunction.setForeground(new Color(62, 202, 27));
		lblNewLabelAdministrationFunction.setBackground(new Color(58, 58, 58));
		panel.add(lblNewLabelAdministrationFunction);

		btnNewButtonGroupManagement.setVisible(false);
		btnNewButtonStatisticConsult.setVisible(false);
		lblNewLabelAdministrationFunction.setVisible(true);

	}

	public JPanel getPanel() {
		return panel;

	}
}