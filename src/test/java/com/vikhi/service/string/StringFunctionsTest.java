package com.vikhi.service.string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.vikhi.exercise.datastrucutres.BinaryTreeTraversal;
import com.vikhi.exercise.scenario.Strugacarro;
import com.vikhi.exercise.string.CharIterations;
import com.vikhi.exercise.string.CrossBoxGenerator;
import com.vikhi.exercise.string.CryptoGraphy;
import com.vikhi.exercise.string.MessageProcessor;
import com.vikhi.exercise.string.RepeatingAlphabets;
import com.vikhi.exercise.string.StringFunctions;
import com.vikhi.util.CalendarUtils;

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
	public void testPrintRectangleWithZeroWidth() {
		strFunctions.printRectangle(0, 12);
		fail("Expected an exception, but not !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPrintRectangleWithZeroHeight() {
		strFunctions.printRectangle(5, 0);
		fail("Expected an exception, but not !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPrintRectangleWithZeroWidthAndHeight() {
		strFunctions.printRectangle(0, 0);
		strFunctions.printSquare(0);
		fail("Expected an exception, but not !");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPrintRSquareWithZeroSize() {
		strFunctions.printSquare(0);
		fail("Expected an exception, but not !");
	}
	
	@Test
	public void testCalendarUtil() {
		CalendarUtils cu = new CalendarUtils();
		Date prevMonthDate = cu.getPreviousMonthLastDate();
		
		assertNotNull(prevMonthDate);
		assertSame(Date.class, prevMonthDate.getClass());
		
		prevMonthDate = cu.getPreviousMonthLastDate(0);
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
		
		inputString = null;
		encryptedString = crypto.encrypt(inputString);
		decryptedString = crypto.decrypt(encryptedString);
		
		assertNull(encryptedString);
		assertNull(decryptedString);
		
		inputString = "";
		encryptedString = crypto.encrypt(inputString);
		decryptedString = crypto.decrypt(encryptedString);
		
		assertNull(encryptedString);
		assertNull(decryptedString);
	}
	
	@Test
	public void testMessageProcessor() {
		MessageProcessor mp = new MessageProcessor();
		
		assertEquals(3, mp.getTopMostNumber("3 2 POP"));
		assertEquals(2,mp.getTopMostNumber("2 DUP"));
		assertEquals(0,mp.getTopMostNumber("2 DUP -"));
		assertEquals(6,mp.getTopMostNumber("2 DUP 5 - 3 DUP +"));
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
		assertEquals("b", ra.getRepeatingAlphas(0, 1));
		assertEquals("a", ra.getRepeatingAlphas(1, 0));
		assertEquals("aba", ra.getRepeatingAlphas(2, 1));
		assertEquals("bab", ra.getRepeatingAlphas(1, 2));
		assertEquals("ababa", ra.getRepeatingAlphas(3, 2));
		assertEquals("babab", ra.getRepeatingAlphas(2, 3));
		assertEquals("bababa", ra.getRepeatingAlphas(3, 3));
		assertEquals("bbabab", ra.getRepeatingAlphas(2, 4));
		assertEquals("aababa", ra.getRepeatingAlphas(4, 2));
		assertEquals("aa", ra.getRepeatingAlphas(2, 0));
		assertEquals("bb", ra.getRepeatingAlphas(0, 2));
		assertEquals("", ra.getRepeatingAlphas(0, 3));
		assertEquals("", ra.getRepeatingAlphas(3, 0));
		assertEquals("bbabb", ra.getRepeatingAlphas(1, 4));
		assertEquals("bbab", ra.getRepeatingAlphas(1, 3));
		assertEquals("aaba", ra.getRepeatingAlphas(3, 1));
		assertEquals("bababa", ra.getRepeatingAlphas(3, 3));
		assertEquals("aabaa", ra.getRepeatingAlphas(4, 1));
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
	
	@Test
	public void testIntToString() {
		List<Integer> ints = Arrays.asList(23,4,1,56,7,91,3);
		String intString = strFunctions.getStringFromNumbers(ints);
		assertNotNull(intString);
		assertEquals("23o,4e,1o,56e,7o,91o,3o", intString);
	}
	
	@Test
	public void testUpperCaseConversion() {
		List<String> inStrings = Arrays.asList("Vignesh", "Durairaj");
		List<String> outString = strFunctions.convertToUpperCase(inStrings);
		assertNotNull(outString);
		assertEquals("VIGNESH", outString.get(0));
		assertEquals("DURAIRAJ", outString.get(1));
	}
	
	
	@Test
	public void testNonDuplicatedValue() {
		assertEquals("bans", strFunctions.getNonDuplicatedValue("bananas"));
		assertEquals("progamin", strFunctions.getNonDuplicatedValue("programming"));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsciiSortedStringForNullInput() {
		assertNull(strFunctions.asciiSortedString(null));
		fail("An exception is expected and should not come upto this line");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsciiSortedStringForEmptyInput() {
		assertNull(strFunctions.asciiSortedString(""));
		fail("An exception is expected and should not come upto this line");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAsciiSortedStringForWhiteSpaceAsInput() {
		assertNull(strFunctions.asciiSortedString(" "));
		fail("An exception is expected and should not come upto this line");
	}
	
	@Test
	public void testAsciiSortedString() {
		assertEquals("eegks", strFunctions.asciiSortedString("geeks"));
		assertEquals(" !HWdellloor", strFunctions.asciiSortedString("Hello World!"));
		assertEquals(" !dehllloorw", strFunctions.asciiSortedString("hello world!"));
	}
	
	@Test
	public void testMaskify() {
		assertEquals("############5616", strFunctions.maskify("4556364607935616"));
		assertEquals("#######5616", strFunctions.maskify("64607935616"));
		assertEquals("1", strFunctions.maskify("1"));
		assertEquals("", strFunctions.maskify(""));
		assertEquals("##ippy", strFunctions.maskify("Skippy"));
		assertEquals("####################################man!", strFunctions.maskify("Nananananananananananananananana Batman!"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testMaskifyForFailure() {
		assertEquals("test", strFunctions.maskify(null));
		fail("Not suppose to execute this.");
	}
	
	@Test
	public void testDuplicatesInString() {
		assertEquals(0, strFunctions.getDuplicateCount("abcde"));
		assertEquals(1, strFunctions.getDuplicateCount("abcdea"));
		assertEquals(1, strFunctions.getDuplicateCount("indivisibility"));
		assertEquals(2, strFunctions.getDuplicateCount("Indivisibilities"));
		assertEquals(2, strFunctions.getDuplicateCount("aA11"));
		assertEquals(2, strFunctions.getDuplicateCount("ABBA"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDuplicatesForNull() {
		assertEquals(0, strFunctions.getDuplicateCount(null));
		fail("Not suppose to execute this.");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDuplicatesForEmptyString() {
		assertEquals(0, strFunctions.getDuplicateCount(""));
		fail("Not suppose to execute this.");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDuplicatesForSpace() {
		assertEquals(0, strFunctions.getDuplicateCount(" "));
		fail("Not suppose to execute this.");
	}
	
	@Test
	public void testValidBraces() {
		assertTrue(strFunctions.areValidBraces("(){}[]"));
		assertTrue(strFunctions.areValidBraces("([{}])"));
		assertFalse(strFunctions.areValidBraces("(}"));
		assertFalse(strFunctions.areValidBraces("[(])"));
		assertFalse(strFunctions.areValidBraces("[({})](]"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidBracesForNull() {
		assertEquals("test", strFunctions.areValidBraces(null));
		fail("Not suppose to execute this.");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidBracesForEmptyString() {
		assertEquals(0, strFunctions.areValidBraces(""));
		fail("Not suppose to execute this.");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testValidBracesForSpace() {
		assertEquals(0, strFunctions.areValidBraces(" "));
		fail("Not suppose to execute this.");
	}
	
	@Test
	public void testPangram() {
		assertTrue(strFunctions.isPangram("The quick brown fox jumps over the lazy dog."));
		assertFalse(strFunctions.isPangram("You shall not pass!"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPangramForNull() {
		assertTrue(strFunctions.isPangram(null));
		fail("Not suppose to execute this.");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPangramForEmptyString() {
		assertTrue(strFunctions.isPangram(""));
		fail("Not suppose to execute this.");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPangramForSpace() {
		assertTrue(strFunctions.isPangram(" "));
		fail("Not suppose to execute this.");
	}
}
