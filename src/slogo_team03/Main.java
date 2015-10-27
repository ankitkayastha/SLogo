package slogo_team03;


import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws CommandInputException {
		TurtleMainController controller = new TurtleMainController();
		//TurtleView view = new TurtleView();
		stage.setScene(controller.getScene());
		stage.show();
	}
}