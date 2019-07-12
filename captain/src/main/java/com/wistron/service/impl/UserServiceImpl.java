package com.wistron.service.impl;

import com.wistron.dao.UserDao;
import com.wistron.pojo.User;
import com.wistron.pojo.vo.OrderSituation;
import com.wistron.pojo.vo.Uservo;
import com.wistron.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;


    @Override
    public User findUserByStaffid(String staffid) {
        User user = dao.findUserByStaffid(staffid);
        return user;
    }

    @Override
    public User findUserById(int user_id) {
        User user = dao.findUserById(user_id);
        return user;
    }

    @Override
    public List<Uservo> findNomealstatus() {
        List<Uservo> list = dao.findNomealstatus();
        return list;
    }

    @Override
    public List<OrderSituation> userAmount() {
        List<OrderSituation> list = dao.userAmount();
        return list;
    }

    @Override
    public int deptStq10() {
        int i = dao.deptStq10();
        return i;
    }

    @Override
    public int deptStq20() {
        int i = dao.deptStq20();
        return i;
    }

    @Override
    public void updateMealStatus(List<Integer> ids) {
        dao.updateMealStatus(ids);
    }

    @Override
    public void update(User user) {
        dao.update(user);

    }
}
