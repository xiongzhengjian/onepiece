package com.wistron.dao;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.Bios;
import com.wistron.pojo.Commodity;
import com.wistron.pojo.Meal;
import com.wistron.pojo.Project;
import com.wistron.pojo.vo.Limit;
import com.wistron.pojo.vo.Ordersubmit;

public class CommodityDaoImpl {
	
	private SqlSessionFactory factory;	
	
	//initialize factory when CommodityDaoImpl is created
	public CommodityDaoImpl() {
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
	public int insertCommodities(List<Commodity> commodity){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.commodity.insertCommodities", commodity);
		sqlSession.commit();	
		return rows;
	}
	
	/**
	 * find all and sort in reverse order by commodity desc		
	 * @return
	 */
	public List<Commodity> findAllCommodity(){
		SqlSession sqlSession = factory.openSession();		
		List<Commodity> list = sqlSession.selectList("com.wistron.record.commodity.findAllCommodity");
		return list;
	}


	public int updateCommodity(Commodity commodity) {
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.update("com.wistron.record.commodity.updateCommodity", commodity);
		sqlSession.commit();
		return row;
	}

	public List<Commodity> limitFindAll(Limit limit) {
		SqlSession sqlSession = factory.openSession();
		
		List<Commodity> list = sqlSession.selectList("com.wistron.record.commodity.limitFindAll",limit);
		return list;
	}
	
	public int count() {
		SqlSession sqlSession = factory.openSession();
		int  totalrows = sqlSession.selectOne("com.wistron.record.commodity.count");
		return totalrows;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
