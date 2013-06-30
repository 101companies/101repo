package helloworld;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Service extends Remote {
    public long inc(long x) throws RemoteException;
}

