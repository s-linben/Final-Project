package elements;

import java.util.List;

public class Dialogue {
	private int speakerID;
	private String words;
	private Option choice;			// This will not always exist, but when it doesn it asks the question at the end
	private Dialogue nextDialogue;
	private int num;
	
	public Dialogue(int speakerID,String words) {
		this.speakerID = speakerID;
		this.words = words;
		this.choice = null;
		this.nextDialogue = null;
		this.num = 0;
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
	
	public void setNum(int num) {
		
	}
	
	public void add(Dialogue dialogue) {
		if (nextDialogue != null) {
			nextDialogue.add(dialogue);
		} else {
			nextDialogue = dialogue;
			nextDialogue.setNum(num++);
		}
	}
	
	public void remove() {
		
	}
	
	public String toString() {
		return speakerID + ":" + num;
	}
	
}
