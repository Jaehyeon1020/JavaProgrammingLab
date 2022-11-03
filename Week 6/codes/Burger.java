
public class Burger extends Food{
	private Cheese cheeseObject; // expressing cheese in the burger
	private Ingredient[] ingredient = new Ingredient[100]; // expressing ingredients in the burger
	private int ingredientsCounter = 0; // for storing the number of ingredients this burger has
	
	/**
	 * constructor of Burger class, calling parent's constructor
	 * if type == 1 it means this Burger is Egg Mayo
	 * if type == 2 it means this Burger is Chicken Tikka
	 * if type == 3 it means this Burger is Chicken Ham
	 * if type == 4 it means this Burger is Roasted Chicken
	 */
	public Burger(int type) {
		super(type);
	}
	
	// setter method of class variable cheeseObject
	public void setCheese(Cheese cheese) {
		this.cheeseObject = cheese;
	}
	
	// setter method of class variable ingredients[]
	// this method add one Ingredients class instance to array ingredients[]
	public void addIngredients(Ingredient ingredients) {
		ingredient[ingredientsCounter++] = ingredients; // storing Ingredient instance and count up ingredientsCounter
	}
	
	// getter method of class variable cheeseObject
	public Cheese getCheese() {
		return this.cheeseObject;
	}
	
	// getter method of class variable ingredient[]
	// returns entire array of ingredients
	public Ingredient[] getIngredients() {
		return this.ingredient;
	}
	
	// returns sum of cost of all ingredients in the burger
	public int costOfAllIngredients(Ingredient[] ingredients) {
		int sum = 0; // for storing sum of cost
		for(int i = 0; i < ingredientsCounter; i++) {
			sum += ingredients[i].calculateCost();
		}
		
		return sum;
	}
	
	// returns cost by burger type
	public int getOnlyBurgerCost(int type) {
		switch(super.getType()) {
		case 1: // case user selected Egg Mayo
			return 4000;
		case 2: // case user selected Chicken Tikka
			return 5000;
		case 3: // case user selected Chicken Ham
			return 5000;
		case 4: // case use selected Roasted Chicken
			return 5500;
		default:
			System.out.println("Selected wrong number");
			break;
		}
		
		return 0;
	}
	
	// calculate whole cost of the burger includes cheese and ingredients
	@Override
	public int calculateCost() {
		/**
		 * variable burgerCost
		 * storing whole cost of the burger
		 * cost of whole burger = cost of burger menu + cost of cheese + cost of ingredients
		 */
		int burgerCost = 0;
		
		switch(super.getType()) {
		case 1: // case user selected Egg Mayo
			burgerCost = 4000 + this.getCheese().calculateCost() + this.costOfAllIngredients(ingredient);
			break;
		case 2: // case user selected Chicken Tikka
			burgerCost = 5000 + this.getCheese().calculateCost() + this.costOfAllIngredients(ingredient);
			break;
		case 3: // case user selected Chicken Ham
			burgerCost = 5000 + this.getCheese().calculateCost() + this.costOfAllIngredients(ingredient);
			break;
		case 4: // case user selected Roasted Chicken
			burgerCost = 5500 + this.getCheese().calculateCost() + this.costOfAllIngredients(ingredient);
		default:
			System.out.println("Selected wrong number");
			break;
		}
		
		return burgerCost;
	}
}
