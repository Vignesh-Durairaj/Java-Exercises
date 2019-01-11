package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Assert;
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
		
		private ArrayMethods arrayMethods = new ArrayMethods();

		public ArrayRankedElementTest(int[] inputArr, int rank, int val) {
			super();
			this.inputArr = inputArr;
			this.rank = rank;
			this.val = val;
		}
		
		@Parameters
		public static Collection<Object[]> params() {
			return Arrays.asList(new Object[][] {
				{new int[] {1, 4, 2, 5, 3, 9}, 3, 3}, 
				{new int[] {12, 13, 1, 10, 34, 1}, 2, 10}, 
				{new int[] {1,2,5,6,3,2}, 4, 5}, 
				{new int[] {1, 3, 3, 3, 2, 10, 16, 1, 21}, 3, 3}
			});
		}
		
		@Test
		public void testNormalSearch() {
			int value = arrayMethods.getRankedElementFromArray(inputArr, rank);
			Assert.assertTrue(val == value);
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
			Assert.assertTrue(value > 0);
			Assert.fail("This case should get failed for invalid arguements !");
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
}
