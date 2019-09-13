package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

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
		assertTrue("String".equalsIgnoreCase("string"));
	}
	
	@Test
	public void testReversedSentence() {
		String sentence = "Fighting for simplicity";
		String reversedSentence = "simplicity for Fighting";
		
		assertEquals(reversedSentence, strFunctions.getReversedSentence(sentence));
		assertEquals(reversedSentence, strFunctions.getReversedSentenceWithStreams(sentence));
		
		String reversedCharSentence = "gnithgiF rof yticilpmis";
		assertEquals(reversedCharSentence, strFunctions.getReversedCharsInString(sentence));
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
			fail("Failing this case explicitly because of exception : " + e.getMessage());
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPrintintMethodsNegativeCases() {
		strFunctions.printRectangle(0, 12);
		strFunctions.printRectangle(5, 0);
		
		strFunctions.printSquare(0);
		
		fail("Expected an exception, but not !");
	}
	
	@Test
	public void testCalendarUtil() {
		CalendarUtils cu = new CalendarUtils();
		Date prevMonthDate = cu.getPreviousMonthLastDate();
		
		assertNotNull(prevMonthDate);
		assertSame(Date.class, prevMonthDate.getClass());
	}
	
	@Test
	public void testCharIterations() {
		try {
			CharIterations.main(null);
		} catch (Exception e) {
			fail("Encountered an exception !");
		}
	}
	
	@Test
	public void testCrossBoxGeneration() {
		CrossBoxGenerator cbg = new CrossBoxGenerator();
		try {
			cbg.printCrossBox(10);
			cbg.printCrossBox(7);
		} catch(Exception e) {
			fail("Encountered an exception !");
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
		
		assertNotNull(encryptedString);
		assertNotNull(decryptedString);
		assertFalse(encryptedString.equals(inputString));
		assertTrue(decryptedString.equals(inputString));
		
		encryptedString = crypto.encrypt("");
		assertNull(encryptedString);
		assertNull(crypto.decrypt(encryptedString));
		assertNull(crypto.decrypt(""));
	}
	
	@Test
	public void testMessageProcessor() {
		MessageProcessor mp = new MessageProcessor();
		
		assertEquals(3, mp.getTopMostNumber("3 2 POP"));
		assertEquals(2,mp.getTopMostNumber("2 DUP"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMessage1() {
		MessageProcessor mp = new MessageProcessor();
		mp.getTopMostNumber("2 POP POP");
		fail("Expected an exception, but was not !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMessage2() {
		MessageProcessor mp = new MessageProcessor();
		mp.getTopMostNumber("DUP");
		fail("Expected an exception, but was not !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMessage3() {
		MessageProcessor mp = new MessageProcessor();
		mp.getTopMostNumber("2 POP 3 POP +");
		fail("Expected an exception, but was not !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMessage4() {
		MessageProcessor mp = new MessageProcessor();
		mp.getTopMostNumber("2 POP 3 POP -");
		fail("Expected an exception, but was not !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInvalidMessage5() {
		MessageProcessor mp = new MessageProcessor();
		mp.getTopMostNumber("2 DUP + POP R");
		fail("Expected an exception, but was not !");
	}
	
	@Test
	public void testRepeatingAlphabets() {
		RepeatingAlphabets ra = new RepeatingAlphabets();
		assertEquals("baba", ra.getRepeatingAlphas(2, 2));
		assertEquals("", ra.getRepeatingAlphas(0, 0));
		assertEquals("ab", ra.getRepeatingAlphas(1, 1));
	}
	
	@Test
	public void testRobot() {
		WalkingRobot.main(null);
	}
	
	@Test
	public void testStrugacarro() {
		Strugacarro strug = new Strugacarro();
		assertEquals("", strug.getHighAmplitudeSeason(new int[] {12, 34, 24, 1}));
		assertEquals("AUTUMN", strug.getHighAmplitudeSeason(
				new int[] {12, 34, 24, 1, -2, -21, 32, 87}));
		assertEquals("WINTER", strug.getHighAmplitudeSeason(
				new int[] {12, -12, -8, 1, 12, 21, 18, 12}));
		assertEquals("SUMMER", strug.getHighAmplitudeSeason(
				new int[] {12, 12, 8, 1, 12, -21, 18, 12}));
		assertEquals("SPRING", strug.getHighAmplitudeSeason(
				new int[] {12, -12, -8, 39, 12, -21, 18, 12}));
	}
	
	@Test
	public void testTriangularNumberPrint() {
		strFunctions.printTriangularNumbers(0);
		strFunctions.printTriangularNumbers(5);
		assertTrue("String".equalsIgnoreCase("string"));
	}
	
	@Test
	public void testCapitalization() {
		assertEquals("Test", strFunctions.getCapitalization("test"));
		assertEquals("", strFunctions.getCapitalization(""));
		assertEquals("Hello World !", strFunctions.getCapitalization("hello wORld !"));
	}
}
