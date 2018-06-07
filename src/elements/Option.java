package elements;

public class Option {
	protected String prompt;	// The prompt that will ask the player in the game
	protected Choice[] choices;	// 3 or more choice that the player can make
	protected int result;		// Can only be -1, 0, or 1
	
	public Option() {
		prompt = "";
		choices = new Choice[3];
		result = 0;
	}
	
	public Option(String prompt,Choice[] choices,int result) {
		this.prompt = prompt;
		this.choices = choices;
		this.result = result;
	}
	
	public String getPrompt() {
		return prompt;
	}
	
	public Choice[] getChoices() {
		return choices;
	}
	
	public int getResult() {
		return result;
	}
	
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	
	public void setChoices(Choice[] choices) {
		this.choices = choices;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
	
}
