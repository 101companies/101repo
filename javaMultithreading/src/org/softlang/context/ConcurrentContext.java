package org.softlang.context;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.softlang.action.Action;

public class ConcurrentContext implements Context {

	private static final int POOL_SIZE = 7;
	private int availableThreads = POOL_SIZE;

	private ExecutorService pool;

	private Context backupContext = new SequentialContext();

	public ConcurrentContext() {
		pool = Executors.newFixedThreadPool(POOL_SIZE);
	}

	@Override
	public synchronized <X, Y> void execute(final Action<X, Y> action,
			final X param) {


			final ConcurrentContext context = this;
			pool.submit(new Runnable() {
				@Override
				public void run() {
					action.execute(context, param);

				}
			});

	}

	public void waitForTermination(long timeout, TimeUnit unit)
			throws InterruptedException {
		pool.awaitTermination(timeout, unit);
	}

	public void waitForTermination() {
		try {
			waitForTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
