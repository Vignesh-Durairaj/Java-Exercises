package com.vikhi.main;

import com.vikhi.exercise.NumberUtils;
import com.vikhi.exercise.StringFunctions;

public class GeneralMain {

	public static void main(String[] args) {
		StringFunctions sf = new StringFunctions();
		sf.printDiamondStars(5);
		sf.printDiamondStars(6);
		sf.printDiamondStars(7);
		sf.printDiamondStars(10);
		
		System.out.println(NumberUtils.getDivisibleSums(20));
		System.out.println(NumberUtils.isValidISBN(8535902775L));
		System.out.println(NumberUtils.isValidISBN(1843369283L));
		
		System.out.println(NumberUtils.isConsecutiveDigitNum(1234567));
		System.out.println(NumberUtils.isConsecutiveDigitNum(2146));
	}
}
