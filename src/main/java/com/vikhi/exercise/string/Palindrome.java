package com.vikhi.exercise.string;

import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

public class Palindrome {

	private final Logger log = Logger.getLogger(this.getClass());
	
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
		StringBuilder builder = new StringBuilder();
		String inputStr = str;
		
		for (char c : str.toCharArray()) {
			if (!isPalindrome(inputStr)) {
				shortageChars ++;
				inputStr = inputStr.substring(0, inputStr.length() - builder.length()) + c + builder.toString();
				builder.insert(0, c);
			} else {
				log.info("The input string is already a palindrome.");
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
		
		return 0;
	}
	
	public List<Integer> getPalindromicSubStrings(int stringLength, String inString){
        for (int i = 1; i <= stringLength; i ++) {
            String subject = inString.substring(0, i);
            log.info(getPalindromeLength(subject));
        }
        
        return Arrays.asList();
    }
	
	private int getPalindromeLength(final String str) {
	    int palLength = 0;
	    for (double pivot = 0; pivot < str.length(); pivot += 0.5D) {
	        double palindromeRadius = pivot - (int)pivot;
	        
	        while ((pivot + palindromeRadius) < str.length() && 
	            (pivot - palindromeRadius) >= 0 && 
	            str.charAt((int)(pivot - palindromeRadius)) 
	                == str.charAt((int)(pivot + palindromeRadius))) {
	                int currLength = (str.substring(
	                        (int)(pivot - palindromeRadius), 
                            (int)(pivot + palindromeRadius + 1))).length();
                    if (palLength < currLength) {
                        palLength = currLength;
                    }
                    palindromeRadius++;
	            }
	    }
	    return palLength;
	}
}
