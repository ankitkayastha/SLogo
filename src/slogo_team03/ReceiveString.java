package slogo_team03;

public interface ReceiveString {
	public void receiveCommand(String s) throws CommandInputException, NumberFormatException, TrigonometricException;

	public void receiveLanguage(String s);
}