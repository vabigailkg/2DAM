package utils.functionalities;

import java.text.SimpleDateFormat;

import db.management.AlbumManager;
import db.pojos.Album;

public class Functionalities {

	public void idAleatorio(Album album, AlbumManager albumManager) throws Exception {
		int idAlbum = 0;
		idAlbum = (int) (Math.random() * (albumManager.getMaxNumber())) + 1;
		album.setIdAlbum(idAlbum);
		System.out.println(idAlbum);
	}

	public String date(Album album) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(album.getPublicationDate());
		return formattedDate;
	}

	public String converterDate(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String formattedDate = sdf.format(fecha);
		return formattedDate;
	}
}
