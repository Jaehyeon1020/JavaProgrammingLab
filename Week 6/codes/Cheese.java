
public class Cheese extends Food {
	/**
	 * constructor of Cheese class, calling parent's constructor
	 * if type == 1 it means this Cheese is American Cheese
	 * if type == 2 it means this Cheese is Swiss
	 * if type == 3 it means this Cheese is Cheddar
	 */
	public Cheese(int type) {
		super(type);
	}
	
	// returns cost of the cheese
	@Override
	public int calculateCost() {
		switch(super.getType()) {
		case 1: // case user selected American Cheese
			return 0;
		case 2: // case user selected Swiss
			return 100;
		case 3: // case user selected Cheddar
			return 0;
		default: // case user selected wrong number
			System.out.println("Selected wrong number");
		}
		
		return 0;
	}
}
