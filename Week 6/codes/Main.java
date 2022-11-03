import java.util.Scanner;

public class Main {
	// prints burger menu
	public static void printBurgerMenu() {
		System.out.println("=========================");
		System.out.println("Welcome to SKKU-SUBWAY!");
		System.out.println("Choose burgers (sandwiches): ");
		System.out.println("1. Egg Mayo - 4,000 won");
		System.out.println("2. Chicken Tikka - 5,000 won");
		System.out.println("3. Chiken Ham - 5,000 won");
		System.out.println("4. Roasted Chicken - 5,500 won");
		System.out.println("0. Cancel Order");
	}
	
	// prints cheese menu
	public static void printCheeseMenu() {
		System.out.println("=========================");
		System.out.println("Select Cheese Type: ");
		System.out.println("1. American Cheese - (+0 won)");
		System.out.println("2. Swiss - (+100 won)");
		System.out.println("3. Cheddar - (+0 won)");
	}
	
	// prints ingredients menu
	public static void printIngredientMenu() {
		System.out.println("=========================");
		System.out.println("Select Ingredients: ");
		System.out.println("1. Lettuce - (+0 won)");
		System.out.println("2. Tomatos - (+0 won)");
		System.out.println("3. Cucumbers - (+50 won)");
		System.out.println("4. Olives - (+50 won)");
		System.out.println("0. Skip");
	}
	
	// prints beverages menu
	public static void printBeverageMenu() {
		System.out.println("=========================");
		System.out.println("Select Beverages:");
		System.out.println("1. Cola - 1,000 won");
		System.out.println("2. Fanta - 2,000 won");
		System.out.println("3. Chilsung Cider - 900 won");
		System.out.println("4. Zero Cola - 1,200 won");
		System.out.println("5. Coffee - 2,000 won");
		System.out.println("0. Skip");
	}
	
	// prints extras menu
	public static void printExtraMenu() {
		System.out.println("=========================");
		System.out.println("1. Cookies - 1,500 won");
		System.out.println("2. French Fries - 1,300 won");
		System.out.println("3. Chips - 1,700 won");
		System.out.println("0. Skip");
	}
	
	// print Burger cost, beverage cost, extra cost and finally total price of the order
	public static void printCheck(int burgerPrice, int beveragePrice, int extraPrice, boolean ifIce) {
		System.out.println("=========================");
		System.out.printf("| Burger (with cheese and ingredients): %.1f\n", (double)burgerPrice);
		
		// print about beverage cost only user selected beverage
		if(beveragePrice > 0) {
			// split output by with ice and without ice
			if(ifIce == true) {
				System.out.printf("| Beverage (with ice): %.1f\n", (double)beveragePrice);
			}
			else {
				System.out.printf("| Beverage (without ice): %.1f\n", (double)beveragePrice);
			}
		}
		
		// print about Extra cost when only user selected extra
		if(extraPrice > 0) {
			System.out.printf("| Extra: %.1f\n", (double)extraPrice);
		}
		
		// print total price
		System.out.printf("| TOTAL: %.1f\n", (double)(burgerPrice + beveragePrice + extraPrice));
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // create Scanner class instance to get user input
		int userInput; // for getting user input(selecting number)
		
		printBurgerMenu(); // print burger menu
		System.out.print("Select Burger (1-5): ");
		userInput = scanner.nextInt(); // get user choice
		
		// case of user canceled order
		if(userInput == 0) {
			System.out.println("Bye Bye");
			scanner.close(); // close Scanner before return
			return;
		}
		
		Burger burger = new Burger(userInput); // create new Burger class instance with user choice
		burger.setCost(burger.getOnlyBurgerCost(userInput)); // set burger's cost
		
		printCheeseMenu();
		System.out.print("Select Cheese (1-3): ");
		userInput = scanner.nextInt(); // get user choice
		Cheese cheese = new Cheese(userInput); // create new Cheese class instance with user choice
		cheese.setCost(cheese.calculateCost()); // set cheese's cost
		burger.setCheese(cheese); // set cheese to burger
		
		// this loop will be executed until user enter skip(0)
		while(true) {
			printIngredientMenu();
			System.out.print("Select Ingredients (1-4): ");
			userInput = scanner.nextInt(); // get user choice
			
			// break when user entered skip(0)
			if(userInput == 0) {
				break;
			}
			
			burger.addIngredients(new Ingredient(userInput)); // add ingredient to burger
		}
		
		printBeverageMenu();
		System.out.print("Select Beverage (1-5): ");
		userInput = scanner.nextInt(); // get user choice
		Beverage beverage = new Beverage(userInput); // create new Beverage class instance with user choice
		beverage.setCost(beverage.calculateCost()); // set beverage's cost
		System.out.println("=========================");
		System.out.print("With ice? (0[no] or 1[yes]): ");
		userInput = scanner.nextInt(); // get user choice
		
		// ice setting by userInput
		if(userInput == 0)
			beverage.setIce(false);
		else
			beverage.setIce(true);
		
		printExtraMenu();
		System.out.print("Select Extra: ");
		userInput = scanner.nextInt(); // get user choice
		Extra extra = new Extra(userInput);
		extra.setCost(extra.calculateCost()); // set extra's cost
		
		printCheck(burger.calculateCost(), beverage.calculateCost(), extra.calculateCost(), beverage.getIfIce()); // print final check
		
		scanner.close(); // close Scanner
		
		
		
	}

}
