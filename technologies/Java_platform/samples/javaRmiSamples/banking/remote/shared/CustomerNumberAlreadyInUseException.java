package banking.remote.shared;

/**
 * Signal construction of customer with existing customer number
 */
public class CustomerNumberAlreadyInUseException extends Exception {

	// As this may be passed via RMI, we need to provide a UID for serialization
	 private static final long serialVersionUID = 1L;

}
