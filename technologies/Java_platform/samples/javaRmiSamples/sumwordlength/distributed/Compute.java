package sumwordlength.distributed;

import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * The interface of our remote compute server.
 * There is one method that can compute the length of a string.
 */
public interface Compute extends Remote {
	public int length(String x) throws RemoteException;
}
