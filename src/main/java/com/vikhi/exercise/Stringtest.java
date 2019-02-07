package com.vikhi.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stringtest {

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
}
