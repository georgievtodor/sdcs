package com.musala.sdcs.device.channel.type;

import com.musala.sdcs.exception.InvalidCommandTypeException;
import com.musala.sdcs.util.Validator;

public class URLType {
	private static final String INVALID_URL_MESSAGE = "URL adress must be valid url, instead got %s";

	private String url;

	public URLType(String url) {
		setUrl(url);
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		if (Validator.validateURL(url)) {
			this.url = url;
		} else {
			throw new InvalidCommandTypeException(String.format(INVALID_URL_MESSAGE, url));
		}
	}

	@Override
	public String toString() {
		return getUrl();
	}
}
