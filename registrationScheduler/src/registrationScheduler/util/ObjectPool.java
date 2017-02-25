package registrationScheduler.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class ObjectPool implements ObjectPoolInterface {
	

	private volatile static ObjectPool objectpool;

    private static Map<String, Integer> courses = new HashMap<String, Integer>();
	
	private ObjectPool() {
		Logger.writeMessage("Constructor of ObjectPool", Logger.DebugLevel.CONSTRUCTOR);

	}

	/**
	 * @return
	 */
	public static ObjectPool getInstance() {
		if (objectpool == null) {
			synchronized (ObjectPool.class) {
				if (objectpool == null) {
					objectpool = new ObjectPool();
					objectpool.addObjects();
				}
			}
		}
		return objectpool;
	}
	
	/* (non-Javadoc)
	 * @see registrationScheduler.util.ObjectPoolInterface#addObjects()
	 */
	public synchronized void addObjects() {
		courses.put("A", 60);
		courses.put("B", 60);
		courses.put("C", 60);
		courses.put("D", 60);
		courses.put("E", 60);
		courses.put("F", 60);
		courses.put("G", 60);
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.util.ObjectPoolInterface#returnObject(java.lang.String)
	 */
	public synchronized void returnObject(String course) {
		for (Entry<String, Integer> e : courses.entrySet())
		{
			if(e.getKey().equals(course))
				e.setValue(e.getValue()+1);
		}
	}
	
	/* (non-Javadoc)
	 * @see registrationScheduler.util.ObjectPoolInterface#checkAvailability(java.lang.String)
	 */
	public synchronized boolean checkAvailability(String course) {
		for (Entry<String, Integer> e : courses.entrySet())
		{
			if(e.getKey().equals(course))
				if(e.getValue() != 0)
					return true;
		}
		return false;
				
	}

	/* (non-Javadoc)
	 * @see registrationScheduler.util.ObjectPoolInterface#borrowObject(java.lang.String)
	 */
	public synchronized void borrowObject(String course) {
		for (Entry<String, Integer> e : courses.entrySet())
		{
			if(e.getKey().equals(course))
				if(e.getValue() != 0)
					e.setValue(e.getValue() - 1);
		}
	}
	
	@Override
	public String toString() {
		return "ObjectPool []";
	}	
}