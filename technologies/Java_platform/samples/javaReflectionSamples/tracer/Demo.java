package tracer;

/**
 * Use java.lang.reflect.Proxy to trace all method access to an account object.
 */
public class Demo {
	public static void main(String[] args) {
		IAccount a = (IAccount)Tracer.newInstance(new Account());
//		IAccount a = new Account();
		a.deposit(100);
		a.withdraw(50);
		System.out.println(a.balance());
	}
}
