import java.time.LocalDate;

public class Student {
	private String name; // for storing student's name
	private int birthYear; // for storing student's birth year
	private double cGpa; // for storing student's cumulative GPA
	private String department; // for storing student's department
	
	public Student(String studentName, int dateOfBirth, double gpa, String studentDepartment) {
		name = studentName;
		birthYear = dateOfBirth;
		cGpa = gpa;
		department = studentDepartment;
	}
	// for returning the name of this Student class object
	public String getStudentName() {
		return name;
	}
	// for returning the age of this Student class object
	public int getAge() {
		LocalDate now = LocalDate.now(); // to get what year this year is
		return now.getYear()-birthYear; // calculate the age of this Student class object from birthYear and return
	}
	// for returning the cumulative GPA of this Student class object
	public double getGpa() {
		return cGpa;
	}
	// for returning the department of this Student class object
	public String getDepartment() {
		return department;
	}
}
