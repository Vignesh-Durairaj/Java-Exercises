package com.vikhi.exercise;

public class WalkingRobot {

	
	public void move (int n) {
		Thread t1 = new Thread (new LimbMovement(10, "Left"));
		Thread t2 = new Thread (new LimbMovement(10, "Right"));
		
		System.out.println("Starting movement");
		
		t1.start();
		t2.start();
	}
	
	public static void main(String[] args) {
		WalkingRobot robot = new WalkingRobot();
		robot.move(5);
	}
	
	class LimbMovement implements Runnable {
		
		private int n;
		
		private String limb;

		public LimbMovement(int n, String limb) {
			this.n = n;
			this.limb = limb;
		}
		
		@Override
		public void run() {
			int i = 0;
			try {
				while (i < n) {
					System.out.println(limb + " - " + i);
					i ++;
					Thread.sleep(100);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
