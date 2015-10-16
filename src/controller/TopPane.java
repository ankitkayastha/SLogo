package controller;

import UserInterface.CenterPane.DisplayTurtle;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class TopPane {
	private DisplayTurtle turtle;
	
	public TopPane(DisplayTurtle t) {
		this.turtle = t;
	}
	
	public void changeBackgroundAction(Color c) {
		//StackPane s = turtle.getPane();
		System.out.println(c.toString().substring(0, 8));
		//turtle.getPane().setStyle("{-fx-background-color: #" + c.toString().substring(0, 8) + ";}");
		turtle.getPane().setBackground(new Background(new BackgroundFill(Color.web(c.toString().substring(0, 8)), CornerRadii.EMPTY, Insets.EMPTY)));
	}
}
