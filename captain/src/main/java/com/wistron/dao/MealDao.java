package com.wistron.dao;

import com.wistron.pojo.Meal;
import com.wistron.pojo.vo.Ordersubmit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MealDao {



    @Insert({"<script>" +
            "insert into meal (meal_id,date,site,user,type,decide)" +
            "values" +
            "<foreach collection='list' item='dao' index='index' separator=','>" +
                "(#{dao.meal_id},#{dao.date},#{dao.site},#{dao.user},#{dao.type},#{dao.decide})" +
            "</foreach>" +
            "</script>"})
    @Options(useGeneratedKeys=true)
    public int ofood(List<Meal> list);

    @Select("select * from meal where user=#{user_id} and date >= #{today}")
    public List<Meal> findAll(Ordersubmit ordersubmit);


    @Select("select * from meal where user=#{user_id} and date >=#{nextDay}")
    public List<Meal> findAllLater(Ordersubmit ordersubmit);

    @Update("update meal set decide = #{decide} where meal_id=#{meal_id} and user=#{user}")
    public int update(Meal meal);

    @Select("select * from meal where date=#{date} and type=1")
    public List<Meal> findTodayData(Meal meal);

}
