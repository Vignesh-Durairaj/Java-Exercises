package com.vikhi.exercise;

import java.util.stream.IntStream;

public class LuckyNumberGenerator {

	public int getLuckyNumberAsSum (final int inputNumber) {
		int modSum = inputNumber, number = inputNumber;
		while(number  > 9) {
		    int value = number;
		    modSum = 0;
		    while (value > 0) {
		        modSum += (value % 10);
		        value /= 10;
		    }
		    number = modSum;
		}
		
		return modSum;
	}
	
	public int getLuckyNumberUsingStreams (final int inputNumber) {
		
		int sumValue = inputNumber, number = inputNumber;
		
		while (number > 9) {
			char[] digitsArray = String.valueOf(number).toCharArray();
			sumValue = 
					IntStream
						.range(0, digitsArray.length)
						.map(idx -> Integer.valueOf(String.valueOf(digitsArray[idx])))
						.sum();
			
			number = sumValue;
		}
		
		return sumValue;
	}
}
