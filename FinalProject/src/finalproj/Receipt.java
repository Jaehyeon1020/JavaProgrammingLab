package finalproj;

/** 
 * class for handling user's order
 * stores costs of order and have method for making receipt information
 */
public class Receipt {
	private int mainFoodCost; // for storing cost of main food
	private int sideCost; // for storing cost of side menu
	private int beverageCost; // for storing cost of beverage
	private int totalCost; // for storing total cost of this user
	
	public Receipt(int mainFoodCost, int sideCost, int beverageCost) {
		setMainFoodCost(mainFoodCost);
		setSideCost(sideCost);
		setBeverageCost(beverageCost);
		totalCost = mainFoodCost + sideCost + beverageCost;
	}
	
	/* setter for mainFoodCost */
	public void setMainFoodCost(int mainFoodCost) {
		this.mainFoodCost = mainFoodCost;
	}
	
	/* setter for sideCost */
	public void setSideCost(int sideCost) {
		this.sideCost = sideCost;
	}
	
	/* setter for beverageCost */
	public void setBeverageCost(int beverageCost) {
		this.beverageCost = beverageCost;
	}
	
	/* method for make and get receipt of order */
	private String getReceipt() {
		String receipt = "";
		
		receipt += "===== RECEIPT =====\n"
				+ "";
	}
}
