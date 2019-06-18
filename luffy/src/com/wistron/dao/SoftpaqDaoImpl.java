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
	public int insertSoftpaqs(List<Softpaq> softpaq){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.softpaq.insertSoftpaqs", softpaq);
		sqlSession.commit();	
		return rows;
	}
	
	/**
	 * find all and sort in reverse order by softpaq desc		
	 * @return
	 */
	public List<Softpaq> findAllSoftpaq(){
		SqlSession sqlSession = factory.openSession();		
		List<Softpaq> list = sqlSession.selectList("com.wistron.record.softpaq.findAllSoftpaq");
		return list;
	}


	public int updateSoftpaq(Softpaq softpaq) {
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.update("com.wistron.record.softpaq.updateSoftpaq", softpaq);
		sqlSession.commit();
		return row;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
