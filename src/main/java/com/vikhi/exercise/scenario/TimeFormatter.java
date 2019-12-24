package com.vikhi.exercise.scenario;

import static com.vikhi.util.ConstantsHelper.SYMBOL_BLANK;
import static com.vikhi.util.ConstantsHelper.SYMBOL_SPACE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class TimeFormatter {

	private static final int MINUTE = 60;
	private static final int HOUR = 3600;
	private static final int DAY = 86400;
	private static final int YEAR = 31536000;
	
	private static final String SECOND_STR = "second";
	private static final String MINUTE_STR = "minute";
	private static final String HOUR_STR = "hour";
	private static final String DAY_STR = "day";
	private static final String YEAR_STR = "year";
	
	public String formatDuration(final int seconds) {
		
		Map<String, Integer> decoderMap = new HashMap<>();
		String decodedString;
		
		int remaining = seconds;
		int second = 0;
		int minute = 0;
		int hour = 0;
		int day = 0;
		int year = 0;
		
		if (seconds > 31536000) {
			year = remaining / DAY;
			remaining = remaining % YEAR;
		}
		
		if (seconds > 86400) {
			day = remaining / DAY;
			remaining = remaining % DAY;
			
			if (day == 365) {
				year ++;
				day = 0;
			}
		}
		
		if (seconds > 3600) {
			hour = remaining / HOUR;
			remaining = remaining % HOUR;
			
			if (hour == 24) {
				day ++;
				hour = 0;
			}
		}
		
		if (seconds > 60) {
			minute = remaining / MINUTE;
			remaining = remaining % MINUTE;
			
			if (minute == 60) {
				hour ++;
				minute = 0;
			}
		}
		
		second = remaining;
		if (second == 60) {
			minute ++;
			second = 0;
		}
		
		decoderMap.put(YEAR_STR, year);
		decoderMap.put(DAY_STR, day);
		decoderMap.put(HOUR_STR, hour);
		decoderMap.put(MINUTE_STR, minute);
		decoderMap.put(SECOND_STR, second);
		
		List<String> decodedStrings = decoderMap.entrySet().stream()
			.filter(entry -> entry.getValue() > 0)
			.map(this::getDecodedString)
			.collect(Collectors.toList());
		
		if (decodedStrings.size() == 1) {
			decodedString = decodedStrings.get(0);
		} else {
			decodedString = decodedStrings.subList(0, decodedStrings.size() - 1).stream().collect(Collectors.joining(", ")).concat(" and ").concat(decodedStrings.get(decodedStrings.size() - 1));
		}
		
		return decodedString;
	}
	
	private String getDecodedString (Entry<String, Integer> decodedEntry) {
		Integer val = decodedEntry.getValue();
		return val.toString().concat(SYMBOL_SPACE).concat(decodedEntry.getKey()).concat(val > 1 ? "s" : SYMBOL_BLANK);
	}
	
	private void restructureMap (final Map<String, Integer> inputMap) {
		for (Entry<String, Integer> entry : inputMap.entrySet()) {
			if (entry.getKey().equals(SECOND_STR) && entry.getValue().equals(MINUTE)) {
				inputMap.put(SECOND_STR, 0);
				inputMap.put(MINUTE_STR, inputMap.get(MINUTE_STR) + 1);
			}
			
			if (entry.getKey().equals(MINUTE_STR) && entry.getValue().equals(MINUTE)) {
				inputMap.put(MINUTE_STR, 0);
				inputMap.put(HOUR_STR, inputMap.get(HOUR_STR) + 1);
			}
			
			if (entry.getKey().equals(HOUR_STR) && entry.getValue().equals(24)) {
				inputMap.put(HOUR_STR, 0);
				inputMap.put(DAY_STR, inputMap.get(DAY_STR) + 1);
			}
			
			if (entry.getKey().equals(DAY_STR) && entry.getValue().equals(365)) {
				inputMap.put(DAY_STR, 0);
				inputMap.put(YEAR_STR, inputMap.get(YEAR_STR) + 1);
			}
		}
	}
	
	private Map<String, DecodeObject> initDecoderMap() {
		Map<String, DecodeObject> decoderMap = new HashMap<>();
		decoderMap.put(SECOND_STR, new DecodeObject(SECOND_STR, 60, 60));
		decoderMap.put(MINUTE_STR, new DecodeObject(MINUTE_STR, 60, 60));
		decoderMap.put(HOUR_STR, new DecodeObject(HOUR_STR, 24, 3600));
		decoderMap.put(DAY_STR, new DecodeObject(DAY_STR, 365, 86400));
		decoderMap.put(YEAR_STR, new DecodeObject(YEAR_STR, 1, 31536000));
		
		return decoderMap;
	}
	
	private class DecodeObject {
		private String componentName;
		private int maxValue;
		private int maxSeconds;
		
		public DecodeObject(String componentName, int maxValue, int maxSeconds) {
			super();
			this.componentName = componentName;
			this.maxValue = maxValue;
			this.maxSeconds = maxSeconds;
		}

		public String getComponentName() {
			return componentName;
		}

		public int getMaxValue() {
			return maxValue;
		}

		public int getMaxSeconds() {
			return maxSeconds;
		}
	}
}
