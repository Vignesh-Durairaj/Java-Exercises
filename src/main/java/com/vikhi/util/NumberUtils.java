package com.vikhi.util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

import org.apache.log4j.Logger;

import com.vikhi.pojo.NumberModel;

public class NumberUtils {
	
	private static final Logger LOGGER = Logger.getLogger(NumberUtils.class);
	
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
		
		LOGGER.info(String.join(" ", numList));
	}
	
	public static void getPosAndNegAverages(final int[] inputArr) {
		if (inputArr == null || inputArr.length == 0) {
			throw new IllegalArgumentException("Input array has to be non-empty");
		}
		
		int posSum = 0; 
		int negSum = 0; 
		int posCount = 0; 
		int negCount= 0;
		
		for (int num : inputArr) {
			if (num > 0) {
				posCount ++;
				posSum += num;
			} else if (num < 0) {
				negCount ++;
				negSum += num;
			}
		}
		
		LOGGER.info("Average of positive numbers : " + (posCount == 0 ? 0 : ((double)posSum / posCount)));
		LOGGER.info("Average of negative numbers : " + (negCount == 0 ? 0 : ((double)negSum / negCount)));
	}
	
	public static Double getAverage (final List<Integer> ints) {
		OptionalDouble averageOption =  ints
				.stream()
				.mapToInt(Integer::valueOf)
				.average();
		
		return averageOption.isPresent() ? averageOption.getAsDouble() : null;
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
			int sum = 0; 
			int counter = 1;
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
	
	public static int getQuadrant(final int angle) {
		int actualAngle = angle; 
		int quadrant = 0;
		
		while (actualAngle > 360) {
			actualAngle -= 360;
		}
		
		if (actualAngle <= 90) {
			quadrant = 1;
		} else if (actualAngle > 90 && actualAngle <= 180) {
			quadrant = 2;
		} else if (actualAngle > 180 && actualAngle <= 270) {
			quadrant = 3;
		} else if (actualAngle > 270) {
			quadrant = 4;
		}
		
		return quadrant;
	}
	
	public static boolean isPrime(final int number) {
		boolean isPrime = true;
		
		if(number == 1 || (number != 2 && number % 2 == 0)) {
			isPrime = false;
		} else {
			for (int i = 3; i <= (int)Math.sqrt(number); i ++) {
				if (number % i == 0) {
					isPrime = false;
					break;
				}
			}
		}
		
		return isPrime;
	}
	
	public static int getOneCounts(final int startNumber, final int endNumber) {
		return IntStream
				.rangeClosed(startNumber, endNumber)
				.reduce(0, (a, b) -> a + getOneCounts(b));
	}
	
	private static int getOneCounts(final int number) {
		int oneCount = 0;
		String numStr = String.valueOf(number);
		for (int i = 0; i < numStr.length(); i ++) {
			oneCount += (numStr.charAt(i) == '1') ? 1 : 0;
		}
		
		return oneCount;
	}
	
	public static boolean isPerfectNumber(final int number) {
		int divisorSum = IntStream
							.rangeClosed(1, number / 2)
							.filter(i -> number % i == 0)
							.sum();
		
		return (number == divisorSum);
	}
	
	public static double getAreaOfTriangle(final int a, final int b, final int c) {
		double s = (a + b + c) / (double) 2;
		return Math.sqrt(Math.abs(s * (s - a) * (s - b) * (s - c)));
	}
	
	public static long getSeconds(final int hours, final int minutes, final int seconds) {
		return (hours * 3600) + (minutes * 60) + (long)seconds;
	}
	
	public static boolean isAbundantNumber(final int number) {
		int divisorSum = IntStream
				.rangeClosed(1, number / 2 + 1)
				.filter(num -> number % num == 0)
				.sum();
		
		return (divisorSum > number);
	}
	
	public static boolean getAbundantNumbers(final int maxRange) {
		IntStream
			.rangeClosed(2, maxRange)
			.filter(NumberUtils::isAbundantNumber)
			.forEach(LOGGER::info);
		return true;
	}
	
	public static long countPrimes(long max) {
		LongStream maxNumStream = LongStream.rangeClosed(2, max);
		maxNumStream = max > 1000000 ? maxNumStream.parallel() : maxNumStream;
		
		long count =  maxNumStream
			.filter(num -> LongStream
					.rangeClosed(2, (long) Math.sqrt(num))
					.noneMatch(n -> num % n == 0))
			.count();
		
		maxNumStream.close();
		return count;
	}
	
	public static long getSumOfDigitsBetween(int from, int to) {
		return IntStream
			.rangeClosed(from, to)
			.mapToObj(Integer::toString)
			.map(num -> num.split(""))
			.mapToLong(NumberUtils::getSumOfDigits)
			.sum();
	}
	
	private static long getSumOfDigits(String[] numberAsStrings) {
		boolean isNegative = (numberAsStrings[0].equals("-"));
		int startIndex = isNegative ? 1 : 0;
		long sum = 0;
		for (int i = startIndex; i < numberAsStrings.length; i ++) {
			sum += Long.valueOf(numberAsStrings[i]);
		}
		
		return sum * (isNegative ? -1 : 1);
	}
	
	public static boolean isKaprekarNumber(final int inputNumber) {
		if (inputNumber == 1) {
			return true;
		}
		
		String inputNumStr = String.valueOf(inputNumber);
		BigInteger squaredVal = new BigInteger(inputNumStr).multiply(new BigInteger (inputNumStr));
		String squaredValStr = squaredVal.toString();
		int stringLen = squaredValStr.length();
		
		for (int i = 1; i < stringLen; i++) {
			BigInteger firstNum = new BigInteger(squaredValStr.substring(0, i));
			BigInteger secondNum = new BigInteger(squaredValStr.substring(i, stringLen));
			
			if ((firstNum.add(secondNum)).equals(new BigInteger(inputNumStr))) {
				return true;
			}
		}
		
		return false;
	}
}
