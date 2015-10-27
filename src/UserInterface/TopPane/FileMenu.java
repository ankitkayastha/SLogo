package UserInterface.TopPane;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import UserInterface.CenterPane.DisplayTurtle;
import controller.toppane.UpdateFile;
import javafx.scene.control.Menu;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import slogo_team03.FileInterface;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;

public class FileMenu extends AbstractMenu implements IMenu{

	private FileInterface fi;
	
	public FileMenu(FileInterface fileinterface) {
		this.fi = fileinterface;
	}
	@SuppressWarnings("null")
	@Override
	public Menu makeMenu(DisplayTurtle display, PassToFrontInterface pf, ReceiveFromFront rf) {
		Menu file = new Menu(r.getString("fileTitle"));
		List<String> fileOptions = new ArrayList<String>();
		List<String> fileImages = new ArrayList<String>();
		fileOptions.add(r.getString("saveFile"));
		fileOptions.add(r.getString("loadFile"));
		fileImages.add(r.getString("saveImage"));
		fileImages.add(r.getString("loadImage"));
		UpdateFile updateFile = new UpdateFile(fi);
		Rectangle[] fImages = makeImageNodes(fileImages, 20, 20);
		addMenuItem(file, fileOptions, fImages);
		for (int i = 0; i < fileOptions.size(); i++) {
			if (i == 0) {
				file.getItems().get(i).setOnAction((event) -> {
				FileChooser fc = new FileChooser();
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
				fc.getExtensionFilters().add(extFilter);
				File inputFile = fc.showSaveDialog(null);
				if (inputFile != null) {

					try {
					fi.writeLibraryXmlFile(inputFile.getAbsolutePath());
					}
					catch (Exception e) {
						System.out.println("shit");
						e.printStackTrace();
					}
				}
				fi.writeLibraryXmlFile(inputFile.getName());
				});
			}
			else if (i == 1) {
				file.getItems().get(i).setOnAction((event) -> {
				FileChooser fc = new FileChooser();
				fc.setTitle("Load File");
				FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("XML files (*.xml)", "*.xml");
				fc.getExtensionFilters().add(extFilter);
				File pls = fc.showOpenDialog(null);
				if (!(pls!=null)) {
					try {
						fi.readLibraryXmlFile(pls.getAbsolutePath());
					}
					catch (Exception e) {
						System.out.println("Shit");
						e.printStackTrace();
					}
				}});
			}
		}
		return file;
		
	}

}
