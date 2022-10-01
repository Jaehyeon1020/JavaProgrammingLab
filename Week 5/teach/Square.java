package teach;

public class Square extends Shape2D {
	private double edge; // for getting edge of square
	
	// constructor of Square class
	public Square(double edge) {
		setEdge(edge);
	}
	
	// setter method for member variable edge
	public void setEdge(double edge) {
		this.edge = edge;
	}
	
	// setter method for member variable edge
	public double getEdge() {
		return this.edge;
	}
	
	// overriden method from Shape2D class, returns area of square
	@Override
	public double calculateArea() {
		return getEdge() * getEdge();
	}
}
