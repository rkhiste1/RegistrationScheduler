
package registrationScheduler.util;

public class Logger{

    public static enum DebugLevel { 
    	CONSTRUCTOR,
    	THREAD_RUN,
    	ADD_RESULTS,
    	RESULT_DATA,
    	APV				//average preference value
    	};

    private static DebugLevel debugLevel;
    
    public Logger()
    {
		Logger.writeMessage("Constructor of Logger", Logger.DebugLevel.CONSTRUCTOR);

    }

    /**
     * This method sets debug level as per value given by user
     * 
     * @param levelIn debug value given by user
     */
    public static void setDebugValue (int levelIn) {
	switch (levelIn) {
	  case 4: debugLevel = DebugLevel.CONSTRUCTOR; break;
	  case 3: debugLevel = DebugLevel.THREAD_RUN; break;
	  case 2: debugLevel = DebugLevel.ADD_RESULTS; break;
	  case 1: debugLevel = DebugLevel.RESULT_DATA; break;
	  case 0: debugLevel = DebugLevel.APV; break;
	}
    }

    /**
     * @param levelIn
     */
    public static void setDebugValue (DebugLevel levelIn) {
	debugLevel = levelIn;
    }

    /**
     * This method writes the logger message to standard output, given
     * by string message
     * 
     * @param message string message to be written
     * @param levelIn debug value
     */
    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
	if (levelIn == debugLevel)
	    System.out.println(message);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
	return "Debug Level is " + debugLevel;
    }
}
