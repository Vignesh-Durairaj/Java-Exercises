package com.vikhi.exercise;

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
			int asciiVal = (int)c; 
			int translateVal = 0;
			if ((asciiVal >= 65 && asciiVal <= 90) || 
					asciiVal >= 97 && asciiVal <= 122) {
				if (asciiVal <= 90) {
					translateVal = (asciiVal < 68) ? (asciiVal + 23) : asciiVal - 3;
				} else {
					translateVal = (asciiVal < 100) ? (asciiVal + 23) : asciiVal - 3;
				}
				builder.append((char)translateVal);
			} else {
				builder.append(c);
			}
		}
		return builder.toString();
	}
}

interface LanguageTranslator {
	public String DEFAULT_TRANSLATION = "EN";
	
	// Translates the language from default language
	public String fromDefaultLanguage(String languageTokens);
	
	// Translates the language to default language
	public String toDefaultLanguage(String languageTokens);
}
