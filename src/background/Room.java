package background;

import entity.Item;
import entity.Sprite;
import java.util.ArrayList;

public class Room {
	
	private ArrayList<Item> items;	// Should consider having the general Sprite class instead
	private ArrayList<Sprite> sprites;
	private Room nextRoom;
	private String description;
	
	public Room(ArrayList<Item> items,Room nextRoom,String description) {
		
		
		
	}
	
	public ArrayList<Item> getItems() {
		
		return items;
		
	}
	
	public String getDescription() {
		
		return description;
		
	}
	
	public void setNextRoom(Room nextRoom) {
		
		this.nextRoom = nextRoom;
		
	}
	
}
