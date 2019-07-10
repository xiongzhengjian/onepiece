package com.wistron.service.impl;

import com.wistron.dao.ProjectDao;
import com.wistron.pojo.Project;
import com.wistron.service.ProjectService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.Assert.*;

//Configure spring to integrate with Junit so that Junit loads the Spring container at startup
@RunWith(SpringJUnit4ClassRunner.class)
//Tell Junit spring's configuration file
@ContextConfiguration({"classpath:applicationContext.xml"})
public class ProjectServiceImplTest {


//    @Autowired
//    private ProjectServiceImpl projectService;


    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectDao dao;


/*    @Test
    public void findChassises() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ProjectService projectService = (ProjectService) applicationContext.getBean("projectService");
        List<Project> chassises = projectService.findChassises();
        for (Project chassise : chassises) {
            System.out.println(chassise);
        }
    }*/

    @Test
    public void findChassises() {
        List<Project> chassises = projectService.findChassises();
//        List<Project> chassises = dao.findChassises();
        for (Project chassise : chassises) {
            System.out.println(chassise);
        }
    }

    @Test
    public void findPlatform() {
    }
}