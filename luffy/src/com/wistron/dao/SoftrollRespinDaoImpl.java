package com.wistron.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.SoftrollRespin;
import com.wistron.pojo.Wat;
import com.wistron.pojo.vo.Limit;

public class SoftrollRespinDaoImpl {
	
	private SqlSessionFactory factory;	
	
	//initialize factory when CommodityDaoImpl is created
	public SoftrollRespinDaoImpl() {
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
	public int insertMultiple(List<SoftrollRespin> list){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.softrollrespin.insertMultiple", list);
		sqlSession.commit();	
		return rows;
	}
	
	/**
	 * find all and sort in reverse order by wat desc		
	 * @return
	 */
	public List<SoftrollRespin> findAll(){
		SqlSession sqlSession = factory.openSession();		
		List<SoftrollRespin> list = sqlSession.selectList("com.wistron.record.softrollrespin.findAll");
		return list;
	}


	public int update(SoftrollRespin dao) {
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.update("com.wistron.record.softrollrespin.update", dao);
		sqlSession.commit();
		return row;
	}
	
	public List<SoftrollRespin> limitFindAll(Limit limit) {
		SqlSession sqlSession = factory.openSession();
		List<SoftrollRespin> list = sqlSession.selectList("com.wistron.record.softrollrespin.limitFindAll",limit);
		return list;
	}
	
	public int count() {
		SqlSession sqlSession = factory.openSession();
		int  totalrows = sqlSession.selectOne("com.wistron.record.softrollrespin.count");
		return totalrows;
	}
	
	
	
	
	
	
	
	
	
	
	
}
