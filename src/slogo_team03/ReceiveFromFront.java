package slogo_team03;

public interface ReceiveFromFront {
	public void receiveCommand(String s) throws CommandInputException, NumberFormatException, MathException;

	public void receiveLanguage(String s);
	
}