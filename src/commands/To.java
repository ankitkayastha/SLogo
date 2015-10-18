package commands;

import java.util.ArrayList;
import java.util.List;

public class To extends SpecialCommand {
	private boolean wellDefined;
	private UserCommand userCommand;
	
	public To() {
		runList = new ArrayList<String>();
		paramCode = "n[p][c]";
	}
	
	public void createUserDefinedCommand(String name) {
		userCommand = new UserCommand(name);
	}
	
	public UserCommand getUserCommand() {
		return userCommand;
	}
	
	@Override
	public void addVariable(String var) {
		variableList.add(var);
		userCommand.addVariable(var);
	}
	
	@Override
	public void addListOfCommands(List<String> cList) {
		myCommandLists.add(cList);
		userCommand.addListOfCommands(cList);
	}

	public double execute() {
		int numParams = userCommand.numberOfParameters();
		double[] params = new double[numParams];
		for (int i = 0; i < userCommand.numberOfParameters(); i++) {
			params[i] = 1;
		}
		runList = userCommand.assignValuesToCommandList(params);
		return -1;
	}
}