package com.musala.sdcs.util;

import java.util.regex.Pattern;

public class Validator {
	private static final int PERCENT_MIN_VALUE = 0;
	private static final int PERCENT_MAX_VALUE = 100;

	private static String URL_PATTERN = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";

	public static boolean validatePercent(String value) {
		Integer val = Integer.parseInt(value);

		if (PERCENT_MAX_VALUE >= val && val >= PERCENT_MIN_VALUE) {
			return true;
		}

		return false;
	}

	public static boolean validateURL(String value) {
		return Pattern.matches(URL_PATTERN, value) ? true : false;
	}
}
