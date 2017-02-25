package registrationScheduler.util;

public interface ObjectPoolInterface {
	
	/**
	 * This methods , upon initialization, adds objects to object pool
	 */
	public void addObjects();
	
	/**
	 * This method returns an object back to the object pool
	 * 
	 * @param course object to be returned
	 */
	public void returnObject(String course);
	
	/**
	 * This method reserves an object to be borrowed given by
	 * String course, and decreases it's capacity by 1.
	 * 
	 * @param course object to be borrowed
	 */
	public void borrowObject(String course);
	
	/**
	 * This method checks whether given object is available 
	 * in the object pool to borrow
	 * 
	 * @param course object for which availability is checked 
	 * @return true if object is available, else false
	 */
	public boolean checkAvailability(String course);
}