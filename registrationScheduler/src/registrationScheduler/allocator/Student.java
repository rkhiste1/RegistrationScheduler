package registrationScheduler.allocator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import registrationScheduler.store.StoreResultInterface;
import registrationScheduler.util.Logger;
import registrationScheduler.util.ObjectPool;
import registrationScheduler.util.ObjectPoolInterface;

public class Student {
	
	ObjectPoolInterface obj = null;
	private int total_preference_score = 0;
	private static int i = 0;
	private List<String> enrolled = new ArrayList<String>();
    private Map<String, Integer> course_pref = new HashMap<String, Integer>();
    private String name;
    
	public Student() {

		total_preference_score = 0;
		course_pref.put("A", 0);
		course_pref.put("B", 0);
		course_pref.put("C", 0);
		course_pref.put("D", 0);
		course_pref.put("E", 0);
		course_pref.put("F", 0);
		course_pref.put("G", 0);
		name = "";
		Logger.writeMessage("Constructor of Student", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 *  This method assigns courses to students as per given preferences
	 *  making sure each student is assigned 5 courses. 
	 * 
	 * @param student student data structure
	 * @param line current line from input file
	 * @param results Object of StoreResultInterface to store result
	 */
	public synchronized void course_assignment(Student[] student, String line, StoreResultInterface results) {
		
		obj = ObjectPool.getInstance();
		String[] inputtoken = line.split("\\s+");
		student[i] = new Student();
		student[i].name= inputtoken[0];
		student[i].course_pref.put("A", Integer.parseInt(inputtoken[1]));
		student[i].course_pref.put("B", Integer.parseInt(inputtoken[2]));
		student[i].course_pref.put("C", Integer.parseInt(inputtoken[3]));
		student[i].course_pref.put("D", Integer.parseInt(inputtoken[4]));
		student[i].course_pref.put("E", Integer.parseInt(inputtoken[5]));
		student[i].course_pref.put("F", Integer.parseInt(inputtoken[6]));
		student[i].course_pref.put("G", Integer.parseInt(inputtoken[7]));
		
		for(int j = 1 ; j <= 7; j++)
		{
			for (Entry<String, Integer> e : student[i].course_pref.entrySet()) 
			{
				if(e.getValue().equals(j)  &&  student[i].enrolled.size() != 5)
				{
					if(obj.checkAvailability(e.getKey()))
					{
						student[i].enrolled.add(e.getKey());
						student[i].total_preference_score += e.getValue();
						obj.borrowObject(e.getKey());
					}
				}
			}
		}
		if(student[i].enrolled.size() != 5)
			random_course_assignment(student, i, results);
		i++;
	}

	/**
	 * This method randomly selects a student and swaps the courses
	 * in case any student is not assigned to 5 courses
	 * 
	 * @param student student data structure
	 * @param index current student index
	 * @param results Object of StoreResultInterface to store result
	 */
	private void random_course_assignment(Student[] student, int index, StoreResultInterface results) {
		// TODO Auto-generated method stub
		Random random = new Random();
		int random_index = 0;
		
		while(student[index].enrolled.size() != 5)
		{
			random_index = random.nextInt(index);
			//if(!student[random_index].enrolled.contains("A") && capacity_for_A!=0)
			for (Entry<String, Integer> e : student[random_index].course_pref.entrySet()) 
			{
				if(!student[random_index].enrolled.contains(e.getKey())  &&  obj.checkAvailability(e.getKey()))
				{
					for(int j = student[random_index].enrolled.size()-1; j>=0 ; j--)
					{
						String temp = student[random_index].enrolled.get(j);
						if(!student[index].enrolled.contains(temp))
						{
							student[random_index].enrolled.add(e.getKey());
							obj.borrowObject(e.getKey());
							student[random_index].enrolled.remove(temp);
							student[index].enrolled.add(temp);
							student[random_index].total_preference_score -= student[random_index].course_pref.get(temp);
							student[random_index].total_preference_score += student[random_index].course_pref.get(e.getKey());
							student[index].total_preference_score += student[index].course_pref.get(temp);
							results.storeResult(student, random_index);
							break;
						}
					}
					break;
				}
			}

		}
	}

	/**
	 * This method returns list of courses to which a student
	 * is currently enrolled
	 * 
	 * @return list of enrolled courses
	 */
	public List<String> getEnrolled() {
		return enrolled;
	}

	/**
	 * @param enrolled
	 */
	public void setEnrolled(List<String> enrolled) {
		this.enrolled = enrolled;
	}

	/**
	 * This method returns name of the student
	 * 
	 * @return current student name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method returns total preference score for a student
	 * 
	 * @return combined preference score of a student for 5 courses
	 */
	public int getTotal_preference_score() {
		return total_preference_score;
	}

	/**
	 * @param total_preference_score
	 */
	public void setTotal_preference_score(int total_preference_score) {
		this.total_preference_score = total_preference_score;
	}

	public String toString() {
		return name + " " + enrolled.toString().replaceAll("\\[|\\]|\\,", "") + " " + total_preference_score ;	
	}	
}
