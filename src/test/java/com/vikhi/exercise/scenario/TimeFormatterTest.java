package com.vikhi.exercise.scenario;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Enclosed.class)
public class TimeFormatterTest {

	@RunWith(Parameterized.class)
	public static class ParameterizedTest {
		
		private int seconds;
		private String formattedTime;
		private TimeFormatter timeFormatter;
		
		public ParameterizedTest(int seconds, String formattedTime) {
			this.seconds = seconds;
			this.formattedTime = formattedTime;
			this.timeFormatter = new TimeFormatter();
		}
		
		@Parameters
		public static Collection<Object[]> params() {
			return Arrays.asList(new Object[][] {
				{1, "1 second"}, 
				{60, "1 minute"}, 
				{62, "1 minute and 2 seconds"}, 
				{120, "2 minutes"}, 
				{3600, "1 hour"}, 
				{3662, "1 hour, 1 minute and 2 seconds"}
			});
		}
		
		@Test
		public void testTimeFormatting() {
			assertEquals(formattedTime, timeFormatter.formatDuration(seconds));
		}
	}
	
	public static class singleScenarioTest {
		
	}
}
