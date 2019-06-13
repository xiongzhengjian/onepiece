package com.wistron.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.Bios;
import com.wistron.pojo.Meal;
import com.wistron.pojo.Project;
import com.wistron.pojo.vo.Ordersubmit;

public class BiosDaoImpl {
	
	private SqlSessionFactory factory;
	private List<Bios> bioses;
	
	//initialize factory when MealDaoImpl is created
	public BiosDaoImpl() {
		super();
		try {
			factory = DaoUtil.getSqlSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	
	/**
	 * Insert multiple data
	 * @return
	 */
	public int insertBioses(List<Bios> bioses){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.bios.insertBioses", bioses);
		sqlSession.commit();	
		return rows;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
