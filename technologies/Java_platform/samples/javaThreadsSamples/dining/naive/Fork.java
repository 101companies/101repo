package dining.naive;

import java.util.Random;

public final class Fork
{
	private boolean taken = false;

	private Random r = new Random();
	
	public boolean isTaken() {
		return taken;
	}	
	
	public void take() throws InterruptedException {
		Thread.sleep(r.nextInt(1024)); // slow fork
		while(taken) { }; // busy waiting
		taken = true;
	}
	
	public void drop() {
		taken = false;
	}
}
