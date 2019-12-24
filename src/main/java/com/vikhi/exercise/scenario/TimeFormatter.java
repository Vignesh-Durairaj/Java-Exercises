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
	
	private final TimeDecoder secondsDecoder = new TimeDecoder(5, "second");
	private final TimeDecoder minutesDecoder = new TimeDecoder(4, "minute");
	private final TimeDecoder hoursDecoder = new TimeDecoder(3, "hour");
	private final TimeDecoder daysDecoder = new TimeDecoder(2, "day");
	private final TimeDecoder yearsDecoder = new TimeDecoder(1, "year");
	
	public String formatDuration(final int seconds) {
		
		Map<TimeDecoder, Integer> decoderMap = new HashMap<>();
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
		
		decoderMap.put(yearsDecoder, year);
		decoderMap.put(daysDecoder, day);
		decoderMap.put(hoursDecoder, hour);
		decoderMap.put(minutesDecoder, minute);
		decoderMap.put(secondsDecoder, second);
		
		List<String> decodedStrings = decoderMap.entrySet().stream()
			.filter(entry -> entry.getValue() > 0)
			.map(this::getDecodedString)
			.sorted(Map.Entry.comparingByKey())
			.map(Entry::getValue)
			.collect(Collectors.toList());
		
		if (decodedStrings.size() == 1) {
			decodedString = decodedStrings.get(0);
		} else if (decodedStrings.size() > 1) {
			decodedString = decodedStrings.subList(0, decodedStrings.size() - 1).stream().collect(Collectors.joining(", ")).concat(" and ").concat(decodedStrings.get(decodedStrings.size() - 1));
		}
		
		return decodedString;
	}
	
	private Entry<Integer, String> getDecodedString (Entry<TimeDecoder, Integer> decodedEntry) {
		Integer val = decodedEntry.getValue();
		return new Entry<Integer, String>() {

			@Override
			public Integer getKey() {
				return decodedEntry.getKey().getSortOrder();
			}

			@Override
			public String getValue() {
				setValue(null);
				return val.toString().concat(SYMBOL_SPACE).concat(decodedEntry.getKey().getDesc()).concat(val > 1 ? "s" : SYMBOL_BLANK);
			}

			@Override
			public String setValue(String value) {
				return value;
			}
			
		};
	}
	
	private class TimeDecoder {
		
		private int sortOrder;
		private String desc;

		public TimeDecoder(int sortOrder, String desc) {
			super();
			this.sortOrder = sortOrder;
			this.desc = desc;
		}

		public int getSortOrder() {
			return sortOrder;
		}

		public String getDesc() {
			return desc;
		}
		
	}
}
