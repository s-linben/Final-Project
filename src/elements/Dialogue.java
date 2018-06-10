package elements;

import java.util.List;

public class Dialogue {
	private int speakerID;
	private String words;
	private Option choice;			// This will not always exist, but when it doesn it asks the question at the end
	//private Dialogue nextDialogue;
	private String ID;				// This is stored in the format of a fa abc and stuff
	
	public Dialogue(int speakerID,String words) {
		this.speakerID = speakerID;
		this.words = words;
		this.choice = null;
		this.nextDialogue = null;
	}
	
	public int getSpeakerID() {
		return speakerID;
	}
	
	public String getWords() {
		return words;
	}
	
	public Dialogue getNextDialogue() {
		return nextDialogue;
	}
	
	public String getID() {
		return ID;
	}
	
	public int size() {
		int size = 0;
		if (nextDialogue != null) {
			size = nextDialogue.size() + 1;
		} else {
			return 1;
		}
		return size;
	}
	
	public void setSpeakerID(int speakerID) {
		this.speakerID = speakerID;
	}
	
	public void setWords(String words) {
		this.words = words;
	}
	
	public void setID(String ID) {
		this.ID = ID;
	}
	
	/*
	 * Adds the dialogue to the end of the line
	 */
	public void add(Dialogue dialogue) {
		if (nextDialogue != null) {
			nextDialogue.add(dialogue);
		} else {
			nextDialogue = dialogue;
			
			//String[] tempId = ID.split("(?!^)");
			char[] tempID = ID.toCharArray();
			tempID[0]++;
			
			boolean run = true;
			boolean addOn = false;
			int index = 0;
			String finalTempId = "";
			while (run) {
				if (tempID[index] == 123) {
					tempID[index] = 'a';
					if ((index + 1) == tempID.length) {
						addOn = true;
					} else {
						index++;
					}
				} else {
					run = false;
				}
			}
			
			for (int tempIdIndex = 0;tempIdIndex < tempID.length;tempIdIndex++) {
				finalTempId += tempID[tempIdIndex];
			}
			
			if (addOn) {
				finalTempId += "a";
			}
			
			nextDialogue.setID(finalTempId);
		}
	}
	
	public String toString() {
		return ID;
	}
	
	public Dialogue next() {
		Dialogue tempDialogue = nextDialogue;
		nextDialogue = null;
		return tempDialogue;
	}
	
}
