package com.vikhi.exercise.string;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;

public class StringFunctions {

	private final Logger log = Logger.getLogger(this.getClass());
	
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
    	StringBuilder builder;
    	for (int i = rows; i > 0; i--) {
    		builder = new StringBuilder();
    		for (int j = 1; j <= i; j ++) {
    			builder.append(" ");
    		}
    		
    		for (int j = 1; j <= val; j ++) {
    			builder.append(j);
    			if(j != val) {
    				builder.append(" ");
    			}
    		}
    		
    		log.info(builder.toString());
    		val ++;
    	}
    }
    
    public void printPyramidNumbersStaticRows(final int rows) {
    	int val = 1;
    	StringBuilder builder;
    	for (int i = rows; i > 0; i--) {
    		builder = new StringBuilder();
    		for (int j = 1; j <= i; j ++) {
    			builder.append(" ");
    		}
    		
    		for (int j = 1; j <= val; j ++) {
    			builder.append(val);
    			if(j != val) {
    				builder.append(" ");
    			}
    		}
    		
    		log.info(builder.toString());
    		val ++;
    	}
    }
    
    public void printPyramidStars(final int rows) {
    	int val = 1;
    	StringBuilder builder;
    	for (int i = rows; i > 0; i--) {
    		builder = new StringBuilder();
    		for (int j = 1; j <= i; j ++) {
    			builder.append(" ");
    		}
    		
    		for (int j = 1; j <= val; j ++) {
    			builder.append("*");
    			if(j != val) {
    				builder.append(" ");
    			}
    		}
    		
    		log.info(builder.toString());
    		val ++;
    	}
    }
    
    public void printPyramidStarsUpright(final int rows) {
    	int val = rows;
    	StringBuilder builder;
    	for (int i = rows; i > 0; i--) {
    		builder = new StringBuilder();
    		for (int j = i; j <= rows; j ++) {
    			builder.append(" ");
    		}
    		
    		for (int j = 1; j <= val; j ++) {
    			builder.append("*");
    			if(j != val) {
    				builder.append(" ");
    			}
    		}
    		
    		log.info(builder.toString());
    		val --;
    	}
    }
    
    public void printSymmetricPyramidNumbers(final int rows) {
    	int val = 1;
    	StringBuilder builder;
    	for (int i = rows; i > 0; i--) {
    		builder = new StringBuilder();
    		int mid = val / 2;
    		for (int j = 1; j <= i; j ++) {
    			builder.append(" ");
    		}
    		
    		for (int j = 1; j <= val; j ++) {
    			builder.append(j <= mid ? j : (val - j + 1));
    			if(j != val) {
    				builder.append(" ");
    			}
    		}
    		
    		log.info(builder.toString());
    		val ++;
    	}
    }
    
    public void printRectangle (final int width, final int height) {
    	if (width == 0 || height == 0) {
    		throw new IllegalArgumentException("The rectangle's dimensions are not to be zero");
    	}
    	
    	StringBuilder builder;
    	
    	for (int h = 1; h <= height; h ++) {
    		builder = new StringBuilder();
    		if (h == 1 || h == height) {
    			for (int w = 1; w <= width; w ++) {
        			builder.append("*");
        		}
    		} else {
    			for (int w = 1; w <= width; w ++) {
        			builder.append(w != 1 && w != width ? " " : "*");
        		}
    		}
    		log.info(builder.toString());
    	}
    }
    
    public void printSquare (final int size) {
    	printRectangle(size, size);
    }
    
    public void printDiamondStars (final int limit) {
    	
    	Supplier<String> starSupplier = new Supplier<String>() {
    		boolean isEvenLimit = limit % 2 == 0;
    		int rowMedian = (limit / 2) + (isEvenLimit ? 0 : 1);
    		int counter = 1; 
    		int startPos = rowMedian; 
    		int endPos = rowMedian;

    		@Override
			public String get() {
				StringBuilder starBuilder = new StringBuilder();
				for (int i = 1; i <= endPos; i ++) {
					if (i >= startPos) {
						starBuilder.append("*");
					} else {
						starBuilder.append(" ");
					}
				}
				
				counter ++;
				if (!isEvenLimit || counter != (rowMedian + 1)) {
					startPos += (rowMedian - counter >= 0 ? -1 : 1);
					endPos += (rowMedian - counter >= 0 ? 1 : -1);
				} 
				return starBuilder.toString();
			}
		};
    	
    	Stream
    		.generate(starSupplier)
    		.limit(limit)
    		.forEach(log::info);
    }
    
    public void printTriangularNumbers(final int limit) {
    	int counter = 1;
    	StringBuilder builder;
    	for (int i = 1; i <= limit; i ++) {
    		builder = new StringBuilder();
    		for (int j = 1; j <= i; j ++, counter ++) {
    			builder.append(counter).append(" ");
    		}
    		log.info(builder.toString());
    	}
    }
    
    public String getCapitalization(final String str) {
    	
    	if (str.trim().equals("")) {
    		return "";
    	}
    	
    	return Arrays
    			.stream(str.split(" "))
    			.map(ele -> ele.toUpperCase().charAt(0) + ele.toLowerCase().substring(1, ele.length()))
    			.peek(log::info)
    			.reduce("", (a, b) -> a + b + " ")
    			.trim();
    }
    
    public String getStringFromNumbers(final List<Integer> ints) {
    	return ints
    			.stream()
    			.map(i -> String.valueOf(i) + (i % 2 == 0 ? 'e' : 'o'))
    			.collect(Collectors.joining(","));
    }
    
    public List<String> convertToUpperCase(List<String> inStrings) {
    	return inStrings
    			.stream()
    			.map(String::toUpperCase)
    			.collect(Collectors.toList());
    }
    
    public <T extends Object> String getListAsString(List<T> items) {
    	return items
    			.stream()
    			.map(Object::toString)
    			.collect(Collectors.joining(","));
    }
    
    public String getNonDuplicatedValue(final String input) {
    	StringBuilder nonDuplicatedValueBuilder = new StringBuilder();
    	asList(input.split("")).stream()
    		.filter(character -> nonDuplicatedValueBuilder.indexOf(character) < 0)
    		.forEach(nonDuplicatedValueBuilder::append);
    	return nonDuplicatedValueBuilder.toString();
    }
}
