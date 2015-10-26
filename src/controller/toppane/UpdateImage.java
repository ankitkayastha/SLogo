package controller.toppane;

import UserInterface.CenterPane.DisplayTurtle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UpdateImage implements EventHandler<ActionEvent> {
	private DisplayTurtle display;
	private String newImage;
	public UpdateImage(DisplayTurtle t, String s) {
		display = t;
		newImage = s;
	}
	
	@Override
	public void handle(ActionEvent event) {
		display.setImage(newImage);
	}
	
}	
