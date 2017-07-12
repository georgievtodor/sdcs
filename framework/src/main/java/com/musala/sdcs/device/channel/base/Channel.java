package com.musala.sdcs.device.channel.base;

/**
 * {@link Channel} is extracted base interface with all non-generic methods.
 * Whole purpose of that extraction is for you to be able to create instances of
 * different channels, referring them with this interface, so that no warnings
 * are displayed, caused by the generic types used.
 *
 */
public interface Channel {

	/**
	 * @return the id of the channel
	 */
	Integer getId();

	/**
	 * sets the channel id
	 * 
	 * @param id
	 */
	void setId(Integer id);

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

	void setChannelType(String channelType);
	
	String getChannelType();
}
