package finalproj;

public class MainFood extends Food{
	private String information; // for storing various information of this food class instance

	public MainFood(FoodType type) {
		super(type);
		setCostByMenu(type);
	}

	/**
	 * set cost of this menu
	 */
	private void setCostByMenu(FoodType type) {
		if (type == FoodType.NONE) {
			super.setCost(0);
		} else if (type == FoodType.HAMBURGER) {
			super.setCost(7000);
		} else if (type == FoodType.SANDWICH) {
			super.setCost(6000);
		} else if (type == FoodType.PIZZA) {
			super.setCost(15000);
		} else if (type == FoodType.CHICKEN) {
			super.setCost(18000);
		} else if (type == FoodType.GIMBAP) {
			super.setCost(4000);
		} else if (type == FoodType.JJAJANGMIEN) {
			super.setCost(6000);
		} else if (type == FoodType.SUSHI) {
			super.setCost(10000);
		}
	}
	
	/**
	 * get information string about this main menu
	 */
	@Override
	public String getInformation() {
		information += "<Main Menu>\n"
				+ super.getType() + ": " + super.getCost() + " won\n";
		
		return information;
	}
}
