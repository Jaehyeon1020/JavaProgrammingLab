package Book;

public class Book {
	private int bookID;
	private String bookTitle;
	private int reviewCount;
	private double averageRate;
	
	public Book(int bookID, String bookTitle, int reviewCount) {
		setBookID(bookID);
		setBookTitle(bookTitle);
		setReviewcount(reviewCount);
		setAverageRate(5.0);
	}
	
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public void setBookTitle(String bookTitle) {
		this.bookTitle = new String(bookTitle);
	}
	
	public void setReviewcount(int reviewCount) {
		this.reviewCount = reviewCount;
	}
	
	public void setAverageRate(double averageRate) {
		this.averageRate = averageRate;
	}
	
	public int getBookID() {
		return bookID;
	}
	
	public String getBookTitle() {
		return bookTitle;
	}
	
	public int getReviewCount() {
		return reviewCount;
	}
	
	public double getAverageRate() {
		return averageRate;
	}
	
	public void updateRate(double inputRate) {
		if(reviewCount == 0) {
			setAverageRate(inputRate);
			updateReviewCount();
		}
		else {
			double newRate = (getAverageRate() * getReviewCount() + inputRate) 
							  / (getReviewCount() + 1);
			updateReviewCount();
			setAverageRate(newRate);
		}
	}
	
	private void updateReviewCount() {
		reviewCount += 1;
	}
}
