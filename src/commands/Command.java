package commands;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import slogo_team03.CommandInputException;
import slogo_team03.Turtle;
import slogo_team03.UserDefinedCommands;
import slogo_team03.UserDefinedVariables;

public abstract class Command {
	protected double[] myParameters = new double[10];
	protected Turtle myTurtle;
	protected String myVariable;
	protected String parameterCode;
	protected List<String> variableList = new ArrayList<String>();
	protected List<List<String>> myCommandLists = new ArrayList<List<String>>();
	protected static UserDefinedCommands userDefinedCommands;
	protected static UserDefinedVariables variableMap;

	public Command() {
	}

	public abstract double execute();

	public void addVariable(String var) {
		variableList.add(var);
	}
	public List<String> getVariableList() {
		return variableList;
	}
	
	public static void setMaps(UserDefinedCommands uMap, UserDefinedVariables vMap) {
		userDefinedCommands = uMap;
		variableMap = vMap;
	}

	public void addListOfCommands(List<String> cList) {
		myCommandLists.add(cList);
	}

	public void setParameter(int i, double param) {
		myParameters[i] = param;
	}

	public void setTurtle(Turtle turtle) {
		myTurtle = turtle;
	}

	public void setVariable(String s) {
		myVariable = s;
	}

	public double executeAndFormat() throws NumberFormatException, CommandInputException {
		DecimalFormat df = new DecimalFormat("#.#####");
		double value = Double.valueOf(df.format(execute()));
		if (Double.valueOf(df.format(value)) == 0.00000)
			return 0;
		return value;
	}

	public String getParamCode() {
		return parameterCode;
	}
}