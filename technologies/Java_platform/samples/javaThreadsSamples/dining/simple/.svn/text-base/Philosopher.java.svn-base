package dining.simple;

public class Philosopher implements Runnable
{
	protected int id;
	protected Fork left, right;

	public Philosopher(int n, Fork l, Fork r)
	{
		this.id = n;
		this.left = l;
		this.right = r;
	}

	public String toString() { 
		return "Philosopher #" + id; 
	}

	protected void print(String postfix) {
		System.out.println(this.toString() + " is " + postfix);
	}
	
	protected void pause() throws InterruptedException {
		Thread.sleep((int)(10*Math.random()));
	}

	public void run()
	{
		try{
			while(!Thread.interrupted())
			{
				print("thinking.");
				pause();
				print("reaching for right fork.");
				right.take();
				print("reaching for left fork.");
				left.take();
				print("eating.");
				pause();
				print("dropping right fork.");
				right.drop();
				print("dropping left fork.");
				left.drop();
			}
		}
		catch (InterruptedException e)
		{
			print("interrupted.");
		}
		print("finished.");
	}
}
