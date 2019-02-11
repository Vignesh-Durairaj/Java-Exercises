package com.vikhi.exercise;

public class ArmstrongNumbers {

	public boolean isArmstrongNumber(final int inNum) {
		
		int sumVal = 0;
		int num = inNum;
		int divisor = String.valueOf(inNum).length();
		
		while (num > 0) {
			int rem = num % 10;
			num /=  10;
			sumVal += Math.pow(rem, divisor);
		}
		return inNum == sumVal;
	}
}
