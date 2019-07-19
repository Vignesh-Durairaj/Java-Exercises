package com.vikhi.exercise;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.BeforeClass;
import org.junit.Test;

public class HandClockTest {

	private static HandClock handClock;
	
	@BeforeClass
	public static void init() {
		handClock = new HandClock();
	}

	@Test(expected=IllegalArgumentException.class)
	public void testNegativeHour() {
		handClock.setHourHand(-2);
		handClock.setMinuteHand(30);
		handClock.optimizeHands();
		fail("Hour value should be positive");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidHour() {
		handClock.setHourHand(13);
		handClock.setMinuteHand(45);
		handClock.optimizeHands();
		fail("Hour value should be less than or equal to 12");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNegativeMinute() {
		handClock.setHourHand(3);
		handClock.setMinuteHand(-1);
		handClock.optimizeHands();
		fail("Minute value should be positive");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testInvalidMinute() {
		handClock.setHourHand(3);
		handClock.setMinuteHand(62);
		handClock.optimizeHands();
		fail("Minute value should be less than or equal to 60");
	}
	
	@Test
	public void testAngles() {
		handClock = new HandClock(3, 30);
		handClock.optimizeHands();
		handClock.findHourAndMinuteAngles();
		double angle = handClock.getAngleBetweenHourAndMinute();
		assertTrue(angle == 75);
		
		double minAngle = handClock.getSmallestAngle();
		assertTrue(minAngle == 75);
	}
	
	@Test
	public void testAnotherAngle() {
		handClock = new HandClock(2, 10);
		handClock.optimizeHands();
		handClock.findHourAndMinuteAngles();
		double angle = handClock.getAngleBetweenHourAndMinute();
		assertTrue(angle == 355);
		
		double minAngle = handClock.getSmallestAngle();
		assertTrue(minAngle == 5);
	}
	
	@Test
	public void testAtNoon() {
		handClock = new HandClock(11, 60);
		handClock.optimizeHands();
		handClock.findHourAndMinuteAngles();
		double angle = handClock.getAngleBetweenHourAndMinute();
		assertTrue(angle == 0);
		
		double minAngle = handClock.getSmallestAngle();
		assertTrue(minAngle == 0);
	}
	
	@Test
	public void testAgainAtNoon() {
		handClock = new HandClock(12, 00);
		handClock.optimizeHands();
		handClock.findHourAndMinuteAngles();
		double angle = handClock.getAngleBetweenHourAndMinute();
		assertTrue(angle == 0);
		
		double minAngle = handClock.getSmallestAngle();
		assertTrue(minAngle == 0);
	}
	
	@Test
	public void testRandomTimings() {
		handClock = new HandClock();
		handClock.setHourHand(6);
		handClock.setMinuteHand(30);
		handClock.optimizeHands();
		handClock.findHourAndMinuteAngles();
		double angle = handClock.getAngleBetweenHourAndMinute();
		assertTrue(angle == 345);
		
		double minAngle = handClock.getSmallestAngle();
		assertTrue(minAngle == 15);
		
		handClock.setHourHand(6);
		handClock.setMinuteHand(00);
		handClock.optimizeHands();
		handClock.findHourAndMinuteAngles();
		angle = handClock.getAngleBetweenHourAndMinute();
		assertTrue(angle == 180);
		
		minAngle = handClock.getSmallestAngle();
		assertTrue(minAngle == 180);
	}
}
