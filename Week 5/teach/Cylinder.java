package teach;

public class Cylinder extends Shape3D {
	private double radius; // for getting radius of the circle(bottom of the cylinder)
	private double height; // for getting height of the cylinder
	private Circle circle; // for getting bottom circle of the cylinder
	
	// constructor of Cylinder class, get radius and height as parameters
	public Cylinder(double radius, double height) {
		setRadius(radius);
		setHeight(height);
		setCircle(radius); // creating bottom Circle instance by given radius
	}
	
	// setter method for member variable radius
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	// setter method for member variable height
	public void setHeight(double height) {
		this.height = height;
	}
	
	// setter method for member variable circle
	public void setCircle(double radius) {
		this.circle = new Circle(radius);
	}
	
	// getter method for member variable radius
	public double getRadius() {
		return this.radius;
	}
	
	// getter method for member variable height
	public double getHeight() {
		return this.height;
	}
	
	// getter method for member variable circle
	public Circle getCircle() {
		return this.circle;
	}
	
	// overriden method from Shape3D class: returns Volume of the Cylinder
	@Override
	public double calculateVolume() {
		return getHeight() * getCircle().calculateArea(); // Cylinder Volume formula: area of the bottom circle * height of the cylinder
	}
}
