package com.wistron.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.Meal;

public class MealDaoImpl {
	
	private SqlSessionFactory factory;
	
	//initialize factory when MealDaoImpl is created
	public MealDaoImpl() {
		super();
		try {
			factory = DaoUtil.getSqlSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public int ofood(List<Meal> meals) {
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.insert("com.wistron.meal.ofood.insert_meal", meals);
		sqlSession.commit();	
		return row;
	}		
	
	
	
	
	
	
	
	
}
