package com.musala.app;

import org.junit.Test;

import com.musala.sdcs.device.channel.DimmingChannel;
import com.musala.sdcs.device.channel.base.Channel;
import com.musala.sdcs.device.channel.type.PercentType;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DimmingChannelTests {

	@Test
	public void WhenDimmingChannelIsCreatedRightCommandIsPassed() {
		Integer id = 1;
		String label = "test label";
		String channelType = "DimmingChannel";
		PercentType mockCommand = mock(PercentType.class);
		when(mockCommand.getVal()).thenReturn("30");
			
		DimmingChannel dimmingChannel = new DimmingChannel(id, label, channelType, mockCommand);
		
		assertEquals(mockCommand.getVal(), dimmingChannel.getCommand().getVal());	
	}
	
}
