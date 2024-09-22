package panelControllers;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.management.ContentManager;
import db.management.PodcasterManager;
import db.management.SeriesManager;
import db.pojos.Content;
import db.pojos.Podcaster;
import db.pojos.Series;

public class PodcastPanelController {
	public DefaultTableModel llenarTablagrupos(ArrayList<JPanel> panels, JTable tabla) throws Exception {
		DefaultTableModel ret = null;
		PodcasterManager podcasterManager = new PodcasterManager();
		ArrayList<Podcaster> listaPodcaster = (ArrayList<Podcaster>) podcasterManager.getPodcaster();

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idGroup");
		tableModel.addColumn("Nombre");

		for (Podcaster Podcaster : listaPodcaster) {
			Object[] fila = { Podcaster.getIdAuthor(), Podcaster.getName(), };
			tableModel.addRow(fila);
		}

		tabla.setModel(tableModel);
		tabla.repaint();

		tabla.getColumnModel().getColumn(0).setMinWidth(0);
		tabla.getColumnModel().getColumn(0).setMaxWidth(0);
		tabla.getColumnModel().getColumn(0).setWidth(0);

		ret = tableModel;
		return ret;
	}

	public Podcaster obtenerInformacionPodcaster(int idPoscaster) throws Exception {
		Podcaster podcaster = new Podcaster();
		PodcasterManager podcasterManager = new PodcasterManager();
		podcaster = podcasterManager.getPodcasterInfo(idPoscaster);
		return podcaster;
	}

	public DefaultTableModel llenarTablaSeries(ArrayList<JPanel> panels, JTable tableSeries, int idPodcaster)
			throws Exception {
		DefaultTableModel ret = null;
		SeriesManager seriesManager = new SeriesManager();
		ArrayList<Series> listaSeries = (ArrayList<Series>) seriesManager.getSeries(idPodcaster);

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idSerie");
		tableModel.addColumn("Nombre");

		if (listaSeries != null) {
			for (Series serie : listaSeries) {
				Object[] fila = { serie.getIdSeries(), serie.getTitle(), };
				tableModel.addRow(fila);
			}
		} else {
			System.err.println("La lista de series es null");
		}

		tableSeries.setModel(tableModel);
		tableSeries.repaint();

		tableSeries.getColumnModel().getColumn(0).setMinWidth(0);
		tableSeries.getColumnModel().getColumn(0).setMaxWidth(0);
		tableSeries.getColumnModel().getColumn(0).setWidth(0);

		ret = tableModel;
		return ret;
	}

	public Series obtenerSeriePorId(int idSerie) throws Exception {
		Series serie = new Series();
		SeriesManager seriesManager = new SeriesManager();
		serie = seriesManager.getSeriesInfo(idSerie);
		return serie;
	}

	public DefaultTableModel llenarTablaPodcast(ArrayList<JPanel> panels, JTable tablePodcast, int idPodcaster)
			throws Exception {
		DefaultTableModel ret = null;
		ContentManager podcastManager = new ContentManager();
		ArrayList<Content> listaContent = (ArrayList<Content>) podcastManager.getContentBySerieId(idPodcaster);

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idSerie");
		tableModel.addColumn("Nombre");

		if (listaContent != null) {
			for (Content contenido : listaContent) {
				Object[] fila = { contenido.getIdContent(), contenido.getTitle(), };
				tableModel.addRow(fila);
			}
		} else {
			System.err.println("La lista de series es null");
		}

		tablePodcast.setModel(tableModel);
		tablePodcast.repaint();

		tablePodcast.getColumnModel().getColumn(0).setMinWidth(0);
		tablePodcast.getColumnModel().getColumn(0).setMaxWidth(0);
		tablePodcast.getColumnModel().getColumn(0).setWidth(0);

		ret = tableModel;
		return ret;
	}

	public Image imageConverter(Podcaster Podcaster) {
		Image image = null;
		if (Podcaster != null && Podcaster.getImagen() != null && !Podcaster.getImagen().isEmpty()) {
			try {
				byte[] imageData = Base64.getDecoder().decode(Podcaster.getImagen());
				image = ImageIO.read(new ByteArrayInputStream(imageData));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("La cadena base64 de la imagen es nula o vacía.");
		}
		return image;

	}
}
