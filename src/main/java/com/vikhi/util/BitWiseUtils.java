package com.vikhi.util;

public class BitWiseUtils {

	public int getXorProduct (int numOne, int numTwo) {
		
		int[] xorTracker;
	    if(numOne % 2 == 0) {
	        xorTracker = new int[] {numTwo, 1, numTwo ^ 1, 0};
	    } else {
	        xorTracker = new int[] {numOne, numOne ^ numTwo, numOne - 1, (numOne - 1) ^ numTwo};
	    }
	    		
	    return xorTracker[(numTwo - numOne) % 4];
	}
}
