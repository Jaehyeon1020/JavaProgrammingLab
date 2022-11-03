package teach;

public abstract class Shape3D {
	private double volume; // for getting volume of this shape
	
	// calculates volume of some shape
	// this method will be implemented in subclass
	public abstract double calculateVolume();
	
	// setter method for member variable volume
	public void setVolume(double volume) {
		this.volume = volume;
	}
	
	// getter method for member variable volume
	public double getVolume() {
		return this.volume;
	}
}
