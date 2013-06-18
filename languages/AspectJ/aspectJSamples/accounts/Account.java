package accounts;

public class Account
{
    private double balance = 0;

    public double getBalance() {
        return balance;
    }
    
    public void deposit(double value) {
        balance += value;
    }

    public void withdraw(double value) {
        balance -= value;
    }
}
