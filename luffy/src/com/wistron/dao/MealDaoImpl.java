package com.wistron.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.Meal;
import com.wistron.pojo.vo.Ordersubmit;

public class MealDaoImpl {
	
	private SqlSessionFactory factory;
	private List<Meal> meals;
	
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
		sqlSession.close();
		return row;
	}
	/**
	 * find all meal data that meal date >= today
	 * @return
	 */
	public List<Meal> findAll(Ordersubmit ordersubmit){
		SqlSession sqlSession = factory.openSession();
		meals = sqlSession.selectList("com.wistron.meal.ofood.findAll",ordersubmit);
		sqlSession.close();
		return meals;
	}
	
	public List<Meal> findAllLater(Ordersubmit ordersubmit){
		SqlSession sqlSession = factory.openSession();
		meals = sqlSession.selectList("com.wistron.meal.ofood.findAllLater",ordersubmit);
		sqlSession.close();
		return meals;
	}

	public int update(Meal meal) {
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.update("com.wistron.meal.ofood.update", meal);
		sqlSession.commit();
		sqlSession.close();
		return rows;
	}

	public List<Meal> findTodayData(Meal meal) {
		SqlSession sqlSession = factory.openSession();
		List<Meal> list = sqlSession.selectList("com.wistron.meal.ofood.findTodayData", meal);
		sqlSession.close();
		return list;
	}
	
//	public List<Integer> findTodayData(Meal meal) {
//		SqlSession sqlSession = factory.openSession();
//		List<Integer> list = sqlSession.selectList("com.wistron.meal.ofood.findTodayData", meal);
//		return list;
//	}
	
	
	
	
	
	
	
	
}
