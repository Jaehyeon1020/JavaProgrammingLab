
public class Station {
	private double farePerStation; // for storing fare per extra stations
	private int nStations; // for storing the number of stations
	
	 //constructor of Station class
	public Station(double farePerStation, int nStations) {
		setFarePerStation(farePerStation);
		setNStations(nStations);
	}
	
	
	// getter method of class variable farePerStation
	public double getFarePerStation() {
		return this.farePerStation;
	}
	
	// getter method of class variable nStations
	public int getNStations() {
		return this.nStations;
	}
	
	// setter method of class variable farePerStation
	public void setFarePerStation(double farePerStation) {
		this.farePerStation = farePerStation;
	}
	
	// setter method of class variable nStations
	public void setNStations(int nStations) {
		this.nStations = nStations;
	}
}
