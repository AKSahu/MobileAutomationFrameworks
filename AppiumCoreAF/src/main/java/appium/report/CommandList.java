package appium.report;

import java.util.LinkedList;

/**
 * This class contains the list of commands that were and are logged by
 * reportXXX() methods
 * 
 * @author A. K. Sahu
 */
public class CommandList {

	/**
	 * Queue object for collecting commands
	 */
	private LinkedList<String> successList = new LinkedList<String>();
	private LinkedList<String> failureList = new LinkedList<String>();

	/**
	 * CommandList instance
	 */
	private static CommandList instance = new CommandList();

	/**
	 * Return the instance of this object.
	 * 
	 * @return The instance of this object
	 */
	public static CommandList getInstance() {
		return instance;
	}

	/**
	 * Add a command to the list.
	 * 
	 * @param s
	 *            the command that was run
	 */
	public void reportSuccess(String s) {
		successList.add(s);
	}

	public void reportFailure(String s) {
		failureList.add(s);
	}

	public void clearCommandLog() {
		successList.clear();
		failureList.clear();
	}

	/**
	 * Get all of the commands in the list.
	 * 
	 * @return
	 */
	public String[] getSuccessList() {

		Object[] objectList = successList.toArray();

		String[] stringList = new String[objectList.length];

		for (int i = 0; i < objectList.length; i++)
			stringList[i] = objectList[i].toString();

		return stringList;

	}

	/**
	 * Get all of the commands in the list.
	 * 
	 * @return
	 */
	public String[] getFailureList() {

		Object[] objectList = failureList.toArray();

		String[] stringList = new String[objectList.length];

		for (int i = 0; i < objectList.length; i++)
			stringList[i] = objectList[i].toString();

		return stringList;

	}

	/**
	 * Indicates if command list contains no commands
	 * 
	 * @return
	 */
	public boolean isEmptySuccessList() {
		return (successList.size() == 0);
	}

	public boolean isEmptyFailureList() {
		return (failureList.size() == 0);
	}

}