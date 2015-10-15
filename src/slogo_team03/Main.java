package slogo_team03;

/*import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
// www. j  av  a 2 s .  c  om
public class Main extends Application {
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    ObservableList<String> names = FXCollections
        .observableArrayList();
    ObservableList<String> data = FXCollections.observableArrayList();

    ListView<String> listView = new ListView<String>(data);
    listView.setPrefSize(200, 250);
    listView.setEditable(true);

    names.addAll("A", "B", "C", "D", "E");

    data.add("Double Click to Select Value");

    listView.setItems(data);
    listView.setCellFactory(TextFieldListCell.forListView());

    StackPane root = new StackPane();
    root.getChildren().add(listView);
    primaryStage.setScene(new Scene(root, 200, 250));
    primaryStage.show();
  }
}*/













import java.util.Scanner;

import UserInterface.TurtleView;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		TurtleWorld world = new TurtleWorld();		
		TurtleView view = new TurtleView();
		stage.setScene(view.getScene());
		stage.show();
		Scanner scan = new Scanner(System.in);
	//	while (true) {
		//	world.getInput(scan.nextLine());
	//	}

//		world.getInput("setheading s setheading setheading 180 heading 3"); 
	}	
} 