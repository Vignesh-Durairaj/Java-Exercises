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
}
