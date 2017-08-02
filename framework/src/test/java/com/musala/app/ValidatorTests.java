package com.musala.app;

import org.junit.experimental.theories.*;
import org.junit.runner.RunWith;

import com.musala.sdcs.util.Validator;

import static org.junit.Assert.*;

@RunWith(Theories.class)
public class ValidatorTests {

	public static @DataPoints("correct percent values") String[] correctPercentValues = { "0", "1", "5", "20", "50",
			"99", "100" };

	public static @DataPoints("incorrect percent values") String[] incorrectPercentValues = { "-1", "101", "2186578",
			"-2896348", "30.5", "0.5" };

	public static @DataPoints("correct url values") String[] correctURLValues = { "https://test.com",
			"ftp://192.168.0.1:2015", "http://www.test.com", "http://test.io", "https://www.test.bg" };

	public static @DataPoints("incorrect url values") String[] incorrectURLValues = { "test.ru", "www.test.com",
			"http:/www.test.test", "https://test.", "ftp:/192.168.0.1:27015" };

	public static @DataPoints("correct color values") String[] correctColorValues = { "#cccccc", "#AA33FF", "#6c231e",
			"#808ca0", "#1B4EA9" };

	public static @DataPoints("incorrect color values") String[] incorrectColorValues = { "#ccc", "#AA33FG", "#AA33F",
			"AA33FF", "#cccccc1" };

	@Theory
	public void validatePercentShouldReturnTrueWhenCorrectValueIsPassed(
			@FromDataPoints("correct percent values") String value) {
		assertTrue(Validator.validateNumberIfBetween(value, 0, 100));
	}

	@Theory
	public void validatePercentShouldReturnFalseWhenIncorrectValueIsPassed(
			@FromDataPoints("incorrect percent values") String value) {
		assertFalse(Validator.validateNumberIfBetween(value, 0, 100));
	}

	@Theory
	public void validateURLShouldReturnTrueWhenCorrectURLIsPassed(@FromDataPoints("correct url values") String url) {
		assertTrue(Validator.validateURL(url));
	}

	@Theory
	public void validateURLShouldReturnFalseWhenIncorrectURLIsPassed(
			@FromDataPoints("incorrect url values") String url) {
		assertFalse(Validator.validateURL(url));
	}

	@Theory
	public void validateColorShouldReturnTrueWhenCorrectColorIsPassed(
			@FromDataPoints("correct color values") String color) {
		assertTrue(Validator.validateColor(color));
	}

	@Theory
	public void validateColorShouldReturnFalseWhenInvalidColorIsPassed(
			@FromDataPoints("incorrect color values") String color) {
		assertFalse(Validator.validateColor(color));
	}
}
