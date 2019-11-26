package com.vikhi.exercise.math;

import java.util.stream.IntStream;

import org.apache.log4j.Logger;

public class ArmstrongNumbers {

	private final Logger log = Logger.getLogger(this.getClass());
	
	private int getLength(final int inNum) {
		int length = 0; 
		int number = inNum;
		while (number > 0) {
			length ++;
			number /= 10;
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
			.forEach(log::info);
	}

	public void getArmstrongNumbersFaster() {
		IntStream
			.rangeClosed(1, 1000)
			.filter(this::isArmstrongNumberFaster)
			.forEach(log::info);
	}
}
