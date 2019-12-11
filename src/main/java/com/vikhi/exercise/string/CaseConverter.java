package com.vikhi.exercise.string;

import static com.vikhi.util.ConstantsHelper.SYMBOL_BLANK;

import java.util.Arrays;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class CaseConverter {

	public String convertToCamelCase(final String inputString) {
		return validateAndConvert(inputString, string ->  {
			String pascalCase = getPascalCase(inputString);
			return pascalCase.substring(0, 1).toLowerCase().concat(pascalCase.substring(1));
		});
	}
	
	public String convertToPascalCase(final String inputString) {
		return validateAndConvert(inputString, this::getPascalCase);
	}
	
	public String convertToKebabCase(final String inputString) {
		return validateAndConvert(inputString, str -> getLowerCase(inputString, "-"));
	}
	
	public String convertToSnakeCase(final String inputString) {
		return validateAndConvert(inputString, str -> getLowerCase(inputString, "_"));
	}
	
	public String convertToUpperCaseKebabCase(final String inputString) {
		return validateAndConvert(inputString, str -> getUpperCase(inputString, "-"));
	}
	
	public String convertToUpperCaseSnakeCase(final String inputString) {
		return validateAndConvert(inputString, str -> getUpperCase(inputString, "_"));
	}
	
	private String validateAndConvert(final String inputString, UnaryOperator<String> convertorFunction) {
		if (inputString == null) {
			throw new IllegalArgumentException("Input string should not be null");
		} else if (inputString.trim().equals(SYMBOL_BLANK)) {
			return SYMBOL_BLANK;
		} else {
			return convertorFunction.apply(inputString);
		}
	}
	
	private String getPascalCase(final String inputString) {
		return splitAndJoinString(inputString, "[-_]", s -> s.substring(0, 1).toUpperCase().concat(s.substring(1)), SYMBOL_BLANK);
	}
	
	private String getUpperCase(final String inputString, final String separator) {
		return splitAndJoinString(inputString, "(?=[A-Z])", String::toUpperCase, separator);
	}
	
	private String getLowerCase(final String inputString, final String separator) {
		return splitAndJoinString(inputString, "(?=[A-Z])", String::toLowerCase, separator);
	}
	
	private String splitAndJoinString(final String inputString, final String separator, UnaryOperator<String> func, final String joiner) {
		return Arrays.stream(inputString.split(separator)).map(func).collect(Collectors.joining(joiner));
	}
	
}
