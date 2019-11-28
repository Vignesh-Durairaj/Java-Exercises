package com.vikhi.exercise.datastrucutres;

import java.util.HashSet;
import java.util.Set;

public class ArrayFunctions {

	public int getNearestSmallestPositiveInt (final int[] inputArr) {
		
		Set<Integer> hashSet = new HashSet<>();
		int smallInt = 1;
		
		if (inputArr == null) {
		    return smallInt;
		}
		
		for (int i = 0 ; i < inputArr.length; i++) {
		    if (inputArr[i] > 0) {
		        hashSet.add(inputArr[i]);   
		    }
		}

		while (hashSet.contains(smallInt)) {
			smallInt++;
		}
		
		return smallInt;
	}
}
