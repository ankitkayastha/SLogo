package tyler;
import java.util.Scanner;

public class Main {
	private static Scanner scan;

	public static void main(String[] args) {
		TurtleWorld world = new TurtleWorld();		
		scan = new Scanner(System.in);
		while (true) {
			world.processInput(scan.nextLine());
		}
	}	
}