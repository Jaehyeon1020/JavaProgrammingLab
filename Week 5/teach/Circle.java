package teach;

public class Circle extends Shape2D {
	private double radius; // for getting radius of the circle
	private final double PI = 3.14; // setting PI: constant value
	
	// constructor of Circle class, get radius as parameter
	public Circle(double radius) {
		setRadius(radius);
	}
	
	// setter method for member variable radius
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	// getter method for member variable radius
	public double getRadius() {
		return this.radius;
	}

	// overrided method from Shape2D class
	// returns area of the circle
	@Override
	public double calculateArea() {
		return PI * getRadius() * getRadius(); // area of circle formula : radius^2 * PI
	}
}
