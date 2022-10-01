package teach;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // creating Scanner instance for getting user input
		
		System.out.println("=== Welcome to TEACH MATH ==="); // printing menu to user
		System.out.println("1. Calculate volume of Square Pyramid.");
		System.out.println("2. Calculate volume of Cone.");
		System.out.println("3. Calculate volume of Cylinder.");
		System.out.print("Enter your choice: ");
		
		int UserInput = scanner.nextInt(); // getting user input
		
		// if user chose to calculate volume of square pyramid
		if(UserInput == 1) {
			System.out.print("Enter edge of Square Pyramid: ");
			double userInputEdge = scanner.nextDouble(); // getting edge value from user input
			
			System.out.print("Enter height of Square Pyramid: ");
			double userInputHeight = scanner.nextDouble(); // getting height value from user input
			
			SquarePyramid squarePyramid = new SquarePyramid(userInputEdge, userInputHeight); // creating new SquarePyramid instance
			
			System.out.println("Volume of Square Pyramid: " + squarePyramid.calculateVolume()); // printing calculated square pyramid volume
		}
		// if user chose to calculate volume of cone
		else if(UserInput == 2) {
			System.out.print("Enter radius of Cone: ");
			double userInputradius = scanner.nextDouble(); // getting radius value from user input
			
			System.out.print("Enter height of Cone: ");
			double userInputHeight = scanner.nextDouble(); // getting height value from user input
			
			Cone cone = new Cone(userInputradius, userInputHeight); // creating new Cone instance
			
			System.out.println("Volume of Cone: " + cone.calculateVolume()); // printing calculated cone volume
		}
		// if user chose to calculate volume of cylinder
		else {
			System.out.print("Enter radius of Cylinder: ");
			double userInputRadius = scanner.nextDouble(); // getting radius value from user input
			
			System.out.print("Enter height of Cylinder: ");
			double userInputHeight = scanner.nextDouble(); // getting height value from user input
			
			Cylinder cylinder = new Cylinder(userInputRadius, userInputHeight); // creating new Cylinder instance
			
			System.out.println("Volume of Cylinder: " + cylinder.calculateVolume()); // printing caculated cylinder volume
		}
		
		scanner.close(); // closing Scanner instance
	}
}
