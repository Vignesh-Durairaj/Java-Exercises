package com.vikhi.exercise;

public class MathOperations {

	private static final double ERROR_RANGE = 0.001;
	
	public double power (double x, int n) {
		double result = 1;
		if (n > 0) {
			for (int i = 1; i <= n; i ++) {
				result *= x;
			}
		}
		
		return result;
	}
	
	public double root (double x, int n) {
		if (n == 0) {
			return 1;
		} 
		
		double start = x;
		double end = x / n;
		
		while (start - end > ERROR_RANGE || end - start > ERROR_RANGE) {
			start = end;
			end = ((n - 1) * end + x / power(end, n - 1)) / n;
		}
		
		return end;
	}
	
	public long getXor (final long num) {
		long[] xorArr = {num, 1L, num + 1, 0L};
		return xorArr[(int)(num % 4)];
	}
	
	public long getXorForRange(final long start, final long end) {
		return getXor(end) ^ getXor(start - 1);
	}
}
