package com.vikhi.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayMethods {

	public int getNthSmallElement (final int[] a, final int rank) {
		if (a == null || a.length < rank) {
			throw new IllegalArgumentException("The input array should have minimum " + rank + " number of elements");
		} 
		
		Arrays.sort(a);
		return a[rank - 1];
	}
	
	public int getNthSmallElement (final int rank, final int[] a) {
		if (a == null || a.length < rank) {
			throw new IllegalArgumentException("The input array should have minimum " + rank + " number of elements");
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
		if (a == null || a.length < rank) {
			throw new IllegalArgumentException("The input array should have minimum " + rank + " number of elements");
		}
		
		List<Integer> sortedList = 
			Arrays
				.stream(a)
				.sorted()
				.distinct()
				.boxed()
				.collect(Collectors.toList());
		
		if (sortedList.size() < rank) {
			throw new IllegalArgumentException("No value is " + rank + "th smallest from the input array");
		}
		
		return sortedList.get(rank - 1);
	}
}
