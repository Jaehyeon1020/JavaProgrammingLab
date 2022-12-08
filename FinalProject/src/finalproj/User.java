package finalproj;

/**
 * class about user who order foods 
 */
public class User {
	private String name; // for storing user name
	private String phoneNumber; // for storing user's phone number
	private String address; // for storing user's address
	private boolean isCovidPatient; // for storing whether the user is covid-19 patient
	private Food main; // for storing user selected main menu
	private Food side; // for storing user selected side menu
	private Food beverage; // for storing user selected beverage
	
	public User(String name, String phoneNumber, String address, boolean iscovid) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.isCovidPatient = iscovid;
	}
	
	/* method for set user's order */
	public void setOrder(Food main, Food side, Food beverage) {
		this.main = main;
		this.side = side;
		this.beverage = beverage;
	}
	
	/* getter for name */
	public String getName() {
		return this.name;
	}
	
	/* getter for phoneNumber */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/* getter for address */
	public String getAddress() {
		return this.address;
	}
	
	/* getter for user selected main menu */
	public Food getMainFood() {
		return this.main;
	}
	
	/* getter for user selected side menu */
	public Food getSideFood() {
		return this.side;
	}
	
	/* getter for user selected beverage */
	public Food getBeverageFood() {
		return this.beverage;
	}
	
	/* make user information String and return it */
	public String getUserInfo() {
		String info = "";
		String covidInfo = (this.isCovidPatient == true) ? "Yes" : "NO";
		
		info += "<User Information>\n"
				+ "User Name: " + this.name + "\n"
				+ "Phone Number: " + this.phoneNumber + "\n"
				+ "Address: " + this.address + "\n"
				+ "Covid-19 Patient: " + covidInfo + "\n";
		
		return info;
	}
}
