
package views;

import db.management.*;
import panelControllers.GroupsManagementPanelController;
import panelControllers.SongPanelController;
import utils.functionalities.Sesion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PlayPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private SongPanelController controlador = null;
	private GroupsManagementPanelController groupManagement = new GroupsManagementPanelController();
	private Sesion sesion = Sesion.getInstance();
	private JLabel lblNewLabel = new JLabel("image");
	private SongManager songManager = new SongManager();
	private static final String THE_IMAGE_FILE = new File("").getAbsolutePath() + "\\src\\img\\logo.png";

	public PlayPanel(ArrayList<JPanel> panels) {

		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabel2 = new JLabel("LOGO");
		lblNewLabel2.setBounds(40, 31, 150, 150);
		lblNewLabel2.setIcon(new ImageIcon(THE_IMAGE_FILE));
		panel.add(lblNewLabel2);
		JButton btnNewButtonPlay = new JButton("PLAY");
		btnNewButtonPlay.setBounds(285, 197, 60, 30);
		btnNewButtonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (sesion.getIdAlbum() != 0) {
					List<String> songNames = null;
					try {
						songNames = songManager.getSongNames();
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
					} catch (Exception patata1) {
						JOptionPane.showMessageDialog(null, "Error genérico - " + patata1.getMessage());
					}
					controlador = new SongPanelController(songNames);

					controlador.play();
				} else if (sesion.getIdSeries() != 0) {
					List<String> songNames = null;
					try {
						songNames = songManager.getPodcastNames();
					} catch (SQLException sqle) {
						JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
					} catch (Exception patata2) {
						JOptionPane.showMessageDialog(null, "Error genérico - " + patata2.getMessage());
					}
					controlador = new SongPanelController(songNames);
					controlador.play();
				} else {
					JOptionPane.showMessageDialog(null, "No ha seleccionado los id");
				}
				try {
					lblNewLabel.setIcon(new ImageIcon(groupManagement.imageConverter()));
				} catch (SQLException sqle) {
					JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
				} catch (Exception patata3) {
					JOptionPane.showMessageDialog(null, "Error genérico - " + patata3.getMessage());
				}

			}
		});
		panel.add(btnNewButtonPlay);

		JButton btnNewButtonPrevious = new JButton("PREV");
		btnNewButtonPrevious.setBounds(90, 200, 100, 25);
		btnNewButtonPrevious.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.playPreviousSong();
			}
		});
		panel.add(btnNewButtonPrevious);

		JButton btnNewButtonNext = new JButton("NEXT");
		btnNewButtonNext.setBounds(551, 200, 100, 25);
		btnNewButtonNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.playNextSong();
			}
		});
		panel.add(btnNewButtonNext);

		JButton btnNewButtonFavorites = new JButton("Favorito");
		btnNewButtonFavorites.setBounds(331, 250, 100, 25);
		panel.add(btnNewButtonFavorites);

		JButton btnNewButtonGoBack = new JButton("Volver");
		btnNewButtonGoBack.setBounds(90, 250, 100, 25);
		btnNewButtonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.stop();
				panels.get(10).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(btnNewButtonGoBack);

		JButton btnNewButtonProfile = new JButton("Perfil");
		btnNewButtonProfile.setBounds(551, 246, 100, 25);
		btnNewButtonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(10).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel.add(btnNewButtonProfile);

		panel.setLayout(null);

		JButton btnNewButtonStop = new JButton("STOP");
		btnNewButtonStop.setBounds(408, 197, 60, 30);
		btnNewButtonStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.stop();
			}
		});
		panel.add(btnNewButtonStop);

		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(311, 31, 150, 150);
		panel.add(lblNewLabel);

	}

	public JPanel getPanel() {
		return panel;
	}

}