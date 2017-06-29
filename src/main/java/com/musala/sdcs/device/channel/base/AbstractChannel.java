package com.musala.sdcs.device.channel.base;

/**
 * {@link AbstractChannel<T>} is abstract implementation of {@link GenericChannel<T>}
 *
 * @param <T> command type of the channel
 */
public abstract class AbstractChannel<T> implements GenericChannel<T> {
    private String label;
    private T command;

    public AbstractChannel(String label, T command) {
        this.setLabel(label);
        this.setCommand(command);
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public T getCommand() {
        return command;
    }

    private void setCommand(T command) {
        this.command = command;
    }

    @Override
    public void executeCommand(T command) {
        this.setCommand(command);
    }

}
