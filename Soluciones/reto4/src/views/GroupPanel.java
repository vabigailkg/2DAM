
package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import db.pojos.Album;
import db.pojos.Group;
import db.pojos.Song;
import panelControllers.GroupPanelController;
import utils.functionalities.Sesion;

public class GroupPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTable tableGroups;
	private JTable tableAlbums;
	private JTable tableSongPick;
	private JLabel lblNewLabelGroupImage;
	private JLabel lblNewLabelGroupName;
	private JLabel lblNewLabelDate;
	private JLabel lblNewLabelDescription;
	private JLabel lblNewLabelReplayAmount;
	private JLabel lblNewLabelCDList;
	private JLabel lblNewLabelAlbum;
	private JLabel lblNewLabelAlbumTitle;
	private JLabel lblNewLabelAlbumDate;
	private JLabel lblNewLabelAlbumGender;
	private JLabel lblNewLabelAlbumDescription;
	private JLabel lblNewLabelAlbumViews;
	private JLabel lblNewLabelSongName;
	private JLabel lblNewLabelSongLength;
	private JLabel lblNewLabelSongViews;
	private JLabel lblidCD;
	private Sesion sesion = Sesion.getInstance();
	private static final String THE_IMAGE_FILE = new File("").getAbsolutePath() + "\\src\\img\\logo.png";

	public GroupPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(764, 24, 150, 150);
		lblNewLabel.setIcon(new ImageIcon(THE_IMAGE_FILE));
		panel.add(lblNewLabel);

		lblNewLabelGroupImage = new JLabel("ImagenGrupo");
		lblNewLabelGroupImage.setBounds(243, 24, 150, 150);
		panel.add(lblNewLabelGroupImage);

		lblNewLabelGroupName = new JLabel("NombreGrupo");
		lblNewLabelGroupName.setBounds(448, 36, 118, 14);
		panel.add(lblNewLabelGroupName);

		lblNewLabelDate = new JLabel("FechaFormacion");
		lblNewLabelDate.setBounds(448, 60, 118, 14);
		panel.add(lblNewLabelDate);

		lblNewLabelDescription = new JLabel("Descripcion");
		lblNewLabelDescription.setBounds(448, 84, 118, 14);
		panel.add(lblNewLabelDescription);

		lblNewLabelReplayAmount = new JLabel("Numero de Reproducciones");
		lblNewLabelReplayAmount.setBounds(448, 108, 131, 14);
		panel.add(lblNewLabelReplayAmount);

		lblNewLabelCDList = new JLabel("ELIGE DISCO");
		lblNewLabelCDList.setBounds(251, 184, 83, 14);
		panel.add(lblNewLabelCDList);

		JButton buttonGoBack = new JButton("Volver");
		buttonGoBack.setBounds(44, 273, 89, 23);
		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(5).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(buttonGoBack);

		JButton buttonProfile = new JButton("Perfil");
		buttonProfile.setBounds(44, 303, 89, 23);
		buttonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(5).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel.add(buttonProfile);

		panel.setLayout(null);

		JLabel lblNewLabelPickGroup = new JLabel("ELIGE GRUPO");
		lblNewLabelPickGroup.setBounds(44, 26, 89, 14);
		panel.add(lblNewLabelPickGroup);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 60, 149, 194);
		panel.add(scrollPane);

		tableGroups = new JTable();
		tableGroups.setCellSelectionEnabled(true);
		scrollPane.setViewportView(tableGroups);

		llenarTablaGrupos(panels);
		scrollPane.setViewportView(tableGroups);

		JButton buttonPlay = new JButton("Reproducir");
		buttonPlay.setBounds(44, 337, 89, 23);
		buttonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sesion.setIdAlbum(Integer.parseInt(lblidCD.getText()));
				sesion.setTitle(lblNewLabelSongName.getText());

				panels.get(5).setVisible(false);
				panels.get(10).setVisible(true);
			}
		});
		panel.add(buttonPlay);
		buttonPlay.setEnabled(false);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(251, 209, 118, 151);
		panel.add(scrollPane_1);

		tableAlbums = new JTable();
		tableAlbums.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column" }));
		scrollPane_1.setViewportView(tableAlbums);

		lblNewLabelAlbum = new JLabel("ImagenDisco");
		lblNewLabelAlbum.setBounds(416, 184, 150, 150);
		panel.add(lblNewLabelAlbum);

		lblNewLabelAlbumTitle = new JLabel("NombreDisco");
		lblNewLabelAlbumTitle.setBounds(589, 184, 83, 14);
		panel.add(lblNewLabelAlbumTitle);

		lblNewLabelAlbumDate = new JLabel("FechaDisco");
		lblNewLabelAlbumDate.setBounds(589, 210, 70, 14);
		panel.add(lblNewLabelAlbumDate);

		lblNewLabelAlbumGender = new JLabel("GeneroDisco");
		lblNewLabelAlbumGender.setBounds(589, 240, 70, 14);
		panel.add(lblNewLabelAlbumGender);

		lblNewLabelAlbumDescription = new JLabel("DescripcionDisco");
		lblNewLabelAlbumDescription.setBounds(589, 264, 83, 14);
		panel.add(lblNewLabelAlbumDescription);

		lblNewLabelAlbumViews = new JLabel("ReproduccionesDisco");
		lblNewLabelAlbumViews.setBounds(589, 288, 101, 14);
		panel.add(lblNewLabelAlbumViews);

		JLabel lblNewLabelSongPick = new JLabel("ELIGE CANCION");
		lblNewLabelSongPick.setBounds(251, 405, 83, 14);
		panel.add(lblNewLabelSongPick);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(251, 440, 118, 125);
		panel.add(scrollPane_2);

		tableSongPick = new JTable();
		tableSongPick.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column" }));
		scrollPane_2.setViewportView(tableSongPick);

		lblNewLabelSongName = new JLabel("NombreCancion");
		lblNewLabelSongName.setBounds(483, 405, 83, 14);
		panel.add(lblNewLabelSongName);

		lblNewLabelSongLength = new JLabel("DuracionCancion");
		lblNewLabelSongLength.setBounds(483, 441, 83, 14);
		panel.add(lblNewLabelSongLength);

		lblNewLabelSongViews = new JLabel("ReproduccionesCancion");
		lblNewLabelSongViews.setBounds(483, 475, 118, 14);
		panel.add(lblNewLabelSongViews);

		lblidCD = new JLabel("idCd");
		lblidCD.setBounds(483, 501, 45, 13);
		panel.add(lblidCD);

		tableGroups.getSelectionModel().addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tableGroups.getSelectedRow();
					if (selectedRow != -1) {
						Integer groupId = Integer.parseInt(tableGroups.getValueAt(selectedRow, 0).toString());
						String groupName = (String) tableGroups.getValueAt(selectedRow, 1);
						lblNewLabelAlbum.setText("");
						lblNewLabelAlbumTitle.setText("");
						lblNewLabelAlbumDate.setText("");
						lblNewLabelAlbumGender.setText("");
						lblNewLabelAlbumDescription.setText("");
						lblNewLabelAlbumViews.setText("");

						DefaultTableModel emptySongTableModel = new DefaultTableModel();
						tableSongPick.setModel(emptySongTableModel);

						lblNewLabelSongName.setText("");
						lblNewLabelSongLength.setText("");
						lblNewLabelSongViews.setText("");
						lblidCD.setText("");
						buttonPlay.setEnabled(false);

						cargarInformacionGrupo(groupName);

						cargarTablaDiscos(panels, groupId);
					}
				}
			}
		});

		tableAlbums.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tableAlbums.getSelectedRow();
					if (selectedRow != -1) {
						int albumId = (int) tableAlbums.getValueAt(selectedRow, 0);
						DefaultTableModel emptySongTableModel = new DefaultTableModel();
						tableSongPick.setModel(emptySongTableModel);

						lblNewLabelSongName.setText("");
						lblNewLabelSongLength.setText("");
						lblNewLabelSongViews.setText("");
						lblidCD.setText("");
						cargarInformacionDisco(albumId);
						buttonPlay.setEnabled(false);

						cargarTablaCanciones(panels, albumId);
					}
				}
			}
		});

		tableSongPick.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tableSongPick.getSelectedRow();
					if (selectedRow != -1) {
						int songId = (int) tableSongPick.getValueAt(selectedRow, 0);

						cargarInformacionCancion(songId);
						buttonPlay.setEnabled(true);
					}
				}
			}
		});

	}

	private void llenarTablaGrupos(ArrayList<JPanel> panels) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idGrupo");
		tableModel.addColumn("Nombre");

		GroupPanelController funcionalidades = new GroupPanelController();
		try {
			tableModel = funcionalidades.llenarTablagrupos(panels, tableGroups);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + e.getMessage());
		}

		tableGroups.setModel(tableModel);
		tableGroups.repaint();
	}

	private void cargarInformacionGrupo(String groupName) {

		GroupPanelController funcionalidades = new GroupPanelController();

		try {
			Group grupo = funcionalidades.obtenerInformacionGrupo(groupName);
			if (grupo != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				String fechaFormacionStr = dateFormat.format(grupo.getCreationDate());

				lblNewLabelGroupImage.setIcon(new ImageIcon(funcionalidades.imageConverter(grupo)));
				lblNewLabelGroupName.setText(grupo.getName() != null ? grupo.getName() : "");
				lblNewLabelDate.setText(fechaFormacionStr != null ? fechaFormacionStr : "");
				lblNewLabelDescription.setText(grupo.getDescription() != null ? grupo.getDescription() : "");
				lblNewLabelReplayAmount.setText(Integer.toString(grupo.getNumReproduccion()));

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar la información del grupo: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargarTablaDiscos(ArrayList<JPanel> panels, int idGroup) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idDisco");
		tableModel.addColumn("titulo");

		GroupPanelController funcionalidades = new GroupPanelController();
		try {
			tableModel = funcionalidades.llenarTablaDiscos(panels, tableAlbums, idGroup);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + e.getMessage());
		}
		tableAlbums.setModel(tableModel);
		tableAlbums.repaint();
	}

	protected void cargarInformacionDisco(int albumId) {
		GroupPanelController funcionalidades = new GroupPanelController();

		try {
			Album disco = funcionalidades.obtenerDiscoPorTitulo(albumId);
			if (disco != null) {
				lblNewLabelAlbum.setIcon(new ImageIcon(funcionalidades.imageConverterDisco(disco.getCdImage())));
				lblNewLabelAlbumTitle.setText(disco.getTitle() != null ? disco.getTitle() : "");
				lblNewLabelAlbumDate
						.setText(disco.getPublicationDate() != null ? disco.getPublicationDate().toString() : "");
				lblNewLabelAlbumGender.setText(disco.getGenre() != null ? disco.getGenre() : "");
				lblNewLabelAlbumDescription.setText(disco.getDescription() != null ? disco.getDescription() : "");
				lblNewLabelAlbumViews.setText(Integer.toString(disco.getNumReproduccion()));
				sesion.setImagen(disco.getCdImage());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar la información del disco: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void cargarTablaCanciones(ArrayList<JPanel> panels, int albumId) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("id");
		tableModel.addColumn("titulo");

		GroupPanelController funcionalidades = new GroupPanelController();
		try {
			tableModel = funcionalidades.llenarTablaCanciones(panels, tableSongPick, albumId);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + e.getMessage());
		}
		tableSongPick.setModel(tableModel);
		tableSongPick.repaint();

	}

	private void cargarInformacionCancion(int songId) {
		GroupPanelController funcionalidades = new GroupPanelController();
		try {
			Song cancion = funcionalidades.obtenerCancionPorId(songId);

			if (cancion != null) {
				lblNewLabelSongName.setText(cancion.getTitle() != null ? cancion.getTitle() : "");
				lblNewLabelSongLength.setText(cancion.getDuration() != null ? cancion.getDuration() : "");
				lblNewLabelSongViews.setText(Integer.toString(cancion.getPlayAmount()));
				lblidCD.setText(Integer.toString(cancion.getIdCd()));

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar la información de la canción: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public JPanel getPanel() {
		return panel;
	}
}