
package panelControllers;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import db.management.GroupManager;
import db.management.PodcasterManager;
import db.pojos.Group;
import db.pojos.Podcaster;
import utils.functionalities.Sesion;

public class GroupsManagementPanelController {
	GroupManager groupManager = new GroupManager();
	PodcasterManager podcastManager = new PodcasterManager();
	Group group = new Group();
	Sesion sesion = Sesion.getInstance();

	public void createNewAuthor(String nombreAuthor, String imagen, String descripcion, String año, boolean group,
			boolean podcaster) throws Exception {

		Date fecha = convertDate(año);
		System.out.println(fecha);
		if (group) {
			groupManager.insert(nombreAuthor, imagen, descripcion, fecha);
		} else if (podcaster) {
			podcastManager.insert(nombreAuthor, imagen, descripcion, fecha);
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione Grupo o Podcaster");
		}

	}

	public Date convertDate(String fecha) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date fechaConvertida = null;

		try {
			Date parsed = dateFormat.parse(fecha);
			fechaConvertida = new java.sql.Date(parsed.getTime());
		} catch (Exception e) {
			System.out.println("Error occurred" + e.getMessage());
			JOptionPane.showMessageDialog(null, "Escriba con el formato YY-MM-DD");
		}
		return fechaConvertida;

	}

	public boolean getAuthor(boolean podcaster, boolean group, String name) throws Exception {
		boolean author = false;
		if (group) {
			groupManager.getGroupForName(name);
			author = true;
		} else if (podcaster) {
			podcastManager.getPodcastForName(name);
			author = true;
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione Grupo o Podcaster");
			author = false;
		}
		return author;
	}

	public void updateAuthor(String nombreAuthor, String imagen, String descripcion, String año, boolean podcaster,
			boolean group) throws Exception {
		Date fecha = convertDate(año);
		if (group) {
			groupManager.update(nombreAuthor, imagen, descripcion, fecha);
		} else if (podcaster) {
			podcastManager.update(nombreAuthor, imagen, descripcion, fecha);
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione Grupo o Podcaster");
		}
	}

	public boolean deleteAuthor(boolean podcaster, boolean group, String name) throws Exception {
		boolean author = false;
		if (group) {
			groupManager.deleteName(name);
			author = true;
		} else if (podcaster) {
			podcastManager.deleteName(name);
			author = true;
		} else {
			JOptionPane.showMessageDialog(null, "Seleccione Grupo o Podcaster");
			author = false;
		}
		return author;
	}

	public String convertirImagenABase64(String ruta) throws Exception {
		String base64Image = "";

		File file = new File(ruta);
		FileInputStream fileInputStreamReader = new FileInputStream(file);
		byte[] bytes = new byte[(int) file.length()];
		fileInputStreamReader.read(bytes);
		fileInputStreamReader.close();

		base64Image = Base64.getEncoder().encodeToString(bytes);
		return base64Image;
	}

	public Image imageConverter() throws Exception {
		Image image = null;

		if (sesion != null && sesion.getImagen() != null && !sesion.getImagen().isEmpty()) {
			byte[] imageData = Base64.getDecoder().decode(sesion.getImagen());
			image = ImageIO.read(new ByteArrayInputStream(imageData));
		} else {
			JOptionPane.showMessageDialog(null, "La cadena base64 de la imagen es nula o vacía.");
		}

		return image;
	}

	public Image imageConverterPodcast(Podcaster podcast) throws Exception {
		Image image = null;

		if (podcast != null && podcast.getImagen() != null && !podcast.getImagen().isEmpty()) {
			byte[] imageData = Base64.getDecoder().decode(podcast.getImagen());
			image = ImageIO.read(new ByteArrayInputStream(imageData));
		} else {
			JOptionPane.showMessageDialog(null, "La cadena base64 de la imagen es nula o vacía.");
		}

		return image;
	}

	public String date(Sesion sesion) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(sesion.getCreationDate());
		return formattedDate;
	}

	public String datePodcast(Sesion sesion) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(sesion.getCreationDate());
		return formattedDate;
	}

}