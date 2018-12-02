package com.vikhi.exercise;

public class BitWiseUtils {

	public int getXorProduct (int a, int b) {
		
		int[] xorTracker;
	    if(a % 2 == 0) {
	        xorTracker = new int[] {b, 1, b ^ 1, 0};
	    } else {
	        xorTracker = new int[] {a, a ^ b, a - 1, (a - 1) ^ b};
	    }
	    		
	    return xorTracker[(b - a) % 4];
	}
}
