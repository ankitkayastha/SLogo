package UserInterface.RightPane;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import slogo_team03.PassToFrontInterface;
import javafx.scene.control.TextArea;

import java.util.List;
import java.util.ResourceBundle;


import UserInterface.LeftPane.ListViewHandler;
import controller.IFront;

public class CommandHistory implements IFront {
	
	private ListViewHandler listViewHandler;
	private List<ListView<String>> commandHist;
	private PassToFrontInterface pInterface;
	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.RightPane/RightResource");
	private Group root;
	
	public CommandHistory(PassToFrontInterface pf) {
		root = new Group();
		listViewHandler = new ListViewHandler();
		this.pInterface = pf;
	}
	
	public void makeListView(TextArea field) {
		Text title = new Text();
		title.setText("Command History");
		title.setTranslateX(Double.parseDouble(r.getString("translateX")));
		title.setTranslateY(Double.parseDouble(r.getString("translateY")));
		double[] prefWidth = {Double.parseDouble(r.getString("prefWidth"))};
		double[] prefHeight = {Double.parseDouble(r.getString("prefHeight"))};
		double[] translateY = {Double.parseDouble(r.getString("historyTranslateY"))};
		double[] translateX = {Double.parseDouble(r.getString("historyTranslateX"))};
		commandHist = listViewHandler.createListView(1, prefWidth, prefHeight, translateY, translateX);
		for (ListView<String> list: commandHist) {
			list.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> field.setText(newVal));
			root.getChildren().add(list);
		}
		root.getChildren().add(title);
	}
	public Group getRoot() {
		return root;
	}

	@Override
	public void update() {
		String lastCommand = pInterface.getLastCommand();
		for (int i = 0; i < listViewHandler.getObsList().size(); i++) {
			ObservableList<String> obs = listViewHandler.getObsList().get(i); 
			obs.add(lastCommand);
			commandHist.get(i).setItems(obs);
		}
	}

}
