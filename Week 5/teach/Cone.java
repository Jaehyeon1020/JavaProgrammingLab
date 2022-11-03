package teach;

public class Cone extends Shape3D{
	private double radius; // for getting radius of the circle(bottom of the cone)
	private double height; // for getting height of the cone
	private Circle circle; // for getting bottom circle of the cone
	
	// constructor of Cone class, get radius and height as parameters
	public Cone(double radius, double height) {
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
	
	// overrided method from Shape3D class, returns the volume of cone
	@Override
	public double calculateVolume() {
		return (1.0/3.0) * getCircle().calculateArea() * getHeight(); // volume of cone formula : 1/3 * area of bottom circle * height of cone
	}
}
