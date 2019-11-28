package com.vikhi.exercise.scenario;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import com.vikhi.exercise.scenario.WalkingRobot.Dummy;
import com.vikhi.exercise.scenario.WalkingRobot.LimbMovement;


@RunWith(Enclosed.class)
public class WalkingRobotTest {

	@RunWith(MockitoJUnitRunner.class)
	public static class InterruptedRobotTest {
		
		@Spy private WalkingRobot interruptedRobot = spy(new WalkingRobot());
		private Dummy newDummy = mock(Dummy.class);
		
		@SuppressWarnings("unchecked")
		@Test(expected = InterruptedException.class)
		public void testForInterruptedRobot() {
			when(interruptedRobot.move(100)).thenThrow(InterruptedException.class);
			interruptedRobot.makeRobotMove(100);
		}
		
		@SuppressWarnings({ "static-access", "unchecked" })
		@Test
		public void testForAnotherInterruption() throws InterruptedException {
			when(newDummy.getDummy()).thenThrow(InterruptedException.class);
			LimbMovement limbMovement = interruptedRobot.new LimbMovement(10, "left").setDummy(newDummy);
			limbMovement.run();
		}
	}
	
	public static class GeneralRobotTest {
		
		private static WalkingRobot WalkingRobot;
		
		private String string = "String";
		
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
			assertEquals(string, "String");
			
			WalkingRobot.makeRobotMove(15);
			try {
				Thread.currentThread().stop();
			} catch (Throwable t) {
				t.printStackTrace();
			}
		}
		
		@Test
		public void testInterruptedRobot() {
			assertEquals(string, "String");
			Thread.currentThread().interrupt();
			Thread.currentThread().interrupt();
			WalkingRobot.makeRobotMove(200);
			WalkingRobot.makeRobotMove(10);
			Thread.currentThread().interrupt();
		}
	}
}
