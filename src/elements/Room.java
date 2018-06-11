package elements;

import java.util.ArrayList;
import javafx.scene.image.Image;

public class Room {
	private Image background;
	
	// This only takes a specific link to the image
	public Room(String image) {
		background = new Image(image);
	}
	
	public Image getBackground() {
		return background;
	}
	
	public void setBackground(String image) {
		background = new Image(image);
	}
	
}
