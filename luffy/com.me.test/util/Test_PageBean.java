package util;

import java.util.List;

import org.junit.Test;

import com.wistron.dao.BiosDaoImpl;
import com.wistron.pojo.Bios;
import com.wistron.pojo.vo.Page;

public class Test_PageBean {
	
	BiosDaoImpl biosDao = new BiosDaoImpl(); 
	/**
	 * With two arguments, the first argument specifies the offset of the first row to return, 
	 * and the second specifies the maximum number of rows to return.
	 *  The offset of the initial row is 0 (not 1): 
		SELECT * FROM tbl LIMIT 5,10;  # Retrieve rows 6-15
	 */
	@Test
	public void test1() {
		List<Bios> list = biosDao.limitFindAll(new Page(0,10));
		int totalRecord = list.size();
		
		System.out.println(list);
		
	}

}
