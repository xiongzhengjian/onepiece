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
	//private List<Bios> bioses;
	
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
	
	/**
	 * find all and sort in reverse order by bios_id desc		
	 * @return
	 */
	public List<Bios> findAll(){
		SqlSession sqlSession = factory.openSession();		
		List<Bios> list = sqlSession.selectList("com.wistron.record.bios.findAll");
		return list;
	}


	public int edit(Bios bios) {
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.update("com.wistron.record.bios.update", bios);
		sqlSession.commit();
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
