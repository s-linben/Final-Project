package entity;

import javafx.scene.image.Image;
import main.Animation;

public class Entity extends Sprite {
	
	protected int xDir, yDir;	// This is a -1, 0, and 1 value that tells which direction the Entity is going
	protected Animation idleLeft, idleRight, moveLeft, moveRight;	// We are not going to have a change in directions from up and down
	protected Image portrait;
	private boolean interactable;
	
}
