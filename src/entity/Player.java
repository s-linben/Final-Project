package entity;

import main.Animation;
import javafx.scene.image.Image;

public class Player	extends Sprite {
	
	private Animation idleLeft, idleRight, moveLeft, moveRight;	// We are not going to have a change in directions from up and down
	private Image portrait;
	
	public Image getPortrait() {
		
		return portrait;
		
	}
	
}
