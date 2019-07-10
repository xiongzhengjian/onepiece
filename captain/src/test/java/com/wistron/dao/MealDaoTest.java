package com.wistron.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
//Configure spring to integrate with Junit so that Junit loads the Spring container at startup
@RunWith(SpringJUnit4ClassRunner.class)
//Tell Junit spring's configuration file
@ContextConfiguration({"classpath:applicationContext.xml"})
public class MealDaoTest {

    @Autowired
    private MealDao dao;

    @Test
    public void insertOrderedMeals() {
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