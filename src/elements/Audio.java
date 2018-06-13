package elements;

import javafx.scene.media.Media;
import java.io.File;
import java.io.FileNotFoundException;

public class Audio {
	private Media song;
	
	public Audio() {
		song = null;
	}
	
	public Audio(Media song) {
		this.song = song;
	}
	
	public Audio(File file) {
		this.song = new Media(file.toURI().toString());
	}
	
	public Audio(String textFile) throws FileNotFoundException {
		//this.song = new Media(new File(textFile).toURI().toString());
		this.song = new Media(textFile);
	}
	
	public Media getSong() {
		return song;
	}
	
	public void setSong(Media song) {
		this.song = song;
	}
}
