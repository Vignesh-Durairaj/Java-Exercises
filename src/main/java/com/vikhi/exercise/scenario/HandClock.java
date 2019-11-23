package com.vikhi.exercise.scenario;

public class HandClock {

	public int hourHand;
	
	public int minuteHand;
	
	public double hourAngle;
	
	public double minuteAngle;
	
	public HandClock() {
		// Can be implemented if needed in future.
	}
	
	public HandClock(int hourHand, int minuteHand) {
		super();
		this.hourHand = hourHand;
		this.minuteHand = minuteHand;
	}

	public void setHourHand(int hourHand) {
		this.hourHand = hourHand;
	}

	public void setMinuteHand(int minuteHand) {
		this.minuteHand = minuteHand;
	}

	public void optimizeHands() {
		if (hourHand < 0 || hourHand > 12 || minuteHand < 0 || minuteHand > 60) {
			throw new IllegalArgumentException("Hour and minute should be positive value "
					+ "with a max value of 12 and 60 respectively !");
		}
		
		if (minuteHand == 60) {
			hourHand += 1;
			minuteHand = 0;
		}
		
		if (hourHand >= 12) {
			hourHand = 12 - hourHand;
		}
	}
	
	public void findHourAndMinuteAngles() {
		minuteAngle = 6D * minuteHand;
 		hourAngle = (0.5 * minuteHand) + (30 * hourHand);
	}
	
	public double getAngleBetweenHourAndMinute() {
		double initAngle = minuteAngle - hourAngle;
		return (initAngle < 0 ? 360 + initAngle : initAngle);
	}
	
	public double getSmallestAngle() {
		double angleDiff = getAngleBetweenHourAndMinute();
		return Math.min(360 - angleDiff, angleDiff);
	}
}
