package db.managementJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import db.management.ContentManager;

import db.management.SongManager;

public class SongManagerTest {

	SongManager songManager = new SongManager();
	ContentManager contentManager = new ContentManager();

	@Test
	public void getPodcastName() {

		boolean checkNameExistance = false;
		List<String> name;
		try {
			name = songManager.getPodcastNames();
			if (name != null) {
				checkNameExistance = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue("Has traido los mombres de podcasts", checkNameExistance);
	}

	@Test
	public void getSongName() {

		boolean checkNameExistance = false;
		List<String> name;
		try {
			name = songManager.getSongNames();
			if (name != null) {
				checkNameExistance = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertTrue("Has traido los mombres de canciones", checkNameExistance);
	}

	@Test
	public void updateNumReproductions() {
		String nombre = "Canciong.mp3";
		boolean checkUserExistance = false;
		try {
			checkUserExistance = songManager.updateNumReproduction(nombre);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse("No se ha aumentado el número de reproducciones", checkUserExistance);
	}

	@Test
	public void deleteSong() {
		int id = 1;
		int checkDelete = 0;
		try {
			checkDelete = songManager.delete(id);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(0, checkDelete);
	}

}