package finalproj;

/** 
 * class for handling user's order
 * stores costs of order and have method for making receipt information
 */
public class Receipt {
	private Food main; // for storing Food class instance saving main dish
	private Food side; // for storing Food class instance saving side menu
	private Food beverage; // for storing Food class instance saving beverage
	
	public Receipt(Food main, Food side, Food beverage) {
		setMain(main);
		setSide(side);
		setBeverage(beverage);
	}

	/* setter for main */
	private void setMain(Food main) {
		this.main = main;
	}
	
	/* setter for side */
	private void setSide(Food side) {
		this.side = side;
	}
	
	/* setter for beverage */
	private void setBeverage(Food beverage) {
		this.beverage = beverage;
	}
	
	/* getter for main */
	public Food getMain() {
		return this.main;
	}
	
	/* getter for side */
	public Food getSide() {
		return this.side;
	}
	
	/* getter for beverage */
	public Food getbeverageCost() {
		return this.beverage;
	}
	
	/* get total cost of the order */
	public int getTotalCost() {
		return main.getCost() + side.getCost() + beverage.getCost();
	}
	
	/* method for make and get receipt of order */
	public String getReceipt() {
		String receipt = "";
		
		receipt += "===== Your Order =====\n"
				+ "<Main dish>\n"
				+ main.getInformation()
				+ "\n<Side dish>\n"
				+ side.getInformation()
				+ "\n<Beverage>\n"
				+ beverage.getInformation()
				+ "\n";
		
		return receipt;
	}
}
