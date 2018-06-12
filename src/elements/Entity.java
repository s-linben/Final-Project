package elements;

import javafx.scene.image.Image;

public class Entity {
	//protected int x,y;
	protected Image image;
	protected String name;
	//protected boolean active;
	
	public Entity(String image,String name) {
		this.image = new Image(image);
		this.name = name;
	}
	
	public Image getImage() {
		return image;
	}
	
	public String getName() {
		return name;
	}
	
	public void setImage(String image) {
		this.image = new Image(image);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
