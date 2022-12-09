package finalproj;

/**
 * exception class that occurs when user entered wrong format of phone number
 */
@SuppressWarnings("serial")
public class ImproperPhoneNumberException extends RuntimeException {
	public ImproperPhoneNumberException() {
		super("Please enter your phone number correctly.\nPhone number must be 000-0000-0000 format.");
	}
}
