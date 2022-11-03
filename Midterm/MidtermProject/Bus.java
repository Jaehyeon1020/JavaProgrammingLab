
public class Bus extends PublicTransport {
	private Station busStation; // for storing Station instance
	
	// constructor of Class Bus
	public Bus(double baseFare, double farePerStation, int nStations) {
		super("Bus");
		super.setBaseFare(baseFare);
		setBusStation(farePerStation, nStations);
	}
	
	// getter method of class variable busStation
	public Station getBusStation() {
		return this.busStation;
	}
	
	// setter method of class variable busStation
	public void setBusStation(double farePerStation, int nStations) {
		this.busStation = new Station(farePerStation, nStations);
	}

	/**
	 * if the bus passes over 5 stations, extra fare is added
	 * else total fare is just same as base fare
	 */
	@Override
	public double calculatePayment() {
		if(busStation.getNStations() > 5) {
			super.setTotalFare(super.getBaseFare() + busStation.getFarePerStation()
								* (busStation.getNStations() - 5));
			return super.getTotalFare();
		}
		else {
			return super.getBaseFare();
		}
	}

}
