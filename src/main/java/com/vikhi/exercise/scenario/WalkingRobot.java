package com.vikhi.exercise.scenario;

import org.apache.log4j.Logger;

public class WalkingRobot {

	private final Logger log = Logger.getLogger(this.getClass());
	
	protected boolean move (int n) {
		Thread t1 = null;
		if (n <= 0) {
			t1 = new Thread(new LimbMovement(3, null));
		}
		t1 = new Thread (new LimbMovement(n, "Left"));
		Thread t2 = new Thread (new LimbMovement(n, "Right"));
		
		log.info("Starting movement");
		
		t1.start();
		t2.start();
		return true;
	}
	
	public void makeRobotMove (int steps) {
		move(steps);
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
					log.info(limb + " - " + i);
					i ++;
					Thread.sleep(100);
				}
			} catch (InterruptedException e) {
				log.error(e);
				Thread.currentThread().interrupt();
			}
		}
	}
}
