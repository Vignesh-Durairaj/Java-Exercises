package com.vikhi.exercise;

public class BinaryUtils {

	public long flip32BitNumber(final long number) {
		String binaryInt = Long.toBinaryString(number);
		int length = binaryInt.length();
		StringBuilder builder = new StringBuilder(binaryInt);
		
		for (int i = 1; i <= (32 - length); i++){
			builder.insert(0, '0');
		}
		
		binaryInt = builder.toString();
		builder = new StringBuilder();
		for (int i = 0; i < binaryInt.length(); i++) {
			builder.append(Integer.valueOf(String.valueOf(binaryInt.charAt(i))) ^ 1);
		}
		
		return Long.valueOf(builder.toString(), 2);
	}
}
