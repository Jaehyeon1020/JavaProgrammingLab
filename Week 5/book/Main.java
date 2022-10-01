package book;

import java.util.Scanner;

public class Main {
	
	/**
	 *  this method prints information of the book that is passed as parameter
	 *  parameter bookNumber is the number that indicates an order of this book
	 */
	public static void printBookInfo(Book book, int bookNumber) {
		System.out.println("Book " + bookNumber + ": " + book.getBookTitle());
		System.out.println("Book ID: " + book.getBookID());
		System.out.println("Book rate: " + book.getAverageRate());
		System.out.println("Number of reviews: " + book.getReviewCount());
	}
	
	// this method prints the menu that the user will see when he execute this program
	public static void printMenu(Book firstBook, Book secondBook) {
		System.out.println("=========================");
		printBookInfo(firstBook, 1); // call printBookInfo for parameter firstBook
		System.out.println("==========");
		printBookInfo(secondBook, 2); // call printBookInfo for parameter secondBook
		System.out.println("=========================");
		System.out.print("Please select book (order number): "); // for asking user to select book
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // Creating new Scanner instance
		
		int userInputBookNumber; // for check what user enter(this variable means what order of book user wants)
		double userInputRate; // for check what user enter(this variable means user's rate about the book)
		
		Book firstBook = new Book(2343, "Harry Potter", 0); // Creating new Book instance
		Book secondBook = new Book(4434, "Deep Learning", 0); // Creating new Book instance
		
		// executing infinitly until user enter 0 for asking if user wants to continue or stop
		while(true) {
			printMenu(firstBook, secondBook); // printing info of books and ask for selecting book
			userInputBookNumber = scanner.nextInt(); // getting input from user
			
			// if user chose book 1
			if(userInputBookNumber == 1) {
				System.out.println("You selected Book: " + firstBook.getBookTitle()); // printing user-selected book info
				System.out.print("Please enter your rate: "); // asking user to enter rate about book
				userInputRate = scanner.nextDouble(); // getting input from user
				firstBook.updateRate(userInputRate); // updating rate and the number of reviews
			}
			// if user chose book 2
			else {
				System.out.println("You selected Book: " + secondBook.getBookTitle()); // printing user-selected book info
				System.out.print("Please enter your rate: "); // asking user to enter rate about book
				userInputRate = scanner.nextDouble(); // getting input from user
				secondBook.updateRate(userInputRate); // updating rate and the number of reviews
			}
			
			System.out.print("Would you like to rate more (1: yes, 0: no): "); // asking if user wants to continue or stop
			
			// if user entered 0(if user wanted to stop)
			if(scanner.nextInt() == 0) {
				break; // break out of this while loop
			}
		}
		
		scanner.close(); // closing Scanner instance
	}

}
