package com.vikhi.exercise;

public class BitWiseUtils {

	public int getXorProduct (int a, int N) {
		
		int[] xorTracker;
	    if(a % 2 == 0) {
	        xorTracker = new int[] {N, 1, N ^ 1, 0};
	    } else {
	        xorTracker = new int[] {a, a ^ N, a - 1, (a - 1) ^ N};
	    }
	    		
	    return xorTracker[(N - a) % 4];
	}
}
