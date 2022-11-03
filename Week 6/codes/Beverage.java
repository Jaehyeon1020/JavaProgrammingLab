
public class Beverage extends Food{
	private boolean ice; // storing if the beverage has ice or not
	
	/**
	 * constructor of Beverage class, calling parent's constructor
	 * if type == 1 it means this Beverage is Cola
	 * if type == 2 it means this Beverage is Fanta
	 * if type == 3 it means this Beverage is Chilsung cider
	 * if type == 4 it means this Beverage is Zero Cola
	 * if type == 5 it means this Beverage is Coffee
	 * if type == 0 it means user skipped beverage
	 */
	public Beverage(int type) {
		super(type);
	}
	
	// getter method of class variable ice
	public boolean getIfIce() {
		return this.ice;
	}
	
	// setter method of class variable ice
	public void setIce(boolean ice) {
		this.ice = ice;
	}
	
	// returns cost of the beverage
	@Override
	public int calculateCost() {
		switch(super.getType()) {
		case 1: // case user selected Cola
			return 1000;
		case 2: // case user selected Fanta
			return 1100;
		case 3: // case user selected Chilsung Cider
			return 900;
		case 4: // case user selected Zero Cola
			return 1200;
		case 5: // case user selected Coffee
			return 2000;
		case 0: // case user didn't choice beverage
			return 0;
		default: // case user entered wrong numbers
			System.out.println("Selelcted wrong number");
		}
		
		return 0;
	}
}
