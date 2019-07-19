package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class MathOperationsTest {

	private static MathOperations mathOperations = new MathOperations();
	
	@RunWith(Parameterized.class)
	public static class PowerTest {
		
		private double x;
		private int n;
		private double ans;
		
		public PowerTest(double x, int n, double ans) {
			super();
			this.x = x;
			this.n = n;
			this.ans = ans;
		}
		
		@Parameters
		public static Collection<Object []> params() {
			return Arrays.asList(new Object[][] {
				{2, 2, 4},
				{2, 3, 8},
				{3, 1, 3},
				{10, 0, 1},
				{10, 2, 100}, 
			});
		}
		
		@Test
		public void testPower() {
			double ans = mathOperations.power(x, n);
			assertEquals(this.ans, ans, 0.001D);
		}
	}
	
	@RunWith(Parameterized.class)
	public static class PowerRoot {
		
		private double x;
		private int n;
		private double ans;
		
		public PowerRoot(double x, int n, double ans) {
			super();
			this.x = x;
			this.n = n;
			this.ans = ans;
		}
		
		@Parameters
		public static Collection<Object []> params() {
			return Arrays.asList(new Object[][] {
				{8, 3, 2},
				{729, 3, 9},
				{125, 3, 5},
				{10, 0, 1},
				{100, 2, 10}, 
			});
		}
		
		@Test
		public void testPower() {
			double ans = mathOperations.root(x, n);
			assertEquals(this.ans, ans, 0.001D);
		}
	}
	
	public static class XorFunctionTest {
		
		MathOperations mathOperations = new MathOperations();
		
		@Test
		public void testXor() {
			assertEquals(11, mathOperations.getXor(10L));
			assertEquals(0, mathOperations.getXor(55L));
		}
		
		@Test
		public void testXorForRange() {
			assertEquals(12, mathOperations.getXorForRange(5, 8));
			assertEquals(1, mathOperations.getXorForRange(20, 25));
		}
	}
}
