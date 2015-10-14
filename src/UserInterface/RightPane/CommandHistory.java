package UserInterface.RightPane;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import java.util.ResourceBundle;


public class CommandHistory {
	private ListView<String> myListView;
	private ObservableList<String> myObsList;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.RightPane/RightResource");
	private Group root;
	public CommandHistory() {
		myListView = new ListView<String>();
		myObsList = FXCollections.observableArrayList();
		root = new Group();
	}
	
	public void makeListView() {
		Text title = new Text();
		title.setText("Command History");
		title.setTranslateX(Double.parseDouble(r.getString("translateX")));
		title.setTranslateY(Double.parseDouble(r.getString("translateY")));
		title.setTranslateY(20);
		myListView.setPrefSize(Double.parseDouble(r.getString("prefWidth")), Double.parseDouble(r.getString("prefHeight")));
		myListView.setItems(myObsList);
		root.getChildren().add(title);
		root.getChildren().add(myListView);
	}
	public Group getRoot() {
		return root;
	}
	public ObservableList<String> getObs() {
		System.out.println(myObsList.toString());

		return myObsList;
	}
	
	public ListView getListView() {
		System.out.println("ListView returns " + myListView.getItems().toString());

		return myListView;
	}

}
