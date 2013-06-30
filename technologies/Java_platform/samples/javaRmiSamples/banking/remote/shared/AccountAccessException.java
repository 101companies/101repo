package banking.remote.shared;

/**
 *  Signal depositing or withdrawing issues.
 */
public class AccountAccessException extends Exception {

	/**
	 * This exception may be passed via RMI.
	 * Hence, we need to provide a UID for serialization of this class.
	 */
	private static final long serialVersionUID = 1L;

}
