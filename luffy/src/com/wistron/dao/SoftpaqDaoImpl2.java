package com.wistron.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.Commodity;
import com.wistron.pojo.Softpaq;
import com.wistron.pojo.Softpaq2;
import com.wistron.pojo.vo.Limit;

public class SoftpaqDaoImpl2 {
	
	private SqlSessionFactory factory;	
	
	//initialize factory when CommodityDaoImpl is created
	public SoftpaqDaoImpl2() {
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
	public int insertMultiple(List<Softpaq2> softpaq){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.softpaq2.insertMultiple", softpaq);
		sqlSession.commit();	
		sqlSession.close();
		return rows;
	}
	
	/**
	 * find all and sort in reverse order by softpaq2 desc		
	 * @return
	 */
	public List<Softpaq2> findAll(){
		SqlSession sqlSession = factory.openSession();		
		List<Softpaq2> list = sqlSession.selectList("com.wistron.record.softpaq2.findAll");
		sqlSession.close();
		return list;
	}


	public int update(Softpaq2 softpaq) {
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.update("com.wistron.record.softpaq2.update", softpaq);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}
	
	public List<Softpaq2> limitFindAll(Limit limit) {
		SqlSession sqlSession = factory.openSession();
		List<Softpaq2> list = sqlSession.selectList("com.wistron.record.softpaq2.limitFindAll",limit);
		sqlSession.close();
		return list;
	}
	
	public int count() {
		SqlSession sqlSession = factory.openSession();
		int  totalrows = sqlSession.selectOne("com.wistron.record.softpaq2.count");
		sqlSession.close();
		return totalrows;
	}
	
	
	
	
	
	
	
	
	
	
	
}
