
public class Extra extends Food{
	/**
	 * constructor of Extra class, calling parent's constructor
	 * if type == 1 it means this Extra is Cookies
	 * if type == 2 it means this Extra is French Fries
	 * if type == 3 it means this Extra is Chips
	 * if type == 0 it means user skipped Extra
	 */
	public Extra(int type) {
		super(type);
	}
	
	
	@Override
	public int calculateCost() {
		switch(super.getType()) {
		case 1: // case user selected Cookies
			return 1500;
		case 2: // case user selected French Fries
			return 1300;
		case 3: // case user selected Chips
			return 1700;
		case 0: // case user selected nothing
			return 0;
		default: // case user selected wrong number
			System.out.println("Selected wrong number");
		}
		
		return 0;
	}
}
