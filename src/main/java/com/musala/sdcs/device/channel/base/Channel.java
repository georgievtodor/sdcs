package com.musala.sdcs.device.channel.base;

/**
 * {@link Channel<T>} is a representation of the mutual properties across all channels
 *
 * @param <T> channel command type
 */
public interface Channel<T> {

    /**
     * @return the label of the channel
     */
    String getLabel();

    /**
     * sets the channel label
     * 
     * @param label
     */
    void setLabel(String label);

    /**
     * @return current command
     */
    T getCommand();

    /**
     * executes newly given command
     * 
     * @param command
     */
    void executeCommand(T command);

}