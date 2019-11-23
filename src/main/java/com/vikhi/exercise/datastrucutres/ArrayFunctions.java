package com.vikhi.exercise;

import java.util.HashSet;
import java.util.Set;

public class ArrayFunctions {

	public int getNearestSmallestPositiveInt (final int[] A) {
		
		Set<Integer> hashSet = new HashSet<>();
		int smallInt = 1;
		
		if (A == null) {
		    return smallInt;
		}
		
		for (int i = 0 ; i < A.length; i++) {
		    if (A[i] > 0) {
		        hashSet.add(A[i]);   
		    }
		}

		while (hashSet.contains(smallInt)) {
			smallInt++;
		}
		
		return smallInt;
	}
}
