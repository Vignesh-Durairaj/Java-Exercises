package com.vikhi.exercise;

import java.util.ArrayList;
import java.util.List;

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
}
