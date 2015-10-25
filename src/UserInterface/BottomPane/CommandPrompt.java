package UserInterface.BottomPane;

import controller.BottomPane;
import controller.IFront;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import slogo_team03.AngleInterface;
import slogo_team03.CommandInputException;
import slogo_team03.CoordinateInterface;
import slogo_team03.PassToFrontInterface;
import slogo_team03.PenUpDownInterface;
import slogo_team03.ReceiveFromFront;
import slogo_team03.TrigonometricException;
import slogo_team03.VisibleInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import UserInterface.CenterPane.DisplayTurtle;
import UserInterface.LeftPane.LeftContent;
import UserInterface.RightPane.CommandHistory;
import UserInterface.TopPane.MenuHandler;

public class CommandPrompt implements IFront {
	private Group root;
	private TextArea field;

	private ResourceBundle r = ResourceBundle.getBundle("UserInterface.BottomPane/bottomResource");
	private ReceiveFromFront receiveInterface;
	private List<IFront> frontObjects;
	public CommandPrompt(ReceiveFromFront rf, List<IFront> front) {
		field = new TextArea();
		receiveInterface = rf;
		frontObjects = front;
	}
	public Group getRoot() {
		return root;
	}
	
	public TextArea getField() {
		return field;
	}
	
	public void makeCommandPromptArea(BottomPane bottomController, ReceiveFromFront rs, PassToFrontInterface pf) {
		root = new Group();

		ButtonHandler buttonHandler = new ButtonHandler();
		Button[] buttonArr;
		field.setPrefSize(Double.parseDouble(r.getString("inputBoxWidth")), Double.parseDouble(r.getString("inputBoxHeight")));
		String[] titles = {r.getString("runTitle"), r.getString("clearTitle")};
		double[] translateX = {Double.parseDouble(r.getString("runTranslateX")), Double.parseDouble(r.getString("clearTranslateX"))};
		double[] translateY = {Double.parseDouble(r.getString("runTranslateY")), Double.parseDouble(r.getString("clearTranslateY"))};
		buttonArr = buttonHandler.makeButtons(2, titles, translateX, translateY);
		Button clear = buttonArr[1];
		Button run = buttonArr[0];

		field.setOnKeyPressed(event -> bottomController.handleKeyInput(event.getCode(), field));
		
		clear.setOnAction((event) -> {
			bottomController.clearButtonAction(field);
		}); 
		List<Node> nodeList = new ArrayList<Node>();
		nodeList.add(field);
		for (Button button: buttonArr)
			nodeList.add(button);
		root.getChildren().addAll(nodeList);
		run.setOnAction((event) -> {
			try {
				bottomController.runButtonAction(field.getText(), frontObjects, rs); 
				this.update();
			}
				//bottomController.runButtonAction(field, rs);
			 catch (CommandInputException e) {
				Custom_Alert alert = new Custom_Alert(AlertType.WARNING, r.getString("errorString"), r.getString("invalid"));
				if (e.getBadInput().isEmpty()) {
					alert.setContentText(r.getString("parameters"));
				} else {
					alert.setContentText("Please check your spelling of \"" + e.getBadInput() + "\".");
				}
				alert.showAndWait();
			}
			catch (TrigonometricException e) {
				Custom_Alert alert = new Custom_Alert(AlertType.WARNING, r.getString("errorString"), r.getString("trig"));
				alert.setContentText(e.getBadFunction()); 
				alert.showAndWait();
			}
			
			
		});
	}
	@Override
	public void update() {
		field.clear();
		
		// TODO Auto-generated method stub
		
	}
	
}
