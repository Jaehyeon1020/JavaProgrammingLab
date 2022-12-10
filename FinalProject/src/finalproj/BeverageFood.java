package finalproj;

public class BeverageFood extends Food {
	private String information; // for storing various information of this food class instance

	public BeverageFood(FoodType type) {
		super(type);
		setCostByMenu(type);
	}
	
	/**
	 * set cost of this menu
	 */
	private void setCostByMenu(FoodType type) {
		if (type == FoodType.NONE || type == FoodType.WATER) {
			super.setCost(0);
		} else if (type == FoodType.GREEN_TEA) {
			super.setCost(1000);
		} else if (type == FoodType.COKE) {
			super.setCost(2000);
		} else if (type == FoodType.SODA) {
			super.setCost(2000);
		} else if (type == FoodType.ORANGE_JUICE) {
			super.setCost(2000);
		} else if (type == FoodType.LEMONADE) {
			super.setCost(2500);
		}
	}

	@Override
	public String getInformation() {
		information = "<Beverage>\n"
				+ super.getType() + ": " + super.getCost() + " won\n";
		
		return information;
	}

}
