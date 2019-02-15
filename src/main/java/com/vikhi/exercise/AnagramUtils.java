package com.vikhi.exercise;

public class AnagramUtils {

	private AnagramUtils() {
		// Can be implemented if needed
	}
	
	public static boolean isAnagram(final String stringOne, final String stringTwo) {
		boolean isAnagram = Boolean.TRUE;
		char[] charArr = stringOne.replaceAll(" ", "").toLowerCase().toCharArray();
		StringBuilder builder = new StringBuilder(stringTwo.replaceAll(" " , "").toLowerCase());
		
		for (char c : charArr) {
			int idx = builder.indexOf(String.valueOf(c));
			if (idx >= 0) {
				builder.replace(idx, idx + 1, "");
			} else {
				isAnagram = Boolean.FALSE;
				break;
			}
		}
		
		if (builder.length() > 0) {
			isAnagram = Boolean.FALSE;
		}
		
		return isAnagram;
	}
}
