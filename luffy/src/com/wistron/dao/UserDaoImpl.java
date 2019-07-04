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
	public List<OrderSituation> orderSituationStep1(){
		SqlSession sqlSession = factory.openSession();	
		List<OrderSituation> listOrderSituationStep1 = sqlSession.selectList("com.wistron.meal.user.orderSituationStep1");
		return listOrderSituationStep1;
	}
	/**
	 * find   3 orderedNum 4 notOrderedNum 5 orderRatem value after group by department
	 * @return
	 */
	public List<OrderSituation> orderSituationStep2(){
		SqlSession sqlSession = factory.openSession();	
		List<OrderSituation> listOrderSituationStep2 = sqlSession.selectList("com.wistron.meal.user.orderSituationStep2");
		return listOrderSituationStep2;
	}

	public void updateMealStatus(String staffid) {
		SqlSession sqlSession = factory.openSession();
		sqlSession.update("com.wistron.meal.user.updateMealStatus",staffid);
		sqlSession.commit();
	}
	
}
