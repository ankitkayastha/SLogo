package commands;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import slogo_team03.CommandInputException;
import slogo_team03.TrigonometricException;
import slogo_team03.Turtle;
import slogo_team03.UserDefinedCommands;
import slogo_team03.UserDefinedVariables;
import java.util.ResourceBundle;

public abstract class Command {
	protected Turtle myTurtle;
	protected String myParameterCode;
	protected List<Double> myParameters = new ArrayList<Double>();
	protected List<String> myVariables = new ArrayList<String>();
	protected List<List<String>> myCommandLists = new ArrayList<List<String>>();
	protected static UserDefinedCommands userDefinedCommands;
	protected static UserDefinedVariables variableMap;
	protected final ResourceBundle ParameterCode = ResourceBundle.getBundle("commands/ParameterCode");;

	public Command() {
		myParameterCode = ParameterCode.getString(toString());
	}

	public abstract String toString();

	public abstract double execute() throws CommandInputException, TrigonometricException;

	public static void setMaps(UserDefinedCommands uMap, UserDefinedVariables vMap) {
		userDefinedCommands = uMap;
		variableMap = vMap;
	}

	public String getParameterCode() {
		return myParameterCode;
	}

	public void addParameter(double param) {
		myParameters.add(param);
	}

	public void addVariable(String var) {
		myVariables.add(var);
	}

	public List<String> getVariableList() {
		return myVariables;
	}

	public void addListOfCommands(List<String> cList) {
		myCommandLists.add(cList);
	}

	public void setTurtle(Turtle turtle) {
		myTurtle = turtle;
	}

	public double executeAndFormat() throws CommandInputException, TrigonometricException {
		DecimalFormat df = new DecimalFormat("#.#####");
		double value = Double.valueOf(df.format(execute()));
		try {
			if (Double.valueOf(df.format(value)) == 0.00000)
				return 0;
		} catch (NumberFormatException e) {
			throw new CommandInputException("(Number Formatting)");
		}
		return value;
	}
}