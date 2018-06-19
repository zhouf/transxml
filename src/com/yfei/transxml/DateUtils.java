package com.yfei.transxml;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	/**
	 * 通过文件名规则判断是否是七天内的数据
	 * @param xmlFileName 文件名参数如：reqlog_2018_06_03_15_23_15_728.xml
	 * @return 是七天内数据返回 true，否则返回false
	 */
	public static boolean xmlFilein7days(String xmlFileName) {
		//xmlFileName=reqlog_2018_06_03_15_23_15_728.xml
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd");
		Calendar markdayCal = Calendar.getInstance();
		markdayCal.add(Calendar.DATE, -7);
		
		String str=xmlFileName.substring(7, 17);
		Calendar fileDate = Calendar.getInstance();
		try {
			fileDate.setTime(sdf.parse(str));
			return markdayCal.before(fileDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return false;
	}
}
