package com.vikhi.exercise;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class FibonacciSeriesTest {

	public static class SingulateNumericalTests {
		
		private static FibonacciSeries numericalMethods;
		
		@BeforeClass
		public static void init() {
			numericalMethods = new FibonacciSeries();
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testNegativeInputForRecursice() {
			BigInteger outputVal = numericalMethods.getValueFromRecursive(-1);
			Assert.assertNotNull(outputVal);
			Assert.fail("Input Arguments should not be a negative a value");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testNegativeInputForMethod() {
			BigInteger outputVal = numericalMethods.getValueFromMethod(-1);
			Assert.assertNotNull(outputVal);
			Assert.fail("Input Arguments should not be a negative a value");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testNegativeInputForFastProcess() {
			BigInteger outputVal = numericalMethods.getValueFromMethod(-1);
			Assert.assertNotNull(outputVal);
			Assert.fail("Input Arguments should not be a negative a value");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testNegativeInputForArrayProcess() {
			BigInteger outputVal = numericalMethods.getValueUsingArrays(-1);
			Assert.assertNotNull(outputVal);
			Assert.fail("Input Arguments should not be a negative a value");
		}
	}
	
	@RunWith(Parameterized.class)
	public static class GroupedNumericalTests {
		
		private int inputVal;
		private BigInteger outputVal;
		
		public GroupedNumericalTests(final int inputVal, final BigInteger outputVal) {
			this.inputVal = inputVal;
			this.outputVal = outputVal;
		}
		
		@Parameters
		public static Collection<Object[]> inputParams() {
			return Arrays.asList(new Object[][]{
				{0, BigInteger.ZERO}, 
				{1, BigInteger.valueOf(1)},
				{2, BigInteger.valueOf(1)},
				{3, BigInteger.valueOf(2)},
				{4, BigInteger.valueOf(3)}, 
				{5, BigInteger.valueOf(5)},
				{6, BigInteger.valueOf(8)},
				{7, BigInteger.valueOf(13)}, 
				{8, BigInteger.valueOf(21)}
			});
		}
		
		@Test
		public void testRecursiveValue () {
			FibonacciSeries numericalMethods = new FibonacciSeries();
			BigInteger processedVal = numericalMethods.getValueFromRecursive(inputVal);
			Assert.assertEquals(outputVal, processedVal);
		}
		
		@Test
		public void testFunctionalValue () {
			FibonacciSeries numericalMethods = new FibonacciSeries();
			BigInteger processedVal = numericalMethods.getValueFromMethod(inputVal);
			Assert.assertEquals(outputVal, processedVal);
		}
		
		@Test
		public void testFastProcessValue () {
			FibonacciSeries numericalMethods = new FibonacciSeries();
			BigInteger processedVal = numericalMethods.getValueFromFastProcess(inputVal);
			Assert.assertEquals(outputVal, processedVal);
		}
		
		@Test
		public void testArrayProcessValue () {
			FibonacciSeries numericalMethods = new FibonacciSeries();
			BigInteger processedVal = numericalMethods.getValueUsingArrays(inputVal);
			Assert.assertEquals(outputVal, processedVal);
		}
	}
}
