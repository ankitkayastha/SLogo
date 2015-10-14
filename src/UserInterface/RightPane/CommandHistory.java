package UserInterface.RightPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.util.ResourceBundle;


public class CommandHistory {
	private Group root;
	private ListView<String> myListView;
	private ObservableList<String> myObsList;
	private ScrollPane rightPane;
	private VBox rightBox;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.RightPane/RightResource");
	//private BottomPane bottomPaneController;
	public CommandHistory() {
		rightPane = new ScrollPane();
		rightBox = new VBox();
		myListView = new ListView<String>();
		myObsList = FXCollections.observableArrayList();
		//root = makeScrollablePane();
		//root = makeScrollablePane();
	}
	
	public void makeScrollablePane() {
		//ListView<String> myListView = new ListView<String>();
		//root = new Group();
		Text title = new Text();
		//title.setTranslateY(Integer.parseInt(r.getString("translateY")));
		//title.setTranslateX(Integer.parseInt(r.getString("translateX")));
		//title.setText(r.getString("title"));
		//ScrollPane pane = new ScrollPane();
		myListView.setPrefSize(Double.parseDouble(r.getString("prefWidth")), Double.parseDouble(r.getString("prefHeight")));
		//rightBox.setPrefSize
		//root.getChildren().add(pane);
	//	rightPane.getChildren().add(new Text("Hi"));
		//root.getChildren().add(title);
		//pane.setContent(new Button("Hello"));
		//ObservableList<String> list = FXCollections.observableArrayList("Hi", "How are you");
		myObsList.add("Hi");
		myListView.setItems(myObsList);
		//root.getChildren().add(myListView);
		//return root;
	}
	public Group getRoot() {
		makeScrollablePane();
		return root;
	}
	public ObservableList<String> getObs() {
		System.out.println(myObsList.toString());

		return myObsList;
	}
	
	//public void runButtonAction(TextArea field)
	public ListView getListView() {
		//makeScrollablePane();
		System.out.println("ListView returns " + myListView.getItems().toString());

		return myListView;
	}
	public ScrollPane getPane() {
		System.out.println("Accessing command history pane");
		return rightPane;
		
	}
}
