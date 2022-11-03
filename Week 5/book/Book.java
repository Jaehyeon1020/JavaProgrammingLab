package book;

public class Book {
	private int bookID; // for storing ID of the book
	private String bookTitle; // for storing Title of the book
	private int reviewCount; // for storing the number of reviews of the book
	private double averageRate; // for storing average rate of the book
	
	// constructor of class Book
	public Book(int bookID, String bookTitle, int reviewCount) {
		setBookID(bookID);
		setBookTitle(bookTitle);
		setReviewcount(reviewCount);
		setAverageRate(5.0); // setting default rate as 5.0
	}
	
	// setter method of member variable bookID
	public void setBookID(int bookID) {
		this.bookID = bookID; 
	}
	
	// setter method of member variable bookTitle
	public void setBookTitle(String bookTitle) {
		this.bookTitle = new String(bookTitle);
	}
	
	// setter method of member variable reviewCount
	public void setReviewcount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	
	// setter method of member variable averageRate
	public void setAverageRate(double averageRate) {
		this.averageRate = averageRate;
	}
	
	// getter method of member variable bookID
	public int getBookID() {
		return bookID;
	}
	
	// getter method of member variable bookTitle
	public String getBookTitle() {
		return bookTitle;
	}
	
	// getter method of member variable reviewCount
	public int getReviewCount() {
		return reviewCount;
	}
	
	// getter method of member variable averageRate
	public double getAverageRate() {
		return averageRate;
	}
	
	/**
	 * this method do change averageRate by inputRate that is getted from user input
	 * @param inputRate: rate by user(keyboard input)
	 */
	public void updateRate(double inputRate) {
		// if there was NO review until this method is called, averageRate is equal to inputRate
		if(reviewCount == 0) {
			setAverageRate(inputRate);
			updateReviewCount(); // after setting averageRate, count up the number of review
		}
		else {
			/**
			 * if there was 1 or more reviews until this method is called, calculate rate newly
			 * formula of calculation of new rate:
			 * (current averageRate) * (current number of reviews) + (inputRate) / the number of reviews including new input
			 */
			double newRate = (getAverageRate() * getReviewCount() + inputRate) 
							  / (getReviewCount() + 1);
			setAverageRate(newRate); // setting new averageRate by newRate
			updateReviewCount(); // after setting averageRate, count up the number of review
		}
	}
	
	/**
	 * plus 1 to current reviewCount(the number of reviews)
	 * this method must be called only by execution of method updateRate
	 * so set the access modifier to private
	 */
	private void updateReviewCount() {
		reviewCount += 1;
	}
}
