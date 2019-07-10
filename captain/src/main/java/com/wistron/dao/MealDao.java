package com.wistron.dao;

import com.wistron.pojo.Meal;
import com.wistron.pojo.vo.Ordersubmit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MealDao {

    @Insert("insert into meal " +
            "(meal_id,date,site,user,type,decide)" +
            " values " +
            "(#{meal.meal_id},#{meal.date},#{meal.site},#{meal.user},#{meal.type},#{meal.decide})")
    public int insertOrderedMeals(List<Meal> meals);

    @Select("select * from meal where user=#{user_id} and date >= #{today}")
    public List<Meal> findAll(Ordersubmit ordersubmit);


    @Select("select * from meal where user=#{user_id} and date >=#{nextDay}")
    public List<Meal> findAllLater(Ordersubmit ordersubmit);

    @Update("update meal set decide = #{decide} where meal_id=#{meal_id} and user=#{user}")
    public int update(Meal meal);

    @Select("select * from meal where date=#{date} and type=1")
    public List<Meal> findTodayData(Meal meal);

}
