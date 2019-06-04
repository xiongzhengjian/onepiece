package dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.wistron.dao.UserDaoImpl;
import com.wistron.pojo.User;
import com.wistron.pojo.vo.OrderSituation;
import com.wistron.pojo.vo.Uservo;

public class Test_UserDao {
	
	private SqlSessionFactory factory;
	private UserDaoImpl userDao;
	
	@Before
	public void initFactory() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		factory = new SqlSessionFactoryBuilder().build(inputStream);
		userDao = new UserDaoImpl();
		
	}	
	
	/**
	 * get a data of user by user_id
	 * @throws Exception
	 */
	@Test
	public void testFindUserById() throws Exception {
		SqlSession sqlSession = factory.openSession();
		User user = sqlSession.selectOne("com.wistron.meal.user.findUserById",3);
		System.out.println(user);
		sqlSession.close();
		
	}
	/**
	 * insert a data into table user
	 * @throws Exception 
	 */
	@Test
	public void testInsertUser() throws Exception{
		User user1 =  new User(4,"Q17111011","陈美玲","Gina C Chen",'f',"Gina@Wistron.com",3);
		User user2 =  new User(5,"Q18060501","刘常凤","Fia Liu",'f',"Fia@Wistron.com",3);
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.insert("com.wistron.meal.user.insertUser",user2);
		sqlSession.commit();
		sqlSession.close();		
	}
	
	@Test
	public void testUpdateUser() throws Exception{
		SqlSession sqlSession = factory.openSession();
		User user = new User();
		user.setEnname("Gina C Chen");
		user.setUser_id(7);
		int row = sqlSession.update("com.wistron.meal.user.updateUserById",user);
		sqlSession.commit();
		sqlSession.close();		
	}
	
	@Test
	public void orderSituation() throws Exception{		
		OrderSituation orderSituation = userDao.orderSituation();
		System.out.println(orderSituation);
		
	}
	@Test
	public void findNomealstatus() throws Exception{		
		List<Uservo> uservos = userDao.findNomealstatus();
		System.out.println(uservos);
		
	}
	
	@Test
	public void orderSituationStep1() throws Exception{		
		List<OrderSituation> listOrderSituationStep1 = userDao.orderSituationStep1();
		System.out.println(listOrderSituationStep1);
		
	}
	@Test
	public void orderSituationStep2() throws Exception{		
		List<OrderSituation> listOrderSituationStep2 = userDao.orderSituationStep2();
		System.out.println(listOrderSituationStep2);
		
	}
	
	
}
