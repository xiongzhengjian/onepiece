package com.wistron.dao;

import com.wistron.pojo.User;
import com.wistron.pojo.vo.OrderSituation;
import com.wistron.pojo.vo.Uservo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserDao {

    @Select("select * from user where staffid = #{staffid}")
    public User findUserByStaffid(String staffid);

    @Select("select * from user where user_id = #{id}")
    public User findUserById(int user_id);

    public OrderSituation orderSituation();

    @Select("select * from user where mealstatus=0 order by department")
    public List<Uservo> findNomealstatus();

    @Select("select department as dept,count(user_id) as employeesNum from user group by department")
    public List<OrderSituation> userAmount();

    //public int findDeptStq00();

    @Select("select count(user_id) as 1STQ00 from user where department='1STQ10' and  mealstatus=1")
    public int deptStq10();

    @Select("select count(user_id) as 1STQ00 from user where department='1STQ20' and  mealstatus=1")
    public int deptStq20();

    @Update("update user set mealstatus = 1 where user_id in (#{list})")
    public void updateMealStatus(List<Integer> ids);

    @Update("update user set password=#{password},name=#{name},enname=#{enname},email=#{email},hireDate=#{hireDate}" +
            " where " +
            "user_id=#{user_id}"
    )
    public void update(User user);

}
