import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		TurtleWorld world = new TurtleWorld();		
		Scanner scan = new Scanner(System.in);
		while (true) {
			world.getInput(scan.nextLine());
		}
//		world.getInput("setheading s setheading setheading 180 heading 3"); 
	}	
}