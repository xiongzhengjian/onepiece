package com.wistron.dao;

import com.wistron.pojo.Project;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class ProjectDaoTest {

    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private InputStream in;

    @Before
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession =  sqlSessionFactory.openSession();
    }

    @After
    public void tearDown() throws Exception {
        sqlSession.close();
        in.close();
    }

    @Test
    public void findChassises(){
        ProjectDao dao =  sqlSession.getMapper(ProjectDao.class);
        List<Project> projects = dao.findChassises();
        for (Project project : projects) {
            System.out.println(project);
        }


    }

    @Test
    public void findPlatform() {
        ProjectDao dao = sqlSession.getMapper(ProjectDao.class);
        List<Project> platform = dao.findPlatform("Shave3");
        for (Project project : platform) {
            System.out.println(project);
        }

    }
}