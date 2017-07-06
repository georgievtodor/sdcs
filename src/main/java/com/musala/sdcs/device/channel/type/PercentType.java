package com.musala.sdcs.device.channel.type;

import com.musala.sdcs.exception.InvalidCommandTypeException;
import com.musala.sdcs.util.Validator;

public class PercentType {
	private static final String INVALID_PERCENT_VALUE = "Percent value must be Integer between 0 and 100 inclusive, instead got %s";

	private String numVal;

	public PercentType(String val) {
		setNumVal(val);
	}

	public void setNumVal(String val) {
		if (Validator.validatePercent(val)) {
			this.numVal = val;
		} else {
			throw new InvalidCommandTypeException(String.format(INVALID_PERCENT_VALUE, val));
		}
	}

	public String getNumVal() {
		return numVal;
	}

	@Override
	public String toString() {
		return numVal;
	}

}
