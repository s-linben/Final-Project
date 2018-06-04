package entity;

import javafx.scene.image.Image;

public class Prop extends Sprite {
	
	Image[] image;
	
	public Prop(Image image) {
		
		this.image = new Image[] {image};
		
	}
	
	public Prop(Image[] image) {
		
		this.image = image;
		
	}
	
	public Image[] getImage() {
		
		return image;
		
	}
	
	public void setImage(Image[] image) {
		
		this.image = image;
		
	}
	
}
