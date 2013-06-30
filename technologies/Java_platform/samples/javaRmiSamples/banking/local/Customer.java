package banking.local;

/**
 * This class provides the functionality for manipulating Customer objects.
 */
public class Customer {

	private Bank bank;
	private Integer customerNumber;
	private String customerName;
	
	/**
	 * Creates a new Customer object.
	 * 
	 * @param bm The Bank for this customer
	 * @param customerNumber A system-wide unique reference number
	 * @param customerName This customer's name, free-form String
	 */
	public Customer(Bank bm, Integer customerNumber, String customerName) {
		this.bank = bm;
		this.customerNumber = customerNumber;
		this.customerName = customerName;
	}

	/**
	 * Returns the Bank object that manages this customer.
	 * 
	 * @return A Banl object.
	 */
	public Bank getBank() {
		return bank;
	}

	/**
	 * Fetches this customer's reference number from the database.
	 * 
	 * @return This customer's number
	 */
	public Integer getCustomerNumber() {
		return customerNumber;
	}
	
	/**
	 * Fetches this customer's name from the database.
	 * 
	 * @return This customer's name.
	 */
	public String getName() {
		return customerName;
	}
}
