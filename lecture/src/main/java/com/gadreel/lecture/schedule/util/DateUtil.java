package com.gadreel.lecture.schedule.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static Date stringToDate(String dateStr){
		try{
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			return df.parse(dateStr);
		} catch(ParseException exception){
			return null;
		}
	}
	
	public static String dateToString(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		return df.format(date);
	}
}
