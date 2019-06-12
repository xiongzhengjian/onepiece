package com.wistron.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.Meal;
import com.wistron.pojo.Project;
import com.wistron.pojo.vo.Ordersubmit;

public class ProjectDaoImpl {
	
	private SqlSessionFactory factory;
	private List<Project> projects;
	
	//initialize factory when MealDaoImpl is created
	public ProjectDaoImpl() {
		super();
		try {
			factory = DaoUtil.getSqlSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	/**
	 * 
	 * @return
	 */
	public List<Project> findChassises(){
		SqlSession sqlSession = factory.openSession();
		projects = sqlSession.selectList("com.wistron.record.project.findchassises");
		return projects;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Project> findPlatform(String chassis){
		SqlSession sqlSession = factory.openSession();
		projects = sqlSession.selectList("com.wistron.record.project.findplatform",chassis);
		return projects;
	}
	
	
	
	
	
	
	
	
	
	
	
}
