package elements;

import java.util.ArrayList;

public class Instance {
	private Dialogue activeDialogue;
	private ArrayList<Entity> entities;	// The integer of the Entities in here is the speaker ID
	private Room room;
	private Instance nextInstance;
	private int num;
	
	public Instance() {
		activeDialogue = null;
		entities = new ArrayList<Entity>();
		room = null;
		nextInstance = null;
		num = 0;
	}
	
	public Instance(Dialogue activeDialogue,ArrayList<Entity> entities,Room room,Instance nextInstance,int num) {
		this.activeDialogue = activeDialogue;
		this.entities = entities;
		this.room = room;
		this.nextInstance = nextInstance;
		this.num = num;
	}
	
	public Dialogue getActiveDialogue() {
		return activeDialogue;
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	
}
