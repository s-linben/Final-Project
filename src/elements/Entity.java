package elements;

import javafx.scene.image.Image;

public class Entity {
	protected Image image;
	
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
