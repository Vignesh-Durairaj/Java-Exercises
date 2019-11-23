package com.vikhi.exercise;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.vikhi.exercise.datastrucutres.CollectionsMethods;


public class CollectionsTest {

	private static CollectionsMethods cm;
	
	@Before
	public void init() {
		cm = new CollectionsMethods();
	}
	
	@Test
	public void testLargestNumberinList() {
		assertEquals(3, cm.getLargestNumber(Arrays.asList(3, 1, 2, 3)));
		assertEquals(500, cm.getLargestNumber(Arrays.asList(7, 5, 500, -8, 0, 3, 56, -1000)));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testLargestNumberWithNullInput() {
		assertEquals(10, cm.getLargestNumber(null));
		fail("This case is not supposed to get passed for NULL input in arguments.");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testLargestNumberWithEmptyListInput() {
		assertEquals(10, cm.getLargestNumber(new ArrayList<Integer>()));
		fail("This case is not supposed to get passed for empty input list in arguments.");
	}
}
