package helloworld;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;

public class Client {

	public static void main(String[] args) {
		try {
			InetAddress addr = InetAddress.getLocalHost();
			String hostname = addr.getHostName();
			Service s = (Service) Naming.lookup("rmi://"+hostname+"/Service");
			System.out.println(s.inc(42));
		} catch (UnknownHostException uhoste) {
			// ... TODO ...
		} catch (MalformedURLException murle) {
			// ... TODO ...
		} catch (RemoteException re) {
			// ... TODO ...
		} catch (NotBoundException nbe) {
			// ... TODO ...
		}
	}
}
