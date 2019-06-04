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
		
		encryptedString = crypto.encrypt("");
		Assert.assertNull(encryptedString);
		Assert.assertNull(crypto.decrypt(encryptedString));
		Assert.assertNull(crypto.decrypt(""));
	}
	
	@Test
	public void testMessageProcessor() {
		MessageProcessor mp = new MessageProcessor();
		
		Assert.assertEquals(3, mp.getTopMostNumber("3 2 POP"));
		Assert.assertEquals(2,mp.getTopMostNumber("2 DUP"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMessage1() {
		MessageProcessor mp = new MessageProcessor();
		mp.getTopMostNumber("2 POP POP");
		Assert.fail("Expected an exception, but was not !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMessage2() {
		MessageProcessor mp = new MessageProcessor();
		mp.getTopMostNumber("DUP");
		Assert.fail("Expected an exception, but was not !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMessage3() {
		MessageProcessor mp = new MessageProcessor();
		mp.getTopMostNumber("2 POP 3 POP +");
		Assert.fail("Expected an exception, but was not !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMessage4() {
		MessageProcessor mp = new MessageProcessor();
		mp.getTopMostNumber("2 POP 3 POP -");
		Assert.fail("Expected an exception, but was not !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMessage5() {
		MessageProcessor mp = new MessageProcessor();
		mp.getTopMostNumber("2 DUP + POP R");
		Assert.fail("Expected an exception, but was not !");
	}
	
	@Test
	public void testRepeatingAlphabets() {
		RepeatingAlphabets ra = new RepeatingAlphabets();
		Assert.assertEquals("baba", ra.getRepeatingAlphas(2, 2));
		Assert.assertEquals("", ra.getRepeatingAlphas(0, 0));
		Assert.assertEquals("ab", ra.getRepeatingAlphas(1, 1));
	}
	
	@Test
	public void testRobot() {
		WalkingRobot.main(null);
	}
	
	@Test
	public void testStrugacarro() {
		Strugacarro strug = new Strugacarro();
		Assert.assertEquals("", strug.getHighAmplitudeSeason(new int[] {12, 34, 24, 1}));
		Assert.assertEquals("AUTUMN", strug.getHighAmplitudeSeason(
				new int[] {12, 34, 24, 1, -2, -21, 32, 87}));
		Assert.assertEquals("WINTER", strug.getHighAmplitudeSeason(
				new int[] {12, -12, -8, 1, 12, 21, 18, 12}));
		Assert.assertEquals("SUMMER", strug.getHighAmplitudeSeason(
				new int[] {12, 12, 8, 1, 12, -21, 18, 12}));
		Assert.assertEquals("SPRING", strug.getHighAmplitudeSeason(
				new int[] {12, -12, -8, 39, 12, -21, 18, 12}));
	}
	
	@Test
	public void testTriangularNumberPrint() {
		strFunctions.printTriangularNumbers(0);
		strFunctions.printTriangularNumbers(5);
	}
	
	@Test
	public void testCapitalization() {
		Assert.assertEquals("Test", strFunctions.getCapitalization("test"));
		Assert.assertEquals("", strFunctions.getCapitalization(""));
		Assert.assertEquals("Hello World !", strFunctions.getCapitalization("hello wORld !"));
	}
}
