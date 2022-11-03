package teach;

public class SquarePyramid extends Shape3D {
	private double edge; // for storing edge of bottom square
	private double height; // for storing height of square pyramid
	private Square square; // for storing bottom square of pyramid
	
	// constructor of SquarePyramid class
	public SquarePyramid(double edge, double height) {
		setEdge(edge);
		setHeight(height);
		setSquare(edge); // Creating bottom square instance
	}
	
	// setter method for member variable edge
	public void setEdge(double edge) {
		this.edge = edge;
	}
	
	// setter method for member variable height
	public void setHeight(double height) {
		this.height = height;
	}
	
	// setter method for member variable square
	public void setSquare(double edge) {
		this.square = new Square(edge);
	}
	
	// getter method for member variable edge
	public double getEdge() {
		return this.edge;
	}
	
	// getter method for member variable height
	public double getHeight() {
		return this.height;
	}
	
	// getter method for member variable sqaure
	public Square getSquare() {
		return this.square;
	}
	
	// overriden method from Shape3D: returns volume of the square pyramid
	@Override
	public double calculateVolume() {
		return (1.0/3.0) * getSquare().calculateArea() * getHeight(); // square pyramid volume formula: 1/3 * bottom square area * height of pyramid
	}
}
