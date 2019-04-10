package com.vikhi.exercise;

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
}
