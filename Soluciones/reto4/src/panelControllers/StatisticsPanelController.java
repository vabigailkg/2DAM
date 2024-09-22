package panelControllers;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import db.management.ContentManager;
import db.management.PodcasterManager;
import db.management.SeriesManager;
import db.pojos.Podcaster;
import db.pojos.Series;
import db.pojos.Song;

public class StatisticsPanelController {

	public DefaultTableModel llenarTablaContent(ArrayList<JPanel> panels, JTable tabla) throws Exception {
		DefaultTableModel ret = null;
		ContentManager contentManager = new ContentManager();
		ArrayList<Song> listaContent = (ArrayList<Song>) contentManager.getTop10();

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Titulo");
		tableModel.addColumn("Reproducciones");

		for (Song song : listaContent) {
			Object[] fila = { song.getIdContent(), song.getTitle(), song.getPlayAmount(), };
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

	public DefaultTableModel llenarTablaagrupation(ArrayList<JPanel> panels, JTable tabla) throws Exception {
		DefaultTableModel ret = null;
		SeriesManager seriesManager = new SeriesManager();
		ArrayList<Series> listaContent = (ArrayList<Series>) seriesManager.getTop10();

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Titulo");
		tableModel.addColumn("Reproducciones");

		for (Series serie : listaContent) {
			Object[] fila = { serie.getIdSeries(), serie.getTitle(), serie.getNumReproduction(), };
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

	public DefaultTableModel llenarTablaAutores(ArrayList<JPanel> panels, JTable tabla) throws Exception {
		DefaultTableModel ret = null;
		PodcasterManager authorManager = new PodcasterManager();
		ArrayList<Podcaster> listAuthor = (ArrayList<Podcaster>) authorManager.getTop10Author();

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("Id");
		tableModel.addColumn("Titulo");
		tableModel.addColumn("Reproducciones");

		for (Podcaster author : listAuthor) {
			Object[] fila = { author.getIdAuthor(), author.getName(), author.getNumReproduction(), };
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

}
