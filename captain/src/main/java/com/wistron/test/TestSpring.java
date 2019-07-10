package com.wistron.test;

import com.wistron.service.ProjectService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test
    public void run1(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ProjectService projectService = (ProjectService) applicationContext.getBean("projectService");
        projectService.findChassises();
    }
}
