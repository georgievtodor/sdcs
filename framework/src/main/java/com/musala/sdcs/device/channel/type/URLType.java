package com.musala.sdcs.device.channel.type;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.musala.sdcs.exception.InvalidCommandTypeException;
import com.musala.sdcs.util.Validator;

public class URLType {
	private static final String INVALID_URL_MESSAGE = "URL adress must be valid url, instead got %s";
	private static final Logger logger = LoggerFactory.getLogger(URLType.class);
	private String val;

	public URLType(String val) {
		setVal(val);
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		if (Validator.validateURL(val)) {
			this.val = val;
		} else {
			String errorMessage = String.format(INVALID_URL_MESSAGE, val);

			logger.error(errorMessage);
			throw new InvalidCommandTypeException(errorMessage);

		}
	}

	@Override
	public String toString() {
		return getVal();
	}
}
