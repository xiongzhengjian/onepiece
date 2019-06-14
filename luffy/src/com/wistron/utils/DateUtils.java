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
     * 
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
    
    /**
     * 
     * @param schedule(MM/dd/YYYY:06/13/2019 - 09/18/2019 )
     * @return  return two date formate is yyyy-MM-dd
     * @throws ParseException
     */
    public static Date[] splitSchedule(String schedule) throws ParseException {
		 schedule.replaceAll(" ", "");
		 //06/13/2019 - 09/18/2019  
		 String[] startAndEnd = schedule.split("-");		
			 //06/13/2019
			 String startStr = startAndEnd[0];
			 //09/18/2019
			 String endStr = startAndEnd[1];
			 //06 13 2019
			 String[] startmdy  = startStr.split("/");
			//09 18 2019
			 String[] endmdy  = endStr.split("/");
			 // 2019-06-13
			 String startymd = startmdy[2]+"-"+startmdy[0]+"-"+startmdy[1];
			 String endymd = endmdy[2]+"-"+endmdy[0]+"-"+endmdy[1];
			 Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startymd.replaceAll(" ", ""));
			 Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endymd.replaceAll(" ", ""));
			 Date[] startDateAndEndDate = {startDate,endDate};		
			 return startDateAndEndDate; 
	 }
    
    
}
