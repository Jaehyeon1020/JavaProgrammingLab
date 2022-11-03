
public abstract class Food implements Payment {
	private int type; // for storing the type of food
	private int cost = 0; // for storing the cost of food
	
	public Food(int type) {
		setType(type);
	}
	
	@Override
	public abstract int calculateCost();
	
	// getter method for class variable type
	public int getType() {
		return this.type;
	}
	
	// getter method for class variable cost
	public int getCost() {
		return this.cost;
	}
	
	 // setter method for class variable type
	public void setType(int type) {
		this.type = type;
	}
	
	// setter method for class variable cost
	public void setCost(int cost) {
		this.cost = cost;
	}
}
