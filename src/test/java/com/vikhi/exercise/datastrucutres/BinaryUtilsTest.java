package com.vikhi.exercise.datastrucutres;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.vikhi.util.BinaryUtils;
import com.vikhi.util.BitWiseUtils;

public class BinaryUtilsTest {

	@Test
	public void testFlippingBytes() {
		BinaryUtils bu = new BinaryUtils();
		assertEquals(4294954951L, bu.flip32BitNumber(12344L));
		assertEquals(4294967285L, bu.flip32BitNumber(10L));
	}
	
	@Test
	public void testXorProduct() {
		BitWiseUtils bw = new BitWiseUtils();
		assertEquals(9, bw.getXorProduct(2, 8));
		assertEquals(11, bw.getXorProduct(3, 8));
	}
}
