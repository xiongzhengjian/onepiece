package dao;


import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wistron.dao.DictionaryDaoImpl;
import com.wistron.pojo.Dictionary;

public class DaoTest_Dictionary {
	
	private DictionaryDaoImpl dictionaryDao;
	
	@Before
	public void initFactory() throws Exception {		
		dictionaryDao = new DictionaryDaoImpl();
	}	
	
	
	@Test
	public void testFindById() throws Exception {
		Dictionary dictionary = dictionaryDao.findById(1);	
		System.out.println(dictionary);	
		
	}
	
	@Test
	public void insert() throws Exception {
		Dictionary dic1 = new Dictionary(11,"test1","T1");
		Dictionary dic2 = new Dictionary(12,"dic12","T2");
		dictionaryDao.insert(dic2);	
		
	}
	
	@Test
	public void update() throws Exception {
		//data of dictionary item 11 is(11,test1,T1)
		Dictionary dic = new Dictionary(11,"test12","T2");
		dictionaryDao.update(dic);	
		
	}
	
	@Test
	public void delete() throws Exception {		
		dictionaryDao.delete(12);			
	}
	
	@Test
	public void findAll() throws Exception {		
		List<Dictionary> all = dictionaryDao.findAll();
		System.out.println(all);
	}

	
	
}
