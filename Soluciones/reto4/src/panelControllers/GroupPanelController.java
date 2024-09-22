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

import db.management.AlbumManager;
import db.management.ContentManager;
import db.management.GroupManager;
import db.pojos.Album;
import db.pojos.Group;
import db.pojos.Song;

public class GroupPanelController {

	public DefaultTableModel llenarTablagrupos(ArrayList<JPanel> panels, JTable tabla) throws Exception {
		DefaultTableModel ret = null;
		GroupManager groupManager = new GroupManager();
		ArrayList<Group> listaGrupos = (ArrayList<Group>) groupManager.getGroup();

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idGroup");
		tableModel.addColumn("Nombre");

		for (Group grupo : listaGrupos) {
			Object[] fila = { grupo.getIdGroup(), grupo.getName(), };
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

	public Group obtenerInformacionGrupo(String groupName) throws Exception {
		Group grupo = new Group();
		GroupManager groupManager = new GroupManager();
		grupo = groupManager.getGroupInfo(groupName);
		return grupo;
	}

	public DefaultTableModel llenarTablaDiscos(ArrayList<JPanel> panels, JTable tableAlbums, int idGroup)
			throws Exception {
		DefaultTableModel ret = null;
		AlbumManager albumManager = new AlbumManager();
		ArrayList<Album> listaAlbums = (ArrayList<Album>) albumManager.getAlbumsByGroupId(idGroup);

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idGroup");
		tableModel.addColumn("Nombre");

		for (Album album : listaAlbums) {
			Object[] fila = { album.getIdAlbum(), album.getTitle(), };
			tableModel.addRow(fila);
		}

		tableAlbums.setModel(tableModel);
		tableAlbums.repaint();

		tableAlbums.getColumnModel().getColumn(0).setMinWidth(0);
		tableAlbums.getColumnModel().getColumn(0).setMaxWidth(0);
		tableAlbums.getColumnModel().getColumn(0).setWidth(0);

		ret = tableModel;
		return ret;
	}

	public Album obtenerDiscoPorTitulo(int albumId) throws Exception {
		Album album = new Album();
		AlbumManager albumManager = new AlbumManager();
		album = albumManager.getGroupInfobyId(albumId);
		return album;
	}

	public DefaultTableModel llenarTablaCanciones(ArrayList<JPanel> panels, JTable tableSongPick, int albumId)
			throws Exception {
		DefaultTableModel ret = null;
		ContentManager contentManager = new ContentManager();
		ArrayList<Song> listaCanciones = (ArrayList<Song>) contentManager.getContentByAlbunId(albumId);

		DefaultTableModel tableModel = new DefaultTableModel();
		tableModel.addColumn("idGroup");
		tableModel.addColumn("Nombre");

		for (Song cancion : listaCanciones) {
			Object[] fila = { cancion.getIdContent(), cancion.getTitle(), };
			tableModel.addRow(fila);
		}

		tableSongPick.setModel(tableModel);
		tableSongPick.repaint();

		tableSongPick.getColumnModel().getColumn(0).setMinWidth(0);
		tableSongPick.getColumnModel().getColumn(0).setMaxWidth(0);
		tableSongPick.getColumnModel().getColumn(0).setWidth(0);

		ret = tableModel;
		return ret;
	}

	public Song obtenerCancionPorId(int songId) throws Exception {
		Song cancion = new Song();
		ContentManager groupSong = new ContentManager();
		cancion = groupSong.getContentBySonId(songId);
		return cancion;
	}

	public Image imageConverter(Group grupo) {
		Image image = null;
		if (grupo != null && grupo.getImagen() != null && !grupo.getImagen().isEmpty()) {
			try {
				byte[] imageData = Base64.getDecoder().decode(grupo.getImagen());
				image = ImageIO.read(new ByteArrayInputStream(imageData));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("La cadena base64 de la imagen es nula o vacía.");
		}
		return image;

	}

	public Image imageConverterDisco(String grupo) {
		Image image = null;
		if (grupo != null && grupo != null && !grupo.isEmpty()) {
			try {
				byte[] imageData = Base64.getDecoder().decode(grupo);
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