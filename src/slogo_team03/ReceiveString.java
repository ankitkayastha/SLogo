package slogo_team03;

public interface ReceiveString {
	public void receiveCommand(String s) throws CommandInputException;
	
	public void receiveLanguage(String s);
	
	public void receiveUpdatedVariables();
}
