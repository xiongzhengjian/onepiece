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
	
	
}
