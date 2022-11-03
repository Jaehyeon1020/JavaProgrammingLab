import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String studentName; // Variable to store student's name and use as an argument of constructor of Student class
		int dateOfBirth; // Variable to store student's birth year and use as an argument of constructor of Student class
		double gpa; // Variable to store student's CGPA and use as an argument of constructor of Student class
		String department; // Variable to store student's department and use as an argument of constructor of Student class
		
		Scanner userInput = new Scanner(System.in); // for getting keyboard input
		System.out.print("Enter your name: ");
		studentName = userInput.nextLine(); // get student's name from keyboard input
		System.out.print("Enter your date of birth: ");
		dateOfBirth = userInput.nextInt(); // get student's birth year from keyboard input
		userInput.nextLine(); // for removing remaining Enter
		System.out.print("Enter your cumulative GPA: ");
		gpa = userInput.nextDouble(); // get student's CGPA from keyboard input
		userInput.nextLine(); // for removing remaining Enter
		System.out.print("Enter your department: ");
		department = userInput.nextLine(); // get student's department from keyboard input
		userInput.close();
		
		Student studentObject = new Student(studentName, dateOfBirth, gpa, department); // initializing Student class object
		System.out.println("==========================");
		System.out.println("Student name: " + studentObject.getStudentName()); 
		System.out.println("Student's age: " + studentObject.getAge());
		System.out.println("Student's CGPA: " + studentObject.getGpa());
		System.out.println("Student's department: " + studentObject.getDepartment());
		
	}

}
