package com.wistron.dao;

import com.wistron.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

//Configure spring to integrate with Junit so that Junit loads the Spring container at startup
@RunWith(SpringJUnit4ClassRunner.class)
//Tell Junit spring's configuration file
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserDaoTest {

//    private SqlSessionFactory sqlSessionFactory;
//    private SqlSession sqlSession;
//    private InputStream in;
//
//    @Before
//    public void setUp() throws Exception {
//        in = Resources.getResourceAsStream("SqlMapConfig.xml");
//        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
//        sqlSession =  sqlSessionFactory.openSession();
//    }
//
//    @After
//    public void tearDown() throws Exception {
//        sqlSession.close();
//        in.close();
//    }

    @Autowired
    private UserDao userDao;


    @Test
    public void findUserByStaffid() {
        User q17100529 = userDao.findUserByStaffid("Q17100529");
        System.out.println(q17100529);
    }

    @Test
    public void findUserById() {
    }

    @Test
    public void findNomealstatus() {
    }

    @Test
    public void findUserAmount() {
    }

    @Test
    public void findDeptStq10() {
        int deptStq10 = userDao.findDeptStq10();
        System.out.println(deptStq10);
    }

    @Test
    public void findDeptStq20() {
    }

    @Test
    public void updateMealStatus() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        userDao.updateMealStatus(list);
    }

    @Test
    public void update() {
    }
}