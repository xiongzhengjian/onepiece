package com.wistron.service.impl;

import com.wistron.dao.BaseTest;
import com.wistron.pojo.Meal;
import com.wistron.service.MealService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class MealServiceImplTest extends BaseTest {

    @Autowired
    private MealService service;


    @Test
    public void ofood() {
        Meal meal1 = new Meal(new Date(),"WCQ",11,1,1);
        Meal meal2 = new Meal(new Date(),"WCQ",11,1,1);
        List<Meal> list = new ArrayList<>();
        list.add(meal1);
        list.add(meal2);
        service.ofood(list);
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