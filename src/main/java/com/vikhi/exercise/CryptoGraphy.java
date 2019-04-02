package com.vikhi.exercise;

public class CryptoGraphy {

	private static final String MASK_SEPARATOR = "|";
	
	public String decrypt(final String encryptedString) {
		StringBuilder builder = new StringBuilder(0);
        
       if (null != encryptedString && encryptedString.trim() != "") {
              String[] strArray = encryptedString.split(MASK_SEPARATOR);
                     for (String str : strArray) {
                           builder.append((char) Integer.parseInt(str));
                     }
              }
       return builder.toString();
	}
}
