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
     * Compare the sizes of two dates
     * myDate>compareDate return 1
     * myDate<compareDate return-1
     * myDate==compareDate return 0 
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
    
    /**
     * 日期相加减天数
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
            SimpleDateFormat sdf = new SimpleDateFormat(DateUtils_origin.DATE_PATTERN);
            date = sdf.parse(sdf.format(date));
        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days);
        return cal.getTime();
    }
}
