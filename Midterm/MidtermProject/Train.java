
public class Train extends PublicTransport {
	private Station trainStation; // for storing Station instance
	
	// constructor of class Train
	public Train(double baseFare, double farePerStation, int nStations) {
		super("Train");
		super.setBaseFare(baseFare);
		setTrainStation(farePerStation, nStations);
	}
	
	// getter method for class variable trainStation
	public Station getTrainStation() {
		return this.trainStation;
	}
	
	// setter method for class variable trainStation
	public void setTrainStation(double farePerStation, int nStation) {
		this.trainStation = new Station(farePerStation, nStation);
	}
	
	@Override
	public double calculatePayment() {
		if(trainStation.getNStations() > 5) {
			super.setTotalFare(super.getBaseFare() + trainStation.getFarePerStation()
								* (trainStation.getNStations() - 5));
			return super.getTotalFare();
		}
		else {
			return super.getBaseFare();
		}
	}

}
