package com.vikhi.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordAnagram {
	
	private static final List<Character> VOWEL_CHARS = Arrays.asList(new Character[]{'A', 'E', 'I', 'O', 'U'});
	
	public Set<String> getFilteredCombinations(final String str) {
		Set<String> comboSet = getCombinations(str);
		Set<String> filteredSet = new HashSet<>();
		for (String string : comboSet) {
			if (!isStartingWithVowel(string) && !isHavingTwoConsecutives(string)) {
				filteredSet.add(string);
			}
		}
		return filteredSet;
	}
	
	private Set<String> getCombinations(final String str) {
		Set<String> combinationsSet = new HashSet<String>();
        
		if (str.length() == 0) {
            combinationsSet.add("");
            return combinationsSet;
        }
		
        char initial = str.charAt(0); 
        String rem = str.substring(1); 
        Set<String> words = getCombinations(rem);
        for (String word : words) {
            for (int i = 0;i<=word.length();i++){
            	String newWord = replaceCharacter(word, initial, i);
        		combinationsSet.add(newWord);
            }
        }
        return combinationsSet;
	}
	
	private String replaceCharacter(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }
	
	private boolean isStartingWithVowel(final String str) {
		return VOWEL_CHARS.contains(str.charAt(0));
	}
	
	private boolean isHavingTwoConsecutives(final String str) {
		for (int i = 1; i < str.length(); i++) {
			char firstChar = str.charAt(i - 1);
			char secondChar = str.charAt(i);
			if ((VOWEL_CHARS.contains(firstChar) && VOWEL_CHARS.contains(secondChar)) || 
					(!VOWEL_CHARS.contains(firstChar) && !VOWEL_CHARS.contains(secondChar))) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		WordAnagram anagram = new WordAnagram();
		String str = "AABCY";
		System.out.println(anagram.getCombinations(str));
		System.out.println(anagram.getFilteredCombinations(str));
	}
}
