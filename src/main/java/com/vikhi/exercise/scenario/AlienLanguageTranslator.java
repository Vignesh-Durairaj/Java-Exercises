package com.vikhi.exercise.scenario;

import com.vikhi.exercise.interfaces.LanguageTranslator;

public class AlienLanguageTranslator implements LanguageTranslator {

	@Override
	public String fromDefaultLanguage(String languageTokens) {
		char[] inArr = languageTokens.toCharArray();
		StringBuilder builder = new StringBuilder();
		
		for (char c : inArr) {
			int asciiVal = (int)c; 
			int translateVal = 0;
			if ((asciiVal >= 65 && asciiVal <= 90) || 
					asciiVal >= 97 && asciiVal <= 122) {
				if (asciiVal <= 90) {
					translateVal = (asciiVal > 87) ? (asciiVal - 23) : asciiVal + 3;
				} else {
					translateVal = (asciiVal > 119) ? (asciiVal - 23) : asciiVal + 3;
				}
				builder.append((char)translateVal);
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}

	@Override
	public String toDefaultLanguage(String languageTokens) {
		char[] inArr = languageTokens.toCharArray();
		StringBuilder builder = new StringBuilder();
		for (char c : inArr) {
			builder.append(getTransformedCharacter(c, false));
		}
		return builder.toString();
	}
	
	private char getTransformedCharacter (final char c, final boolean isFromDefaultLanguage) {
		int asciiVal = (int)c;
		if ((asciiVal >= 65 && asciiVal <= 90) || 
				asciiVal >= 97 && asciiVal <= 122) {
			return ((char)getTranslatedValue(asciiVal, isFromDefaultLanguage));
		} else {
			return c;
		}
	}
	
	private int getTranslatedValue(final int asciiVal, final boolean isFromDefaultLanguage) {
		int translateVal = 0;
		if (asciiVal <= 90) {
			if (isFromDefaultLanguage) {
				translateVal = (asciiVal > 119) ? (asciiVal - 23) : asciiVal + 3;
			} else {
				translateVal = (asciiVal < 68) ? (asciiVal + 23) : asciiVal - 3;
			}
			
		} else {
			if (isFromDefaultLanguage) {
				translateVal = (asciiVal > 87) ? (asciiVal - 23) : asciiVal + 3;
			} else {
				translateVal = (asciiVal < 100) ? (asciiVal + 23) : asciiVal - 3;
			}
			
		}
		
		return translateVal;
	}
	
	private int getTranslatedValueForNearEnd(final int asciiVal, final boolean isFromDefaultLanguage) {
		return 1;
	}
}