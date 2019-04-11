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
		
		List<String> numList = new ArrayList<>();
		int sampled = number - 1;
		
		for (int i = 1; i <= count; i ++) {
			numList.add(String.valueOf(sampled --));
		}
		
		System.out.println(String.join(" ", numList));
	}
}
