package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

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
			assertNotNull(outputVal);
			fail("Input Arguments should not be a negative a value");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testNegativeInputForMethod() {
			BigInteger outputVal = numericalMethods.getValueFromMethod(-1);
			assertNotNull(outputVal);
			fail("Input Arguments should not be a negative a value");
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testNegativeInputForArrayProcess() {
			BigInteger outputVal = numericalMethods.getValueUsingArrays(-1);
			assertNotNull(outputVal);
			fail("Input Arguments should not be a negative a value");
		}
		@Test(expected=IllegalArgumentException.class)
		public void testNegativeInputForFastProcess() {
			BigInteger outputVal = numericalMethods.getValueFromFastProcess(-1);
			assertNotNull(outputVal);
			fail("Input Arguments should not be a negative a value");
		}
	}
	
	@RunWith(Parameterized.class)
	public static class GroupedNumericalTests {
		
		private FibonacciSeries numericalMethods = new FibonacciSeries();
		
		private int inputVal;
		private BigInteger outputVal;
		private float average;
		private double averageDouble;
		
		public GroupedNumericalTests(final int inputVal, final BigInteger outputVal, 
				final float average, final double averageDouble) {
			this.inputVal = inputVal;
			this.outputVal = outputVal;
			this.average = average;
			this.averageDouble = averageDouble;
		}
		
		@Parameters
		public static Collection<Object[]> inputParams() {
			return Arrays.asList(new Object[][]{
				{0, BigInteger.ZERO, 0, 0}, 
				{1, BigInteger.valueOf(1), 1, 1},
				{2, BigInteger.valueOf(1), 1, 1},
				{3, BigInteger.valueOf(2), 1, 1.33},
				{4, BigInteger.valueOf(3), 1, 1.75}, 
				{5, BigInteger.valueOf(5), 2, 2.4},
				{6, BigInteger.valueOf(8), 3, 3.33},
				{7, BigInteger.valueOf(13), 2, 4.71}, 
				{8, BigInteger.valueOf(21), 4, 6.75}
			});
		}
		
		@Test
		public void testRecursiveValue () {
			BigInteger processedVal = numericalMethods.getValueFromRecursive(inputVal);
			assertEquals(outputVal, processedVal);
		}
		
		@Test
		public void testFunctionalValue () {
			BigInteger processedVal = numericalMethods.getValueFromMethod(inputVal);
			assertEquals(outputVal, processedVal);
		}
		
		@Test
		public void testFastProcessValue () {
			BigInteger processedVal = numericalMethods.getValueFromFastProcess(inputVal);
			assertEquals(outputVal, processedVal);
		}
		
		@Test
		public void testArrayProcessValue () {
			BigInteger processedVal = numericalMethods.getValueUsingArrays(inputVal);
			assertEquals(outputVal, processedVal);
		}
		
		@Test
		public void testFibonacciAverage() {
			float fibbAverage = numericalMethods.getFibonacciAverage(inputVal);
			if (inputVal > 0) {
				assertEquals(average, fibbAverage, 1);
			}
		}
		
		@Test
		public void testFibonacciAverageWithStreams() {
			double fibbAverageDouble = numericalMethods.getFibonacciAverageUsingStream(inputVal);
			assertEquals(averageDouble, fibbAverageDouble, 1);
		}
	}
}
