package finalproj;

/** 
 * class for handling user's order
 * stores costs of order and have method for making receipt information
 */
public class Receipt {
	private User user;
	
	public Receipt(User user) {
		this.user = user;
	}
	
	/* get total cost of the order */
	public int getTotalCost() {
		int mainCost = user.getMainFood().getCost(); // cost of user's main menu
		int sideCost = user.getSideFood().getCost(); // cost of user's side menu
		int beverageCost = user.getBeverageFood().getCost(); // cost of user's beverage menu
		
		return mainCost + sideCost + beverageCost;
	}
	
	/* method for make and get receipt of order */
	public String getReceipt() {
		String receipt = "";
		
		receipt += user.getUserInfo() + "\n"
				+ "===== Your Order =====\n"
				+ "<Main dish>\n"
				+ user.getMainFood().getInformation() + "\n"
				+ "<Side dish>\n"
				+ user.getSideFood().getInformation() + "\n"
				+ "<Beverage>\n"
				+ user.getBeverageFood().getInformation() + "\n";
		
		return receipt;
	}
}
