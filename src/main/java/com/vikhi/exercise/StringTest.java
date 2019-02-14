package com.vikhi.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringTest {

    public String getReversedSentence (final String sentence) {
    	
    	String[] strArr = sentence.split(" ");
		StringBuilder builder = new StringBuilder();
		for (int i = strArr.length - 1; i >= 0; i --) {
			builder.append(strArr[i]);
			if(i != 0) {
				builder.append(" ");
			}
		}
		
		return builder.toString();
    }
    
    public String getReversedSentenceWithStreams(final String sentence) {
    	
    	String[] strArr = sentence.split(" ");
    	Supplier<String> strSupplier = new Supplier<String>() {

    		int i = strArr.length - 1;
    		
			@Override
			public String get() {
				String myStr = strArr[i];
				i --;
				return myStr;
			}
    		
		};
    	
		List<String> myList = Stream.generate(strSupplier).limit(strArr.length).collect(Collectors.toList());
    	return String.join(" ", myList);
    }
    
    public String getReversedCharsInString (final String inStr) {
    	String[] strArr = inStr.split(" ");
    	return Arrays
	    		.stream(strArr)
	    		.map(str -> new StringBuilder(str).reverse())
	    		.collect(Collectors.joining(" "));
    }
    
    public void printPyramidNumbersDynamicRows(final int rows) {
    	int val = 1;
    	for (int i = rows; i > 0; i--) {
    		for (int j = 1; j <= i; j ++) {
    			System.out.print(" ");
    		}
    		
    		for (int j = 1; j <= val; j ++) {
    			System.out.print(j);
    			if(j != val) {
    				System.out.print(" ");
    			}
    		}
    		
    		System.out.println("");
    		val ++;
    	}
    }
    
    public void printPyramidNumbersStaticRows(final int rows) {
    	int val = 1;
    	for (int i = rows; i > 0; i--) {
    		for (int j = 1; j <= i; j ++) {
    			System.out.print(" ");
    		}
    		
    		for (int j = 1; j <= val; j ++) {
    			System.out.print(val);
    			if(j != val) {
    				System.out.print(" ");
    			}
    		}
    		
    		System.out.println("");
    		val ++;
    	}
    }
    
    public void printPyramidStars(final int rows) {
    	int val = 1;
    	for (int i = rows; i > 0; i--) {
    		for (int j = 1; j <= i; j ++) {
    			System.out.print(" ");
    		}
    		
    		for (int j = 1; j <= val; j ++) {
    			System.out.print("*");
    			if(j != val) {
    				System.out.print(" ");
    			}
    		}
    		
    		System.out.println("");
    		val ++;
    	}
    }
    
    public void printPyramidStarsUpright(final int rows) {
    	int val = rows;
    	for (int i = rows; i > 0; i--) {
    		for (int j = i; j <= rows; j ++) {
    			System.out.print(" ");
    		}
    		
    		for (int j = 1; j <= val; j ++) {
    			System.out.print("*");
    			if(j != val) {
    				System.out.print(" ");
    			}
    		}
    		
    		System.out.println("");
    		val --;
    	}
    }
    
    public void printSymmetricPyramidNumbers(final int rows) {
    	int val = 1;
    	for (int i = rows; i > 0; i--) {
    		int mid = val / 2;
    		for (int j = 1; j <= i; j ++) {
    			System.out.print(" ");
    		}
    		
    		for (int j = 1; j <= val; j ++) {
    			System.out.print(j <= mid ? j : (val - j + 1));
    			if(j != val) {
    				System.out.print(" ");
    			}
    		}
    		
    		System.out.println("");
    		val ++;
    	}
    }
    
}
