package commands;

import java.util.ArrayList;
import java.util.List;

public class To extends SpecialCommand {
	// private boolean wellDefined;
	private UserCommand userCommand;

	public To() {
		runList = new ArrayList<String>();
		parameterCode = "n[p][c]";
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
		// System.out.print("Command Definition:");
		// for (int z = 0; z < cList.size(); z++) {
		// System.out.print(" " + cList.get(z));
		// } System.out.println();
		myCommandLists.add(cList);
		userCommand.addListOfCommands(cList);
	}

	public double execute() {
		userCommand.setParameterCode(userCommand.getVariableList().size());
		int numParams = userCommand.getNumberOfParameters();
		double[] params = new double[numParams];
		for (int i = 0; i < numParams; i++) {
			params[i] = 1.0;
		}
		runList = userCommand.assignValuesToCommandList(params);
		// System.out.print("RunList:");
		// for (int z = 0; z < runList.size(); z++) {
		// System.out.print(" " + runList.get(z));
		// } System.out.println();
		return -1;
	}
}