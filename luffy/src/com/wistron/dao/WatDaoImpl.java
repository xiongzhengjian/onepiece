package com.wistron.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.wistron.pojo.Wat;

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
		return rows;
	}
	
	/**
	 * find all and sort in reverse order by wat desc		
	 * @return
	 */
	public List<Wat> findAll(){
		SqlSession sqlSession = factory.openSession();		
		List<Wat> list = sqlSession.selectList("com.wistron.record.wat.findAll");
		return list;
	}


	public int update(Wat wat) {
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.update("com.wistron.record.wat.update", wat);
		sqlSession.commit();
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
