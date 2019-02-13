package com.vikhi.exercise;

public class Factorials {

	public int getFactorial(final int num) {
		int fact = 1;
	    for (int i = num; i > 1; i --) {
	        fact *= i;
	    }
	    return fact;
	}
	
	public int getFactorialRecursive(final int num) {
		if (num == 0 || num == 1) {
			return 1;
		} else {
			return num * getFactorialRecursive(num - 1);
		}
		
	}
}
