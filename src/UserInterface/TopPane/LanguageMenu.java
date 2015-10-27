package UserInterface.TopPane;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import UserInterface.CenterPane.DisplayTurtle;
import controller.toppane.UpdateLanguage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.shape.Rectangle;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;

public class LanguageMenu extends AbstractMenu implements IMenu {

	ResourceBundle r = ResourceBundle.getBundle("UserInterface.TopPane/TopResource");

	@Override
	public Menu makeMenu(DisplayTurtle display, PassToFrontInterface pf, ReceiveFromFront rf) {
		Menu language = new Menu(r.getString("languageTitle"));
		UpdateLanguage updateLang = new UpdateLanguage(rf);
		List<String> languageOptions = new ArrayList<String>();
		List<String> flagOptions = new ArrayList<String>();
		for (int i = 1; i <= 8; i++) {
			languageOptions.add(r.getString("languageItem" + Integer.toString(i)));
			flagOptions.add(r.getString("languageFlag" + Integer.toString(i)));
		}
		Rectangle[] flagRects = makeImageNodes(flagOptions, 75, 50);
		addMenuItem(language, languageOptions, flagRects);
		for (MenuItem m: language.getItems()) {
			m.setOnAction((event) -> updateLang.changeLanguage(m.getText()));
		}
		return language;
	}

}
