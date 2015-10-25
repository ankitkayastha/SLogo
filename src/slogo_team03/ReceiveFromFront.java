package slogo_team03;

public interface ReceiveFromFront {
	public void receiveCommand(String s) throws CommandInputException, NumberFormatException, TrigonometricException;

	public void receiveLanguage(String s);
}