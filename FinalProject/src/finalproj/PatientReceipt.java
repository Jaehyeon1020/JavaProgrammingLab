package finalproj;

/**
 * class for covid-19 patient user
 * covid-19 patient user can get 3,000won discount on main menu and 1,000won discount on side menu
 */
public class PatientReceipt extends Receipt {

	public PatientReceipt(User user) {
		super(user);
	}
	
	/** get total cost of the order : covid-19 patient can get 3,000won discount on main menu and 1,000won discount on side menu*/
	@Override
	public int getTotalCost() {
		User user = super.getUser();
		
		int mainCost = user.getMainFood().getCost() - 3000; // cost of user's main menu(3,000won discount applied)
		int sideCost = user.getSideFood().getCost() - 1000; // cost of user's side menu(1,000won discount applied)
		int beverageCost = user.getBeverageFood().getCost(); // cost of user's beverage menu
		
		return mainCost + sideCost + beverageCost;
	}
	
	/**
	 * method for make and get receipt of order
	 * in case of covid-19 patient, additional information on patient discounts is included in the receipt.
	 */
	@Override
	public String getReceipt() {
		User user = super.getUser();
		String receipt = "";
		
		receipt += user.getUserInfo() + "\n"
				+ "===== Your Order =====\n"
				+ user.getMainFood().getInformation() + "\n"
				+ "Covid-19 patient discount: -3,000 won\n"
				+ user.getSideFood().getInformation() + "\n"
				+ "Covid-19 patient discount: -1,000 won\n"
				+ user.getBeverageFood().getInformation() + "\n";
		
		return receipt;
	}
}
