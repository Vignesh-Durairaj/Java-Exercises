package com.vikhi.main;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SmallestNonAdjacentSum {

	private static int getSmallestNonAdjacentSum(final int[] intArr) {
		// TODO: Implement this
		return 0;
	}
	
	public static void main(String[] args) {
		assertValues(new int[] {1, 2, 3, 4}, 4, false);
		assertValues(new int[] {1, 6, 2, 5, 1, 6}, 2, false);
		assertValues(new int[] {1, 2, 2, 4, 6}, 3, false);
		assertValues(new int[] {-1, -4, 0, 4, 1, 0, 1}, -4, false);
		assertValues(null, -1, true);
		assertValues(new int[] {}, -1, true);
		assertValues(new int[] {1}, -1, true);
	}
	
	private static void assertValues(int[] input, int expected, boolean expectedAnyException) {
		String inputArrayString = input == null ? "null" : IntStream.of(input).mapToObj(Integer::toString).collect(Collectors.joining(", "));
		System.out.print("For input [" + inputArrayString +"] : ");
		
		try {
			int actual = getSmallestNonAdjacentSum(input);
			if (expectedAnyException) {
				System.out.println("FAIL. An exception is expected to be thrown.");
				return;
			}
			if (actual == expected) {
				System.out.println("PASS");
			} else {
				System.out.println(String.format("FAIL. Expected %s but got %s.", expected, actual));
			}
		} catch (Exception e) {
			if (expectedAnyException) {
				System.out.println("PASS");
			} else {
				System.out.println("FAIL. Exception thrown.");
				e.printStackTrace();
			}
		}
	}
}
