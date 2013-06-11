package dining.simple;

public final class Fork {
	
	private boolean taken = false;

	public boolean isTaken()
	{
		return taken;
	}	
	
	public synchronized	void take() throws InterruptedException {
		while(taken)
			wait();
		taken = true;
	}
	
	public synchronized void drop() {
		taken = false;
		notifyAll();
	}
}
