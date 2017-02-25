
package registrationScheduler.threadMgmt;

import java.io.IOException;
import java.util.Arrays;
import registrationScheduler.allocator.Student;
import registrationScheduler.store.StoreResultInterface;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

public class WorkerThread implements Runnable  {

	private FileProcessor fp;
	private StoreResultInterface results;
	private Student [] student;
	private Student s = new Student();
	
    public WorkerThread(FileProcessor fpIn, StoreResultInterface resultsIn, Student[] studentIn) {
    	fp = fpIn;
    	results = resultsIn;
    	student = studentIn;
		Logger.writeMessage("Constructor of WorkerThread", Logger.DebugLevel.CONSTRUCTOR);
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
	// ...
		String line = null;
		try {
			while((line = fp.readFromFile()) != null)
			{
				s.course_assignment(student, line, results);
				Thread.yield();
				results.storeResult(student);
				Thread.yield();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
		Logger.writeMessage("Thread's run() method", Logger.DebugLevel.THREAD_RUN);
    }

	@Override
	public String toString() {
		return "WorkerThread [fp=" + fp + ", results=" + results + ", student="
				+ Arrays.toString(student) + "]";
	}
}