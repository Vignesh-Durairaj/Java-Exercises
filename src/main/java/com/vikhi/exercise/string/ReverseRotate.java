package com.vikhi.exercise.string;

import static com.vikhi.util.ConstantsHelper.SYMBOL_BLANK;

import java.util.Arrays;

/**
 * The input is a string 'string' of digits. 
 * Cut the string into chunks (a chunk here is a substring of the initial string) of size 'size' (ignore the last chunk if its size is less than 'size').

 * If a chunk represents an integer such as the sum of the cubes of its digits is divisible by 2, reverse that chunk; 
 * otherwise rotate it to the left by one position. Put together these modified chunks and return the result as a string.

 * @author Vignesh_Durairaj
 *
 */
public class ReverseRotate {

	public String revRot(String string, int size) {
		
		int stringLength = string.length();
		if (size == 0 || stringLength < size) {
			return SYMBOL_BLANK;
		}
		
		String modifiedStr = string.substring(0, stringLength - (stringLength % size));
		String[] strArr = modifiedStr.split("(?<=\\G.{" + size + "})");
		StringBuilder builder = new StringBuilder();
		
		for (String s : strArr) {
			boolean isEvenArmstrong = Arrays.stream(s.split(SYMBOL_BLANK))
					.mapToInt(Integer::valueOf)
					.mapToLong(i -> i * i * i)
					.sum() % 2 == 0; 
			
			if (isEvenArmstrong) {
				builder.append(new StringBuilder(s).reverse().toString());
			} else {
				builder.append(s.subSequence(1, s.length())).append(s.charAt(0));
			}
		}
		
		return builder.toString();
	}
	
}
