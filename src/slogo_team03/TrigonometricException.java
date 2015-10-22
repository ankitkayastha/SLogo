package slogo_team03;

public class TrigonometricException extends Exception {
	private String myBadFunction;

	public TrigonometricException(String badFunction) {
		myBadFunction = badFunction;
	}

	public String getBadFunction() {
		return myBadFunction;
	}
}