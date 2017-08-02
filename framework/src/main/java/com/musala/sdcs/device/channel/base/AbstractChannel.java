package com.musala.sdcs.device.channel.base;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musala.sdcs.repository.ChannelRepository;

/**
 * {@link AbstractChannel<T>} is abstract implementation of
 * {@link GenericChannel<T>}
 *
 * @param <T>
 *            command type of the channel
 */
public abstract class AbstractChannel<T> implements GenericChannel<T> {
	private static Logger logger = LoggerFactory.getLogger(AbstractChannel.class);

	private static final String LOGGER_COMMAND_EXECUTION_INFO = "%s was executed";

	private Integer id;
	private String label;
	private String channelType;
	private T command;
	
	private ChannelRepository channelRepository;

	public AbstractChannel(Integer id, String label, String channelType, T command) {
		setId(id);
		setLabel(label);
		setCommand(command);
		setChannelType(channelType);
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
	public void setChannelType(String channelType) {
		this.channelType = channelType;
	}
	
	@Override
	public String getChannelType() {
		return channelType;
	}

	@Override
	public T getCommand() {
		return command;
	}

	private void setCommand(T command) {
		this.command = command;
	}

	private ChannelRepository getChannelRepository() {
		return channelRepository;
	}

	@Override
	public void executeCommand(T command) throws SQLException {
		this.setCommand(command);
		getChannelRepository().updateChannelCommand(command.toString(), getId(), getChannelType());
		logger.info(String.format(LOGGER_COMMAND_EXECUTION_INFO, command.toString()));
	}

}
