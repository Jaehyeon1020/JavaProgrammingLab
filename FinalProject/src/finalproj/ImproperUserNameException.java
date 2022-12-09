package finalproj;

/**
 * exception class that occurs when user entered wrong format of name
 */
@SuppressWarnings("serial")
public class ImproperUserNameException extends RuntimeException {
	public ImproperUserNameException() {
		super("Please enter your name in the correct format.\nName must be between 4 and 16 characters long.");
	}
}
