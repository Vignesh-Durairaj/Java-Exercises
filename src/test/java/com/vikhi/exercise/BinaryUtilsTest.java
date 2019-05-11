package com.vikhi.exercise;

import org.junit.Assert;
import org.junit.Test;

public class BinaryUtilsTest {

	@Test
	public void testFlippingBytes() {
		BinaryUtils bu = new BinaryUtils();
		Assert.assertEquals(4294954951L, bu.flip32BitNumber(12344L));
		Assert.assertEquals(4294967285L, bu.flip32BitNumber(10L));
	}
	
	@Test
	public void testXorProduct() {
		BitWiseUtils bw = new BitWiseUtils();
		Assert.assertEquals(9, bw.getXorProduct(2, 8));
		Assert.assertEquals(11, bw.getXorProduct(3, 8));
	}
}
