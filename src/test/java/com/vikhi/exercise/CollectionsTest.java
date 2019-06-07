package com.vikhi.exercise;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CollectionsTest {

	private static CollectionsMethods cm;
	
	@Before
	public static void init() {
		cm = new CollectionsMethods();
	}
	
	@Test
	public void testLargestNumberinList() {
		Assert.assertEquals(3, cm.getLargestNumber(Arrays.asList(3, 1, 2, 3)));
		Assert.assertEquals(100, cm.getLargestNumber(Arrays.asList(7, 5, 500, -8, 0, 3, 56, -1000)));
	}
}