package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.vikhi.exercise.math.NumberCompositions;

@RunWith(Parameterized.class)
public class NumberCompositionsTest {

	private int spaceCovered;
	
	private BigInteger probabilityCount;
	
	private static NumberCompositions numberCompositions;

	public NumberCompositionsTest(int spaceCovered, BigInteger probabilityCount) {
		super();
		this.spaceCovered = spaceCovered;
		this.probabilityCount = probabilityCount;
	}
	
	@BeforeClass
	public static void init() {
		numberCompositions = new NumberCompositions();
	}
	
	@Parameters
	public static Collection<Object[]> parameters() {
		return Arrays.asList(new Object[][] {
			{0, BigInteger.valueOf(1)},
			{1, BigInteger.valueOf(1)},
			{2, BigInteger.valueOf(2)},
			{3, BigInteger.valueOf(4)},
			{4, BigInteger.valueOf(8)},
			{5, BigInteger.valueOf(16)},
			{6, BigInteger.valueOf(32)},
			{7, BigInteger.valueOf(63)},
			{8, BigInteger.valueOf(125)},
			{9, BigInteger.valueOf(248)},
			{10, BigInteger.valueOf(492)}
		});
	}
	
	@Test
	public void testDiceCompositions() {
		BigInteger probabilityCount = numberCompositions.getDiceCompositions(this.spaceCovered);
		assertEquals(probabilityCount, this.probabilityCount);
	}
}
