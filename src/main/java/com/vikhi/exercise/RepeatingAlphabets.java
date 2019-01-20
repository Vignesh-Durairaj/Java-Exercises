package com.vikhi.exercise;

public class RepeatingAlphabets {

	public String getRepeatingAlphas(final int aCount, final int bCount) {
		int a = aCount, b = bCount;
		if (a == 0 && b == 0) {
			return "";
		} else if (a == 1 && b == 1) {
			return "ab";
		}
		
		StringBuilder builder = new StringBuilder();
		String lastPrinted = (a > b) ? "a" : "b";
		builder.append(lastPrinted);
		if (a > b) {
			a --;
		} else {
			b --;
		}
		
		while (a > 0 || b > 0) {
			
			if (builder.toString().endsWith("ab") || builder.toString().endsWith("ba")) {
				if (b >= a) {
					builder.append("b");
					b --;
				} else if (a > b) {
					builder.append("a");
					a --;
				}
			} else if (builder.toString().endsWith("aa")) {
				if (b > 0) {
					builder.append("b");
					b --;
				} else {
					builder.delete(0, builder.length());
					break;
				}
			} else if (builder.toString().endsWith("bb")) {
				if (a > 0) {
					builder.append("a");
					a --;
				} else {
					builder.delete(0, builder.length());
					break;
				}
			} else if (builder.toString().equals("a") || builder.toString().equals("b")) {
				if (a > b) {
					builder.append("a");
					a --;
				} else if (b > a) {
					builder.append("b");
					b --;
				}
			}
		}
		
		return builder.toString();
	}
}
