package com.wistron.service;

import com.wistron.pojo.Meal;
import com.wistron.pojo.vo.Ordersubmit;


import java.util.List;

public interface MealService {

    public int ofood(List<Meal> list);

    public List<Meal> findAll(Ordersubmit ordersubmit);


    public List<Meal> findAllLater(Ordersubmit ordersubmit);

    public int update(Meal meal);

    public List<Meal> findTodayData(Meal meal);
}
