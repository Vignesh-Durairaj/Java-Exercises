package com.vikhi.exercise;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtils {

	public Date getPreviousMonthLastDate () {
		
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		currentMonth = currentMonth == 0 ? 11 : currentMonth - 1;
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, currentMonth);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		return calendar.getTime();
	}	
}
