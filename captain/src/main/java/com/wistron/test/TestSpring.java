package com.wistron.test;

import com.wistron.pojo.Project;
import com.wistron.service.ProjectService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestSpring {
    @Test
    public void run1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ProjectService projectService = (ProjectService) applicationContext.getBean("projectService");
        List<Project> chassises = projectService.findChassises();
        for (Project chassise : chassises) {
            System.out.println(chassise);
        }


    }
}
