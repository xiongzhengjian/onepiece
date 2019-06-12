package dao;



import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.wistron.dao.MealDaoImpl;
import com.wistron.dao.ProjectDaoImpl;
import com.wistron.pojo.Meal;
import com.wistron.pojo.Project;
import com.wistron.pojo.vo.Ordersubmit;

public class DaoTest_Project {
	
	private ProjectDaoImpl projectDao;
	
	@Before
	public void initFactory() throws Exception {		
		projectDao = new ProjectDaoImpl();
	}		
	
	
	@Test
	public void findchassises() throws Exception {//pass			
		List<Project> chassises = projectDao.findChassises();
		System.out.println(chassises);
		
	}
	
	@Test
	public void findplatform() throws Exception {//pass			
		List<Project> chassises = projectDao.findPlatform("Shave3");
		System.out.println(chassises);
		
	}
	
	

	
	
}
