package elements;

import javafx.scene.image.Image;

public class Entity {
	//protected int x,y;
	protected Image image;
	//protected boolean active;
	
	public Entity(String image) {
		this.image = new Image(image);
	}
	
	public Entity(Image image) {
		
		this.image = image;
		
	}
	
	public Image getImage() {
		
		return image;
		
	}
	
	public void setImage(String image) {
		
		this.image = new Image(image);
		
	}
	
}
