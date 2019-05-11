package com.vikhi.exercise;

import java.util.Date;

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
	
	@Test
	public void testCalendarUtil() {
		CalendarUtils cu = new CalendarUtils();
		Date prevMonthDate = cu.getPreviousMonthLastDate();
		
		Assert.assertNotNull(prevMonthDate);
		Assert.assertSame(Date.class, prevMonthDate.getClass());
	}
	
	@Test
	public void testCharIterations() {
		try {
			CharIterations.main(null);
		} catch (Exception e) {
			Assert.fail("Encountered an exception !");
		}
	}
	
	@Test
	public void testCrossBoxGeneration() {
		CrossBoxGenerator cbg = new CrossBoxGenerator();
		try {
			cbg.printCrossBox(10);
			cbg.printCrossBox(7);
		} catch(Exception e) {
			Assert.fail("Encountered an exception !");
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidCrossBoxGeneration() {
		CrossBoxGenerator cbg = new CrossBoxGenerator();
		cbg.printCrossBox(-1);
	}
	
	@Test
	public void testCryptography() {
		String inputString = "Vignesh Durairaj";
		CryptoGraphy crypto = new CryptoGraphy();
		
		String encryptedString = crypto.encrypt(inputString);
		String decryptedString = crypto.decrypt(encryptedString);
		
		Assert.assertNotNull(encryptedString);
		Assert.assertNotNull(decryptedString);
		Assert.assertFalse(encryptedString.equals(inputString));
		Assert.assertTrue(decryptedString.equals(inputString));
	}
}
