package com.vikhi.exercise;

public class RepeatingAlphabets {

	private StringBuilder builder;
	int a;
	int b;
	
	public String getRepeatingAlphas(final int aCount, final int bCount) {
		a = aCount;
		b = bCount;
		if (a == 0 && b == 0) {
			return "";
		} else if (a == 1 && b == 1) {
			return "ab";
		}
		
		builder = new StringBuilder((a > b) ? "a" : "b");
		if (a > b) {
			a --;
		} else {
			b --;
		}
		
		constructStringBuffer();
		
		return builder.toString();
	}
	
	private void constructStringBuffer() {
		while (a > 0 || b > 0) {
			
			if (builder.toString().endsWith("ab")) {
				appendWhenAIsGreaterThanOrEqualsB();
			} else if (builder.toString().endsWith("ba")) {
				appendWhenBIsGreaterThanOrEqualsA();
			} else if (builder.toString().endsWith("aa")) {
				if (b > 0) {
					appendB();
				} else {
					builder.delete(0, builder.length());
					break;
				}
			} else if (builder.toString().endsWith("bb")) {
				if (a > 0) {
					appendA();
				} else {
					builder.delete(0, builder.length());
					break;
				}
			} else if (builder.toString().equals("a")) {
				appendWhenAIsGreaterThanB();
			} else if (builder.toString().equals("b")) {
				appendWhenAIsGreaterThanOrEqualsB();
			}
		}
	}
	
	private void appendWhenAIsGreaterThanOrEqualsB() {
		if (a >= b) {
			appendA();
		} else {
			appendB();
		}
	}
	
	private void appendWhenBIsGreaterThanOrEqualsA() {
		if (b >= a) {
			appendB();
		} else {
			appendA();
		}
	}
	
	private void appendWhenAIsGreaterThanB() {
		if (a > b) {
			appendA();
		} else {
			appendB();
		}
	}

	private void appendA() {
		builder.append("a");
		a --;
	}
	
	private void appendB() {
		builder.append("b");
		b --;
	}
	
}
