package tracer;

/**
 * The interface of the real subject and proxy
 */
public interface IAccount {
    public double balance();
    public void deposit(double value);
    public void withdraw(double value);
}
