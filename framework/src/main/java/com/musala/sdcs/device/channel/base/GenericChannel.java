package com.musala.sdcs.device.channel.base;

/**
 * {@link GenericChannel<T>} extends {@link Channel} and includes all generic
 * methods for the channels
 *
 * @param <T>
 *            channel command type
 */
public interface GenericChannel<T> extends Channel {
	/**
	 * @return current command
	 */
	T getCommand();

	/**
	 * executes given command
	 * 
	 * @param command
	 */
	void executeCommand(T command);


}