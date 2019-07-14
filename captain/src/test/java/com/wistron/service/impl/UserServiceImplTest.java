package com.wistron.service.impl;

import com.wistron.dao.BaseTest;
import com.wistron.pojo.vo.OrderSituation;
import com.wistron.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserService service;

    @Test
    public void findUserByStaffid() {
    }

    @Test
    public void findUserById() {
    }

    @Test
    public void findNomealstatus() {
    }

    @Test
    public void userAmount() {
        List<OrderSituation> list = service.userAmount();
        for (OrderSituation orderSituation : list) {
            System.out.println(orderSituation);
        }
    }

    @Test
    public void deptStq10() {
        int i = service.deptStq10();
        System.out.println(i);
    }

    @Test
    public void deptStq20() {

    }

    @Test
    public void updateMealStatus() {
        // service.updateMealStatus();
        ArrayList<Integer> list = new ArrayList<>();

        list.add(11);
        list.add(5);
        service.updateMealStatus(list);



    }

    @Test
    public void update() {
    }
}