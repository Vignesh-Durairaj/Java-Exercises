package com.vikhi.exercise;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class FibonacciSeries {

	private static Map<Integer, BigInteger> fibonacciMap = new HashMap<>();
	
	static {
		fibonacciMap.put(0, BigInteger.ZERO);
		fibonacciMap.put(1, BigInteger.valueOf(1));
	}
	
	/**
	 * Returns the implementation of the mathematical function as below
	 * 
	 * f(0) = 0
	 * f(1) = 1
	 * f(n) = f(n-1) + f(n-2)
	 * 
	 * Implemented using recursive call
	 * 
	 * @param position - the value of 'n' for which the function has to be applied 
	 * @return f(n) - The final value with the function applied over the argument
	 */
	public BigInteger getValueFromRecursive (final int position) {
		
		if (position < 0) {
			throw new IllegalArgumentException("Input number should be a positive integer");
		} else if (position <= 1) {
			return BigInteger.valueOf(position);
		} else {
			return (getValueFromRecursive(position - 1).add(getValueFromRecursive(position - 2)));
		}
	}
	
	public BigInteger getValueFromMethod (final int position) {
		BigInteger s0 = BigInteger.ZERO;
		BigInteger s1 = BigInteger.valueOf(1);
		BigInteger val = BigInteger.ZERO;
		
		if (position < 0) {
			throw new IllegalArgumentException("Input position should be a positive integer");
		} else if (position > 1) {
			for (int i = 2; i <= position; i++) {
				val = s0.add(s1);
				s0 = new BigInteger(s1.toString());
				s1 = new BigInteger(val.toString());
			}
		} else {
			val = BigInteger.valueOf(position);
		}
		
		return val;
	}
	
	public BigInteger getValueFromFastProcess(final int position) {
		if (position < 0) {
			throw new IllegalArgumentException("Input position should be a positive integer");
		} else {
			if (fibonacciMap.containsKey(position)){
				return fibonacciMap.get(position);
			} else {
				BigInteger newValue = getValueFromFastProcess(position - 1).add(getValueFromFastProcess(position - 2));
				fibonacciMap.put(position, newValue);
				return newValue;
			}
		}
	}
	
	public static void main(String[] args) {
		long startTime, endTime;
		FibonacciSeries fibonacciSeries = new FibonacciSeries();
		
		startTime = System.currentTimeMillis();
		System.out.println(fibonacciSeries.getValueFromMethod(8181));
		endTime = System.currentTimeMillis();
		System.out.println("Time taken to evaluate using method : " + (endTime - startTime) + "ms");
		
		startTime = System.currentTimeMillis();
		System.out.println(fibonacciSeries.getValueFromFastProcess(8181));
		endTime = System.currentTimeMillis();
		System.out.println("Time taken to evaluate using Fast process : " + (endTime - startTime) + "ms");
	}
}
