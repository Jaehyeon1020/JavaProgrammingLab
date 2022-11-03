package company;

public class Employee {
	private String name; // for storing an Employee instance's name
	private double salary; // for storing an Employee instance's salary value
	private double tax; // for storing an Employee instance's tax value
	private double insurance; // for storing an Employee instance's insurance value
	
	// Constructor of Employee class : get name and salary by arguments and set tax and insurance by using given salary value
	public Employee(String name, double salary) {
		setName(name);
		setSalary(salary);
		setTax();
		setInsurance();
	}
	
	// setter method of class variable name
	public void setName(String name) {
		this.name = new String(name);
	}
	
	// setter method of class variable salary
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	// setter method of class variable tax : tax value is calculated to 8.8% of salary
	public void setTax() {
		this.tax = salary * 0.088;
	}
	
	// setter method of class variable insurance : insurance value is calculated to 6.5% of salary
	public void setInsurance() {
		this.insurance = salary * 0.065;
	}
	
	// getter method of class variable Name
	public String getName() {
		return this.name;
	}
	
	// getter method of class variable salary
	public double getSalary() {
		return this.salary;
	}
	
	// getter method of class variable tax
	public double getTax() {
		return this.tax;
	}
	
	// getter method of class variable insurance
	public double getInsurance() {
		return this.insurance;
	}
	
	// print info of this object: name, salary, tax and insurance
	public void getInformation() {
		System.out.println("==============================");
		System.out.println("Employee Info");
		System.out.println("Name: " + getName());
		System.out.printf("Salary: %.1f\n", getSalary());  // salary is double type, so outputs only one digit below the decimal point for clean look
		System.out.printf("Tax: %.1f\n", getTax()); // tax is double type, so outputs only one digit below the decimal point for clean look
		System.out.printf("Insurance: %.1f\n", getInsurance()); // insurance is double type, so outputs only one digit below the decimal point for clean look
	}
	
	// calculate the salary increased by salaryIncreasePercentage; As the salary increases, tax and insurance change
	public void increaseSalary(double salaryIncreasePercentage) {
		setSalary(salary * (1 + salaryIncreasePercentage/100)); // set new salary increased by given percentage
		setTax(); // re-calculate tax value by changed salary
		setInsurance(); // re-calculate insurance value by changed salary
	}
}