package com.vikhi.exercise;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;

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
	
	public BigInteger getValueUsingArrays (final int position) {
		if (position < 0) {
			throw new IllegalArgumentException("Input position should be a positive integer");
		} else {
			BigInteger[] fibonacciArr = new BigInteger[position + 1];
			fibonacciArr[0] = BigInteger.ZERO;
			
			if (position >= 1) {
				fibonacciArr[1] = BigInteger.valueOf(1);
			}

			processFibonacciArray(position, fibonacciArr);
			return fibonacciArr[position];
		}
	}
	
	private BigInteger processFibonacciArray (final int position, final BigInteger[] fibonacciArr) {
		if (fibonacciArr[position] != null) {
			return fibonacciArr[position];
		} else {
			BigInteger newValue = processFibonacciArray(position - 1, fibonacciArr).add(processFibonacciArray(position - 2, fibonacciArr));
			fibonacciArr[position] = newValue;
			return newValue;
		}
	}
	
	public float getFibonacciAverage(final int count) {
		int a = 0; 
		int b = 1; 
		int total = 1;
		
		for (int i = 2; i < count; i ++) {
			total += (a + b);
			int tmp = a;
			a = b;
			b = (a + tmp);
		}
		return (float)total/count;
	}
	
	public double getFibonacciAverageUsingStream(final int count) {
		
		IntSupplier fibbSupplier = new IntSupplier() {
			
			int previous = 0; 
			int current = 1;
			
			@Override
			public int getAsInt() {
				int temp = current;
				current += previous;
				previous = temp;
				return temp;
			}
		};
		
		return IntStream
				.generate(fibbSupplier)
				.limit(count)
				.average().orElse(0D);
	}
}