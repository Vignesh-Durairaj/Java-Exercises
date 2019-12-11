package com.vikhi.exercise.string;

import static com.vikhi.util.ConstantsHelper.SYMBOL_BLANK;
import static com.vikhi.util.ConstantsHelper.SYMBOL_HYPHEN;
import static com.vikhi.util.ConstantsHelper.SYMBOL_UNDER_SCORE;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CaseConverter {

	public String convertToCamelCase(final String inputString) {
		if (inputString == null) {
			throw new IllegalArgumentException("Input string should not be null");
		} else if (inputString.trim().equals(SYMBOL_BLANK)) {
			return SYMBOL_BLANK;
		} else {
			String pascalCase = getPascalCase(inputString);
			return pascalCase.substring(0, 1).toLowerCase() + pascalCase.substring(1);
		}
	}
	
	public String convertToPascalCase(final String inputString) {
		if (inputString == null) {
			throw new IllegalArgumentException("Input string should not be null");
		} else if (inputString.trim().equals(SYMBOL_BLANK)) {
			return SYMBOL_BLANK;
		} else {
			return getPascalCase(inputString);
		}
	}
	
	public String convertToKebabCase(final String inputString) {
		return null;
	}
	
	public String convertToSnakeCase(final String inputString) {
		return null;
	}
	
	private String getPascalCase(final String inputString) {
		return Arrays.stream(inputString.split(SYMBOL_HYPHEN))
				.flatMap(string -> Arrays.stream(string.split(SYMBOL_UNDER_SCORE)))
				.map(str -> str.substring(0, 1).toUpperCase() + str.substring(1))
				.collect(Collectors.joining());
	}
	
}
