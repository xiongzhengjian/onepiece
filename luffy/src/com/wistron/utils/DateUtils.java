package com.wistron.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class DateUtils {
    
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String MONTH_PATTERN = "yyyy-MM";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String MINUTE_ONLY_PATTERN = "mm";
    public static final String HOUR_ONLY_PATTERN = "HH";
    
    /**
     * add date according to parameter days then return the result of date  
     * @param date if is Null the value is current day
     * @param days : count of days to add
     * @param includeTime:  is include hh mm ss; true:include
     * @return	return the date after added  days
     * @throws ParseException 
     */
    public static Date dateAdd(Date date, int days, boolean includeTime) throws ParseException{
        if(date == null){
            date = new Date();
        }
        if(!includeTime){
            SimpleDateFormat sdf = new SimpleDateFormat(DateUtils.DATE_PATTERN);
            date = sdf.parse(sdf.format(date));
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
    
  
    
    /**
     * 将日期时间格式成日期对象，和dateParse互用
     * @param dateTime Date
     * @return Date
     * @throws ParseException
     */
    public static Date dateTimeToDate(Date dateTime) throws ParseException{
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }    
  

    /** 
     * 时间加减天数 
     * @param startDate 要处理的时间，Null则为当前时间 
     * @param days 加减的天数 
     * @return Date 
     */  
    public static Date dateAddDays(Date startDate, int days) {  
        if (startDate == null) {  
            startDate = new Date();  
        }  
        Calendar c = Calendar.getInstance();  
        c.setTime(startDate);  
        c.set(Calendar.DATE, c.get(Calendar.DATE) + days);  
        return c.getTime();  
    }
    
 
    
    /** 
     * 时间比较（如果myDate>compareDate返回1，<返回-1，相等返回0） 
     * @param myDate 时间 
     * @param compareDate 要比较的时间 
     * @return int 
     */  
    public static int dateCompare(Date myDate, Date compareDate) {  
        Calendar myCal = Calendar.getInstance();  
        Calendar compareCal = Calendar.getInstance();  
        myCal.setTime(myDate);  
        compareCal.setTime(compareDate);  
        return myCal.compareTo(compareCal);    
   
    
    }
}
