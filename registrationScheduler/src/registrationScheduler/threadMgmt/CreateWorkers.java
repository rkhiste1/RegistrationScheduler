
package registrationScheduler.threadMgmt;
// TODO Auto-generated constructor stub

import java.util.Arrays;

import registrationScheduler.allocator.Student;

import registrationScheduler.store.StoreResultInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class CreateWorkers  {
	
	private FileProcessor fp;
	private StoreResultInterface results;
	private Student [] student;
	
	public CreateWorkers(FileProcessor fpIn, StoreResultInterface resultsIn, Student[] studentIn) {
		fp = fpIn;
		results = resultsIn;
		student = studentIn;
		Logger.writeMessage("Constructor of CreateWorkers", Logger.DebugLevel.CONSTRUCTOR);
	}

	/**
	 * This methods creates NUM_THREADS threads, starts them and
	 * joins on them, via the threaded class WorkerThread
	 * 
	 * @param NUM_THREADS number of threads to be created
	 */
	public void startWorkers(int NUM_THREADS) {
		
		int i = 0;
		WorkerThread workerThread = new WorkerThread(fp , results, student);
		Thread[] threads = new Thread[NUM_THREADS];		
		for (i = 0; i < threads.length; i++)
		{
		    threads[i] = new Thread(workerThread);
		    threads[i].start();
		}
		for(i = 0; i < NUM_THREADS; i++)
		{
			try {
					threads[i].join();
			} catch (InterruptedException e) {
					e.printStackTrace();
			} finally {
					
			}
		}
	
    // this class has the method startWokers(...)
	}

	@Override
	public String toString() {
		return "CreateWorkers [fp=" + fp + ", results=" + results
				+ ", student=" + Arrays.toString(student) + "]";
	}	
}