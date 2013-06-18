package accounts;

public aspect SafeAccount {

	  before(Account a, double value):
	      call(void Account.withdraw(double)) && target(a) && args(value) {
	    assert value >= 0 && a.getBalance() >= value;
	  }

	  before(Account a, double value):
	      call(void Account.deposit(double)) && target(a) && args(value) {
	    assert value >= 0;
	  }	  
	  
}
