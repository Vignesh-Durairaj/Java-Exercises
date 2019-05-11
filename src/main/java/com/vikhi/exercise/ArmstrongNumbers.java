package com.vikhi.exercise;

import java.util.stream.IntStream;

public class ArmstrongNumbers {

	private int getLength(int inNum) {
		int length = 0;
		while (inNum > 0) {
			length ++;
			inNum /= 10;
		}
		return length;
	}
	
	public int power(final int base, final int power) {
		int product = 1;
		int powerVal = power;
		while (powerVal > 0){
			product *= base;
			powerVal --;
		}
		return product;
	}
	
	public boolean isArmstrongNumberFaster(final int inNum) {
		
		int sumVal = 0;
		int num = inNum;
		int divisor = getLength(inNum);
		
		while (num > 0) {
			int rem = num % 10;
			num /=  10;
			sumVal += power(rem, divisor);
		}
		return inNum == sumVal;
	}
	
	public boolean isArmstrongNumber(final int inNum) {
		char[] numCharArr = String.valueOf(inNum).toCharArray();
		int divisor = numCharArr.length;
		int sumVal = 0;
		
		for (char c: numCharArr) {
			sumVal += Math.pow(Character.getNumericValue(c), divisor);
		}
		
		return sumVal == inNum;
	}
	
	public void getArmstrongNumbers() {
		IntStream
			.rangeClosed(1, 1000)
			.filter(this::isArmstrongNumber)
			.forEach(System.out::println);
	}

	public void getArmstrongNumbersFaster() {
		IntStream
			.rangeClosed(1, 1000)
			.filter(this::isArmstrongNumberFaster)
			.forEach(System.out::println);
	}
}
