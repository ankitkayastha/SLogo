package commands;

public class Product extends Command {
	public Product() {
		super();
	}

	public double execute() {
		return myParameters[0] * myParameters[1];
	}
	
	@Override
	public String toString() {
		return "Product";
	}
}