package com.musala.sdcs.device.channel.base;

import com.musala.sdcs.device.channel.type.PercentType;
import com.musala.sdcs.repository.ChannelRepository;

/**
 * {@link AbstractChannel<T>} is abstract implementation of
 * {@link GenericChannel<T>}
 *
 * @param <T>
 *            command type of the channel
 */
public abstract class AbstractChannel<T> implements GenericChannel<T> {
	private Integer id;
	private String label;
	private T command;
	private ChannelRepository channelRepository;

	public AbstractChannel(Integer id, String label, T command) {
		setId(id);
		setLabel(label);
		setCommand(command);
		this.channelRepository = new ChannelRepository();
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer channelId) {
		this.id = channelId;
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
	public ChannelRepository getChannelRepository() {
		return channelRepository;
	}

	@Override
	public void executeCommand(T command) {
		this.setCommand(command);
		getChannelRepository().updateChannelCommand(command.toString(), getId());
	}

}
