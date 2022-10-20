
public abstract class PublicTransport implements Payable {
	private String model; // for storing what is this transport
	private double baseFare; // for storing base fare of this transport
	private double totalFare; // for storing total fare this transport
	
	public PublicTransport(String model) {
		setModel(model);
	}

	@Override
	public abstract double calculatePayment();
	
	// getter method for class variable model
	public String getModel() {
		return this.model;
	}
	
	// getter method for class variable baseFare
	public double getBaseFare() {
		return this.baseFare;
	}
	
	// getter method for class variable totalFare
	public double getTotalFare() {
		return this.totalFare;
	}
	
	// setter method for class variable model
	public void setModel(String model) {
		this.model = new String(model);
	}
	
	// setter method for class variable baseFare
	public void setBaseFare(double baseFare) {
		this.baseFare = baseFare;
	}
	
	// setter method for class variable totalFare
	public void setTotalFare(double totalFare) {
		this.totalFare = totalFare;
	}
}









