package sumlength.distributed;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

/*
 * Implementation of our remote compute server
 */
public class ComputeImpl extends UnicastRemoteObject implements Compute {

	/*
	 * As this may be passed via RMI, we need to provide a UID for serialization
	 */
	private static final long serialVersionUID = -3444936070391659180L;

	/*
	 * Default constructor
	 */
	public ComputeImpl() throws RemoteException {
	}

	/*
	 * Implementation of the interface's method
	 */
	public int length(String x) {
		//
		// This server is a bit slow.
		// It takes 1+ sec to compute the length.
		//
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
		}
		return x.length();
	}
}
