package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class ArrayMethodsTest {

	@RunWith(Parameterized.class)
	public static class ArrayRankedElementTest {
		
		private int[] inputArr;
		private int rank;
		private int val;
		private int nonDistinctVal;
		
		private ArrayMethods arrayMethods = new ArrayMethods();

		public ArrayRankedElementTest(int[] inputArr, int rank, int val, int nonDistinctVal) {
			super();
			this.inputArr = inputArr;
			this.rank = rank;
			this.val = val;
			this.nonDistinctVal = nonDistinctVal;
		}
		
		@Parameters
		public static Collection<Object[]> params() {
			return Arrays.asList(new Object[][] {
				{new int[] {1, 4, 2, 5, 3, 9}, 3, 3, 3}, 
				{new int[] {12, 13, 1, 10, 34, 1}, 2, 10, 1}, 
				{new int[] {1,2,5,6,3,2}, 4, 5, 3}, 
				{new int[] {1, 3, 3, 3, 2, 10, 16, 1, 21}, 3, 3, 2}
			});
		}
		
		@Test
		public void testNormalSearch() {
			int value = arrayMethods.getRankedElementFromArray(inputArr, rank);
			assertTrue(val == value);
			assertTrue(nonDistinctVal == arrayMethods.getNthSmallElement(rank, inputArr));
			assertTrue(nonDistinctVal == arrayMethods.getNthSmallElement(inputArr, rank));
		}
		
	}
	
	@RunWith(Parameterized.class)
	public static class ArrayRankedElementInvalidCasesTest {
		
		private int[] inputArr;
		private int rank;
		
		private ArrayMethods arrayMethods = new ArrayMethods();

		public ArrayRankedElementInvalidCasesTest(int[] inputArr, int rank) {
			super();
			this.inputArr = inputArr;
			this.rank = rank;
		}
		
		@Parameters
		public static Collection<Object[]> params() {
			return Arrays.asList(new Object[][] {
				{new int[] {1, 4, 2, 5, 3, 9}, 7}, 
				{new int[] {12, 13, 1, 10, 34, 1}, -1}, 
				{new int[] {1,2,5,6,3,2}, -1}, 
				{new int[] {1, 3, 3, 3, 2, 10, 16, 1, 21}, 7}
			});
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testNormalSearch() {
			int value = arrayMethods.getRankedElementFromArray(inputArr, rank);
			assertTrue(value > 0);
			fail("This case should get failed for invalid arguements !");
		}
		
	}
	
	@RunWith(Parameterized.class)
	public static class PlaneBookingInvalidArguementsTest {
		
		private int totalRows;
		private String reservedSeats;
		private int familiesAccomodated;
		
		private int getFamiliesAccomodated(final int totalRows, final String reservedSeats) {
			ArrayMethods arrayMethods = new ArrayMethods();
			try {
				return arrayMethods.getFamilyNosForPlane(totalRows, reservedSeats);
			} catch (IllegalArgumentException iae) {
				return -1;
			}
		}
		
		public PlaneBookingInvalidArguementsTest(int totalRows, String reservedSeats, int familiesAccomodated) {
			this.totalRows = totalRows;
			this.reservedSeats = reservedSeats;
			this.familiesAccomodated = familiesAccomodated;
		}
		
		@Parameters
		public static Collection<Object[]> params() {
			return Arrays.asList(new Object[][] {
				{1, null, 3}, 
				{5, null, 15},
				{10, "", 30},
				{5, "Test", -1}, 
				{3, "3B 4C 7P", -1}, 
				{3, "3B 1C 2P", -1}, 
				{10, "1A 2D 3G 4H 5K", 27}
			});
		}
		
		@Test
		public void testFamilyNosForPlane() {
			assertEquals(this.familiesAccomodated, getFamiliesAccomodated(this.totalRows, this.reservedSeats));
		}
	}
	
	public static class GenericTestCases {
		
		private ArrayMethods am = new ArrayMethods();
		
		@Test
		public void testFrequencySortArray() {
			int[] inputArr = {1, 2, 3, 2, 4, 4, 3, 4, 7, 4};
			int[] outputArr = {4, 4, 4, 4, 2, 2, 3, 3, 1, 7};
			
			assertTrue(Arrays.equals(outputArr, am.frequencySortArray(inputArr)));
			assertTrue(Arrays.equals(new int[] {}, am.frequencySortArray(new int[] {})));
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidFrequencySort() {
			am.frequencySortArray(null);
			fail("Expected an exception, but not !");
		}
		
		@Test
		public void testStatistics() {
			am.getStatistics(new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8});
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testStatisticsInvalidInput() {
			am.getStatistics(null);
			am.getStatistics(new int[] {});
			am.getStatistics(new int[] {1});
			am.getStatistics(new int[] {0});
			
			fail("Expected an exception, but not !");
		}
		
		@Test
		public void testIsNumeric() {
			assertTrue(am.isNumeric("1235"));
			assertTrue(am.isNumeric("52369742"));
			assertTrue(!am.isNumeric("123O5"));
			assertTrue(!am.isNumeric("abcd"));
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidInputSmallestSum() {
			am.getSmallestSum(null);
			am.getSmallestSum(new int[] {1, 2, 3});
			
			am.getSmallestSumUsingStream(null);
			am.getSmallestSumUsingStream(new int[] {1, 2, 3});
			
			am.smallestNotAdjacentSum(null);
			am.smallestNotAdjacentSum(new int[] {1, 2, 3, 4});
			
			fail("Exception is expected, but not !");
		}
		
		@Test
		public void testArrayFunctions() {
			ArrayFunctions af = new ArrayFunctions();
			assertEquals(1, af.getNearestSmallestPositiveInt(null));
			assertEquals(3, af.getNearestSmallestPositiveInt(new int[] {1, 4, 5, 2, 8}));
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase1() {
			am.getNthSmallElement(0, new int[] {1, 2, 3});
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase2() {
			am.getNthSmallElement(1, null);
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase3() {
			am.getNthSmallElement(5, new int[] {1, 2, 3});
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase4() {
			am.getNthSmallElement(new int[] {1, 2, 3}, 0);
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase5() {
			am.getNthSmallElement(null, 2);
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase6() {
			am.getNthSmallElement(new int[] {1, 2, 3}, 5);
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase7() {
			am.getRankedElementFromArray(new int[] {1, 2, 3}, 0);
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase8() {
			am.getRankedElementFromArray(null, 1);
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase9() {
			am.getRankedElementFromArray(new int[] {1, 2, 3}, 6);
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase10() {
			am.getSmallestSum(new int[] {1, 2, 3});
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase11() {
			am.getSmallestSum(null);
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase12() {
			am.getSmallestSumUsingStream(new int[] {1, 2, 3});
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase13() {
			am.getSmallestSumUsingStream(null);
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase14() {
			am.smallestNotAdjacentSum(null);
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase15() {
			am.smallestNotAdjacentSum(new int[] {1, 2, 3});
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase16() {
			am.getStatistics(new int[] {1});
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase17() {
			am.getStatistics(null);
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase18() {
			am.isNumeric("");
			fail("Expected an exception, but was not!");
		}
		
		@Test(expected = IllegalArgumentException.class)
		public void testInvalidCase19() {
			am.isNumeric(null);
			fail("Expected an exception, but was not!");
		}
	}
	
	@RunWith(Parameterized.class)
	public static class ArrayReversalTest {
		
		private ArrayMethods am = new ArrayMethods();
		private int[] inputArr, outputArr;

		public ArrayReversalTest(int[] inputArr, int[] outputArr) {
			super();
			this.inputArr = inputArr;
			this.outputArr = outputArr;
		}
		
		@Parameters
		public static Collection<Object[]> params() {
			return Arrays.asList(new Object[][] {
				{new int[] {1, 2, 3, 4}, new int[] {4, 3, 2, 1}},
				{new int[] {1}, new int[] {1}}, 
				{new int[] {}, new int[] {}}, 
				{new int[] {3, 5, 2, 6, 9}, new int[] {9, 6, 2, 5, 3}}, 
				{new int[] {21, 34, 64, 23, 90, 2, 46, 1, 36, 0}, new int[] {0, 36, 1, 46, 2, 90, 23, 64, 34, 21}} 
			});
		}
		
		@Test
		public void testClassicReversing() {
			assertTrue(Arrays.equals(outputArr, am.reverseArray(inputArr)));
		}
		
		@Test
		public void testStreamedReversing() {
			assertTrue(Arrays.equals(outputArr, am.reverseArrayWithStreams(inputArr)));
		}
		
		@Test
		public void testSmartReversing() {
			int[] newInputArr = Arrays.copyOf(inputArr, inputArr.length);
			am.reverseArraySmartly(newInputArr);
			assertTrue(Arrays.equals(outputArr, newInputArr));
		}
	}
	
	@RunWith(Parameterized.class)
	public static class SmallestSumTest {
		
		private ArrayMethods am = new ArrayMethods();
		private int[] inputArr;
		private int smallestSum;
		private int smallestNonAdjSum;
		
		public SmallestSumTest(int[] inputArr, int smallestSum, int smallestNonAdjSum) {
			super();
			this.inputArr = inputArr;
			this.smallestSum = smallestSum;
			this.smallestNonAdjSum = smallestNonAdjSum;
		}
		
		@Parameters
		public static Collection<Object[]> params() {
			return Arrays.asList(new Object[][] {
				{new int[] {1, 2, 3, 4, 5}, 5, 6},
				{new int[] {0, 0, 0, 0, 0, 0, 0, 0}, 0, 0},
				{new int[] {1, 8, 3, 7, 5, 4, 10}, 7, 7}
			}); 
		}
		
		@Test
		public void testSmallestSum() {
			assertEquals(smallestSum, am.getSmallestSum(inputArr));
		}
		
		@Test
		public void testSmallestSumWithStreams() {
			assertEquals(smallestSum, am.getSmallestSumUsingStream(inputArr));
		}
		
		@Test
		public void testNonAdjacentSmallSum() {
			assertEquals(smallestNonAdjSum, am.smallestNotAdjacentSum(inputArr));
		}
		
		@Test
		public void testFunction() {
			Integer[] intArr = Arrays.stream(inputArr).boxed().toArray(Integer[]::new);
			assertNotNull(am.function(intArr, 1, 3));
		}
	}
}
