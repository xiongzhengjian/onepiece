package dao;



import java.text.SimpleDateFormat;
import java.util.Date;
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
	
	@Test
	public void findAllLater() throws Exception {
		Ordersubmit ordersubmit = new Ordersubmit();
		ordersubmit.setUser_id(11);
		List<Meal> all = mealDao.findAllLater(ordersubmit);
		System.out.println(all);
		
	}
	
//	@Test
//	public void findTodayData() throws Exception {
//		String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
//		//Find out if the user has a meal record for the day
//		
//		 Meal meal = new Meal();
//		 meal.setDate(new SimpleDateFormat("yyyy-MM-dd").parse(today));
//		 meal.setUser(11);
//		int value = mealDao.findTodayData(meal);
//		System.out.println(value);
//		
//	}
	

	
	
}
