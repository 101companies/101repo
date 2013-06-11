package dining.timeout;

import dining.simple.Fork;

public class Philosopher extends dining.simple.Philosopher
{
	private int timeout;
	private long start;

	public Philosopher(int n, Fork l, Fork r, int to)
	{
		super(n,l,r);
		this.timeout = to;
	}

	@Override
	public void run()
	{
		try{
			while(!Thread.interrupted())
			{
				print("thinking.");
				pause();
				print("reaching for right fork.");
				while(true)
				{
					right.take();
					print("reaching for left fork.");
					if(left.isTaken())
					{
						start = System.currentTimeMillis();
						while ((left.isTaken())&&(System.currentTimeMillis()<start+timeout))
							Thread.sleep(100);
						if(left.isTaken())
						{
							print("dropping right fork while still being hungry.");
							right.drop();
							continue;
						}
					}
					// <-- at this point the deadlock still can happen.
					left.take();
					break;
				}
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
