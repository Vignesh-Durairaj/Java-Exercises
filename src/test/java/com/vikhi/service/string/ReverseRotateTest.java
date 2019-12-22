package com.vikhi.service.string;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.vikhi.exercise.string.ReverseRotate;

public class ReverseRotateTest {

	private ReverseRotate reverseRotate;
	
	@Before
	public void init() {
		reverseRotate = new ReverseRotate();
	}
	
	@Test
	public void testReverseRotate() {
		assertEquals("234561876549", reverseRotate.revRot("123456987654", 6));
		assertEquals("234561356789", reverseRotate.revRot("123456987653", 6));
		assertEquals("44668753", reverseRotate.revRot("66443875", 4));
		assertEquals("64438756", reverseRotate.revRot("66443875", 8));
		assertEquals("67834466", reverseRotate.revRot("664438769", 8));
		assertEquals("23456771", reverseRotate.revRot("123456779", 8));
		assertEquals("", reverseRotate.revRot("", 8));
		assertEquals("", reverseRotate.revRot("123456779", 0));
		assertEquals("0365065073456944", reverseRotate.revRot("563000655734469485", 4));
	}
}
