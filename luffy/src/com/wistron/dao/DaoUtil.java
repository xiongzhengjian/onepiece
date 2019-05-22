package com.wistron.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DaoUtil {
	/**
	 * build a SqlSessionFactory with config file,then return back the factory
	 * @return
	 * @throws Exception
	 */
	public static SqlSessionFactory getSqlSessionFactory() throws Exception {
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
}
