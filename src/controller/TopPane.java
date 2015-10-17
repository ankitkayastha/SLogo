package controller;

import UserInterface.CenterPane.DisplayTurtle;
import javafx.geometry.Insets;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import slogo_team03.Turtle;

public class TopPane {
	private DisplayTurtle turtle;
	
	public TopPane(DisplayTurtle t) {
		this.turtle = t;
	}
	
	
	
	public void changeImage(String s) {
		turtle.getImageView().setImage(new Image(s));;
	}
	public void changeBackgroundAction(Color c) {
		//StackPane s = turtle.getPane();
		//System.out.println(c.toString().substring(0, 8));
		//turtle.getPane().setStyle("{-fx-background-color: #" + c.toString().substring(0, 8) + ";}");
		turtle.getGC().setFill(c);
		turtle.getGC().fillRect(0, 0, 500, 500);

		//turtle.getPane().setBackground(new Background(new BackgroundFill(Color.web(c.toString().substring(0, 8)), CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void changePenColorAction(Color c) {
		turtle.setLineColor(c);
	}
	
	public void changeImageAction(String s) {
		turtle.setImage(s);
	}
}
