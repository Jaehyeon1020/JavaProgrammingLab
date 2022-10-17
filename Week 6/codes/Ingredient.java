
public class Ingredient extends Food{
	/**
	 * constructor of Ingredients class, calling parent's constructor
	 * if type == 1 it means this ingredient is lettuce
	 * if type == 2 it means this ingredient is tomatoes
	 * if type == 3 it means this ingredient is cucumbers
	 * if type == 4 it means this ingredient is olives
	 * if type == 0 it means user didn't select this ingredient
	 */
	public Ingredient(int type) {
		super(type);
	}
	
	@Override
	public int calculateCost() {
		switch(super.getType()) {
		case 0: // case user selected nothing
			return 0;
		case 1: // case user selected lettuce
			return 0;
		case 2: // case user selected tomatoes
			return 0;
		case 3: // case user selected cucumbers
			return 50;
		case 4: // case user selected olives
			return 50;
		default: // case user select wrong number
			System.out.println("Selected wrong number");
		}
		
		return 0;
	}
}
