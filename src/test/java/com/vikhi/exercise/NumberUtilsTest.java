package com.vikhi.exercise;

import static com.vikhi.exercise.NumberUtils.countPrimes;
import static com.vikhi.exercise.NumberUtils.getAbundantNumbers;
import static com.vikhi.exercise.NumberUtils.getAmicableSums;
import static com.vikhi.exercise.NumberUtils.getAreaOfTriangle;
import static com.vikhi.exercise.NumberUtils.getAverage;
import static com.vikhi.exercise.NumberUtils.getDigitOccurence;
import static com.vikhi.exercise.NumberUtils.getDivisibleSums;
import static com.vikhi.exercise.NumberUtils.getLastNumberSamples;
import static com.vikhi.exercise.NumberUtils.getOddSum;
import static com.vikhi.exercise.NumberUtils.getOneCounts;
import static com.vikhi.exercise.NumberUtils.getPosAndNegAverages;
import static com.vikhi.exercise.NumberUtils.getQuadrant;
import static com.vikhi.exercise.NumberUtils.getSeconds;
import static com.vikhi.exercise.NumberUtils.isAbundantNumber;
import static com.vikhi.exercise.NumberUtils.isAmicable;
import static com.vikhi.exercise.NumberUtils.isBinary;
import static com.vikhi.exercise.NumberUtils.isConsecutiveDigitNum;
import static com.vikhi.exercise.NumberUtils.isKaprekarNumber;
import static com.vikhi.exercise.NumberUtils.isPerfectNumber;
import static com.vikhi.exercise.NumberUtils.isPrime;
import static com.vikhi.exercise.NumberUtils.isValidISBN;
import static com.vikhi.exercise.NumberUtils.getSumOfDigitsBetween;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.vikhi.pojo.NumberModel;

public class NumberUtilsTest {

	@Test
	public void testNumberSwap() {
		int a = 10; 
		int b = 15;
		NumberModel numberModel = new NumberModel();
		numberModel.setA(a);
		numberModel.setB(b);
		
		NumberUtils.swapNumber(numberModel);
		assertTrue(a == numberModel.getB());
		assertTrue(b == numberModel.getA());
		assertNotNull(numberModel.toString());
		
		NumberUtils.smartSwapNumber(numberModel);
		assertTrue(a == numberModel.getA());
		assertTrue(b == numberModel.getB());
		assertNotNull(numberModel.toString());
	}
	
	@Test
	public void testIsBinary() {
		assertTrue(isBinary(1011));
		assertFalse(isBinary(1234));
		assertTrue(isBinary(000));
		assertTrue(isBinary(111));
	}
	
	@Test
	public void testPositiveCases() {
		try {
			getLastNumberSamples(10, 3);
			getPosAndNegAverages(new int[]{1, 2, -3, 4, -2, -9, 4});
			getPosAndNegAverages(new int[]{1, 2, -3, 4, -2, -9, 0, -4});
		} catch (Exception e) {
			fail("Failed the executions");
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegativeCases() {
		getLastNumberSamples(3, 15);
		fail("This case is suppose to throw an exception, but not");
	}
	
	@Test
	public void testDigitOccurence() {
		assertSame(3, getDigitOccurence(121315, 1));
		assertSame(0, getDigitOccurence(123456, 7));
		assertSame(2, getDigitOccurence(15972421, 2));
		assertSame(1, getDigitOccurence(1234567, 5));
	}
	
	@Test
	public void testIsAmicable() {
		assertTrue(isAmicable(6L));
		assertFalse(isAmicable(16L));
		assertTrue(isAmicable(220L));
	}
	
	@Test
	public void testAmicableSums() {
		assertEquals(6, getAmicableSums(20));
		assertEquals(34, getAmicableSums(30));
	}
	
	@Test
	public void testDivisbleSums() {
		assertEquals(23, getDivisibleSums(10));
		assertEquals(78, getDivisibleSums(20));
	}
	
	@Test
	public void testIsValidISBN() {
		assertTrue(isValidISBN(8535902775L));
		assertFalse(isValidISBN(1843369283L));
		assertFalse(isValidISBN(18433693L));
		assertFalse(isValidISBN(184336928334L));
	}
	
	@Test
	public void testIsConsecutiveDigitSum() {
		assertTrue(isConsecutiveDigitNum(12345));
		assertFalse(isConsecutiveDigitNum(12354));
		assertTrue(isConsecutiveDigitNum(6789));
	}
	
	@Test
	public void testArmstrongNumbers() {
		ArmstrongNumbers an = new ArmstrongNumbers();
		
		assertTrue(an.isArmstrongNumber(4210818));
		assertTrue(an.isArmstrongNumberFaster(146511208));
		assertFalse(an.isArmstrongNumberFaster(93085));
	}
	
	@Test
	public void testArmstrongNumbersPrint() {
		ArmstrongNumbers an = new ArmstrongNumbers();
		try {
			an.getArmstrongNumbers();
			an.getArmstrongNumbersFaster();
		} catch(Exception e) {
			fail("Exception ecnountered !");
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidTestCase() {
		getPosAndNegAverages(null);
		fail("Exception is expected, but was not");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEmptyInputTestCase() {
		getPosAndNegAverages(new int[] {});
		fail("Exception is expected, but was not");
	}
	
	@Test
	public void testFactorials() {
		Factorials factorial = new Factorials();
		
		assertEquals(1, factorial.getFactorial(0));
		assertEquals(1, factorial.getFactorialRecursive(0));
		assertEquals(1, factorial.getFactorialWithStreams(0));
		
		assertEquals(1, factorial.getFactorial(1));
		assertEquals(1, factorial.getFactorialRecursive(1));
		assertEquals(1, factorial.getFactorialWithStreams(1));
		
		assertEquals(120, factorial.getFactorial(5));
		assertEquals(120, factorial.getFactorialRecursive(5));
		assertEquals(120, factorial.getFactorialWithStreams(5));
	}
	
	@Test
	public void testLuckyNumberGenerator() {
		LuckyNumberGenerator lng = new LuckyNumberGenerator();
		
		assertEquals(6, lng.getLuckyNumberAsSum(213));
		assertEquals(3, lng.getLuckyNumberAsSum(3));
	}
	
	@Test
	public void testLuckyNumberGeneratorWithStreams() {
		LuckyNumberGenerator lng = new LuckyNumberGenerator();
		
		assertEquals(6, lng.getLuckyNumberUsingStreams(213));
		assertEquals(3, lng.getLuckyNumberUsingStreams(3));
	}
	
	@Test
	public void testOddSum() {
		assertEquals(25, getOddSum(10));
		assertEquals(64, getOddSum(15));
		assertEquals(0, getOddSum(0));
	}
	
	@Test
	public void testQuadrantIdentifier() {
		assertEquals(1, getQuadrant(362));
		assertEquals(2, getQuadrant(92));
		assertEquals(3, getQuadrant(197));
		assertEquals(4, getQuadrant(301));
		assertEquals(1, getQuadrant(30));
		assertEquals(1, getQuadrant(90));
		assertEquals(2, getQuadrant(180));
		assertEquals(3, getQuadrant(270));
		assertEquals(4, getQuadrant(271));
		assertEquals(3, getQuadrant(181));
	}
	
	@Test
	public void testIsPrime() {
		assertFalse(isPrime(1));
		assertTrue(isPrime(2));
		assertTrue(isPrime(3));
		assertFalse(isPrime(4));
		assertTrue(isPrime(5));
		assertTrue(isPrime(19));
		assertFalse(isPrime(21));
		assertFalse(isPrime(1000));
	}
	
	@Test
	public void testOneCounts() {
		assertEquals(4, getOneCounts(1, 11));
		assertEquals(34, getOneCounts(11, 111));
		assertEquals(36, getOneCounts(1, 111));
	}
	
	@Test
	public void testPerfectNumbers() {
		assertTrue(isPerfectNumber(6));
		assertTrue(isPerfectNumber(28));
		assertTrue(isPerfectNumber(496));
		
		assertFalse(isPerfectNumber(10));
		assertFalse(isPerfectNumber(1));
		assertFalse(isPerfectNumber(25));
	}
	
	@Test
	public void testAreaOfTriangle() {
		assertEquals(0, getAreaOfTriangle(0, 0, 0), 0.0001D);
		assertEquals(0, getAreaOfTriangle(1, 2, 3), 1D);
		assertEquals(4.898, getAreaOfTriangle(1, 2, 5), 1D);
	}
	
	@Test
	public void testSecondsMethods() {
		assertEquals(39010, getSeconds(10, 50, 10));
		assertEquals(44705, getSeconds(12, 25, 5));
		assertEquals(605, getSeconds(0, 10, 5));
	}
	
	@Test
	public void testIsAbundant() {
		assertTrue(isAbundantNumber(12));
		assertTrue(isAbundantNumber(18));
		assertTrue(isAbundantNumber(20));
		
		assertFalse(isAbundantNumber(1));
		assertFalse(isAbundantNumber(10));
	}
	
	@Test
	public void testPrintintAbundantNumbers() {
		getAbundantNumbers(20);
		getAbundantNumbers(40);
		assertEquals("String", "String");
	}
	
	@Test
	public void testPrimeCount() {
		assertEquals(78498, countPrimes(1000001));
		assertEquals(25, countPrimes(100));
		assertEquals(0, countPrimes(1));
	}
	
	@Test
	public void testAverage() {
		List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Double average = getAverage(ints);
		assertNotNull(average);
		assertEquals(Double.valueOf(5.5), average);
		
		average = getAverage(Arrays.asList());
		assertNull(average);
	}
	
	@Test
	public void testSumOfDigitsBetween() {
		assertEquals(3, getSumOfDigitsBetween(10, 11));
		assertEquals(2, getSumOfDigitsBetween(-10, 11));
		assertEquals(15, getSumOfDigitsBetween(7, 8));
		assertEquals(-29, getSumOfDigitsBetween (-20, -17));
		assertEquals(6, getSumOfDigitsBetween(10, 12));
		assertEquals(-19, getSumOfDigitsBetween(-22, -19));
		assertEquals(0, getSumOfDigitsBetween(-19, -22));
	}
	
	@Test
	public void testKaprekarNumbers() {
		assertTrue(isKaprekarNumber(1));
		assertTrue(isKaprekarNumber(9));
		assertTrue(isKaprekarNumber(45));
		assertTrue(isKaprekarNumber(55));
		assertTrue(isKaprekarNumber(99));
		assertTrue(isKaprekarNumber(297));
		assertTrue(isKaprekarNumber(703));
		assertTrue(isKaprekarNumber(999));
		
		assertFalse(isKaprekarNumber(2));
		assertFalse(isKaprekarNumber(81));
	}
}
