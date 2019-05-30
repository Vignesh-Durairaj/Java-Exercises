package com.vikhi.exercise;

import org.junit.Assert;
import org.junit.Test;

import com.vikhi.pojo.NumberModel;

public class NumberUtilsTest {

	@Test
	public void testNumberSwap() {
		int a = 10, b = 15;
		NumberModel numberModel = new NumberModel();
		numberModel.setA(a);
		numberModel.setB(b);
		
		NumberUtils.swapNumber(numberModel);
		Assert.assertTrue(a == numberModel.getB());
		Assert.assertTrue(b == numberModel.getA());
		Assert.assertNotNull(numberModel.toString());
		
		NumberUtils.smartSwapNumber(numberModel);
		Assert.assertTrue(a == numberModel.getA());
		Assert.assertTrue(b == numberModel.getB());
		Assert.assertNotNull(numberModel.toString());
	}
	
	@Test
	public void testIsBinary() {
		Assert.assertTrue(NumberUtils.isBinary(1011));
		Assert.assertTrue(!NumberUtils.isBinary(1234));
		Assert.assertTrue(NumberUtils.isBinary(000));
		Assert.assertTrue(NumberUtils.isBinary(111));
	}
	
	@Test
	public void testPositiveCases() {
		try {
			NumberUtils.getLastNumberSamples(10, 3);
			NumberUtils.getPosAndNegAverages(new int[]{1, 2, -3, 4, -2, -9, 4});
		} catch (Exception e) {
			Assert.fail("Failed the executions");
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNegativeCases() {
		NumberUtils.getLastNumberSamples(3, 15);
		Assert.fail("This case is suppose to throw an exception, but not");
	}
	
	@Test
	public void testDigitOccurence() {
		Assert.assertSame(3, NumberUtils.getDigitOccurence(121315, 1));
		Assert.assertSame(0, NumberUtils.getDigitOccurence(123456, 7));
		Assert.assertSame(2, NumberUtils.getDigitOccurence(15972421, 2));
		Assert.assertSame(1, NumberUtils.getDigitOccurence(1234567, 5));
	}
	
	@Test
	public void testIsAmicable() {
		Assert.assertTrue(NumberUtils.isAmicable(6L));
		Assert.assertTrue(!NumberUtils.isAmicable(16L));
		Assert.assertTrue(NumberUtils.isAmicable(220L));
	}
	
	@Test
	public void testAmicableSums() {
		Assert.assertEquals(6, NumberUtils.getAmicableSums(20));
		Assert.assertEquals(34, NumberUtils.getAmicableSums(30));
	}
	
	@Test
	public void testDivisbleSums() {
		Assert.assertEquals(23, NumberUtils.getDivisibleSums(10));
		Assert.assertEquals(78, NumberUtils.getDivisibleSums(20));
	}
	
	@Test
	public void testIsValidISBN() {
		Assert.assertTrue(NumberUtils.isValidISBN(8535902775L));
		Assert.assertTrue(!NumberUtils.isValidISBN(1843369283L));
		Assert.assertTrue(!NumberUtils.isValidISBN(18433693L));
		Assert.assertTrue(!NumberUtils.isValidISBN(184336928334L));
	}
	
	@Test
	public void testIsConsecutiveDigitSum() {
		Assert.assertTrue(NumberUtils.isConsecutiveDigitNum(12345));
		Assert.assertTrue(!NumberUtils.isConsecutiveDigitNum(12354));
		Assert.assertTrue(NumberUtils.isConsecutiveDigitNum(6789));
	}
	
	@Test
	public void testArmstrongNumbers() {
		ArmstrongNumbers an = new ArmstrongNumbers();
		
		Assert.assertTrue(an.isArmstrongNumber(4210818));
		Assert.assertTrue(an.isArmstrongNumberFaster(146511208));
		Assert.assertTrue(!an.isArmstrongNumberFaster(93085));
	}
	
	@Test
	public void testArmstrongNumbersPrint() {
		ArmstrongNumbers an = new ArmstrongNumbers();
		try {
			an.getArmstrongNumbers();
			an.getArmstrongNumbersFaster();
		} catch(Exception e) {
			Assert.fail("Exception ecnountered !");
		}
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testInvalidTestCase() {
		NumberUtils.getPosAndNegAverages(null);
		Assert.fail("Exception is expected, but was not");
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testEmptyInputTestCase() {
		NumberUtils.getPosAndNegAverages(new int[] {});
		Assert.fail("Exception is expected, but was not");
	}
	
	@Test
	public void testFactorials() {
		Factorials factorial = new Factorials();
		
		Assert.assertEquals(1, factorial.getFactorial(0));
		Assert.assertEquals(1, factorial.getFactorialRecursive(0));
		Assert.assertEquals(1, factorial.getFactorialWithStreams(0));
		
		Assert.assertEquals(1, factorial.getFactorial(1));
		Assert.assertEquals(1, factorial.getFactorialRecursive(1));
		Assert.assertEquals(1, factorial.getFactorialWithStreams(1));
		
		Assert.assertEquals(120, factorial.getFactorial(5));
		Assert.assertEquals(120, factorial.getFactorialRecursive(5));
		Assert.assertEquals(120, factorial.getFactorialWithStreams(5));
	}
	
	@Test
	public void testLuckyNumberGenerator() {
		LuckyNumberGenerator lng = new LuckyNumberGenerator();
		
		Assert.assertEquals(6, lng.getLuckyNumberAsSum(213));
		Assert.assertEquals(3, lng.getLuckyNumberAsSum(3));
	}
	
	@Test
	public void testLuckyNumberGeneratorWithStreams() {
		LuckyNumberGenerator lng = new LuckyNumberGenerator();
		
		Assert.assertEquals(6, lng.getLuckyNumberUsingStreams(213));
		Assert.assertEquals(3, lng.getLuckyNumberUsingStreams(3));
	}
	
	@Test
	public void testOddSum() {
		Assert.assertEquals(25, NumberUtils.getOddSum(10));
		Assert.assertEquals(64, NumberUtils.getOddSum(15));
		Assert.assertEquals(0, NumberUtils.getOddSum(0));
	}
	
	@Test
	public void testQuadrantIdentifier() {
		Assert.assertEquals(1, NumberUtils.getQuadrant(362));
		Assert.assertEquals(2, NumberUtils.getQuadrant(92));
		Assert.assertEquals(3, NumberUtils.getQuadrant(197));
		Assert.assertEquals(4, NumberUtils.getQuadrant(301));
		Assert.assertEquals(1, NumberUtils.getQuadrant(30));
		Assert.assertEquals(1, NumberUtils.getQuadrant(90));
		Assert.assertEquals(2, NumberUtils.getQuadrant(180));
		Assert.assertEquals(3, NumberUtils.getQuadrant(270));
		Assert.assertEquals(4, NumberUtils.getQuadrant(271));
	}
	
	@Test
	public void testIsPrime() {
		Assert.assertFalse(NumberUtils.isPrime(1));
		Assert.assertTrue(NumberUtils.isPrime(2));
		Assert.assertTrue(NumberUtils.isPrime(3));
		Assert.assertFalse(NumberUtils.isPrime(4));
		Assert.assertTrue(NumberUtils.isPrime(5));
		Assert.assertTrue(NumberUtils.isPrime(19));
		Assert.assertFalse(NumberUtils.isPrime(21));
		Assert.assertFalse(NumberUtils.isPrime(1000));
	}
	
	@Test
	public void testOneCounts() {
		Assert.assertEquals(4, NumberUtils.getOneCounts(1, 11));
		Assert.assertEquals(34, NumberUtils.getOneCounts(11, 111));
		Assert.assertEquals(36, NumberUtils.getOneCounts(1, 111));
	}
}
