package tyler;
public class Product extends Command {
	public Product() {
		paramCode = "ee";
	}

	public double execute() {
		return myParameters[0] * myParameters[1];
	}
}