package com.yfei.transxml;

import java.util.Calendar;

public class DateUtils {

	/**
	 * 检查是否是七天内的数据
	 * @param logtime 传入的日期long类型字串
	 * @return 如果是当前日期七天内的数据返回true
	 */
	public static boolean in7days(String logtime) {
		if(logtime!=null && logtime.length()>0) {
			long day = Long.parseLong(logtime);
			
			Calendar markdayCal = Calendar.getInstance();
			markdayCal.add(Calendar.DATE, -7);
			Calendar logday = Calendar.getInstance();
			logday.setTimeInMillis(day);
			
			return (markdayCal.before(logday));
		}else {
			return false;
		}
	}
}
