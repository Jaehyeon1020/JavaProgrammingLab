package teach;

public abstract class Shape2D {
	private double area; // for getting area of this shape
	
	// calculates area of some shape
	// this method will be implemented in subclass
	public abstract double calculateArea();
	
	// setter method for member variable area
	public void setArea(double area) {
		this.area = area;
	}
	
	// getter method of member variable area
	public double getArea() {
		return this.area;
	}
}
