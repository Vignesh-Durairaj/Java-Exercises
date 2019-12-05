package com.vikhi.exercise.scenario;

import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

public class BinaryStringsTest {

	private BinaryStrings binaryStrings;
	
	@Before
	public void init() {
		binaryStrings = new BinaryStrings();
	}
	
	@Test
	public void testPopulation() {
		assertSame(0, binaryStrings.countBits(0));
		assertSame(1, binaryStrings.countBits(1));
		assertSame(2, binaryStrings.countBits(3));
		assertSame(13, binaryStrings.countBits(12324623));
	}
}
