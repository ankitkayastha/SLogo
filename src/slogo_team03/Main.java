package slogo_team03;

import java.util.Scanner;

import UserInterface.TurtleView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws CommandInputException {
		TurtleWorld world = new TurtleWorld();		
		TurtleView view = new TurtleView();
		stage.setScene(view.getScene());
		stage.show();
		Scanner scan = new Scanner(System.in);


		/*while (true) {
			world.processInput(scan.nextLine());
		} */

//		while (true) {
//			world.processInput(scan.nextLine());
//		}
	}	
} 
