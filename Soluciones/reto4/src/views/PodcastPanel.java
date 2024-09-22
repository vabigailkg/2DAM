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

import db.pojos.Podcaster;
import db.pojos.Series;
import db.pojos.Song;
import panelControllers.GroupPanelController;
import panelControllers.PodcastPanelController;
import utils.functionalities.Sesion;

public class PodcastPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JTable tablePodcaster;
	private JTable tableSerie;
	private JTable tablePodcast;
	private JLabel lblNewLabelPodcasterImage;
	private JLabel lblNewLabelPodcasterName;
	private JLabel lblNewLabelPodcasterDate;
	private JLabel lblNewLabelPodcasterDescription;
	private JLabel lblNewLabelPodcasterReplayAmount;
	private JLabel lblNewLabelSeriesTitle;
	private JLabel lblNewLabelSeriesTheme;
	private JLabel lblNewLabelFirstPodcastDate;
	private JLabel lblNewLabelEndSeries;
	private JLabel lblNewLabelPodcastPick;
	private JLabel lblNewLabelPodcastViews;
	private JLabel lblIdSerie;
	private static final String THE_IMAGE_FILE = new File("").getAbsolutePath() + "\\src\\img\\logo.png";
	private Sesion sesion = Sesion.getInstance();
	private JLabel lblNombrePodcast;

	public PodcastPanel(ArrayList<JPanel> panels) {
		panel = new JPanel();
		panel.setBounds(0, 0, 1000, 650);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));

		lblNewLabelPodcasterImage = new JLabel("ImagenPodcaster");
		lblNewLabelPodcasterImage.setBounds(251, 18, 150, 150);
		panel.add(lblNewLabelPodcasterImage);

		lblNewLabelPodcasterName = new JLabel("NombrePodcaster");
		lblNewLabelPodcasterName.setBounds(483, 36, 118, 14);
		panel.add(lblNewLabelPodcasterName);

		lblNewLabelPodcasterDate = new JLabel("FechaUnion");
		lblNewLabelPodcasterDate.setBounds(483, 61, 118, 14);
		panel.add(lblNewLabelPodcasterDate);

		lblNewLabelPodcasterDescription = new JLabel("Descripcion");
		lblNewLabelPodcasterDescription.setBounds(483, 86, 118, 14);
		panel.add(lblNewLabelPodcasterDescription);

		lblNewLabelPodcasterReplayAmount = new JLabel("Numero de Reproducciones");
		lblNewLabelPodcasterReplayAmount.setBounds(483, 111, 131, 14);
		panel.add(lblNewLabelPodcasterReplayAmount);

		JLabel lblNewLabelSeriesList = new JLabel("ELIGE SERIE");
		lblNewLabelSeriesList.setBounds(251, 184, 83, 14);
		panel.add(lblNewLabelSeriesList);

		JButton buttonGoBack = new JButton("Volver");
		buttonGoBack.setBounds(44, 273, 89, 23);
		buttonGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panels.get(12).setVisible(false);
				panels.get(8).setVisible(true);
			}
		});
		panel.add(buttonGoBack);

		JButton buttonProfile = new JButton("Perfil");
		buttonProfile.setBounds(44, 303, 89, 23);
		buttonProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				panels.get(12).setVisible(false);
				panels.get(13).setVisible(true);
			}
		});
		panel.add(buttonProfile);

		panel.setLayout(null);

		JLabel lblNewLabelPickPodcaster = new JLabel("ELIGE PODCASTER");
		lblNewLabelPickPodcaster.setBounds(44, 26, 118, 14);
		panel.add(lblNewLabelPickPodcaster);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(44, 60, 149, 194);
		panel.add(scrollPane);

		// Creamos la tabla de Podcaster y la asignamos a tableGroups
		tablePodcaster = new JTable();
		tablePodcaster.setCellSelectionEnabled(true);
		scrollPane.setViewportView(tablePodcaster);

		// Recuperamos y pintamos los datos de los Podcaster en la tabla
		llenarTablaPodcaster(panels);
		scrollPane.setViewportView(tablePodcaster);

		JButton buttonPlay = new JButton("Reproducir");
		buttonPlay.setBounds(44, 337, 89, 23);
		buttonPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sesion.setIdSeries(Integer.parseInt(lblIdSerie.getText()));
				sesion.setTitle(lblNombrePodcast.getText());
				panels.get(12).setVisible(false);
				panels.get(10).setVisible(true);
			}
		});
		panel.add(buttonPlay);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(251, 209, 118, 151);
		panel.add(scrollPane_1);

		tableSerie = new JTable();
		tableSerie.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column" }));
		scrollPane_1.setViewportView(tableSerie);

		lblNewLabelSeriesTitle = new JLabel("NombreSerie");
		lblNewLabelSeriesTitle.setBounds(483, 184, 83, 14);
		panel.add(lblNewLabelSeriesTitle);

		lblNewLabelSeriesTheme = new JLabel("Tematica");
		lblNewLabelSeriesTheme.setBounds(483, 209, 70, 14);
		panel.add(lblNewLabelSeriesTheme);

		lblNewLabelFirstPodcastDate = new JLabel("FechaPrimerPodcast");
		lblNewLabelFirstPodcastDate.setBounds(483, 234, 118, 14);
		panel.add(lblNewLabelFirstPodcastDate);

		lblNewLabelEndSeries = new JLabel("FechaFinSerie");
		lblNewLabelEndSeries.setBounds(483, 259, 83, 14);
		panel.add(lblNewLabelEndSeries);

		lblNewLabelPodcastPick = new JLabel("ELIGE PODCAST");
		lblNewLabelPodcastPick.setBounds(251, 405, 83, 14);
		panel.add(lblNewLabelPodcastPick);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(251, 440, 118, 125);
		panel.add(scrollPane_2);

		buttonPlay.setEnabled(false);

		tablePodcast = new JTable();
		tablePodcast.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "New column" }));
		scrollPane_2.setViewportView(tablePodcast);

		lblNewLabelPodcastViews = new JLabel("ReproduccionesPodcast");
		lblNewLabelPodcastViews.setBounds(483, 483, 118, 14);
		panel.add(lblNewLabelPodcastViews);

		lblIdSerie = new JLabel("IdSerie");
		lblIdSerie.setBounds(483, 508, 46, 14);
		panel.add(lblIdSerie);

		JLabel lblNewLabel = new JLabel("LOGO");
		lblNewLabel.setBounds(818, 18, 150, 150);
		lblNewLabel.setIcon(new ImageIcon(THE_IMAGE_FILE));
		panel.add(lblNewLabel);

		lblNombrePodcast = new JLabel("NombrePodcast");
		lblNombrePodcast.setBounds(483, 458, 121, 14);
		panel.add(lblNombrePodcast);

		// Agregar ListSelectionListener a la tabla de Podcaster
		tablePodcaster.getSelectionModel()
				.addListSelectionListener((ListSelectionListener) new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						if (!event.getValueIsAdjusting()) {
							int selectedRow = tablePodcaster.getSelectedRow();
							if (selectedRow != -1) { // Verificar si se seleccionó una fila válida
								// Limpiar los datos de la tabla de serie
								Integer podcasterId = Integer
										.parseInt(tablePodcaster.getValueAt(selectedRow, 0).toString());
								String podcasterName = (String) tablePodcaster.getValueAt(selectedRow, 1);
								// Limpiar los datos de la información de Serie
								lblNewLabelSeriesTitle.setText("");
								lblNewLabelSeriesTheme.setText("");
								lblNewLabelFirstPodcastDate.setText("");
								lblNewLabelEndSeries.setText("");
								lblNewLabelPodcastPick.setText("");
								lblIdSerie.setText("");
								// Limpiar los datos de la tabla de podcast
								DefaultTableModel emptySongTableModel = new DefaultTableModel();
								tablePodcast.setModel(emptySongTableModel);

								// Limpiar los datos de la información de podcast
								lblNombrePodcast.setText("");
								lblNewLabelPodcastViews.setText("");
								lblIdSerie.setText("");
								// Desactivar el boton reproducir
								buttonPlay.setEnabled(false);

								// Llamamos al método para cargar la información del Podcaster seleccionado
								cargarInformacionPodcaster(podcasterId);

								// Llamamos al método para cargar la tabla de Serie del Podcaster seleccionado
								cargarTablaSeries(panels, podcasterId);
							}
						}
					}
				});
		// Agregar ListSelectionListener a la tabla de discos
		tableSerie.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tableSerie.getSelectedRow();
					if (selectedRow != -1) { // Verificar si se seleccionó una fila válida
						int serieId = (int) tableSerie.getValueAt(selectedRow, 0);
						// Limpiar los datos de la tabla de canciones
						DefaultTableModel emptySongTableModel = new DefaultTableModel();
						tablePodcast.setModel(emptySongTableModel);

						// Limpiar los datos de la información de Podcaster
						lblNombrePodcast.setText("");
						lblNewLabelPodcastViews.setText("");
						lblIdSerie.setText("");
						// Llamamos al método para cargar la información del disco seleccionado
						cargarInformacionSeries(serieId);
						// Desactivar el boton reproducir
						buttonPlay.setEnabled(false);

						// Llamamos al método para cargar la tabla de Podcaster del grupo seleccionado
						cargarTablaPodcast(panels, serieId);
					}
				}
			}
		});

		// Agregar ListSelectionListener a la tabla de canciones
		tablePodcast.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (!event.getValueIsAdjusting()) {
					int selectedRow = tablePodcast.getSelectedRow();
					if (selectedRow != -1) { // Verificar si se seleccionó una fila válida
						// Obtener los datos de la podcast seleccionada
						int podcastId = (int) tablePodcast.getValueAt(selectedRow, 0);

						// Llamar al método para cargar la información de la podcast seleccionada
						cargarInformacionPodcast(podcastId);
						// Desactivar el boton reproducir
						buttonPlay.setEnabled(true);
					}
				}
			}
		});

	}

	private void llenarTablaPodcaster(ArrayList<JPanel> panels) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idPodcaster");
		tableModel.addColumn("Nombre");

		PodcastPanelController funcionalidades = new PodcastPanelController();
		try {
			tableModel = funcionalidades.llenarTablagrupos(panels, tablePodcaster);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception patata1) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + patata1.getMessage());
		}
		tablePodcaster.setModel(tableModel);
		tablePodcaster.repaint();

	}

	private void cargarInformacionPodcaster(int idPodcaster) {

		PodcastPanelController funcionalidades = new PodcastPanelController();
		Podcaster podcaster = null;
		try {
			podcaster = funcionalidades.obtenerInformacionPodcaster(idPodcaster);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception patata2) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + patata2.getMessage());
		}

		try {
			if (podcaster != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				String fechaFormacionStr = dateFormat.format(podcaster.getCreationDate());

				lblNewLabelPodcasterImage.setIcon(new ImageIcon(funcionalidades.imageConverter(podcaster)));
				lblNewLabelPodcasterName.setText(podcaster.getName() != null ? podcaster.getName() : "");
				lblNewLabelPodcasterDate.setText(fechaFormacionStr != null ? fechaFormacionStr : "");
				lblNewLabelPodcasterDescription
						.setText(podcaster.getDescription() != null ? podcaster.getDescription() : "");
				lblNewLabelPodcasterReplayAmount.setText(Integer.toString(podcaster.getNumReproduction()));
				sesion.setImagen(podcaster.getImagen());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar la información del podcaster: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargarTablaSeries(ArrayList<JPanel> panels, int idPodcaster) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idSerie");
		tableModel.addColumn("titulo");

		PodcastPanelController funcionalidades = new PodcastPanelController();
		try {
			tableModel = funcionalidades.llenarTablaSeries(panels, tableSerie, idPodcaster);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception patata3) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + patata3.getMessage());
		}
		tableSerie.setModel(tableModel);
		tableSerie.repaint();
	}

	private void cargarInformacionSeries(int idSerie) {

		PodcastPanelController funcionalidades = new PodcastPanelController();
		Series serie = null;
		try {
			serie = funcionalidades.obtenerSeriePorId(idSerie);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception patata1) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + patata1.getMessage());
		}

		try {
			if (serie != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				String fechaInicioStr = dateFormat.format(serie.getStartDate());
				String fechaFinStr = dateFormat.format(serie.getEndDate());

				lblNewLabelSeriesTitle.setText(serie.getTitle() != null ? serie.getTitle() : "");
				lblNewLabelSeriesTheme.setText(serie.getTopic() != null ? serie.getTopic() : "");
				lblNewLabelFirstPodcastDate.setText(fechaInicioStr != null ? fechaInicioStr : "");
				lblNewLabelEndSeries.setText(fechaFinStr != null ? fechaFinStr : "");

			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar la información de la Serie: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargarTablaPodcast(ArrayList<JPanel> panels, int idSerie) {
		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idPodcast");
		tableModel.addColumn("titulo");

		PodcastPanelController funcionalidades = new PodcastPanelController();
		try {
			tableModel = funcionalidades.llenarTablaPodcast(panels, tablePodcast, idSerie);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception patata1) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + patata1.getMessage());
		}

		tablePodcast.setModel(tableModel);
		tablePodcast.repaint();
	}

	private void cargarInformacionPodcast(int songId) {
		GroupPanelController funcionalidades = new GroupPanelController();
		Song cancion = null;
		try {
			cancion = funcionalidades.obtenerCancionPorId(songId);
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "Error con la BBDD - " + sqle.getMessage());
		} catch (Exception patata1) {
			JOptionPane.showMessageDialog(null, "Error genérico - " + patata1.getMessage());
		}
		try {
			if (cancion != null) {
				lblNombrePodcast.setText(cancion.getTitle() != null ? cancion.getTitle() : "");
				lblNewLabelPodcastViews.setText(Integer.toString(cancion.getPlayAmount()));
				lblIdSerie.setText(Integer.toString(cancion.getIdSerie()));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al cargar la información de la podcast: " + e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	public JPanel getPanel() {
		return panel;
	}
}