package com.wistron.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.User;
import com.wistron.pojo.vo.OrderSituation;

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
	
}
