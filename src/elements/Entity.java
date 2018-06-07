package elements;

import javafx.scene.image.Image;

public class Entity {
	protected Point location;
	protected Image image;
	protected boolean active;
	
	public Entity() {
		
	}
	
	public Entity(Image image) {
		
		this.image = image;
		
	}
	
	public Image getImage() {
		
		return image;
		
	}
	
	public void setImage(Image image) {
		
		this.image = image;
		
	}
	
}
