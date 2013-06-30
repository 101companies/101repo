package helloworld;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.net.InetAddress;

public class Server {

	public Server() {
		try {
			Service s = new ServiceImpl();
			InetAddress addr = InetAddress.getLocalHost();
			String hostname = addr.getHostName();
			Naming.rebind("rmi://"+hostname+"/Service", s);
		} catch (Exception e) {
			System.out.println("Trouble: " + e);
		}
	}

	public static void main(String args[]) {
		try {
			LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
		} catch (RemoteException e) {
			System.out.println("Trouble: " + e);
		}
		new Server();
	}
}
