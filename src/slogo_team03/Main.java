package slogo_team03;


import UserInterface.TurtleView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws CommandInputException {
		TurtleView view = new TurtleView();
		stage.setScene(view.getScene());
		stage.show();
	}
}