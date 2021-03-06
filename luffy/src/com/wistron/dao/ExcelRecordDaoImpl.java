package com.wistron.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.Bios;
import com.wistron.pojo.Commodity;
import com.wistron.pojo.Softpaq;
import com.wistron.pojo.Softpaq2;
import com.wistron.pojo.SoftrollRespin;
import com.wistron.pojo.Wat;

public class ExcelRecordDaoImpl {
	
	private SqlSessionFactory factory;
	//initialize factory when MealDaoImpl is created
	public ExcelRecordDaoImpl() {
			super();
			try {
				factory = DaoUtil.getSqlSessionFactory();
			} catch (Exception e) {
				e.printStackTrace();
			}
	}	 
	
	public List<Bios> findAllBios(){		
		SqlSession sqlSession = factory.openSession();		
		List<Bios> list = sqlSession.selectList("com.wistron.record.bios.findAllBios");
		sqlSession.close();
		return list;
	}
	
	public List<Commodity> findAllCommodity(){
		SqlSession sqlSession = factory.openSession();		
		List<Commodity> list = sqlSession.selectList("com.wistron.record.commodity.findAll");
		sqlSession.close();
		return list;
	}
	
	public List<Softpaq> findAllSoftpaq(){
		SqlSession sqlSession = factory.openSession();		
		List<Softpaq> list = sqlSession.selectList("com.wistron.record.softpaq.findAllSoftpaq");
		sqlSession.close();
		return list;
	}
	
	public List<Softpaq2> findAllSoftpaq2(){
		SqlSession sqlSession = factory.openSession();		
		List<Softpaq2> list = sqlSession.selectList("com.wistron.record.softpaq2.findAllSoftpaq");
		sqlSession.close();
		return list;
	}
	
	public List<Wat> findAllWat(){
		SqlSession sqlSession = factory.openSession();		
		List<Wat> list = sqlSession.selectList("com.wistron.record.wat.findAllWat");
		sqlSession.close();
		return list;
	}
	
	public List<SoftrollRespin> findAllSoftrollrespin(){
		SqlSession sqlSession = factory.openSession();		
		List<SoftrollRespin> list = sqlSession.selectList("com.wistron.record.softrollrespin.findAllsfrb");
		sqlSession.close();
		return list;
	}
	
	public int insertBioses(List<Bios> bioses){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.bios.insertBioses", bioses);
		sqlSession.commit();	
		sqlSession.close();
		return rows;
	}
	
	public int insertCommodities(List<Commodity> commodity){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.commodity.insertCommodities", commodity);
		sqlSession.commit();	
		sqlSession.close();
		return rows;
	}
	
	public int insertSoftpaq(List<Softpaq> softpaq){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.softpaq.insertMultiple", softpaq);
		sqlSession.commit();	
		sqlSession.close();
		return rows;
	}
	
	public int insertSoftpaq2(List<Softpaq2> softpaq){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.softpaq2.insertMultiple", softpaq);
		sqlSession.commit();	
		sqlSession.close();
		return rows;
	}
	
	public int insertWat(List<Wat> list){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.wat.insertMultiple", list);
		sqlSession.commit();	
		sqlSession.close();
		return rows;
	}

	public int insertIsr(List<SoftrollRespin> list){
		SqlSession sqlSession = factory.openSession();
		int rows = sqlSession.insert("com.wistron.record.softrollrespin.insertMultiple", list);
		sqlSession.commit();	
		sqlSession.close();
		return rows;
	}
}
