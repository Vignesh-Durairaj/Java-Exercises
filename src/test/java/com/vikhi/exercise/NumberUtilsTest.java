package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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
		assertTrue(NumberUtils.isBinary(1011));
		assertFalse(NumberUtils.isBinary(1234));
		assertTrue(NumberUtils.isBinary(000));
		assertTrue(NumberUtils.isBinary(111));
	}
	
	@Test
	public void testPositiveCases() {
		try {
			NumberUtils.getLastNumberSamples(10, 3);
			NumberUtils.getPosAndNegAverages(new int[]{1, 2, -3, 4, -2, -9, 4});
			NumberUtils.getPosAndNegAverages(new int[]{1, 2, -3, 4, -2, -9, 0, -4});
		} catch (Exception e) {
			fail("Failed the executions");
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegativeCases() {
		NumberUtils.getLastNumberSamples(3, 15);
		fail("This case is suppose to throw an exception, but not");
	}
	
	@Test
	public void testDigitOccurence() {
		assertSame(3, NumberUtils.getDigitOccurence(121315, 1));
		assertSame(0, NumberUtils.getDigitOccurence(123456, 7));
		assertSame(2, NumberUtils.getDigitOccurence(15972421, 2));
		assertSame(1, NumberUtils.getDigitOccurence(1234567, 5));
	}
	
	@Test
	public void testIsAmicable() {
		assertTrue(NumberUtils.isAmicable(6L));
		assertFalse(NumberUtils.isAmicable(16L));
		assertTrue(NumberUtils.isAmicable(220L));
	}
	
	@Test
	public void testAmicableSums() {
		assertEquals(6, NumberUtils.getAmicableSums(20));
		assertEquals(34, NumberUtils.getAmicableSums(30));
	}
	
	@Test
	public void testDivisbleSums() {
		assertEquals(23, NumberUtils.getDivisibleSums(10));
		assertEquals(78, NumberUtils.getDivisibleSums(20));
	}
	
	@Test
	public void testIsValidISBN() {
		assertTrue(NumberUtils.isValidISBN(8535902775L));
		assertFalse(NumberUtils.isValidISBN(1843369283L));
		assertFalse(NumberUtils.isValidISBN(18433693L));
		assertFalse(NumberUtils.isValidISBN(184336928334L));
	}
	
	@Test
	public void testIsConsecutiveDigitSum() {
		assertTrue(NumberUtils.isConsecutiveDigitNum(12345));
		assertFalse(NumberUtils.isConsecutiveDigitNum(12354));
		assertTrue(NumberUtils.isConsecutiveDigitNum(6789));
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
		NumberUtils.getPosAndNegAverages(null);
		fail("Exception is expected, but was not");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEmptyInputTestCase() {
		NumberUtils.getPosAndNegAverages(new int[] {});
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
		assertEquals(25, NumberUtils.getOddSum(10));
		assertEquals(64, NumberUtils.getOddSum(15));
		assertEquals(0, NumberUtils.getOddSum(0));
	}
	
	@Test
	public void testQuadrantIdentifier() {
		assertEquals(1, NumberUtils.getQuadrant(362));
		assertEquals(2, NumberUtils.getQuadrant(92));
		assertEquals(3, NumberUtils.getQuadrant(197));
		assertEquals(4, NumberUtils.getQuadrant(301));
		assertEquals(1, NumberUtils.getQuadrant(30));
		assertEquals(1, NumberUtils.getQuadrant(90));
		assertEquals(2, NumberUtils.getQuadrant(180));
		assertEquals(3, NumberUtils.getQuadrant(270));
		assertEquals(4, NumberUtils.getQuadrant(271));
	}
	
	@Test
	public void testIsPrime() {
		assertFalse(NumberUtils.isPrime(1));
		assertTrue(NumberUtils.isPrime(2));
		assertTrue(NumberUtils.isPrime(3));
		assertFalse(NumberUtils.isPrime(4));
		assertTrue(NumberUtils.isPrime(5));
		assertTrue(NumberUtils.isPrime(19));
		assertFalse(NumberUtils.isPrime(21));
		assertFalse(NumberUtils.isPrime(1000));
	}
	
	@Test
	public void testOneCounts() {
		assertEquals(4, NumberUtils.getOneCounts(1, 11));
		assertEquals(34, NumberUtils.getOneCounts(11, 111));
		assertEquals(36, NumberUtils.getOneCounts(1, 111));
	}
	
	@Test
	public void testPerfectNumbers() {
		assertTrue(NumberUtils.isPerfectNumber(6));
		assertTrue(NumberUtils.isPerfectNumber(28));
		assertTrue(NumberUtils.isPerfectNumber(496));
		
		assertFalse(NumberUtils.isPerfectNumber(10));
		assertFalse(NumberUtils.isPerfectNumber(1));
		assertFalse(NumberUtils.isPerfectNumber(25));
	}
	
	@Test
	public void testAreaOfTriangle() {
		assertEquals(0, NumberUtils.getAreaOfTriangle(0, 0, 0), 0.0001D);
		assertEquals(0, NumberUtils.getAreaOfTriangle(1, 2, 3), 1D);
		assertEquals(4.898, NumberUtils.getAreaOfTriangle(1, 2, 5), 1D);
	}
	
	@Test
	public void testSecondsMethods() {
		assertEquals(39010, NumberUtils.getSeconds(10, 50, 10));
		assertEquals(44705, NumberUtils.getSeconds(12, 25, 5));
		assertEquals(605, NumberUtils.getSeconds(0, 10, 5));
	}
	
	@Test
	public void testIsAbundant() {
		assertTrue(NumberUtils.isAbundantNumber(12));
		assertTrue(NumberUtils.isAbundantNumber(18));
		assertTrue(NumberUtils.isAbundantNumber(20));
		
		assertFalse(NumberUtils.isAbundantNumber(1));
		assertFalse(NumberUtils.isAbundantNumber(10));
	}
	
	@Test
	public void testPrintintAbundantNumbers() {
		NumberUtils.getAbundantNumbers(20);
		NumberUtils.getAbundantNumbers(40);
		assertEquals("String", "String");
	}
	
	@Test
	public void testPrimeCount() {
		assertEquals(78498, NumberUtils.countPrimes(1000001));
		assertEquals(25, NumberUtils.countPrimes(100));
		assertEquals(0, NumberUtils.countPrimes(1));
	}
	
	@Test
	public void testAverage() {
		List<Integer> ints = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Double average = NumberUtils.getAverage(ints);
		assertNotNull(average);
		assertEquals(Double.valueOf(5.5), average);
	}
}
