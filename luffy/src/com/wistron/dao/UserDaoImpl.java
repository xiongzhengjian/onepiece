package com.wistron.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.User;
import com.wistron.pojo.vo.OrderSituation;
import com.wistron.pojo.vo.Uservo;

public class UserDaoImpl {
	
	private SqlSessionFactory factory;

	public UserDaoImpl() {
		super();
		try {
			factory = DaoUtil.getSqlSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User findUserByStaffid(String staffid) {
		
		SqlSession sqlSession = factory.openSession();
		User user = sqlSession.selectOne("com.wistron.meal.user.findUserByStaffid",staffid);
		return user;
	}
	
	public User findUserById(int user_id) {
		SqlSession sqlSession = factory.openSession();
		User user = sqlSession.selectOne("com.wistron.meal.user.findUserById", user_id);
		return user;
	}

	public OrderSituation orderSituation() {
		SqlSession sqlSession = factory.openSession();
		OrderSituation orderSituation = sqlSession.selectOne("com.wistron.meal.user.orderSituation");
		return orderSituation;
	}
	
	public List<Uservo> findNomealstatus(){
		SqlSession sqlSession = factory.openSession();		
		List<Uservo> uservos = sqlSession.selectList("com.wistron.meal.user.findNomealstatus");
		return uservos;
	}
	/**
	 * find  1 dept 2 emplloyeeNum value after group by department
	 * @return
	 */
	public List<OrderSituation> userAmount(){
		SqlSession sqlSession = factory.openSession();	
		List<OrderSituation> listOrderSituationStep1 = sqlSession.selectList("com.wistron.meal.user.userAmount");
		return listOrderSituationStep1;
	}
	/**
	 * find  1STQ00 orderedNum 
	 * @return
	 */
	public int deptStq00(){
		SqlSession sqlSession = factory.openSession();	
		int stq00 = sqlSession.selectOne("com.wistron.meal.user.1stq00");
		return stq00;
	}
	public int deptStq10(){
		SqlSession sqlSession = factory.openSession();	
		int stq00 = sqlSession.selectOne("com.wistron.meal.user.1stq10");
		return stq00;
	}
	public int deptStq20(){
		SqlSession sqlSession = factory.openSession();	
		int stq00 = sqlSession.selectOne("com.wistron.meal.user.1stq20");
		return stq00;
	}

	public void updateMealStatus(String staffid) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.update("com.wistron.meal.user.updateMealStatus",staffid);
		sqlSession.commit();
	}
	
}
