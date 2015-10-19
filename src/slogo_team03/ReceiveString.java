package slogo_team03;

import java.io.IOException;

public interface ReceiveString {
	public void receiveCommand(String s) throws CommandInputException;
	
	public void receiveLanguage(String s);
	
}
