package concurrent;

/**
 * 
 * JSE readily covers semaphores.
 * See package java.util.concurrent.
 * 
 * http://www.ibm.com/developerworks/library/j-thread.html Writing multithreaded
 * Java applications Alex Roetter (aroetter@CS.Stanford.edu), Software engineer,
 * Teton Data Systems
 * 
 * Section Semaphores
 * 
 * Frequently, several threads will need to access a smaller number of
 * resources. For example, imagine a number of threads running in a Web server
 * answering client requests. These threads need to connect to a database, but
 * only a fixed number of available database connections are available. How can
 * you assign a number of database connections to a larger number of threads
 * efficiently? One way to control access to a pool of resources (rather than
 * just with a simple one-thread lock) is to use what is known as a counting
 * semaphore. A counting semaphore encapsulates managing the pool of available
 * resources. Implemented on top of simple locks, a semaphore is a thread-safe
 * counter initialized to the number of resources available for use. For
 * example, we would initialize a semaphore to the number of database
 * connections available. As each thread acquires the semaphore, the number of
 * available connections is decremented by one. Upon consumption of the
 * resource, the semaphore is released, incrementing the counter. Threads that
 * attempt to acquire a semaphore when all the resources managed by the
 * semaphore are in use simply block until a resource is free.
 * 
 * A common use of semaphores is in solving the "consumer-producer problem."
 * This problem occurs when one thread is completing work that another thread
 * will use. The consuming thread can only obtain more data after the producing
 * thread finishes generating it. To use a semaphore in this manner, you create
 * a semaphore with the initial value of zero and have the consuming thread
 * block on the semaphore. For each unit of work completed, the producing thread
 * signals (releases) the semaphore. Each time a consumer consumes a unit of
 * data and needs another, it attempts to acquire the semaphore again, resulting
 * in the value of the semaphore always being the number of units of completed
 * work ready for consumption. This approach is more efficient than having a
 * consuming thread wake up, check for completed work, and sleep if nothing is
 * available.
 * 
 * Though semaphores are not directly supported in the Java language, they are
 * easily implemented on top of object locks. A simple implementation follows:
 */

public class Semaphore {
	private int count;

	public Semaphore(int n) {
		this.count = n;
	}

	public synchronized void acquire()
		throws InterruptedException
	{
		while (count == 0) {
			System.out.println("Semaphore blocked.");
			wait();
		}
		count--;
		System.out.println("Semaphore acquired (count = " + count + ").");
	}

	public synchronized void release() {
		count++;
		System.out.println("Semaphore released (count = " + count + ").");
		notify(); // alert a thread that's blocking on this semaphore
	}
}