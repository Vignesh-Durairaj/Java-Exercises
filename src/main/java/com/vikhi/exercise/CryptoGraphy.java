package com.vikhi.exercise;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CryptoGraphy {

	private static final String MASK_SEPARATOR = "|";
	
	public String encrypt (final String inputString) {
		String encryptedString = null;
		if (inputString != null && inputString.trim() != "") {
			char[] charArr = inputString.toCharArray();
			List<String> charMapList = 
					IntStream
						.range(0, charArr.length)
						.mapToObj(idx -> String.valueOf(Integer.valueOf(charArr[idx])))
						.collect(Collectors.toList());
			encryptedString = String.join(MASK_SEPARATOR, charMapList);
		}
		return encryptedString;
	}
	
	public String decrypt (final String encryptedString) {
		String decryptedString = null;
		if (encryptedString != null && !encryptedString.trim().equals("")) {
			String[] strArray = encryptedString.split("\\" + MASK_SEPARATOR);
			List<String> charList = 
					IntStream
						.range(0, strArray.length)
						.mapToObj(idx -> String.valueOf((char)Integer.parseInt(strArray[idx])))
						.collect(Collectors.toList());
			decryptedString = String.join("", charList);
		}
		return decryptedString;
	}
}
