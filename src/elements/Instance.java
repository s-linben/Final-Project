package elements;

import java.util.ArrayList;

/*
 * This should be stored in an array initialized of all the elements in order.
 */
public class Instance {
	private Dialogue activeDialogue;
	private ArrayList<Entity> entities;	// The integer of the Entities in here is the speaker ID
	private Room room;
	//private Instance nextInstance;
	//private String id;					// This is a string value of <Instance/Act #> + <Dialogue/Scene #>
	private boolean complete;			// Use this later.
	
	public Instance() {
		activeDialogue = null;
		entities = new ArrayList<Entity>();
		room = null;
		//nextInstance = null;
		//id = "1a";
		complete = false;
	}
	
	public Instance(Dialogue activeDialogue,ArrayList<Entity> entities,Room room,Instance nextInstance) {
		this.activeDialogue = activeDialogue;
		this.entities = entities;
		this.room = room;
		//this.nextInstance = nextInstance;
		//this.id = "1a";							// Note: will never change unless you specify it
		complete = false;
	}
	
	public Dialogue getActiveDialogue() {
		return activeDialogue;
	}
	
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	
	public Instance getNextInstance() {
		return nextInstance;
	}
	
	/*
	public void setId(String id) {
		this.id = id;
	}
	
	public void add(Instance nextInstance) {
		this.nextInstance = nextInstance;
		
		
	}
	
	public void add(Instance nextInstance) {
		this.nextInstance = nextInstance;
		//int tempActId = Character.getNumericValue(id.charAt(0));
		int tempActId = Integer.parseInt(id);
		String tempSceneId = "";
		int tempActIdLength = (int) Math.log10(tempActId) + 1;
		char[] tempSceneIdArray = new char[id.length() - tempActIdLength];
		for (int index = tempActIdLength;index < id.length();index++) {
			tempSceneIdArray[index] = id.charAt(index);
		}
		tempSceneIdArray[0]++;
		boolean increment = true;
		boolean addOnA = false;
		int digit = 0;
		while (increment) {
			if (tempSceneIdArray[digit] == 123) {
				tempSceneIdArray[digit] = 'a';
				if ((digit + 1) == tempSceneIdArray.length) {
					addOnA = false;
					increment = false;
				}
				digit++;
			} else {
				increment = false;
			}
		}
		for (int index2 = 0;index2 < tempSceneIdArray.length;index2++) {
			tempSceneId += tempSceneIdArray[index2];
		}
		if (addOnA) {
			this.nextInstance.setId(tempActId + "a");
		} else {
			this.nextInstance.setId("" + tempActId);
		}
	}
	*/
	
	public void setNextDialogue() {
		this.activeDialogue.next();
	}
	
}
