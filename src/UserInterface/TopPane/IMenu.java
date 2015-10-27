package UserInterface.TopPane;

import UserInterface.CenterPane.DisplayTurtle;
import javafx.scene.control.Menu;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;

public interface IMenu {
	public Menu makeMenu(DisplayTurtle display, PassToFrontInterface pf, ReceiveFromFront rf);
}
