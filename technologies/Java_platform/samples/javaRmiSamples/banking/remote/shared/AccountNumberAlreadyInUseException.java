package banking.remote.shared;

/**
 * Signal construction of account with existing account number
 */
public class AccountNumberAlreadyInUseException extends Exception {

	// As this may be passed via RMI, we need to provide a UID for serialization
	 private static final long serialVersionUID = 1L;

}
