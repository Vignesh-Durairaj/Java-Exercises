package com.vikhi.exercise.string;

public class CrossBoxGenerator {

	public void printCrossBox(final int n) {
		if(n <= 0) {
			throw new IllegalArgumentException("Input parameter should be greater than 0");
		}
		
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= n; j ++) {
				if (i == 1 || i == n) {
					System.out.print("#");
				} else {
					System.out.print((j == 1 || j == n || j == i || j == (n - i + 1)) ? "#" : " ");
				}
			}
			System.out.println("");
		}
	}
}
