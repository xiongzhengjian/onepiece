package dao;



import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wistron.dao.MealDaoImpl;
import com.wistron.pojo.Meal;
import com.wistron.pojo.vo.Ordersubmit;

public class DaoTest_Meal {
	
	private MealDaoImpl mealDao;
	
	@Before
	public void initFactory() throws Exception {		
		mealDao = new MealDaoImpl();
	}		
	
	
	@Test
	public void findAll() throws Exception {
		Ordersubmit ordersubmit = new Ordersubmit();
		ordersubmit.setUser_id(2);
		List<Meal> all = mealDao.findAll(ordersubmit);
		System.out.println(all);
		
	}

	
	
}
