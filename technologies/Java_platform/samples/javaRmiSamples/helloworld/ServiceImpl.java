package helloworld;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class ServiceImpl extends UnicastRemoteObject implements Service {

	// Needed for serialization
	private static final long serialVersionUID = 6102178242852627613L;

	// Needed because of exception
	public ServiceImpl() throws RemoteException {
        super();
    }

    public long inc(long x) throws RemoteException {
        return ++x;
    }
}

