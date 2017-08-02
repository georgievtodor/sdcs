package com.musala.sdcs.util;

import java.util.regex.Pattern;

public class Validator {
	private static String URL_PATTERN = "^(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
	private static String COLOR_PATTERN = "(^#[0-9a-fA-F]{6}$)|(^#[0-9a-fA-F]{3}$)";

	public static boolean validateNumberIfBetween(String value, int min, int max) {
		Integer val;

		try {
			val = Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return false;
		}

		if (max >= val && val >= min) {
			return true;
		}

		return false;
	}

	public static boolean validateURL(String value) {
		return Pattern.matches(URL_PATTERN, value) ? true : false;
	}

	public static boolean validateColor(String value) {
		return Pattern.matches(COLOR_PATTERN, value) ? true : false;
	}
}
