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
		System.out.println(Math.tan(Math.PI / 2));
		TurtleView view = new TurtleView();
		stage.setScene(view.getScene());
		stage.show();

		// Scanner scan = new Scanner(System.in);
		// TurtleWorld world = new TurtleWorld();
		// while (true) {
		// String s = scan.nextLine();
		// // + "\n" + scan.nextLine() + "\n" +
		// // scan.nextLine() + "\n" + scan.nextLine();
		// world.processInput(s);
		// }
	}
}