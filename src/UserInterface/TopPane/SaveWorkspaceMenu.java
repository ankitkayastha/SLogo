package UserInterface.TopPane;

import java.util.ArrayList;
import java.util.List;
import UserInterface.CenterPane.DisplayTurtle;
import controller.toppane.UpdateFile;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.shape.Rectangle;
import slogo_team03.FileInterface;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;

public class SaveWorkspaceMenu extends AbstractMenu implements IMenu{
	FileInterface fi;
	public SaveWorkspaceMenu(FileInterface fileInterface) {
		this.fi = fileInterface;
	}

	@Override
	public Menu makeMenu(DisplayTurtle display, PassToFrontInterface pf, ReceiveFromFront rf) {
		Menu save = new Menu(r.getString("saveTitle"));
		List<String> saveOptions = new ArrayList<String>();
		List<String> saveImages = new ArrayList<String>();
		saveOptions.add(r.getString("saveWorkspaceFile"));
		saveImages.add(r.getString("saveImage"));
		UpdateFile updateFile = new UpdateFile(fi);
		Rectangle[] fImages = makeImageNodes(saveImages, 20, 20);
		addMenuItem(save, saveOptions, fImages);

		for (MenuItem m : save.getItems()) {
			m.setOnAction((event) -> {
				try {
					updateFile.saveWorkspaceFile();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		}
		return save;
	}

}
