package com.wistron.service;

import com.wistron.pojo.User;
import com.wistron.pojo.vo.OrderSituation;
import com.wistron.pojo.vo.Uservo;

import java.util.List;

public interface UserService {

    public User findUserByStaffid(String staffid);

    public User findUserById(int user_id);

    public List<Uservo> findNomealstatus();

    public List<OrderSituation> userAmount();


    public int deptStq10();

    public int deptStq20();

    public void updateMealStatus(List<Integer> ids);


    public void update(User user);

}
