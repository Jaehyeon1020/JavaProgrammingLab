package Book;

import java.util.Scanner;

public class Main {
	
	public static void printBookInfo(Book book, int bookNumber) {
		System.out.println("Book " + bookNumber + ": " + book.getBookTitle());
		System.out.println("Book ID: " + book.getBookID());
		System.out.println("Book rate: " + book.getAverageRate());
		System.out.println("Number of reviews: " + book.getReviewCount());
	}
	
	public static void printMenu(Book firstBook, Book secondBook) {
		System.out.println("=========================");
		printBookInfo(firstBook, 1);
		System.out.println("==========");
		printBookInfo(secondBook, 2);
		System.out.println("=========================");
		System.out.print("Please select book (order number): ");
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int userInputBookNumber;
		double userInputRate;
		
		Book firstBook = new Book(2343, "Harry Potter", 0);
		Book secondBook = new Book(4434, "Deep Learning", 0);
		
		while(true) {
			printMenu(firstBook, secondBook);
			userInputBookNumber = scanner.nextInt();
			
			if(userInputBookNumber == 1) {
				System.out.println("You selected Book: " + firstBook.getBookTitle());
				System.out.print("Please enter your rate: ");
				userInputRate = scanner.nextDouble();
				firstBook.updateRate(userInputRate);
			}
			else {
				System.out.println("You selected Book: " + secondBook.getBookTitle());
				System.out.print("Please enter your rate: ");
				userInputRate = scanner.nextDouble();
				secondBook.updateRate(userInputRate);
			}
			
			System.out.print("Would you like to rate more (1: yes, 0: no): ");
			
			if(scanner.nextInt() == 0) {
				break;
			}
		}
		scanner.close();
	}

}
