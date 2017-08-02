package com.musala.sdcs.device.channel.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musala.sdcs.exception.InvalidCommandTypeException;
import com.musala.sdcs.util.Validator;

public class NumberType {
	private static final String INVALID_PERCENT_VALUE = "Number value must be Integer between %s and %s inclusive, instead got %s";
	private static final Logger logger = LoggerFactory.getLogger(NumberType.class);

	private String val;
	private int minVal;
	private int maxVal;
	
	public NumberType(String val, int minVal, int maxVal) {
		this.minVal = minVal;
		this.maxVal = maxVal;
		setVal(val);
	}

	public void setVal(String val) {
		if (Validator.validateNumberIfBetween(val, getMinVal(), getMaxVal())) {
			this.val = val;
		} else {
			String errorMessage = String.format(INVALID_PERCENT_VALUE, getMinVal(), getMaxVal(), val);
			logger.error(errorMessage);
			throw new InvalidCommandTypeException(errorMessage);
		}
	}
	
	public int getMinVal() {
		return minVal;
	}

	public int getMaxVal() {
		return maxVal;
	}



	public String getVal() {
		return val;
	}

	@Override
	public String toString() {
		return val;
	}
}
