package company;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double salaryIncreasePercentage = 0; // for caculation to increase salary by given percentage
		Scanner scanner = new Scanner(System.in); // for get variable salaryIncreasePercentage from keyboard input
		
		Employee firstEmployee = new Employee("John", 600000); // Creating first Employee class instance
		Employee secondEmployee = new Employee("Mark", 900000); // Creating second Employee class instance
		
		firstEmployee.getInformation(); // printing firstEmployee's information
		secondEmployee.getInformation(); // printing secondEmployee's information
		
		System.out.println("==============================");
		System.out.print("Increase salary (in percentage): ");
		salaryIncreasePercentage = scanner.nextDouble(); // getting percentage from keyboard input
		scanner.close(); // closing Scanner object
		
		firstEmployee.increaseSalary(salaryIncreasePercentage); // increasing Salary by salaryIncreasePercentage(tax and insurance are also changed)
		secondEmployee.increaseSalary(salaryIncreasePercentage); // increasing Salary by salaryIncreasePercentage(tax and insurance are also changed)
		
		System.out.println("After Salary Increase");
		firstEmployee.getInformation(); // printing firstEmployee's changed information
		secondEmployee.getInformation(); // printing firstEmployee's changed information
	}

}
