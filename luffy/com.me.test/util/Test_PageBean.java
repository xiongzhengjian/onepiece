package util;

import java.util.List;

import org.junit.Test;

import com.wistron.dao.BiosDaoImpl;
import com.wistron.pojo.Bios;
import com.wistron.pojo.vo.Limit;
import com.wistron.utils.PageBean;

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
		
		
		
		int totalRows = biosDao.count();
		int currentPage = 2;
		int perPageRows = 15;
		PageBean<Bios> pageBean = new PageBean<Bios>(totalRows,perPageRows,currentPage);
		List<Bios> data = biosDao.limitFindAll(new Limit(pageBean.getOffset(),pageBean.getPerPageRows()));
//		pageBean.setData(data);
		
		
		int offset = pageBean.getOffset();
		int pageRangeStart = pageBean.getPageRangeStart();
		int pageRangeEnd = pageBean.getPageRangeEnd();
//		List<Bios> list = pageBean.getData();
		
//		System.out.println(list);
		System.out.println("totalRows:  "+totalRows+";  totalPage:  "+pageBean.getTotalPage()+";  offset:  "+offset+";  pageRangeStart  :"+pageRangeStart+";  pageRangeEnd:   "+pageRangeEnd);
		
		for(int i=pageBean.getPageRangeStart();i<=pageBean.getPageRangeEnd();i++) {
			System.out.print(i+", ");
		}
		
	}

}
