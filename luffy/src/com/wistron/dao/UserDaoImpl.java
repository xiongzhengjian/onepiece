package com.wistron.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.User;

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
	
}
