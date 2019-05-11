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
	
	@Test
	public void testNegativeCases() {
		try {
			NumberUtils.getLastNumberSamples(3, 15);
			NumberUtils.getPosAndNegAverages(null);
			NumberUtils.getPosAndNegAverages(new int[] {});
			Assert.fail("This case is suppose to throw an exception, but not");
		} catch (IllegalArgumentException e) {
			
		}
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
	}
	
	@Test
	public void testIsConsecutiveDigitSum() {
		Assert.assertTrue(NumberUtils.isConsecutiveDigitNum(12345));
		Assert.assertTrue(!NumberUtils.isConsecutiveDigitNum(12354));
		Assert.assertTrue(NumberUtils.isConsecutiveDigitNum(6789));
	}
}
