package com.vikhi.exercise;

public class CrossBoxGenerator {

	public void printCrossBox(final int n) {
		if(n <= 0) {
			throw new IllegalArgumentException("Innput parameter should be greater than 0");
		}
		
		for (int i = 1; i <= n; i ++) {
			for (int j = 1; j <= n; j ++) {
				if (i == 1 || i == n) {
					System.out.print("#");
				} else {
					if (j == 1 || j == n || j == i || j == (n - i + 1)) {
						System.out.print("#");
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println("");
		}
	}
}
