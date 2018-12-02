package com.vikhi.exercise;

import java.util.Arrays;

public class ArrayMethods {

	public int getNthSmallElement (final int[] a, final int rank) {
		if (a == null || a.length < rank || rank < 1) {
			throw new IllegalArgumentException("The input array should have minimum " + rank + " number of elements");
		} 
		
		Arrays.sort(a);
		return a[rank - 1];
	}
	
	public int getNthSmallElement (final int rank, final int[] a) {
		if (a == null || a.length < rank || rank < 1) {
			throw new IllegalArgumentException("The input array should have minimum of " + rank + " elements");
		}
		
		for (int i = 0; i < a.length; i ++) {
			for (int j = i + 1; j < a.length; j ++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		
		return a[rank - 1];
	}
	
	public int getRankedElementFromArray (final int[] a, final int rank) {
		if (a == null || a.length < rank || rank < 1) {
			throw new IllegalArgumentException("The input array should have minimum " + rank + " number of elements");
		}
		
		int[] sortedArray = 
			Arrays
				.stream(a)
				.sorted()
				.distinct()
				.toArray();
		
		if (sortedArray.length < rank) {
			throw new IllegalArgumentException("No value is " + rank + "th smallest from the input array");
		}
		
		return sortedArray[rank - 1];
	}
}
