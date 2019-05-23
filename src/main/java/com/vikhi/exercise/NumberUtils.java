package com.vikhi.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import com.vikhi.pojo.NumberModel;

public class NumberUtils {
	
	private NumberUtils() {
		// Implement this if needed
	}

	public static void swapNumber(final NumberModel numModel) {
		int temp = numModel.getA();
		numModel.setA(numModel.getB());
		numModel.setB(temp);
	}
	
	public static void smartSwapNumber(final NumberModel numModel) {
		numModel.setA(numModel.getA() + numModel.getB());
		numModel.setB(numModel.getA() - numModel.getB());
		numModel.setA(numModel.getA() - numModel.getB());
	}
	
	public static boolean isBinary (final int inputNumber) {
		boolean isBinary = Boolean.TRUE;
		int number = inputNumber;
		while (number > 0) {
			int mod = number % 10;
			if (mod > 1) {
				isBinary = Boolean.FALSE;
				break;
			} else {
				number /= 10;
			}
		}
		
		return isBinary;
	}
	
	public static void getLastNumberSamples(final int number, final int count) {
		if (count >= number) {
			throw new IllegalArgumentException("Unable to the sampling");
		}
		
		List<String> numList = new ArrayList<>(count);
		int sampled = number - 1;
		
		for (int i = 1; i <= count; i ++) {
			numList.add(String.valueOf(sampled --));
		}
		
		System.out.println(String.join(" ", numList));
	}
	
	public static void getPosAndNegAverages(final int[] inputArr) {
		if (inputArr == null || inputArr.length == 0) {
			throw new IllegalArgumentException("Input array has to be non-empty");
		}
		
		int posSum = 0, negSum = 0, posCount = 0, negCount= 0;
		for (int num : inputArr) {
			if (num > 0) {
				posCount ++;
				posSum += num;
			} else if (num < 0) {
				negCount ++;
				negSum += num;
			}
		}
		
		System.out.println("Average of positive numbers : " + (posCount == 0 ? 0 : ((double)posSum / posCount)));
		System.out.println("Average of negative numbers : " + (negCount == 0 ? 0 : ((double)negSum / negCount)));
	}
	
	public static int getDigitOccurence (final int number, final int digit) {
		String numString = String.valueOf(number);
		String query = String.valueOf(digit);
		int occurrences = 0;
		
		char[] digitArr = numString.toCharArray();
		for (char digitChar : digitArr) {
			if (query.equalsIgnoreCase(String.valueOf(digitChar))) {
				occurrences ++;
			}
		}
		
		return occurrences;
	}
	
	public static boolean isAmicable (final long number) {
		return (number == getFactorsSum(getFactorsSum(number)));
	}
	
	private static long getFactorsSum (final long number) {
		return LongStream
				.range(1, number)
				.filter(num -> number % num == 0)
				.sum();
	}
	
	public static long getAmicableSums(final long limit) {
		return LongStream
					.rangeClosed(1, limit)
					.filter(NumberUtils::isAmicable)
					.sum();
	}
	
	public static long getDivisibleSums(final int maxLimit) {
		return LongStream
					.range(1, maxLimit)
					.filter(num -> (num % 3 == 0 || num % 5 == 0))
					.sum();
	}
	
	public static boolean isValidISBN (final long number) {
		
		boolean isValidISBN;
		
		String numStr = String.valueOf(number);
		if (numStr.length() != 10) {
			isValidISBN = Boolean.FALSE;
		} else {
			int sum = 0, counter = 1;
			for(int i = 9; i >= 0; i --, counter ++) {
				sum += (Character.getNumericValue(numStr.charAt(i)) * counter);
			}
			
			isValidISBN = (sum % 11 == 0);
		}
		
		return isValidISBN;
	}
	
	public static boolean isConsecutiveDigitNum (final int number) {
		String numStr = String.valueOf(number);
		Integer digit = Character.getNumericValue(numStr.charAt(0));
		StringBuilder builder = new StringBuilder(digit.toString());
		
		digit ++;
		for (int i = 1; i < numStr.length(); i ++, digit ++) {
			builder.append(digit.toString());
		}
		
		return numStr.equals(builder.toString());
	}
	
	public static long getOddSum(final long limit) {
		return LongStream
				.rangeClosed(1, limit)
				.filter(num -> num % 2 == 1)
				.sum();
	}
}
