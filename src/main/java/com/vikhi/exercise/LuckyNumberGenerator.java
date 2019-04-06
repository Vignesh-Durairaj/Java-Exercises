package com.vikhi.exercise;

public class LuckyNumberGenerator {

	public int getLuckyNumberAsSum (final int inputNumber) {
		int modSum = 0, number = inputNumber;
		while(number  > 9) {
		    int value = number;
		    modSum = 0;
		    while (value > 0) {
		        modSum += (value % 10);
		        value /= 10;
		    }
		    number = modSum;
		}
		
		return modSum;
	}
	
	public static void main(String[] args) {
		LuckyNumberGenerator lng = new LuckyNumberGenerator();
		System.out.println(lng.getLuckyNumberAsSum(131083));
	}
}
