package com.vikhi.exercise.scenario;

public class WalkingRobot {

	
	public void move (int n) {
		Thread t1 = null;
		if (n <= 0) {
			t1 = new Thread(new LimbMovement(3, null));
		}
		t1 = new Thread (new LimbMovement(n, "Left"));
		Thread t2 = new Thread (new LimbMovement(n, "Right"));
		
		System.out.println("Starting movement");
		
		t1.start();
		t2.start();
	}
	
	public static void main(String[] args) {
		WalkingRobot robot = new WalkingRobot();
		robot.move(Integer.parseInt(args[0]));
	}
	
	class LimbMovement implements Runnable {
		
		private int n;
		
		private String limb;

		public LimbMovement(int n, String limb) {
			this.n = n;
			this.limb = limb;
		}
		
		@Override
		public void run(){
			int i = 0;
			try {
				while (i < n) {
					System.out.println(limb + " - " + i);
					i ++;
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				Thread.currentThread().interrupt();
			}
		}
	}
}
