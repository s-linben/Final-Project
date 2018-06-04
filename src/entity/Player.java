package entity;

import main.Animation;
import javafx.scene.image.Image;

public class Player	extends Entity {
	
	
	
	public Image getPortrait() {
		
		return portrait;
		
	}
	
	public Animation getIdleLeft() {
		
		return idleLeft;
		
	}
	
	public Animation getIdleRight() {
		
		return idleRight;
		
	}
	
	
	
}
