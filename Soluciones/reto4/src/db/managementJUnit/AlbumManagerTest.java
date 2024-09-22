package db.managementJUnit;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import db.management.AlbumManager;
import db.pojos.Album;
import java.util.Date;

public class AlbumManagerTest {

	AlbumManager albumManager = new AlbumManager();

	int idAlbum = 1;
	String title = "Disco AB";
	String genre = "Rock";
	String description = "Descripcion disco AB";
	List<Album> previousList = null;
	List<Album> nextList = null;
	String image = "imagen1.jpg";
	Date currentDate = new Date();
	int previousLength = 0;
	int nextLength = 0;

	@Test
	public void deleteAlbumSuccessful() {

		boolean checkAlbumExistance = false;
		try {
			previousList = albumManager.select(idAlbum);
			albumManager.deleteById(idAlbum);
			nextList = albumManager.select(idAlbum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nextList == null) {
			checkAlbumExistance = true;
		}
		assertTrue("Se ha podido borrar el album", checkAlbumExistance);
	}

	@Test
	public void deleteAlbumUnsuccessful() {

		boolean checkAlbumExistance = false;
		try {
			previousList = albumManager.select(idAlbum);
			albumManager.deleteById(idAlbum);
			nextList = albumManager.select(idAlbum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (nextList != null) {
			checkAlbumExistance = true;
		}
		assertFalse("No se ha podido borrar el album", checkAlbumExistance);
	}

	@Test
	public void insertSuccessful() {

		boolean insertDone = false;
		try {
			previousLength = albumManager.obtenerGrupo().size();
			albumManager.insert(title, image, description, currentDate);
			nextLength = albumManager.obtenerGrupo().size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (previousLength != nextLength) {
			insertDone = true;
		}
		assertTrue("Se ha podido crear el album", insertDone);
	}

	@Test
	public void insertUnsuccessful() {

		boolean insertDone = false;
		try {
			previousLength = albumManager.obtenerGrupo().size();
			albumManager.insert(title, image, description, currentDate);
			nextLength = albumManager.obtenerGrupo().size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (previousLength == nextLength) {
			insertDone = true;
		}
		assertTrue("No se ha podido crear el album", insertDone);
	}

	@Test
	public void readSuccessful() {
		boolean checkAlbumExistance = false;
		try {
			previousList = albumManager.select(idAlbum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (previousList != null) {
			checkAlbumExistance = true;
		}
		assertTrue("Se ha leido correctamente", checkAlbumExistance);
	}

	@Test
	public void readUnsuccessful() {
		boolean checkAlbumExistance = false;
		try {
			previousList = albumManager.select(idAlbum);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (previousList != null) {
			checkAlbumExistance = true;
		}
		assertFalse("No se ha podido leer correctamente", checkAlbumExistance);
	}

	@Test
	public void updateSuccessful() {
		try {
			previousList = albumManager.select(idAlbum);
			albumManager.update(title, image, description, currentDate);
			nextList = albumManager.select(idAlbum);
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertEquals("No se ha podido actualizar correctamente", previousList, nextList);
	}

}
