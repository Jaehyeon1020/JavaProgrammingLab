package finalproj;

public class SideFood extends Food {
	private String information; // for storing various information of this food class instance

	public SideFood(FoodType type) {
		super(type);
		setCostByMenu(type);
	}
	
	/**
	 * set cost of this menu
	 */
	private void setCostByMenu(FoodType type) {
		if (type == FoodType.NONE) {
			super.setCost(0);
		} else if (type == FoodType.FRENCH_FRIES) {
			super.setCost(4000);
		} else if (type == FoodType.CHEESE_STICK) {
			super.setCost(2000);
		} else if (type == FoodType.FRIED_RICE) {
			super.setCost(5000);
		}
	}

	@Override
	public String getInformation() {
		information += "<Side Menu>\n"
				+ super.getType() + ": " + super.getCost() + " won\n";
		
		return information;
	}

}
