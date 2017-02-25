
package registrationScheduler.store;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import registrationScheduler.allocator.Student;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class Results implements StdoutDisplayInterface, FileDisplayInterface, StoreResultInterface {
	
	private PrintWriter writer;
	private String name;
	private String courses;
	private int totalScore;
	private List<Results> schedules;
	private static int index = 0;
	private static double avg_score = 0.0;
	private DecimalFormat myFormat = new DecimalFormat("#.0");
	
	public Results() {
		
		Logger.writeMessage("Constructor of Results", Logger.DebugLevel.CONSTRUCTOR);
		schedules = new ArrayList<Results>();
	}

    /* (non-Javadoc)
     * @see registrationScheduler.store.StdoutDisplayInterface#writeScheduleToScreen()
     */
    public void writeScheduleToScreen() {
    	
	// ..
    	Logger.writeMessage("Contents of data structure in results store\n" + schedules.toString().replaceAll("\\[|\\]|\\,", ""), DebugLevel.RESULT_DATA);
    	for(int k = 0; k < schedules.size(); k++)
    	{
    		System.out.println(" " + schedules.get(k).name + " " + schedules.get(k).courses + " " + schedules.get(k).totalScore);
    	}
    	Logger.writeMessage("Average preference value is: "+ myFormat.format(getAvgScore(schedules.size())), DebugLevel.APV);
		System.out.println("Average preference value is: "+ myFormat.format(getAvgScore(schedules.size())));
    }

	/* (non-Javadoc)
	 * @see registrationScheduler.store.FileDisplayInterface#writeSchedulesToFile(java.lang.String)
	 */
	@Override
	public void writeSchedulesToFile(String output_filename) {
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(output_filename)));
			for(int k = 0; k < schedules.size(); k++)
			{
				writer.write(" " + schedules.get(k).name + " " + schedules.get(k).courses + " " + schedules.get(k).totalScore);
				writer.println();
				writer.flush();
			}
			writer.write("Average preference value is: "+ myFormat.format(getAvgScore(schedules.size())));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally	{
			if(writer != null)
				writer.close();
		}
	}
	
	/* (non-Javadoc)
	 * @see registrationScheduler.store.StoreResultInterface#getAvgScore(int)
	 */
	public double getAvgScore(int n)
	{
		avg_score = 0.0;
		for(int k=0;k<schedules.size();k++)
			avg_score += schedules.get(k).totalScore;
		return (avg_score/n);
	}
	
	/* (non-Javadoc)
	 * @see registrationScheduler.store.StoreResultInterface#storeResult(registrationScheduler.allocator.Student[])
	 */
	@Override
	public synchronized void storeResult(Student[] student) {
		
		//schedules.add(index, student[index].toString());
		Results r = new Results();
		r.name = student[index].getName();
		//r.courses = student[index].enrolled.toString().replaceAll("\\[|\\]|\\,", "");
		r.courses = student[index].getEnrolled().toString().replaceAll("\\[|\\]|\\,", "");
		r.totalScore = student[index].getTotal_preference_score();
		schedules.add(index, r);
		Logger.writeMessage("Entry is added to Results", Logger.DebugLevel.ADD_RESULTS);
		index++;
		
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.store.StoreResultInterface#storeResult(registrationScheduler.allocator.Student[], int)
	 */
	@Override
	public synchronized void storeResult(Student[] student, int i) {
		// TODO Auto-generated method stub
		if(schedules.get(i)!=null)
		{
			schedules.remove(i);
			Results r = new Results();
			r.name = student[i].getName();
			r.courses = student[index].getEnrolled().toString().replaceAll("\\[|\\]|\\,", "");
			r.totalScore = student[i].getTotal_preference_score();
			schedules.add(i, r);
			Logger.writeMessage("Entry is added to Results", Logger.DebugLevel.ADD_RESULTS);
		}
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name + " " + courses + " " + totalScore + "\n";
	}
}