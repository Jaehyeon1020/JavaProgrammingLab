
public class Taxi extends PublicTransport {
	private double farePerKm; // for storing fare per kilometer
	private double distance; // for storing moving distance
	
	public Taxi(double baseFare, double farePerKm, double distance) {
		super("Taxi"); // set model "Taxi"
		super.setBaseFare(baseFare);
		setFarePerKm(farePerKm);
		setDistance(distance);
	}
	
	// getter method for class variable farePerKm
	public double getFarePerKm() {
		return this.farePerKm;
	}
	
	// getter method for class variable distance
	public double getDistance() {
		return this.distance;
	}
	
	// setter method for class variable farePerKm
	public void setFarePerKm(double farePerKm) {
		this.farePerKm = farePerKm;
	}
	
	// setter method for class variable distance
	public void setDistance(double distance) {
		this.distance = distance;
	}

	// returns total fare of this taxi
	@Override
	public double calculatePayment() {
		super.setTotalFare(super.getBaseFare() + getFarePerKm() * getDistance());
		return super.getTotalFare();
	}

}
