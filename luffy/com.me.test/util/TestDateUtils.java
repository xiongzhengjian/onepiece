package util;


import java.text.ParseException;
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
	
	
}
