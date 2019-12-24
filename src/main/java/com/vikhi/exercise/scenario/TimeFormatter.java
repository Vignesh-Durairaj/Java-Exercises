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
		String decodedString = "now";
		
		int remaining = seconds;
		int second = 0;
		int minute = 0;
		int hour = 0;
		int day = 0;
		int year = 0;
		
		if (seconds > YEAR) {
			year = remaining / YEAR;
			remaining = remaining % YEAR;
		}
		
		if (seconds > DAY) {
			day = remaining / DAY;
			remaining = remaining % DAY;
			
			if (day == 365) {
				year ++;
				day = 0;
			}
		}
		
		if (seconds > HOUR) {
			hour = remaining / HOUR;
			remaining = remaining % HOUR;
			
			if (hour == 24) {
				day ++;
				hour = 0;
			}
		}
		
		if (seconds > MINUTE) {
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
		} else if (decodedStrings.size() > 1) {
			decodedString = decodedStrings.subList(0, decodedStrings.size() - 1).stream().collect(Collectors.joining(", ")).concat(" and ").concat(decodedStrings.get(decodedStrings.size() - 1));
		}
		
		return decodedString;
	}
	
	private String getDecodedString (Entry<String, Integer> decodedEntry) {
		Integer val = decodedEntry.getValue();
		return val.toString().concat(SYMBOL_SPACE).concat(decodedEntry.getKey()).concat(val > 1 ? "s" : SYMBOL_BLANK);
	}
}
