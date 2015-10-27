package slogo_team03;

public class MathException extends Exception {
	private String myErrorMessage;

	public MathException(String errorMessage) {
		myErrorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return myErrorMessage;
	}
}