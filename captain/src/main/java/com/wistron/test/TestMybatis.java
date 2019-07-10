package com.wistron.test;

import com.wistron.dao.ProjectDao;
import com.wistron.pojo.Project;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void run() throws Exception {
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession =  sqlSessionFactory.openSession();
        ProjectDao dao =  sqlSession.getMapper(ProjectDao.class);
        List<Project> projects = dao.findChassises();
        System.out.println(projects);
        sqlSession.close();
        in.close();
    }
}
