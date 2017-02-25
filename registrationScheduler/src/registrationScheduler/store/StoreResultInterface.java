package registrationScheduler.store;

import registrationScheduler.allocator.Student;

public interface StoreResultInterface {
	
	/**
	 * This method stores the result from course assignment
	 * to results data structure.
	 * 
	 * @param student
	 */
	public void storeResult(Student[] student);
	
	/**
	 * This method calculates average preference score 
	 * from total preference scores of all students
	 * 
	 * @param n total no. of students
	 * @return average preference score
	 */
	public double getAvgScore(int n);
	
	/**
	 * This method stores the result from course assignment
	 * to results data structure for given student at index i.
	 * 
	 * @param student data structure for student
	 * @param i index for particular student
	 */
	public void storeResult(Student[] student, int i);
}