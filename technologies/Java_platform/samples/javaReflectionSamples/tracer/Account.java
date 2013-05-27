package tracer;

/**
 * A simple account implementation.
 * Objects of this class serve as the real subject for the proxy.
 */
public class Account implements IAccount
{
    private double balance = 0;

    public double balance() {
        return balance;
    }
    
    public void deposit(double value) {
        balance += value;
    }

    public void withdraw(double value) {
        balance -= value;
    }
}
