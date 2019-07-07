package com.wistron.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import com.wistron.pojo.Softpaq;

public class SoftpaqDaoImpl {
	
	private SqlSessionFactory factory;	
	
	//initialize factory when CommodityDaoImpl is created
	public SoftpaqDaoImpl() {
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
	public int insertMultiple(List<Softpaq> softpaq){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.softpaq.insertMultiple", softpaq);
		sqlSession.commit();	
		sqlSession.close();
		return rows;
	}
	
	/**
	 * find all and sort in reverse order by softpaq desc		
	 * @return
	 */
	public List<Softpaq> findAll(){
		SqlSession sqlSession = factory.openSession();		
		List<Softpaq> list = sqlSession.selectList("com.wistron.record.softpaq.findAll");
		sqlSession.close();
		return list;
	}


	public int update(Softpaq softpaq) {
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.update("com.wistron.record.softpaq.update", softpaq);
		sqlSession.commit();
		sqlSession.close();
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
