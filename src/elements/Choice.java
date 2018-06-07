package elements;

public class Choice {
	protected String choice;
	protected int result;		// This is the integer value that tells whether this is a positive, negative, or neutral choice
	
	public Choice() {
		this.choice = "";
	}
	
	public Choice(String text) {
		String[] splitText = text.split("-");
		this.choice = splitText[0];
		this.result = Integer.parseInt(splitText[1]);
	}
	
	public Choice(String choice,int result) {
		this.choice = choice;
		this.result = result;
	}
	
	public String getChoice() {
		
		return this.choice;
		
	}
	
	public void setChoice(String choice) {
		
		this.choice = choice;
		
	}
	
	public String toString() {
		
		return choice;
		
	}
	
}
