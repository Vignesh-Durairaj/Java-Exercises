package com.vikhi.exercise;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class StringFunctionsTest {

	private static StringFunctions strFunctions;
	
	@BeforeClass
	public static void init() {
		strFunctions = new StringFunctions();
	}
	
	@Test
	public void testBinaryTreeTraversal() {
		BinaryTreeTraversal.main(new String[] {});
	}
	
	@Test
	public void testReversedSentence() {
		String sentence = "Fighting for simplicity";
		String reversedSentence = "simplicity for Fighting";
		
		Assert.assertEquals(reversedSentence, strFunctions.getReversedSentence(sentence));
		Assert.assertEquals(reversedSentence, strFunctions.getReversedSentenceWithStreams(sentence));
		
		String reversedCharSentence = "gnithgiF rof yticilpmis";
		Assert.assertEquals(reversedCharSentence, strFunctions.getReversedCharsInString(sentence));
	}
	
	@Test
	public void testPrintingShapes() {
		try {
			strFunctions.printPyramidNumbersDynamicRows(0);
			strFunctions.printPyramidNumbersDynamicRows(4);
			strFunctions.printPyramidNumbersDynamicRows(5);
			
			strFunctions.printPyramidNumbersStaticRows(0);
			strFunctions.printPyramidNumbersStaticRows(4);
			strFunctions.printPyramidNumbersStaticRows(5);
			
			strFunctions.printPyramidStars(0);
			strFunctions.printPyramidStars(4);
			strFunctions.printPyramidStars(5);
			
			strFunctions.printPyramidStarsUpright(0);
			strFunctions.printPyramidStarsUpright(4);
			strFunctions.printPyramidStarsUpright(5);
			
			strFunctions.printSymmetricPyramidNumbers(0);
			strFunctions.printSymmetricPyramidNumbers(4);
			strFunctions.printSymmetricPyramidNumbers(5);
			
			strFunctions.printRectangle(5, 10);
			strFunctions.printRectangle(15, 10);
			
			strFunctions.printSquare(5);
			
			strFunctions.printDiamondStars(0);
			strFunctions.printDiamondStars(5);
			strFunctions.printDiamondStars(6);
		} catch (Exception e) {
			Assert.fail("Failing this case explicitly because of exception : " + e.getMessage());
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPrintintMethodsNegativeCases() {
		strFunctions.printRectangle(0, 12);
		strFunctions.printRectangle(5, 0);
		
		strFunctions.printSquare(0);
		
		Assert.fail("Expected an exception, but not !");
	}
}
