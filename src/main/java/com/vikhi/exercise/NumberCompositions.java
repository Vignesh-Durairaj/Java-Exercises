package com.vikhi.exercise;

import java.math.BigInteger;

public class NumberCompositions {

	public BigInteger getDiceCompositions (int spaceCovered) {
		BigInteger[] probabilityCount = new BigInteger [spaceCovered + 1];
		probabilityCount[0] = BigInteger.valueOf(1);
		
		if (spaceCovered > 0) {
			probabilityCount[1] = BigInteger.valueOf(1);
		}
		
		for(int i = 2; i < spaceCovered + 1; i ++) {
	        for(int j = 1; (j <= 6 && (i - j) >= 0) ; j ++) {
	        	if (probabilityCount[i] == null){
	        		probabilityCount[i] = BigInteger.ZERO;
	        	}
	        	probabilityCount[i] = probabilityCount[i].add(probabilityCount[i - j]);
	        }
	    }
		
		return probabilityCount[spaceCovered];
	}
}
