package com.vikhi.exercise.scenario;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;


@RunWith(Enclosed.class)
public class WalkingRobotTest {

	@RunWith(MockitoJUnitRunner.class)
	public static class InterruptedRobotTest {
		
		@Spy
		private WalkingRobot interruptedRobot = spy(new WalkingRobot());
		
		@SuppressWarnings("unchecked")
		@Test(expected = InterruptedException.class)
		public void testForInterruptedRobot() {
			Mockito.when(interruptedRobot.move(100)).thenThrow(InterruptedException.class);
			interruptedRobot.makeRobotMove(100);
		}
	}
	
	public static class GeneralRobotTest {
		
		private static WalkingRobot WalkingRobot;
		
		@BeforeClass
		public static void init() {
			WalkingRobot = new WalkingRobot();
		}
		
		@SuppressWarnings("deprecation")
		@Test
		public void testRobot() throws InterruptedException {
			WalkingRobot.makeRobotMove(5);
			WalkingRobot.makeRobotMove(0);
			WalkingRobot.makeRobotMove(-5);
			assertEquals("String", "String");
			
			WalkingRobot.makeRobotMove(15);
			try {
				Thread.currentThread().stop();
			} catch (Throwable t) {
				System.out.println("Thread Death encountered");
			}
			
			WalkingRobot.makeRobotMove(500);
			Thread.sleep(3000);
			Thread.currentThread().interrupt();
		}
		
		@Test
		public void testInterruptedRobot() {
			assertEquals("String", "String");
			Thread.currentThread().interrupt();
			Thread.currentThread().interrupt();
			WalkingRobot.makeRobotMove(200);
			WalkingRobot.makeRobotMove(10);
			Thread.currentThread().interrupt();
		}
	}
}
