package management;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javazoom.jl.player.Player;
import pojos.Content;

public class SongManager {
	
	public static final String MUSIC_FOLDER = new File("").getAbsolutePath() + "\\src\\music\\";

	private Player player = null;

	public void play(Content content) {
		new Thread() {
			@Override
			public void run() {
				try {
					FileInputStream fileInputStream = new FileInputStream(MUSIC_FOLDER + content.getTitle());
					player = new Player(fileInputStream);
					player.play();
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		}.start();
	}

	public void stop() {
		if (player != null) {
			player.close();
		}
	}

	public void playNext(List<Content> listContent, Content content) {

		int pos = listContent.indexOf(content);
		
	}
}
