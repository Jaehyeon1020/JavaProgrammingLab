import java.util.Scanner;

public class PowerOf {
	/**
	 * function receives mainNumber and guessedNumber as parameters
	 * and if mainNumber^<some number> == guessedNumber, this function returns <some number>
	 * for example, if mainNumber = 3 and guessedNumber = 9, this function returns 2
	 * if mainNumber and guessedNumber arn't have the relation of squares, this function returns -1 meaning false
	 */
	public static int getHowManySquared(int mainNumber, int guessedNumber) {
		int power = 0; // for counting number how many squared
		double quotient = guessedNumber; // for storing remains after dividing and initialized by guessedNumber
		/**
		 * this loop is for calculating variable power
		 */
		while(true) {
			quotient = quotient/(double)mainNumber;
			power++; // counting up how many squared guessedNumber is
			/**
			 * if mainNumber and guessedNumber have the relation of squares, 
			 * the number 1 will be quotient after continual dividing guessedNumber by mainNumber
			 * if quotient/mainNumber is integer and is 1, this means variable power is fully calculated
			 */
			if((Double.compare(quotient, (double)((int)quotient)) == 0)
					&& (Double.compare(quotient, (double)1)) == 0)
				return power;
			/*
			 * this means quotient/mainNumber is integer
			 * but to calculate how many squared and know whether these two numbers has the relation,
			 * need continual dividing
			 */
			else if(Double.compare(quotient, (double)((int)quotient)) == 0)
				continue;
			else
				return -1;
		}
	}

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // for getting keyboard input
		int mainNumber; // for storing a base number
		int guessedNumber; // for storing a squared number by mainNumber
		int numberOfSquare = -2; // initialized by -2 to distinguish from return value of getHowManySquared
		
		System.out.print("Enter the number: ");
		mainNumber = userInput.nextInt(); // getting a base number
		userInput.nextLine(); // for removing remaining Enter
		
		System.out.print("Enter your guessed power of above number: ");
		guessedNumber = userInput.nextInt(); // getting a squared number
		userInput.nextLine(); // for removing remaining Enter
		userInput.close();
		System.out.println("===================================");
		
		numberOfSquare = getHowManySquared(mainNumber, guessedNumber); // storing the return value of getHowManySquared
		/**
		 * return value: -1 of getHowManySqaured means those two numbers have no relation of square
		 */
		if(numberOfSquare == -1)
			System.out.println("Output: false");
		else
		{
			System.out.println("power: " + numberOfSquare); // printing how many squared
			System.out.println("Output: true");
		}
	}
}
