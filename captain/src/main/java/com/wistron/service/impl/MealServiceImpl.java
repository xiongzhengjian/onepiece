package com.wistron.service.impl;

import com.wistron.dao.MealDao;
import com.wistron.pojo.Meal;
import com.wistron.pojo.vo.Ordersubmit;
import com.wistron.service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("mealService")
@Transactional
public class MealServiceImpl implements MealService {

    @Autowired
    private MealDao dao;

    @Override
    public int ofood(List<Meal> list) {
        int ofood = dao.ofood(list);
        return ofood;
    }

    @Override
    public List<Meal> findAll(Ordersubmit ordersubmit) {
        List<Meal> list = dao.findAll(ordersubmit);
        return list;
    }

    @Override
    public List<Meal> findAllLater(Ordersubmit ordersubmit) {
        List<Meal> list = dao.findAllLater(ordersubmit);
        return list;
    }

    @Override
    public int update(Meal meal) {
        int i = dao.update(meal);
        return i;
    }

    @Override
    public List<Meal> findTodayData(Meal meal) {
        List<Meal> todayData = dao.findTodayData(meal);
        return todayData;
    }
}
