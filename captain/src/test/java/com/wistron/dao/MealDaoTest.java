package com.wistron.dao;

import com.wistron.pojo.Meal;
import org.apache.log4j.DailyRollingFileAppender;
import org.apache.poi.hslf.examples.DataExtraction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
//Configure spring to integrate with Junit so that Junit loads the Spring container at startup
@RunWith(SpringJUnit4ClassRunner.class)
//Tell Junit spring's configuration file
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MealDaoTest {

    @Autowired
    private MealDao dao;

    @Test
    public void ofood() {
        Meal meal1 = new Meal(new Date(),"WCQ",11,1,1);
        Meal meal2 = new Meal(new Date(),"WCQ",11,1,1);
        List<Meal> list = new ArrayList<>();
        list.add(meal1);
        list.add(meal2);
        dao.ofood(list);
    }

    @Test
    public void findAll() {
    }

    @Test
    public void findAllLater() {
    }

    @Test
    public void update() {
    }

    @Test
    public void findTodayData() {
    }
}