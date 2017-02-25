
package registrationScheduler.driver;

import registrationScheduler.allocator.Student;
import registrationScheduler.store.FileDisplayInterface;
import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.store.StoreResultInterface;
import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;

/**
 * @author Rasika Khiste
 *
 */
public class Driver{
	
	private static String input_filename;
	private static String output_filename;
	private static int NUM_THREADS = 0;
	private static int DEBUG_VALUE = 0;

	public static void main(String args[]) {

		System.out.println("\n The inputFile args[0] is: " + args[0]);
		if (args.length != 4) 
		{
			System.err.println("Insufficient arguments");
			System.exit(1);
		}

		if(validate(args))
		{
			Student [] student = new Student[80];
			Logger.setDebugValue(DEBUG_VALUE);
			FileProcessor fp = new FileProcessor(input_filename);
			StoreResultInterface results = new Results();
			CreateWorkers createWorkers = new CreateWorkers(fp, results, student);
			createWorkers.startWorkers(NUM_THREADS);
			((StdoutDisplayInterface)results).writeScheduleToScreen();
			((FileDisplayInterface)results).writeSchedulesToFile(output_filename);
			fp.closeStream();
		}
		else
			System.exit(1);
	} // end main(...)
	
	/**
	 * This method validates the command line arguments
	 * 
	 * @param args command line args[]
	 * @return true if validation is successful, else false
	 */
	private static boolean validate(String[] args)
	{
		input_filename = args[0];
		output_filename = args[1];
		NUM_THREADS = Integer.parseInt(args[2]);
		DEBUG_VALUE = Integer.parseInt(args[3]);
		
		if(NUM_THREADS < 1 || NUM_THREADS > 3)
		{
			System.err.println("Invalid NUM_THREADS: Please enter beetween 1 and 3");
			System.exit(1);
		}
		if(DEBUG_VALUE < 0 || DEBUG_VALUE > 4)
		{
			System.err.println("Invalid DEBUG_VALUE: Please enter beetween 0 and 4");
			System.exit(1);
		}
		return true;
	}

} // end public class Driver
