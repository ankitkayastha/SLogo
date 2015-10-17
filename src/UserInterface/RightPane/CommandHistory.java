package UserInterface.RightPane;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import javafx.scene.control.TextArea;

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
	
	public void makeListView(TextArea field) {
		Text title = new Text();
		title.setText("Command History");
		title.setTranslateX(Double.parseDouble(r.getString("translateX")));
		title.setTranslateY(Double.parseDouble(r.getString("translateY")));
		myListView.setPrefSize(Double.parseDouble(r.getString("prefWidth")), Double.parseDouble(r.getString("prefHeight")));
		myListView.setTranslateY(Double.parseDouble(r.getString("historyTranslateY")));
		myListView.setItems(myObsList);
		
		root.getChildren().add(title);
		root.getChildren().add(myListView);
		/*myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldString, String newString) {
				field.setText(newString);
			}
		});*/
		myListView.getSelectionModel().selectedItemProperty().addListener((ov, o, n) -> field.setText(n));
	}
	public Group getRoot() {
		return root;
	}
	public ObservableList<String> getObs() {
		return myObsList;
	}
	
	public ListView<String> getListView() {
		return myListView;
	}

}
