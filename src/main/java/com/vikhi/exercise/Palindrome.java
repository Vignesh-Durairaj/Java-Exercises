package com.vikhi.exercise;

public class Palindrome {

	public boolean isPalindrome (final String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException("Please specify a valid input string !");
		}
		
		boolean isPalindrome = true;
		int len = str.length();
		String inputStr = str.toUpperCase();
		
		for (int i = 0; i <= len/2; i ++) {
			if (inputStr.charAt(i) != inputStr.charAt(len - i - 1)) {
				isPalindrome = false;
				break;
			}
		}
		
		return isPalindrome;
	}
	
	public int getCharsForPalindrome (final String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException("Please specify a valid input string !");
		}
		
		int shortageChars = 0;
		String appendedStr = "";
		String inputStr = str;
		
		for (char c : str.toCharArray()) {
			if (!isPalindrome(inputStr)) {
				shortageChars ++;
				inputStr = inputStr.substring(0, inputStr.length() - appendedStr.length()) + c + appendedStr;
				appendedStr = c + appendedStr;
			} else {
				break;
			}
		}
		
		return shortageChars;
	}
	
	public int getCharsForInsert(final String str) {
		if (str == null || str.isEmpty()) {
			throw new IllegalArgumentException("Please specify a valid input string !");
		}
		
		if (isPalindrome(str)){
			return 0;
		}
		
		int insertableChars = 0;
		// String tempStr = str.toUpperCase();
		
		
		return insertableChars;
	}
}
