package registrationScheduler.util;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileProcessor {
	
	private String inputfile;
	private BufferedReader reader;
	
	public FileProcessor(String input_filename) {
		
		inputfile = input_filename;
		try {
			reader = new BufferedReader(new FileReader(inputfile));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			
		}
		Logger.writeMessage("Constructor of FileProcessor", Logger.DebugLevel.CONSTRUCTOR);
	}
	
	/**
	 * This method reads a line from the file and returns it.
	 * 
	 * @return a line from file
	 * @throws IOException on input error while reading file
	 * @see IOException
	 */
	public synchronized String readFromFile() throws IOException
	{
		return reader.readLine();
	}
	
	/**
	 * This method closes the File reader
	 */
	public void closeStream() {
		
		try {
			if(reader!=null)
				reader.close();			
		} catch (IOException e) {
			System.err.println("Error occurred while closing file!");
		} finally {
			
		}
	}

	@Override
	public String toString() {
		return "FileProcessor [inputfile=" + inputfile + ", reader=" + reader
				+ "]";
	}
	
}
