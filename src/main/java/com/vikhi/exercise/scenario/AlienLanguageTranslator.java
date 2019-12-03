package com.vikhi.exercise.scenario;

import com.vikhi.exercise.interfaces.LanguageTranslator;

public class AlienLanguageTranslator implements LanguageTranslator {

	@Override
	public String fromDefaultLanguage(String languageTokens) {
		return getTranslation(languageTokens, true);
	}

	@Override
	public String toDefaultLanguage(String languageTokens) {
		return getTranslation(languageTokens, false);
	}
	
	protected char getTransformedCharacter (final char c, final boolean isFromDefaultLanguage) {
		int asciiVal = (int)c;
		if ((asciiVal >= 65 && asciiVal <= 90) || (asciiVal >= 97 && asciiVal <= 122)) {
			return ((char)getTranslatedValue(asciiVal, isFromDefaultLanguage));
		} else {
			return c;
		}
	}
	
	private String getTranslation(final String languageTokens, final boolean isFromDefaultLanguage) {
		char[] inArr = languageTokens.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (char c : inArr) {
			builder.append(getTransformedCharacter(c, isFromDefaultLanguage));
		}
		return builder.toString();
	}
	
	
	private int getTranslatedValue(final int asciiVal, final boolean isFromDefaultLanguage) {
		return asciiVal <= 90 ? 
				getTranslatedValueForNearEnd(asciiVal, isFromDefaultLanguage) : 
					getTranslatedValueForFarEnd(asciiVal, isFromDefaultLanguage);
	}
	
	private int getTranslatedValueForNearEnd(final int asciiVal, final boolean isFromDefaultLanguage) {
		if (isFromDefaultLanguage) {
			return (asciiVal > 87) ? (asciiVal - 23) : asciiVal + 3;
		} else {
			return (asciiVal < 68) ? (asciiVal + 23) : asciiVal - 3;
		}
	}
	
	private int getTranslatedValueForFarEnd(final int asciiVal, final boolean isFromDefaultLanguage) {
		if (isFromDefaultLanguage) {
			return (asciiVal > 119) ? (asciiVal - 23) : asciiVal + 3;
		} else {
			return (asciiVal < 100) ? (asciiVal + 23) : asciiVal - 3;
		}
	}
}