package slogo_team03;

public class CommandInputException extends Exception {
	private String myBadInput;
	
	public CommandInputException(String badInput) {
		setMyBadInput(badInput);
	}

	public String getMyBadInput() {
		return myBadInput;
	}

	private void setMyBadInput(String myBadInput) {
		this.myBadInput = myBadInput;
	}
	
}