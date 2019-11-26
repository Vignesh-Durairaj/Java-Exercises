package com.vikhi.exercise.string;

import org.apache.log4j.Logger;

public class CrossBoxGenerator {

	private final Logger log = Logger.getLogger(this.getClass());
	
	public void printCrossBox(final int n) {
		
		StringBuilder builder;
		
		if(n <= 0) {
			throw new IllegalArgumentException("Input parameter should be greater than 0");
		}
		
		for (int i = 1; i <= n; i ++) {
			builder = new StringBuilder();
			for (int j = 1; j <= n; j ++) {
				if (i == 1 || i == n) {
					builder.append("#");
				} else {
					builder.append((j == 1 || j == n || j == i || j == (n - i + 1)) ? "#" : " ");
				}
			}
			log.info(builder.toString());
		}
	}
}
