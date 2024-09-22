
package panelControllers;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import javazoom.jl.player.Player;

public class SongPanelController {
	private List<String> songNames;
	private static final String MUSIC_FOLDER = new File("").getAbsolutePath() + "\\src\\music\\";
	private static Player player = null;
	private int currentPosition = 0;

	public SongPanelController(List<String> songNames) {
		this.songNames = songNames;
	}

	public void play() {
		new Thread(() -> {
			try {
				FileInputStream fileInputStream = new FileInputStream(MUSIC_FOLDER + songNames.get(currentPosition));
				player = new Player(fileInputStream);
				player.play();
			} catch (Exception e) {
				System.out.println(e);
			}
		}).start();
	}

	public void stop() {
		if (player != null) {
			player.close();
		}
	}

	public void playPreviousSong() {
		currentPosition = (currentPosition - 1 + songNames.size()) % songNames.size();
		stop();
		play();
	}

	public void playNextSong() {
		currentPosition = (currentPosition + 1) % songNames.size();
		stop();
		play();
	}

}