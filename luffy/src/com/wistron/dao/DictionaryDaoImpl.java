package com.wistron.dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.wistron.pojo.Dictionary;

public class DictionaryDaoImpl {
	
	private SqlSessionFactory factory;
	
	//initialize factory when DictionaryDaoImpl is created
	public DictionaryDaoImpl() {
		super();
		try {
			factory = DaoUtil.getSqlSessionFactory();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Dictionary findById(Integer id) throws Exception {		
		 SqlSession sqlSession = factory.openSession();
		 Dictionary dictionary = sqlSession.selectOne("wistron.pojo.dictionary.findById",id);	
		return dictionary;
	}
	
	public int insert(Dictionary dic) {
		SqlSession sqlSession = factory.openSession();
		int row = sqlSession.insert("wistron.pojo.dictionary.insert", dic);
		sqlSession.commit();	
		return row;
	}
	
	public int update(Dictionary dic) {
		SqlSession sqlSession = factory.openSession();
		int i = sqlSession.update("wistron.pojo.dictionary.update", dic);
		sqlSession.commit();
		return i;
	}
	
	public int delete(int id) {
		SqlSession sqlSession = factory.openSession();
		int i = sqlSession.delete("wistron.pojo.dictionary.delete", id);
		sqlSession.commit();
		return i;
	}
	
	public List<Dictionary> findAll(){
		SqlSession sqlSession = factory.openSession();
		List<Dictionary> list = sqlSession.selectList("wistron.pojo.dictionary.findAll");
		return list;
	}
	
	
	
	
	
	
}
