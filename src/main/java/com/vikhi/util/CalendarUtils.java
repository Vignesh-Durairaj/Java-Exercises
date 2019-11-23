package com.vikhi.util;

import java.util.Calendar;
import java.util.Date;

public class CalendarUtils {

	public Date getPreviousMonthLastDate () {
		return getPreviousMonthLastDate(Calendar.getInstance().get(Calendar.MONTH));
	}
	
	public Date getPreviousMonthLastDate(int currentMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, currentMonth == 0 ? 11 : currentMonth - 1);
		calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		
		return calendar.getTime();
	}
}
