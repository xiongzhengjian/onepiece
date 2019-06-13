package util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import com.wistron.pojo.vo.Ordersubmit;
import com.wistron.utils.DateUtils;

public class TestDateUtils {
	
	
	
	@Test
	public void dateAdd() throws ParseException {
//		Date dateAdd = DateUtils.dateAdd(new Date(), 1, false);
//		System.out.println(dateAdd);
		
		Ordersubmit ordersubmit = new Ordersubmit();
		System.out.println(ordersubmit.getToday());
//		System.out.println(ordersubmit.getNextday());
		
	}
	
	@Test
	public void all() throws ParseException {
		Date date = new Date();
		String format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(date);
		String string = date.toString();
		System.out.println(string);
		System.out.println(format);
		
	}
	@Test
	public void test1() throws ParseException {
		String schedule = "06/13/2019 - 09/18/2019";
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
			  
			 String s = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
			 String e = new SimpleDateFormat("yyyy-MM-dd").format(endDate);
		
		System.out.println(s+"===="+e);
		
	}
	
	
}
