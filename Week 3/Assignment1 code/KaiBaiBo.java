import java.util.Random;
import java.util.Scanner;

public class KaiBaiBo {
	/**
	 * function receives round as parameter
	 * and print informations of round
	 */
	public static void printRoundInfo(int round) {
		System.out.println("Round " + (round+1));
		System.out.println("Kai-Bai-Bo!");
		System.out.println("1. Kai (scissors)");
		System.out.println("2. Bai (rock)");
		System.out.println("3. Bo (paper)");
	}
	/**
	 * function receives userWin(the number of user wins) and computerWin(the number of computer wins) as parameter
	 * and prints score information between user and computer
	 */
	public static void printTotalScore(int userWin, int computerWin) {
		System.out.println("You " + userWin + " : " + computerWin + " Computer");
	}
	/**
	 * function receives userWin(the number of user wins) and computerWin(the number of computer wins) as parameter
	 * and prints who is the final winner by comparing userWin and computerWin
	 */
	public static void printWhoIsFinalWinner(int userWin, int computerWin) {
		if(userWin == computerWin)
			System.out.println("Final Winner: Draw!");
		else if(userWin > computerWin)
			System.out.println("Final Winner: You!");
		else
			System.out.println("Final Winner: Computer!");
	}
	/**
	 * function receives selectedNumber as parameter
	 * and converts selectedNumber to Scissors, rock or paper
	 * selectedNumber is a number that is selected by user or computer to select Scissors, rock or paper
	 */
	public static String convertNumToKaiBaiBo(int selectedNumber) {
		if(selectedNumber == 1)
			return "Scissors";
		else if(selectedNumber == 2)
			return "rock";
		else
			return "paper";
	}
	/**
	 * function receives userChoice and computerChoice as parameter
	 * and judges who is the winner by comparing userChoice and computerChoice
	 */
	public static String getWhoIsWinner(int userChoice, int computerChoice) {
		if(userChoice == computerChoice)
			return "draw";
		else if(((userChoice == 1) && (computerChoice == 3)) 
					|| ((userChoice == 2) && (computerChoice == 1)) 
					|| ((userChoice == 3) && (computerChoice == 2)))
			return "you";
		else
			return "Computer";
	}

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in); // for getting keyboard input
		Random randomGenerator = new Random(); // for getting random number to make choice of computer
		int userChoice; // for storing user's choice : Kai, Bai or Bo
		int computerChoice; // for storing computer's choice : Kai, Bai or Bo
		int userWin = 0; // for counting the number of wins by the user
		int computerWin = 0; // for counting the number of wins by the computer
		String winner; // for storing who is the winner of one round
		
		System.out.println("Let's play Kai-Bai-Bo (scissors, rock, paper)");
		/**
		 * this loop is for playing the 3-round Kai-Bai-Bo
		 */
		for(int round=0; round<3; round++) {
			printRoundInfo(round); // print information of game
			System.out.print("Your choice: ");
			userChoice = userInput.nextInt(); // get user's choice
			userInput.nextLine(); // for removing remaining Enter
			System.out.print("You: " + convertNumToKaiBaiBo(userChoice)); // for printing user's choice
			System.out.println();
			computerChoice = randomGenerator.nextInt(3)+1; // for storing computer's choice
			System.out.print("Computer: " + convertNumToKaiBaiBo(computerChoice)); // for printing computer's choice
			System.out.println();
			winner = getWhoIsWinner(userChoice,computerChoice); // for storing information of winner of this round
			System.out.println("Winner: " + winner);
			System.out.println("=========================");

			if(winner == "you") // if user wins, count up userWin
				userWin++;
			else if(winner == "Computer") // if computer wins, count up computerWin
				computerWin++;
		}
		
		printTotalScore(userWin, computerWin);
		printWhoIsFinalWinner(userWin, computerWin);
		userInput.close();
	}
}
