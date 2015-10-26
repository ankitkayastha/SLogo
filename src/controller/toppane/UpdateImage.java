package controller.toppane;

import UserInterface.CenterPane.DisplayTurtle;

public class UpdateImage {
	private DisplayTurtle display;
	public UpdateImage(DisplayTurtle t) {
		display = t;

	}
	
	public void refreshImage(String newImage) {
		display.setImage(newImage);
	}
}	
