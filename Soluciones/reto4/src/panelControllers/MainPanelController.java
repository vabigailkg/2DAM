package panelControllers;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import javax.imageio.ImageIO;

import db.management.AlbumManager;
import db.management.GroupManager;
import db.pojos.Album;
import db.pojos.Group;
import utils.functionalities.Functionalities;

public class MainPanelController {

	private AlbumManager albumManager = null;
	private GroupManager groupManager = null;
	private Functionalities functionalities = null;

	public MainPanelController() {

		albumManager = new AlbumManager();
		groupManager = new GroupManager();
		functionalities = new Functionalities();

	}

	public void getAdd(Album album, Group grupo) throws Exception {

		functionalities.idAleatorio(album, albumManager);

		List<Album> albumAleatorio = albumManager.getAlbum(album);
		if (albumAleatorio != null && !albumAleatorio.isEmpty()) {
			album = albumAleatorio.get(0);
			List<Group> nombreGrupo = groupManager.obtenerNombreDeGrupo(album, grupo);
			if (nombreGrupo != null && !nombreGrupo.isEmpty()) {
				grupo = nombreGrupo.get(0);
			} else {
				System.out.println("No hay nombre");
			}
		} else {
			System.out.println("No se añadio album");
		}
	}

	public Image imageConverter(Album album) {
		Image image = null;
		if (album != null && album.getCdImage() != null && !album.getCdImage().isEmpty()) {
			try {
				byte[] imageData = Base64.getDecoder().decode(album.getCdImage());
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
