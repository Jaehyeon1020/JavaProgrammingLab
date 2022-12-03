package finalproj;

/**
 * class for various type of foods like pizza, ramen or any beverages
 */
public abstract class Food {
	private FoodType type; // for storing type of this food class instance
	private int cost; // for storing cost of this food class instance
	private String foodInfo; // for storing various information of this food class instance
	
	public Food(FoodType type, int cost) {
		setType(type);
		setCost(cost);
	}
	
	/* setter for type of food : class variable type */
	public void setType(FoodType type) {
		this.type = type;
	}
	
	/* setter for cost of food */
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	/* abstract method for saving information of class to foodInfo String */
	public abstract void setInformation();
}