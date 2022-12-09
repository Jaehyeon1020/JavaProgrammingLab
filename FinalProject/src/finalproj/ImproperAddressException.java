package finalproj;

/**
 * exception class that occurs when user entered wrong format of address
 */
@SuppressWarnings("serial")
public class ImproperAddressException extends RuntimeException {
	public ImproperAddressException() {
		super("Please enter your address correctly.\nAddress must be detailed address,city format.");
	}
}
