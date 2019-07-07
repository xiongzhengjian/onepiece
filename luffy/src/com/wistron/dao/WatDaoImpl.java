package com.wistron.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.Softpaq2;
import com.wistron.pojo.Wat;
import com.wistron.pojo.vo.Limit;

public class WatDaoImpl {
	
	private SqlSessionFactory factory;	
	
	//initialize factory when CommodityDaoImpl is created
	public WatDaoImpl() {
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
	public int insertMultiple(List<Wat> list){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.wat.insertMultiple", list);
		sqlSession.commit();	
		sqlSession.close();
		return rows;
	}
	
	/**
	 * find all and sort in reverse order by wat desc		
	 * @return
	 */
	public List<Wat> findAll(){
		SqlSession sqlSession = factory.openSession();		
		List<Wat> list = sqlSession.selectList("com.wistron.record.wat.findAll");
		sqlSession.close();
		return list;
	}


	public int update(Wat wat) {
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.update("com.wistron.record.wat.update", wat);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}
	
	public List<Wat> limitFindAll(Limit limit) {
		SqlSession sqlSession = factory.openSession();
		List<Wat> list = sqlSession.selectList("com.wistron.record.wat.limitFindAll",limit);
		sqlSession.close();
		return list;
	}
	
	public int count() {
		SqlSession sqlSession = factory.openSession();
		int  totalrows = sqlSession.selectOne("com.wistron.record.wat.count");
		sqlSession.close();
		return totalrows;
	}
	
	
	
	
	
	
	
	
	
	
}
