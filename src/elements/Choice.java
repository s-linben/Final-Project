package elements;

public class Choice {
	protected String choice;
	protected boolean done;
	
	public Choice() {
		
		this.choice = "";
		this.done = false;
		
	}
	
	public Choice(String choice,boolean done) {
		
		this.choice = choice;
		this.done = done;
		
	}
	
	public String getChoice() {
		
		return this.choice;
		
	}
	
	public boolean getDone() {
		
		return done;
		
	}
	
	public void setChoice(String choice) {
		
		this.choice = choice;
		
	}
	
	public void setDone(boolean done) {
		
		this.done = done;
		
	}
	
	public String toString() {
		
		return choice;
		
	}
	
}
