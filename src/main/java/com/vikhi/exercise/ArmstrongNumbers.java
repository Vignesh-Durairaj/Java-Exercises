package com.vikhi.exercise;

import java.util.stream.IntStream;

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
	
	public void getArmstrongNumbers() {
		IntStream
			.rangeClosed(1, Integer.MAX_VALUE)
			.filter(this::isArmstrongNumber)
			.forEach(System.out::println);
	}
}
