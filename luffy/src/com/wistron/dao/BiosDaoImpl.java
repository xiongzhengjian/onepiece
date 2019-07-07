package com.wistron.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.Bios;
import com.wistron.pojo.vo.Limit;

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
		sqlSession.close();
		return rows;
	}
	
	/**
	 * find all and sort in reverse order by bios_id desc		
	 * @return
	 */
	public List<Bios> findAll(){
		SqlSession sqlSession = factory.openSession();		
		List<Bios> list = sqlSession.selectList("com.wistron.record.bios.findAll");
		sqlSession.close();
		return list;
	}


	public int edit(Bios bios) {
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.update("com.wistron.record.bios.update", bios);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}


	public List<Bios> limitFindAll(Limit limit) {
		SqlSession sqlSession = factory.openSession();		
		List<Bios> list = sqlSession.selectList("com.wistron.record.bios.limitFindAll",limit);
		sqlSession.close();
		return list;
	}
	
	public int count() {
		SqlSession sqlSession = factory.openSession();
		int  totalrows = sqlSession.selectOne("com.wistron.record.bios.count");
		sqlSession.close();
		return totalrows;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
