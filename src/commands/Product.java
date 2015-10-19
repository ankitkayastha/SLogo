package commands;
public class Product extends Command {
	public Product() {
		parameterCode = "ee";
	}

	public double execute() {
		return myParameters[0] * myParameters[1];
	}
}