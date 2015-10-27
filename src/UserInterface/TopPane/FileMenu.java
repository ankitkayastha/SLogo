package UserInterface.TopPane;


import UserInterface.CenterPane.DisplayTurtle;
import javafx.scene.control.Menu;
import slogo_team03.FileInterface;
import slogo_team03.PassToFrontInterface;
import slogo_team03.ReceiveFromFront;

public class FileMenu extends AbstractMenu implements IMenu{

	private FileInterface fi;
	
	public FileMenu(FileInterface fileinterface) {
		this.fi = fileinterface;
	}
	@Override
	public Menu makeMenu(DisplayTurtle display, PassToFrontInterface pf, ReceiveFromFront rf) {
		Menu file = new Menu(r.getString("fileTitle"));
		SaveLibraryMenu saveLibraryMenu = new SaveLibraryMenu(fi);
		SaveWorkspaceMenu saveWorkspaceMenu = new SaveWorkspaceMenu(fi);
		LoadLibraryMenu loadLibraryMenu = new LoadLibraryMenu(fi);
		LoadWorkspaceMenu loadWorkspaceMenu = new LoadWorkspaceMenu(fi);
		
		Menu saveLibrary = saveLibraryMenu.makeMenu(display, pf, rf);
		Menu saveWorkspace = saveWorkspaceMenu.makeMenu(display, pf, rf);
		Menu loadLibrary = loadLibraryMenu.makeMenu(display, pf, rf);
		Menu loadWorkspace = loadWorkspaceMenu.makeMenu(display, pf, rf);
		
		file.getItems().addAll(saveLibrary, saveWorkspace, loadLibrary, loadWorkspace);

		return file;
		
	}

}
